package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonPK implements Serializable{
	private static final long serialVersionUID = 1L;
    @Column(name="fullname")
	String fullname;
    @Column(name="loc_id")
	Integer locId;
    public PersonPK() {}
	public PersonPK(String fullname, Integer locId) {
		super();
		this.fullname = fullname;
		this.locId = locId;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public Integer getLocId() {
		return locId;
	}
	public void setLocId(Integer locId) {
		this.locId = locId;
	}
    
}
