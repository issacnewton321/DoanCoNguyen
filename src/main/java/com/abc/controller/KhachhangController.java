package com.abc.controller;

import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Khachhang;
import com.abc.repository.KhachhangRepository;

@RestController
public class KhachhangController {
	@Autowired
	KhachhangRepository repo;
	
	@GetMapping("/khachhang")
    public ResponseEntity<List<Khachhang>> all() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.NOT_FOUND);
    }
	
	@PostMapping("/khachhang")
	public Khachhang postKhachhang(@Validated @RequestBody Khachhang kh) {
		repo.save(kh);
		return kh;
	}
	
	
}
