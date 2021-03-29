package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.entity.Khachhang;
import com.abc.entity.Nguoidung;

public interface NguoidungRepository extends JpaRepository<Nguoidung, String>{

}
