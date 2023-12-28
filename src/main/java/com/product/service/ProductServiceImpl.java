package com.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.product.model.Product;
import com.product.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product createProduct(Product product) {
		Product savedproduct = productRepository.save(product);
		return savedproduct;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> list = productRepository.findAll();
		return list;
	}

	@Override
	public Product getProductById(Long productId) {
		Product product = null;
		Optional<Product> findById = productRepository.findById(productId);
		if (findById.isPresent()) {
			product = findById.get();
		}
		return product;
	}

	@Override
	public Product updateProduct(Long productId, Product product) {
		Product product2 = productRepository.findById(productId).get();
		
		product2.setBrandName(product.getBrandName());
		product2.setInStock(product.getInStock());
		product2.setName(product.getName());
		product2.setPrice(product.getPrice());
		product2.setStockQuantity(product.getStockQuantity());
		
		productRepository.save(product2);
		
		return product2;
	}

	@Override
	public void deleteProduct(Long productId) {
		
		productRepository.deleteById(productId);
		}

}
