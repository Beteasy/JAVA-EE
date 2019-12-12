package com.mvc.validator;

import java.util.ArrayList;
import java.util.List;

import com.mvc.form.ProductForm;


public class ProductValidator {
	public List<String> validate(ProductForm productForm) {
		List<String> errors = new ArrayList<String>();
		String name = productForm.getName();
		if (name == null || name.trim().isEmpty()) {
			errors.add("��Ʒ�����Ʋ���Ϊ�գ�");
		}
		String price = productForm.getPrice();
		if (price == null || price.trim().isEmpty()) {
			errors.add("��Ʒ�ļ۸���Ϊ�գ�");
		} else {
			try {
				Float.parseFloat(price);
			} catch (NumberFormatException e) {
				errors.add("�۸����Ƿ����֣�");
			}
		}
		return errors;
	}
}
