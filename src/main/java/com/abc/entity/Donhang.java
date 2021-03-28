package com.abc.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Donhang {
	@Id
	String madh;
	float tongtien;
	Date ngaydat;
	int trangthai;
	int hinhthucthanhtoan;
	
	@OneToMany(mappedBy = "donhang")
	List<CTDH> listCTDH;

	public String getMadh() {
		return madh;
	}

	public void setMadh(String madh) {
		this.madh = madh;
	}

	public float getTongtien() {
		return tongtien;
	}

	public void setTongtien(float tongtien) {
		this.tongtien = tongtien;
	}

	public Date getNgaydat() {
		return ngaydat;
	}

	public void setNgaydat(Date ngaydat) {
		this.ngaydat = ngaydat;
	}

	public int getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(int trangthai) {
		this.trangthai = trangthai;
	}

	public int getHinhthucthanhtoan() {
		return hinhthucthanhtoan;
	}

	public void setHinhthucthanhtoan(int hinhthucthanhtoan) {
		this.hinhthucthanhtoan = hinhthucthanhtoan;
	}

	public List<CTDH> getListCTDH() {
		return listCTDH;
	}

	public void setListCTDH(List<CTDH> listCTDH) {
		this.listCTDH = listCTDH;
	}
	
	
}
