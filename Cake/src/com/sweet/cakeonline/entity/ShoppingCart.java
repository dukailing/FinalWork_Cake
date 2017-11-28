package com.sweet.cakeonline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="shoppingcart")
public class ShoppingCart {
	private int sid;
	private int cid;
	private String cname;
	private float price;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public int getSid() {
	return sid;
}

public void setSid(int sid) {
	this.sid = sid;
}

public int getCid() {
	return cid;
}

public void setCid(int cid) {
	this.cid = cid;
}

public String getCname() {
	return cname;
}

public void setCname(String cname) {
	this.cname = cname;
}

public float getPrice() {
	return price;
}

public void setPrice(float price) {
	this.price = price;
}

}
