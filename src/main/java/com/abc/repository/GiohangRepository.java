package com.abc.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Giohang;
import com.abc.entity.Giohang_ID;

@Service
@Repository
public interface GiohangRepository extends JpaRepository<Giohang, Giohang_ID>{
	
	@Query(nativeQuery = true, value = "select * from Giohang where username = ?1")
	List<Giohang> getGiohangByUsername(String username);
	
	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from Giohang where username = ?1")
	List<Giohang> deleteGiohangByUsername(String username);
	
}
