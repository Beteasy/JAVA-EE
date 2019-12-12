package bean;

public class Email {
	private String email = null;
	private boolean isMail = false;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 用正则表达式来检测email是否给的正确
	 * @return
	 */
	public boolean isMail() {
		String regex =  "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		if (email.matches(regex)) {
			isMail = true;
		}
		return isMail;
	}
	public void setMail(boolean isMail) {
		this.isMail = isMail;
	}
	public Email() {
		super();
	}
	public Email(String email) {
		this.email = email;
	}
	
}
