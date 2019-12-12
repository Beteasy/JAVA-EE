//ShopCart.java
package shoppingcart;

import java.util.*;

public class ShopCart {
	
	/**
	 * 是一个List对象，存放商品
	 * 相当于是模拟购物车本身
	 * 用它的add和remove功能
	 * 还有iterator功能实现遍历
	 */
	private ArrayList<Product> cart=null;
	
	public ShopCart() {
		cart=new ArrayList<Product>();
	}
	
	/**
	 * 向购物车中添加商品
	 * @param product
	 */
	public void addProductToCart(Product product){  
		boolean is = false;
		//是否第一次购买
		for(int i=0; i<cart.size(); i++){
			//如果已经存在该商品
			if(cart.get(i).getId().equals(product.getId())){
			   is = true;
			   cart.get(i).setNum(cart.get(i).getNum()-1);
			   break;
			} 
		}
		//是第一次购买
		if(is == false){
			product.setNum(99);
			cart.add(product);
		}  
	}
	
	/**
	 * 从购物车中删除一商品
	 * @param productId
	 */
	public void removeProductFromCart(String productId){  
		if(cart==null)
			return;
		//用迭代器遍历找商品
		Iterator it=cart.iterator();
		while(it.hasNext()){
			Product item=(Product)it.next();
			if(item.getId().equals(productId)){
				it.remove();
				item.setNum(100);
				return;
			}  
		}
	}
	
	/**
	 * 计算购物车中的商品价格
	 * @return
	 */
	public double getAllProductPrice(){    
		if(cart==null)
			return 0;
		double totalPrice=0;
		Iterator it=cart.iterator();
		while(it.hasNext()){
			Product item=(Product)it.next();
			//积后累加求和
			totalPrice += item.getPrice()*(100-item.getNum());
		}
		return totalPrice;
	}
	
	/**
	 * 返回购物车所有产品信息
	 * @return
	 */
	public List getAllProductsFromCart(){
		return cart;
	}
}
