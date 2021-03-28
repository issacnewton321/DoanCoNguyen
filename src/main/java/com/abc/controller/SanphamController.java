package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Danhmuc;
import com.abc.entity.Khachhang;
import com.abc.entity.Sanpham;
import com.abc.repository.SanphamRepository;

@RestController
public class SanphamController {
	@Autowired
	SanphamRepository repo;
	@GetMapping("/sanpham")
     public ResponseEntity<List<Sanpham>> all() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.NOT_FOUND);
	}
	@PostMapping("/sanpham")
	public Sanpham insertSanpham(@Validated @RequestBody Sanpham sp) {
		repo.save(sp);
		return sp;
	}
	@DeleteMapping("/sanpham/{id}")
    public Sanpham deleteSanpham(@Validated Sanpham sp, String id) {
		repo.deleteById(id);
		return sp;	
	}
	@PutMapping("/sanpham")
	public Sanpham EditSanpham(@Validated @RequestBody Sanpham sp) {
		repo.save(sp);
		return sp;
		
	}
	@GetMapping("/sanpham/{id}")
	public Sanpham getIdSanpham(@Validated Sanpham sp, String id) {
		repo.findById(id);
		return sp;
	}
}
