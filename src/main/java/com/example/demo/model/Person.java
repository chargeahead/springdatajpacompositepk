package com.example.demo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity(name="persons")
public class Person {
	@EmbeddedId
	PersonPK personPK;
	Integer age;
	public PersonPK getPersonPK() {
		return personPK;
	}
	public void setPersonPK(PersonPK personPK) {
		this.personPK = personPK;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
