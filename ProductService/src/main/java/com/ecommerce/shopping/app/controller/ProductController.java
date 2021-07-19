package com.ecommerce.shopping.app.controller;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecommerce.shopping.app.model.Category;
import com.ecommerce.shopping.app.model.City;
import com.ecommerce.shopping.app.model.Product;
import com.ecommerce.shopping.app.service.ICityService;
import com.ecommerce.shopping.app.service.IProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ICityService cityService;

    @Autowired
    private IProductService productService;
    
    @GetMapping("/search")
    public List<City> findCities(Model model) {

        List<City> cities = (List<City>) cityService.findAll();

       // model.addAttribute("cities", cities);

        return cities; //"showCities";
    }
    
    @GetMapping("/searchproduct")
    public List<Product> findProducts(){
		return  productService.findAll();
    
    }
    
    @GetMapping("search/{id}")
    public Product getOneProduct(@PathVariable long id) {
    	return productService.findOne(id);
    }
   
    @PostMapping("/addProduct")
    public ResponseEntity<Object> AddProduct(@RequestBody Product product) {
    	Product addproduct = productService.AddProduct(product);

    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    			.buildAndExpand(addproduct.getIdProduct()).toUri();

    	return ResponseEntity.created(location).build();

    }
   
	@DeleteMapping("/delete")
    public  void deleteProduct(@RequestBody Product product) {
    	
    	productService.DeleteOne(product);


    } 
    
    @PostMapping("/addNewcategory")
    public ResponseEntity<Object> AddCategory(@RequestBody Category category){
		
    	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    			.buildAndExpand(productService.AddNewCategory(category)).toUri();
    	return ResponseEntity.created(location).build();
    	
    }
    
    @PostMapping("/updateProductQuantity")
    public ResponseEntity<Object> updateProductQuantity(@RequestBody Product product) {
    	Product updatedproduct = productService.UpdateProductQuantity(product);

    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    			.buildAndExpand(updatedproduct.getIdProduct()).toUri();

    	return ResponseEntity.created(location).build();

    }
}