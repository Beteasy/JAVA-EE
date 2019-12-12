package com.bean;

public class Product {
	private int id = 0;
	private String name = null;
	private int price = 0;
	private int amount = 0;
	private int newPrice = 0;
	private String date = null;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(int newPrice) {
		this.newPrice = newPrice;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
}
