package br.com.rlabs.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Person Entity Model.
 * 
 * @author Ryan Padilha <ryan.padilha@gmail.com>
 * @since 0.1
 *
 */
@Entity
@Table(name = "person")
public class Person implements Serializable {

	private static final long serialVersionUID = 2277957532205899169L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "Name must be informed")
	@Size(min = 1, max = 100)
	private String name;

	@NotEmpty(message = "Email must be informed")
	private String email;

	@NotEmpty(message = "Document must be informed")
	@Size(min = 1, max = 20)
	private String document;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

}
