package projectdemo.serviceController;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.SessionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import projectdemo.entities.Product;

@Service

public class prductService {

	@Autowired
	EntityManagerFactory emf;
	public ResponseEntity<Object> createService(Product productDetails) {
		Transaction transaction = null;
		Session session = emf.createEntityManager().unwrap(Session.class);
		try {
			productDetails.setProductCreationDate(new Timestamp(System.currentTimeMillis()));
			productDetails.setProductlastUpdatedDate(new Timestamp(System.currentTimeMillis()));
			session.save(productDetails);
			session.flush();
			transaction.commit();
		}catch (Exception e) {
			if(null != transaction) {
			transaction.rollback();
			}
			return new ResponseEntity<Object> ("product saved unsuccessfully", HttpStatus.BAD_REQUEST );
		}
		finally {
			if(null != session) {
				session.clear();
				session.close();
			}
		}
		return new ResponseEntity<Object> ("product saved successfully", HttpStatus.OK );
	}
	public ResponseEntity<Object> getService(String productName) {
		Session session = emf.createEntityManager().unwrap(Session.class);
		try (Connection connection = ((SessionImpl) session).connection();){
			QueryRunner runner = new QueryRunner();
			List<Product> productDetails = new ArrayList<Product>();
			productDetails = runner.query(connection,
					"SELECT * FROM product where name= '%"+productName+"'%",
					new BeanListHandler<Product>(Product.class));
			
					return new ResponseEntity<Object> (productDetails, HttpStatus.OK );
		}catch(Exception exception) {
			return new ResponseEntity<Object> ("Get product failed", HttpStatus.BAD_REQUEST );
		} finally {
			if(null != session) {
				session.clear();
				session.close();
			}
		}
	}

}
