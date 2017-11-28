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

@Entity
@Table(name="cakestep")
public class CakeStep {
	private int stepid;
	private String stepname;
	private Set CakeSet = new HashSet<Cake>();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getStepid() {
		return stepid;
	}
	public void setStepid(int stepid) {
		this.stepid = stepid;
	}
	@Column(name="stepname")
	public String getStepname() {
		return stepname;
	}
	public void setStepname(String stepname) {
		this.stepname = stepname;
	}
	@OneToMany(targetEntity=Cake.class, 
            cascade=CascadeType.ALL)
	@JoinColumn(name="stepid") 
	public Set getCakeSet() {
		return CakeSet;
	}
	public void setCakeSet(Set cakeSet) {
		CakeSet = cakeSet;
	}

}
