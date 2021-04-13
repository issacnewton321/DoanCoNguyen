package com.abc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abc.entity.CTDH;
import com.abc.entity.DanhGia_ID;
import com.abc.entity.Danhgia;
import com.abc.entity.Nguoidung;
import com.abc.entity.Sanpham;

public interface DanhgiaRepository extends JpaRepository<Danhgia, DanhGia_ID>{
	
	@Query(nativeQuery = true, value = "select * from danhgia where masp = ?1")
	List<Danhgia> getDanhgiaByMasp(String masp);
	
	@Query(nativeQuery = true, value = "SELECT *\r\n"
			+ "FROM ctdh ct\r\n"
			+ "WHERE ct.masp=?1 and EXISTS (SELECT 1\r\n"
			+ "              FROM donhang dh\r\n"
			+ "              WHERE dh.username=?2 and dh.madh=ct.madh)")
	List<CTDH> checkDonhangByUsername(String masp, String username);
	
	@Query(nativeQuery = true, value = "delete from danhgia where mand=?1 and masp=?2")
	List<Danhgia> deleteDanhgiaByUsername(String mand, String masp);

}
