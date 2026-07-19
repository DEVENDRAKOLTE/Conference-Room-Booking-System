package com.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
@Id
@Column(name="id")
  int id;
@Column(name="name")
  String name;

@Column(name="password")
String password;

@Column(name="type")
String type;


public User(String name, String password, String type, List<Booking> bookings) {
	super();
	this.name = name;
	this.password = password;
	this.type = type;
	this.bookings = bookings;
}

@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Booking> bookings = new ArrayList<>();

public User() {
	// TODO Auto-generated constructor stub
}
public User(String name, String pssword) {
	super();
	this.name = name;
	this.password = pssword;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public void setName(String name) {
	this.name = name;
}

public String getPassword() {
	return password;
}

public void setPassword(String pssword) {
	this.password = pssword;
}

public List<Booking> getBookings() {
	return bookings;
}

public void setBookings(List<Booking> bookings) {
	this.bookings = bookings;
}


  

}
