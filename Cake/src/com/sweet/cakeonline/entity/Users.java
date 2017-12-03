package com.sweet.cakeonline.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	private int id;
	private String name;
	private String password;
	private String  email;
	private String address;
	private Set shopSet = new HashSet<ShoppingCart>();
	private Set OrderSet=new HashSet<Orders>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(targetEntity=Cake.class, 
            cascade=CascadeType.ALL)
	@JoinColumn(name="userid") 
	public Set getShopSet() {
		return shopSet;
	}
	public void setShopSet(Set shopSet) {
		this.shopSet = shopSet;
	}
	@OneToMany(mappedBy="users",targetEntity=Orders.class, 
            cascade=CascadeType.ALL)
	public Set getOrderSet() {
		return OrderSet;
	}
	public void setOrderSet(Set orderSet) {
		OrderSet = orderSet;
	}
	

}
