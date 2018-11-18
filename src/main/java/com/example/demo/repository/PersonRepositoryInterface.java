package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;
import com.example.demo.model.PersonPK;

public interface PersonRepositoryInterface extends CrudRepository<Person,PersonPK>{
	public List<Person> findByAge(Integer age);

}
