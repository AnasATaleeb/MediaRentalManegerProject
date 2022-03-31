package application;

import java.util.*;

public class Customer implements Comparable<Customer> {
	// define attributes 
	private String id;
	private String mobile;
	private String name;
	private String address;
	private String plan;
	private int value;
	private ArrayList<String> cart = new ArrayList<>( );;
	private ArrayList<String> rented = new ArrayList<>( );;

	// Default constructor
	public Customer() {

	}
	//non default constructor
	public Customer(String id,String name, String address, String mobile, String plan) {
		this.id = id;
		this.mobile = mobile;
		this.name = name;
		this.address = address;
		this.plan = plan;
	}
	//getter for Id
	public String getId() {
		return id;
	}
	//setter for Id
	public void setId(String id) {
		this.id = id;
	}
	//getter for mobile
	public String getMobile() {
		return mobile;
	}
	//setter for mobile
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	//getter for name
	public String getName() {
		return name;
	}
	//setter for name
	public void setName(String name) {
		this.name = name;
	}
	//getter for address
	public String getAddress() { 
		return address;
	}
	//setter for address
	public void setAddress(String address) {
		this.address = address;
	}
	//getter for plan
	public String getPlan() {
		return plan;
	}
	//getter for value
	public int getValue() {
		return value;
	}
	//setter for value
	public void setValue(int value) {
		this.value = value;
	}
	//setter for plan
	public void setPlan(String plan) {
		this.plan = plan;
	}
	//setter for cart array list
	public ArrayList<String> getCart() {
		return cart;
	}
	//setter for cart array list
	public void setCart(ArrayList<String> cart) {
		this.cart = cart;
	}
	//setter for rented array list
	public ArrayList<String> getRented() {
		return rented;
	}
	//setter for rented array list
	public void setRented(ArrayList<String> rented) {
		this.rented = rented;
	}

	//equal method to return true if object equal 
	public boolean equals(Customer o){
		if (this.getName().equals(o.getName()))
			return true;
		else
			return false;
	}
	/*
	 * The comparison is based on the encode value of each character in the strings.
	 * The method returns 0 if the string is equal to the other string. A value less
	 * than 0 is returned if the string is less than the other string (less characters) and a value greater than 0 if the string is greater than the other string (more characters). 
	 */
	@Override
	public int compareTo(Customer o) {
		if (name.compareTo(o.getName()) > 0)
			return 1;
		else if (name.compareTo(o.getName()) < 0)
			return -1;
		else
			return 0;
	}
	// to string to return data of object in string
	@Override
	public String toString() {
		return "Customer [id=" + id + ", mobile=" + mobile + ", name=" + name + ", address=" + address + ", plan="
				+ plan + ", value=" + value + ", cart=" + cart + ", rented=" + rented + "]";
	}
	
	
}
