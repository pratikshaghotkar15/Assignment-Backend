package com.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.product.model.Product;
import com.product.service.ProductService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@RequestBody Product product) {

		Product createdProduct = productService.createProduct(product);

		return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> allProducts = productService.getAllProducts();

		return new ResponseEntity<>(allProducts, HttpStatus.OK);
	}
	
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable Long id){
		
		Product product = productService.getProductById(id);
		
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
		
		Product updateProduct = productService.updateProduct(id, product);
		
		return new ResponseEntity<>(updateProduct,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		
		productService.deleteProduct(id);
		
		String response="deeleted successfully";
		
		return new  ResponseEntity<>(response,HttpStatus.OK);
	}

}
