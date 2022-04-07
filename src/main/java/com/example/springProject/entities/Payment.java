package com.example.springProject.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_payment")
//Dependent Class (Order may or may not have payment)
public class Payment implements Serializable {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant timeStamp;
	
	@JsonIgnore
	@OneToOne
	@MapsId		//In the dependent Class
	private Order order;
	
	public Payment() {
		
	}

	public Payment(Long id, Instant timeStamp, Order order) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Instant timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
}
