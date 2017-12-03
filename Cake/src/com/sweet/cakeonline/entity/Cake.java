package com.sweet.cakeonline.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//蛋糕细节类
@Entity
@Table(name="cake")
public class Cake {
	private int id;
	private String gname;
	private String detail;
	private float price;
	private int typeid;
	private int stepid;
	private int sizeid;
	
//	private CakeSize cakesize;
//	private CakeStep cakestep;
//	private CakeType caketype;

	private String listimg;
	private String img1;
	private String img2;
	private String img3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="gname")
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	@Column(name="detail")
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	@Column(name="price")
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getListimg() {
		return listimg;
	}
	@Column(name="listimg")
	public void setListimg(String listimg) {
		this.listimg = listimg;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public int getTypeid() {
		return typeid;
	}
	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	public int getStepid() {
		return stepid;
	}
	public void setStepid(int stepid) {
		this.stepid = stepid;
	}
	public int getSizeid() {
		return sizeid;
	}
	public void setSizeid(int sizeid) {
		this.sizeid = sizeid;
	}
	
////	@ManyToOne          
////    @JoinColumn(name="sizeid") 
//	public CakeSize getCakesize() {
//		return cakesize;
//	}
//	public void setCakesize(CakeSize cakesize) {
//		this.cakesize = cakesize;
//	}
////	@ManyToOne          
////  @JoinColumn(name="stepid") 
//	public CakeStep getCakestep() {
//		return cakestep;
//	}
//	public void setCakestep(CakeStep cakestep) {
//		this.cakestep = cakestep;
//	}
//////	@ManyToOne          
//////    @JoinColumn(name="typeid") 
//	public CakeType getCaketype() {
//		return caketype;
//	}
//	public void setCaketype(CakeType caketype) {
//		this.caketype = caketype;
//	}	
}
