package com.fatihtoker.mongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatihtoker.mongodb.model.Person;
import com.fatihtoker.mongodb.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	//Create operation
	public Person create(String firstName, String lastName, int age) {
		return personRepository.save(new Person(firstName, lastName, age));
	}
	
	//Retrieve Operation
	public List<Person> getAll(){
		return personRepository.findAll();
	}
	
	public Person getByFirstName(String firstName) {
		return personRepository.findByFirstName(firstName);
	}
	
	//Update operation
	public Person update(String firstName, String lastName, int age) {
		Person p = personRepository.findByFirstName(firstName);
		p.setLastName(lastName);
		p.setAge(age);
		return personRepository.save(p);
	}
	
	public void delete(String firstName) {
		Person p = personRepository.findByFirstName(firstName);
		personRepository.delete(p);
	}
	
	public void deleteAll() {
		personRepository.deleteAll();
	}
	
}
