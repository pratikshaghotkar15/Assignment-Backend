package com.product.service;

import java.util.List;

import com.product.model.Product;

public interface ProductService {
	
	public Product createProduct(Product product);
	
	public List<Product> getAllProducts();
	
	public Product getProductById(Long productId);
	
	public Product updateProduct(Long productId,Product product);
	
	public void deleteProduct(Long productId);
	
	

}
