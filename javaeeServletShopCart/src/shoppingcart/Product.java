//Product.java
package shoppingcart;
public class Product {
	private String id;				//商品标识
	private String name;			//商品名称
	private String description;		//商品描述
	private double price;			//商品价格
	private int num;				//商品数量
	
	public Product(){ }
	
	public Product(
			String id,
			String name,
			String description,
			double price,
			int num){
		this.id=id;
		this.name=name;
		this.description=description;
		this.price=price;
		this.num=num;
	}
	
	public String getId() {
		return (this.id);
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return (this.name);
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return (this.description);
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return (this.price);
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNum() {
		return (this.num);
	}
	public void setNum(int num) {
		this.num = num;
	}
}
