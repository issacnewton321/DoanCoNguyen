package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Sanpham;

@Service
@Repository
public interface SanphamRepository extends JpaRepository<Sanpham, String>{

}
