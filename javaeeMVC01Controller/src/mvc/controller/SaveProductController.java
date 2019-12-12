package mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.domain.Product;
import mvc.form.ProductForm;

/**
 * 对保存进行处理
 * 处理方式：获取数据，再转发到详细界面
 * @author fhzheng
 *
 */
public class SaveProductController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, 
			HttpServletResponse response) {
        ProductForm productForm = new ProductForm();
        // populate form properties
        productForm.setName(
                request.getParameter("name"));
        productForm.setDescription(
                request.getParameter("description"));
        productForm.setPrice(request.getParameter("price"));
        
        // create model
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        try {
        	product.setPrice(Float.parseFloat(
        			productForm.getPrice()));
        } catch (NumberFormatException e) {
        }

        // insert code to add product to the database

        request.setAttribute("product", product);
        return "/WEB-INF/jsp/ProductDetails.jsp";
	}

}
