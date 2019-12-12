package j2017051107_15_javaBean;

public class User {
	
	private String username;
	private String password;
	private int count = 0;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCount() {
		System.out.println("Ö´ÐÐcount++");
		count++;
		System.out.println(this.count);
		return this.count;
		
	}
	
	public void setCount(int count) {
		System.out.println("Ö´ÐÐsetcount");
		this.count = count + 1;
		System.out.println(count);
		System.out.println(this.count);
	}

}
