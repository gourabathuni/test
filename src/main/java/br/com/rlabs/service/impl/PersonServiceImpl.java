package br.com.rlabs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rlabs.model.entity.Person;
import br.com.rlabs.repository.PersonRepository;
import br.com.rlabs.service.PersonService;

/**
 * The Person Service.
 * 
 * @author Ryan Padilha <ryan.padilha@gmail.com>
 * @since 0.1
 *
 */
@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repository;

	@Override
	public List<Person> list() {
		return repository.findAll();
	}

	@Override
	public Person get(Long id) {
		return repository.getOne(id);
	}

	@Transactional
	@Override
	public Person create(Person person) {
		return repository.save(person);
	}

	@Transactional
	@Override
	public Person update(Long id, Person person) {
		final Person persisted = repository.getOne(id);

		if (null == persisted)
			return null;

		persisted.setName(person.getName());
		persisted.setEmail(person.getEmail());
		persisted.setDocument(person.getDocument());

		return repository.save(persisted);
	}

	@Transactional
	@Override
	public Person delete(Long id) {
		final Person persisted = repository.getOne(id);

		if (null == persisted)
			return null;

		repository.delete(persisted);
		return persisted;
	}

}
