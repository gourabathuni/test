package br.com.rlabs.resource.impl;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.rlabs.model.entity.Person;
import br.com.rlabs.resource.PersonResource;
import br.com.rlabs.service.PersonService;

/**
 * The Person Resource REST API.<br>
 * API definition documented by Swagger 2.0.
 * 
 * @author Ryan Padilha <ryan.padilha@gmail.com>
 * @since 0.1
 *
 */
@RestController
@RequestMapping(value = "/api/v1/persons")
public class PersonResourceImpl implements PersonResource {

	@Autowired
	private PersonService service;

	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Person>> list() {
		final List<Person> persons = service.list();

		if (persons.isEmpty())
			return new ResponseEntity<List<Person>>(Collections.emptyList(), HttpStatus.NO_CONTENT);

		return new ResponseEntity<List<Person>>(persons, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Person> get(@PathVariable("id") Long id) {
		final Person person = service.get(id);

		if (null == person)
			return new ResponseEntity<Person>(new Person(), HttpStatus.NO_CONTENT);

		return new ResponseEntity<Person>(person, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = { "", "/" }, method = RequestMethod.POST)
	public ResponseEntity<Person> create(@Valid @RequestBody Person person) {
		final Person persisted = service.create(person);

		if (null == persisted)
			return new ResponseEntity<Person>(person, HttpStatus.NOT_MODIFIED);

		return new ResponseEntity<Person>(persisted, HttpStatus.CREATED);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Person> update(@PathVariable("id") Long id, @Valid @RequestBody Person person) {
		final Person persisted = service.update(id, person);

		if (null == persisted)
			return new ResponseEntity<Person>(new Person(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Person>(persisted, HttpStatus.OK);
	}

	@Override
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Person> delete(@PathVariable("id") Long id) {
		final Person persisted = service.delete(id);

		if (null == persisted)
			return new ResponseEntity<Person>(new Person(), HttpStatus.NOT_FOUND);

		return new ResponseEntity<Person>(new Person(), HttpStatus.NO_CONTENT);
	}

}
