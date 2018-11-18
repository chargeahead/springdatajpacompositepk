package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Person;
import com.example.demo.model.PersonPK;
import com.example.demo.repository.PersonRepositoryInterface;

@Service
public class PersonService {
  @Autowired
  DataSource dataSource;
  
  @Autowired
  PersonRepositoryInterface pri;
  
  public Iterable<Person> getAll(){
	  return pri.findAll();
  }
  public List<Person> getByAge(Integer age){
	  return pri.findByAge(age);
  }
  public Optional<Person> getByPK(PersonPK personPK){
	  return pri.findById(personPK);
  }
  public Person save (String fullname,Integer locId,Integer age) {
	  Person p = new Person();
	  p.setPersonPK(new PersonPK(fullname,locId));
	  p.setAge(age);
	  return pri.save(p);
  }
}
