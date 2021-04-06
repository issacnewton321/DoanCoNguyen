package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.Donhang;

public interface DonhangRepositoty extends JpaRepository<Donhang, String>{
	
	@Query(nativeQuery = true, value= "select * from donhang where username=?1")
	List<Donhang> getDonhangByUsername(String username);

}
