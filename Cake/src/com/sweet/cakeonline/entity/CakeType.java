package com.sweet.cakeonline.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="caketype")
public class CakeType {
	
	private int typeid;
	private String typename;
	//private Set CakeSet = new HashSet<Cake>();
	private List<Cake> CakeList=new ArrayList<Cake>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int id) {
		this.typeid = id;
	}
	@Column(name="typename")
	public String getTypename() {
		return typename;
	}
	public void setTypename(String name) {
		this.typename = name;
	}
//	@OneToMany(targetEntity=Cake.class, 
//            cascade=CascadeType.ALL)
//	@JoinColumn(name="typeid") 
//	public Set getCakeSet() {
//		return CakeSet;
//	}
//	public void setCakeSet(Set cakeSet) {
//		CakeSet = cakeSet;
//	}
	@OneToMany(targetEntity=Cake.class, 
          cascade=CascadeType.ALL)
	@JoinColumn(name="typeid") 
	@OrderColumn(name="orderindex") 
	public List<Cake> getCakeList() {
		return CakeList;
	}
	public void setCakeList(List<Cake> cakeList) {
		CakeList = cakeList;
	}
	
	
}
