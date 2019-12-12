package com.mvc.validator;

import java.util.ArrayList;
import java.util.List;

import com.mvc.form.ProductForm;


public class ProductValidator {
	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<String>();
		String name = productForm.getName();
		if (name == null || name.trim().isEmpty()) {
			errors.add("商品的名称不能为空！");
		}
		String price = productForm.getPrice();
		if (price == null || price.trim().isEmpty()) {
			errors.add("商品的价格不能为空！");
		} else {
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				errors.add("价格不能是非数字！");
			}
		}
		return errors;
	}
}
