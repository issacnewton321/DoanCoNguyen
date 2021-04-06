package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.entity.CTDH;
import com.abc.entity.CTDH_ID;
import com.abc.entity.Donhang;

public interface CTDHRepository extends JpaRepository<CTDH, CTDH_ID>{
	
	@Query(nativeQuery = true, value = "select * from ctdh where madh =?1")
	List<CTDH> getCTDHByMadh(String madh);

	@Query(nativeQuery = true, value = "SELECT *\r\n"
			+ "FROM ctdh ct\r\n"
			+ "WHERE ct.madh=?1 and EXISTS (SELECT 1\r\n"
			+ "              FROM donhang dh\r\n"
			+ "              WHERE dh.username=?2 and dh.madh=ct.madh)")
	List<CTDH> checkCTDHByUsername(String madh, String username);
}
