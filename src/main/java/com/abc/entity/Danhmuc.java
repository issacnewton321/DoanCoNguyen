package com.abc.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Danhmuc {
	@Id
	String madm;
	String tendm;
	@OneToMany(mappedBy = "danhmuc")
	List<Sanpham> ListSanPham;
	public String getMadm() {
		return madm;
	}
	public void setMadm(String madm) {
		this.madm = madm;
	}
	public String getTendm() {
		return tendm;
	}
	public void setTendm(String tendm) {
		this.tendm = tendm;
	}
	public List<Sanpham> getListSanPham() {
		return ListSanPham;
	}
	public void setListSanPham(List<Sanpham> listSanPham) {
		ListSanPham = listSanPham;
	}
	
}
