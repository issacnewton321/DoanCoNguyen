package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Khachhang;
import com.abc.entity.Nguoidung;


@Service
@Repository
public interface NguoidungRepository extends JpaRepository<Nguoidung, String>{
	
}
