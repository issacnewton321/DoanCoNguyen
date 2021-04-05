package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Giohang;
import com.abc.entity.Giohang_ID;

public interface GiohangRepository extends JpaRepository<Giohang, Giohang_ID>{
	
	@Query(nativeQuery = true, value = "select * from Giohang where username = ?1")
	List<Giohang> getGiohangByUsername(String username);
	
	
	@Query(nativeQuery = true, value = "delete from Giohang where username = ?1")
	List<Giohang> deleteGiohangByUsername(String username);
	
	@Query(nativeQuery = true, value = "delete from Giohang where username = ?1 and masp = ?2")
	List<Giohang> deleteGiohangByUsernameAndMasp(String username, String masp);
}
