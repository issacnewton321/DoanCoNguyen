package com.abc.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="nguoidung",uniqueConstraints = @UniqueConstraint(columnNames = {"manv","makh"}))
public class Nguoidung {
	@Id
	String username;
	String password;
	int quyen;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nguoidung")
	List<Danhgia> listDanhGia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nguoidung")
	List<Binhluan> listBinhLuan;
	
	@JsonIgnore
	@OneToMany(mappedBy = "nguoidung")
	List<Giohang> listGioHang;
	
	@JsonIgnore
	@OneToOne
	
	@JoinColumn(name ="manv", nullable = true)
	Nhanvien nhanvien;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name ="makh",nullable = true)
	Khachhang khachhang;
	
	
	
	public Nhanvien getNhanvien() {
		return nhanvien;
	}

	public void setNhanvien(Nhanvien nhanvien) {
		this.nhanvien = nhanvien;
	}

	public Khachhang getKhachhang() {
		return khachhang;
	}

	public void setKhachhang(Khachhang khachhang) {
		this.khachhang = khachhang;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}

	public List<Danhgia> getListDanhGia() {
		return listDanhGia;
	}

	public void setListDanhGia(List<Danhgia> listDanhGia) {
		this.listDanhGia = listDanhGia;
	}

	public List<Binhluan> getListBinhLuan() {
		return listBinhLuan;
	}

	public void setListBinhLuan(List<Binhluan> listBinhLuan) {
		this.listBinhLuan = listBinhLuan;
	}

	public List<Giohang> getListGioHang() {
		return listGioHang;
	}

	public void setListGioHang(List<Giohang> listGioHang) {
		this.listGioHang = listGioHang;
	}
	
}
