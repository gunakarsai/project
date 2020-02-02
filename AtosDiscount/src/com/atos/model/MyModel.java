package com.atos.model;

public class MyModel {
	private int id;
	private String Name;
	private String Password;
	private String Email;
	private String Country;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public MyModel(int id, String name, String password, String email, String country) {
		super();
		this.id = id;
		Name = name;
		Password = password;
		Email = email;
		Country = country;
	}
	public MyModel() {
		super();
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
}
