package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Danhmuc;
import com.abc.entity.Sanpham;
import com.abc.repository.SanphamRepository;

@RestController
public class SanphamController {
	@Autowired
	SanphamRepository repo;
	@GetMapping("/sanpham")
	public List<Sanpham> getSanpham() {
		return repo.findAll();
	}
	@PostMapping("/sanpham")
	public Sanpham insertSanpham(@Validated @RequestBody Sanpham sp) {
		repo.save(sp);
		return sp;
	}
	@DeleteMapping("/sanpham")
    public Sanpham deleteSanpham(@Validated @RequestBody Sanpham sp) {
		repo.delete(sp);
		return sp;	
	}
	@PutMapping("/sanpham")
	public Sanpham EditSanpham(@Validated @RequestBody Sanpham sp) {
		return sp;
		
	}
}
