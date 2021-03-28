package com.abc.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Danhmuc {
	@Id
	String madm;
	String tendm;
	
	@JsonIgnore
	@OneToMany(mappedBy = "danhmuc", fetch=FetchType.EAGER)
	Collection<Sanpham> sanpham;
	
//	List<Sanpham> listSanPham;
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
//	public List<Sanpham> getListSanPham() {
//		return listSanPham;
//	}
	public void setListSanPham(List<Sanpham> listSanPham) {
		listSanPham = listSanPham;
	}
	
}
