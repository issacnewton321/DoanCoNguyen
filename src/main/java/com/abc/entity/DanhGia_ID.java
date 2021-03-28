package com.abc.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DanhGia_ID implements Serializable{
	String mand;
	String masp;
	public String getMand() {
		return mand;
	}
	public void setMand(String mand) {
		this.mand = mand;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	
	
}
