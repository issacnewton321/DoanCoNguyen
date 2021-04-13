package com.abc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Giohang_ID implements Serializable{
	String username;
	String masp;
	
	public Giohang_ID() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Giohang_ID(String username, String masp) {
		super();
		this.username = username;
		this.masp = masp;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	
	
}
