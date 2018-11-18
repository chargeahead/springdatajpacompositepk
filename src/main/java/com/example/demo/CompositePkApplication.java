package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.model.Person;
import com.example.demo.model.PersonPK;
import com.example.demo.service.PersonService;

@SpringBootApplication
@EntityScan("com.example.demo.model")
@EnableJpaRepositories(basePackages= {"com.example.demo.repository"})

public class CompositePkApplication  implements CommandLineRunner{
    
	@Autowired
	PersonService ps;
	public static void main(String[] args) {
		SpringApplication.run(CompositePkApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Person p = ps.save("John Doe",2,32);
		System.out.println("Person inserted with fullname "+p.getPersonPK().getFullname());
		
		Optional<Person> p2 = ps.getByPK(new PersonPK("John Doe",2));
		System.out.println("Person retrieved with fullname "+p2.get().getPersonPK().getFullname());
	}
}
