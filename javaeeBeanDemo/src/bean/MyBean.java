package bean;

public class MyBean {
	
	private String name = null;
	private String pass = null;
	private int count = 0;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getCount() {
		count ++;
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
