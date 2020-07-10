package br.com.rlabs.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Address Entity Model.
 * 
 * @author Ryan Padilha <ryan.padilha@gmail.com>
 * @since 0.1
 *
 */
@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = -6666579301627981408L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "")
	@Size(min = 1, max = 200)
	private String addressRaw;

	private String number;

	@NotEmpty(message = "Latitude must be informed")
	@Size(min = 1)
	private Double lat;

	@NotEmpty(message = "Longitude must be informed")
	@Size(min = 1)
	private Double lng;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date created = new Date();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddressRaw() {
		return addressRaw;
	}

	public void setAddressRaw(String addressRaw) {
		this.addressRaw = addressRaw;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
