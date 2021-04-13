package com.abc.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Nhanvien;

@Service
@Repository
public interface NhanvienRepository extends JpaRepository<Nhanvien, String> {
	@Transactional
	@Modifying
	String deleteByManv(String manv);
}
