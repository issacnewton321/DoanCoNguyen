package com.abc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Khachhang;

@Service
@Repository
public interface KhachhangRepository extends JpaRepository<Khachhang, String> {
	@Transactional
	@Modifying
	String deleteByMakh(String makh);
}
