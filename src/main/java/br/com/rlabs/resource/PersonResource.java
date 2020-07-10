package br.com.rlabs.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.com.rlabs.model.entity.Person;

/**
 * The Person Resource Interface.
 * 
 * @author Ryan Padilha <ryan.padilha@gmail.com>
 * @since 0.1
 *
 */
public interface PersonResource {

	ResponseEntity<List<Person>> list();

	ResponseEntity<Person> get(Long id);

	ResponseEntity<Person> create(Person person);

	ResponseEntity<Person> update(Long id, Person person);

	ResponseEntity<Person> delete(Long id);
}
