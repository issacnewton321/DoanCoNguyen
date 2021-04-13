package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Danhmuc;

@Service
@Repository
public interface DanhmucRepository extends JpaRepository<Danhmuc, String>{
	Danhmuc findByMadm(String madm);
}
