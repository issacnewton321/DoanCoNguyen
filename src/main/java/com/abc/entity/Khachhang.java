package com.abc.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Khachhang {
	@Id
	String mand;
	String ho;
	String ten;
	String diachi;
	String sdt;
	String email;
	int gioitinh;
	Date ngaytaotk;
	
	@JsonIgnore
	@OneToOne(mappedBy = "khachhang")
	Nguoidung nguoidung;

	public String getMand() {
		return mand;
	}

	public void setMand(String mand) {
		this.mand = mand;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(int gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaytaotk() {
		return ngaytaotk;
	}

	public void setNgaytaotk(Date ngaytaotk) {
		this.ngaytaotk = ngaytaotk;
	}

	public Nguoidung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(Nguoidung nguoidung) {
		this.nguoidung = nguoidung;
	}
	
	
}
