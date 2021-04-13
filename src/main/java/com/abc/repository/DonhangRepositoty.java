package com.abc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.abc.entity.Donhang;

@Service
@Repository
public interface DonhangRepositoty extends JpaRepository<Donhang, String>{

}
