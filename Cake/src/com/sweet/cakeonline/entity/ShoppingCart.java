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
	private int userid;
	private String cakeimg;
	private int count;


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

public int getUserid() {
	return userid;
}

public void setUserid(int userid) {
	this.userid = userid;
}

public String getCakeimg() {
	return cakeimg;
}

public void setCakeimg(String cakeimg) {
	this.cakeimg = cakeimg;
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}


}
