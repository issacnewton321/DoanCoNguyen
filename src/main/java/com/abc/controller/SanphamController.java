package com.abc.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
	}

	@PostMapping("/sanpham")
	public String postSanpham(@Validated @RequestBody Sanpham sp) {
		List<Sanpham> sanpham = repo.findAll();
		for (Sanpham s : sanpham) {
			if (s.getMasp().equalsIgnoreCase(sp.getMasp())) {
				return "false";
			}
		}
		repo.save(sp);
		return "true";
	}

	@DeleteMapping("/sanpham/{masp}")
	public String deleteIdSanpham(@PathVariable String masp) {
		try {
			repo.deleteById(masp);
		} catch (Exception e) {
			e.getMessage();
			return "false";
		}
		return "true";
	}

	@PutMapping("/sanpham")
	public String putSanpham(@Validated @RequestBody Sanpham sp) {
		try {
			repo.save(sp);
		} catch (Exception ex) {
			ex.getMessage();
			return "false";
		}
		return "true";
	}

	@GetMapping("/sanpham/{masp}")
	public Optional<Sanpham> getIdSanpham(@PathVariable("masp") String masp) {
		return repo.findById(masp);
	}
}
