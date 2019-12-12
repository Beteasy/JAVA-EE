package com.shoppingCart;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShopCart {
	private ArrayList<Product> cart = null;
	
	public ShopCart() {
		cart = new ArrayList<Product>();
	}
	
	public void addProductToCart(Product product) {
		//用于判断是否是第一次购买
		boolean isFirst = true;
		
		//遍历购物车，查看购物车中是否已经有该商品
		for (int i = 0; i < cart.size(); i++) {
			//商品已经存在
			if (cart.get(i).getId().equals(product.getId())) {
				isFirst = false;
				//??????????????????????????加一还是减一
				cart.get(i).setNum(cart.get(i).getNum()-1);
				break;
			}
		}
		if (isFirst == true) {
			product.setNum(199);
			cart.add(product);
		}
	}
	
	public void removeProductFromCart(String productId) {
		if (cart == null) {
			return;
		}
		Iterator it = cart.iterator();
		while (it.hasNext()) {
			Product product = (Product) it.next();
			if (product.getId().equals(productId)) {
				it.remove();
				
				product.setNum(200);
				return;
			}
			
		}
		
	}
	
	public double getAllProductPrice() {
		double sum = 0.0;
		if (cart == null) {
			return 0;
		}
		else {
			Iterator iterator = cart.iterator();
			while (iterator.hasNext()) {
				Product product = (Product) iterator.next();
				sum += product.getPrice()*(200 - product.getNum());
			}
		}
		return sum;
	}
	
	public List getAllProductsFromCart(){
		return cart;
	}
}
