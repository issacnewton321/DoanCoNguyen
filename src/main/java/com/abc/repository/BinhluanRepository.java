package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Binhluan;

@Service
@Repository
public interface BinhluanRepository extends JpaRepository<Binhluan, Integer>{

}
