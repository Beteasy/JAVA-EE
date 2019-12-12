package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.domain.Product;
import com.mvc.form.ProductForm;
import com.mvc.validator.ProductValidator;



public class SaveProductController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		  ProductForm productForm = new ProductForm();
	        productForm.setName(request.getParameter("name"));
	        productForm.setDescription(request.getParameter("description"));
	        productForm.setPrice(request.getParameter("price"));

	        // 校验form的数据
	        ProductValidator productValidator = new ProductValidator();
	        List<String> errors = productValidator.validate(productForm);
	        
	        if (errors.isEmpty()) {
	            Product product = new Product();
	            product.setName(productForm.getName());
	            product.setDescription(productForm.getDescription());
	            product.setPrice(Float.parseFloat(productForm.getPrice()));

	            // no validation error, execute action method
	            // insert code to save product to the database

	            // store product in a scope variable for the view
	            request.setAttribute("product", product);
	            return "/WEB-INF/jsp/ProductDetails.jsp";
	        } else {
	            // store errors and form in a scope variable for the view
	            request.setAttribute("errors", errors);
	            request.setAttribute("form", productForm);
	            return "/WEB-INF/jsp/ProductForm.jsp";
	        }
	}

}
