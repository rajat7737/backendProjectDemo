package projectdemo.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import projectdemo.entities.Product;
import projectdemo.serviceController.prductService;
@RestController
@RequestMapping("product")
public class productController {
	
	@Autowired
	prductService prductService;
	
	@PostMapping("add")
	public ResponseEntity<Object> createProduct(@RequestBody Product productDetails){
	return prductService.createService(productDetails);
	}
	
	@GetMapping("search")
	public ResponseEntity<Object> getProduct(@RequestParam String productName){
	return prductService.getService(productName);
	}
}