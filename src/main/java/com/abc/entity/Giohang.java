package com.abc.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Giohang {
	@EmbeddedId
	Giohang_ID id;
	int soluong;
	
	@ManyToOne
	@MapsId("makh")
	@JoinColumn(name = "makh")
	Nguoidung nguoidung;
	
	@ManyToOne
	@MapsId("masp")
	@JoinColumn(name = "masp")
	Sanpham sanpham;

	public Giohang_ID getId() {
		return id;
	}

	public void setId(Giohang_ID id) {
		this.id = id;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public Nguoidung getNguoidung() {
		return nguoidung;
	}

	public void setNguoidung(Nguoidung nguoidung) {
		this.nguoidung = nguoidung;
	}

	public Sanpham getSanpham() {
		return sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}
	
	
}
