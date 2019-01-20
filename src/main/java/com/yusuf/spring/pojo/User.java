package com.yusuf.spring.pojo;

public class User {

	private long id;
	private String name;
	private String password;
	private Email email;
	private Advert advert;
	private String advertTitle;
	

	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public User(String name, String password,Advert advert) {
		this.name = name;
		this.password = password;
		this.setAdvert(advert);
	}

	User() {
	}
	
	
	
	public String getAdvertTitle() {
		return advertTitle;
	}

	public void setAdvertTitle(String advertTitle) {
		this.advertTitle = advertTitle;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	protected long getId() {
		return id;
	}

	protected void setId(long id) {
		this.id = id;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public Advert getAdvert() {
		return advert;
	}

	public void setAdvert(Advert advert) {
		this.advert = advert;
	}

}