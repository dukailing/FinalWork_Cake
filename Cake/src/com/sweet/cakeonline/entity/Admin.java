package com.sweet.cakeonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//管理员类
@Entity
@Table(name="admin")
public class Admin {
	private int aid;
	private String aname;
	private String password;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Column(name="aname")
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	@Column(name="apassword")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
