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
import javax.persistence.OneToMany;
import javax.persistence.Table;
//蛋糕大小类
@Entity
@Table(name="cakesize")
public class CakeSize {
	private int sizeid;
	private String sizename;
	private Set CakeSet = new HashSet<Cake>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getSizeid() {
		return sizeid;
	}
	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	@Column(name="sizename")
	public String getSizename() {
		return sizename;
	}
	public void setSizename(String sizename) {
		this.sizename = sizename;
	}

	@OneToMany(targetEntity=Cake.class, 
    cascade=CascadeType.ALL)
    @JoinColumn(name="sizeid") 
	public Set getCakeSet() {
		return CakeSet;
	}
	public void setCakeSet(Set cakeSet) {
		CakeSet = cakeSet;
	}
	
}
