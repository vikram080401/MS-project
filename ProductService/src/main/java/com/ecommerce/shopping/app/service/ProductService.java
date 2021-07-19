package com.ecommerce.shopping.app.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.shopping.app.model.Category;
import com.ecommerce.shopping.app.model.Product;
import com.ecommerce.shopping.app.repository.CategoryRepository;
import com.ecommerce.shopping.app.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	Logger logger = LoggerFactory.getLogger(ProductService.class);

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;

	@Override
	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product findOne(long id) {
		return productRepository.findById(id).orElse(null);

	}

	@Override
	public String DeleteOne(Product product) {
		String Response = null;
		if (productRepository.existsById(product.getIdProduct())) {
			productRepository.deleteById(product.getIdProduct());
			Response = "Delete Sucess for Product " + product.getDescription().toString();
		} else {
			Response = "Product " + product.getDescription().toString() + "does not exist !! Invalid Operation ";
		}
		return Response;

	}

	@Override
	public Product AddProduct(Product product) {
		Product savedProduct = new Product();
		try {
			logger.info("Product-Service: " + "Adding new product " + product.getDescription());
			if (categoryRepository.findByDescription(product.getCategory().getDescription()) == null) {
				logger.info("Product-Service: " + "Product Category " + product.getCategory().getDescription()
						+ " does not exist. Adding product category to database !");
				Category entityCat = new Category();
				entityCat.setDescription(product.getCategory().getDescription());
				Category addedNewCategory = AddNewCategory(entityCat);

				product.setCategory(addedNewCategory);
				savedProduct = SaveProduct(product);

			} else {

				product.setCategory(categoryRepository.findByDescription(product.getCategory().getDescription()));
				savedProduct = SaveProduct(product);

			}
		} catch (Exception e) {
			logger.error("Product-Service: "+e.getMessage());
		}
		return savedProduct;

	}

	public Category AddNewCategory(Category category) {
		Category savedCategory = new Category();
		try {
			savedCategory = categoryRepository.save(category);
			logger.info("Product-Service: " + "Product Category " + savedCategory.getDescription()
					+ " added to database with category ID as !" + savedCategory.getIdCategory().toString());
		} catch (Exception e) {
			logger.error("Product-Service: " + e.getMessage());

		}
		return savedCategory;
	}

	public Product SaveProduct(Product product) {
		Product productSaved = new Product();
		try {
			if (productRepository.findByDescription(product.getDescription()) == null) {

				productSaved = productRepository.save(product);
				logger.info("Product-Service: " + "Added new product " + product.getDescription()
						+ " to database with product ID :" + productSaved.getIdProduct());
			} else {
				logger.info("Product-Service: " + "Product " + product.getDescription()
						+ " already exist in the database , appending quantity to product ID :"
						+ productSaved.getIdProduct());
				Product updateProduct = new Product();
				updateProduct.setAvailablequantity(
						productRepository.findByDescription(product.getDescription()).getAvailablequantity()
								+ product.getAvailablequantity());
				updateProduct.setCategory(product.getCategory());
				updateProduct.setDescription(product.getDescription());
				updateProduct
						.setIdProduct(productRepository.findByDescription(product.getDescription()).getIdProduct());
				updateProduct.setPrice(product.getPrice());
				productRepository.save(updateProduct);
				logger.info("Product-Service: " + "Product " + product.getDescription() + " updated sucessfully");
			}
		} catch (Exception e) {

			logger.error("Product-Service: " + e.getMessage());
		}
		return productSaved;

	}
	public Product UpdateProductQuantity(Product product) {
		Product updatedproduct=new Product();
		try {
			product.setCategory(categoryRepository.findByDescription(product.getCategory().getDescription()));
			int quantity=0;
			int quantitytoreduce=product.getAvailablequantity();
			int availableQuantity=productRepository.findByDescription(product.getDescription()).getAvailablequantity();
			if (availableQuantity>=quantitytoreduce) {
				quantity=availableQuantity-quantitytoreduce;
				updatedproduct.setAvailablequantity(quantity);
				updatedproduct.setCategory(product.getCategory());
				updatedproduct.setDescription(product.getDescription());
				updatedproduct.setIdProduct(productRepository.findByDescription(product.getDescription()).getIdProduct());
				updatedproduct.setPrice(product.getPrice());
				updatedproduct= productRepository.save(updatedproduct);
			}else {
				logger.error("Product-Service: "+ "Sorry!! Not enough stock available for this transaction!");
				updatedproduct.setAvailablequantity(productRepository.findByDescription(product.getDescription()).getAvailablequantity());
				updatedproduct.setCategory(productRepository.findByDescription(product.getDescription()).getCategory());
				updatedproduct.setDescription(productRepository.findByDescription(product.getDescription()).getDescription());
				updatedproduct.setIdProduct(productRepository.findByDescription(product.getDescription()).getIdProduct());
				updatedproduct.setPrice(productRepository.findByDescription(product.getDescription()).getPrice());
				
			}
		} catch (Exception e) {
			logger.error("Product-Service: "+ e.getMessage());
		}
		return updatedproduct;
		
	}

}
