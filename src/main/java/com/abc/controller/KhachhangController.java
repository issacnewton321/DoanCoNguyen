package com.abc.controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.ast.Var;
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

import com.abc.entity.Khachhang;
import com.abc.repository.KhachhangRepository;

@RestController
public class KhachhangController {
	@Autowired
	KhachhangRepository repo;
	
	@GetMapping("/khachhang")
    public ResponseEntity<List<Khachhang>> getKhachhang() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
	
	@GetMapping("/khachhang/{mand}")
	public Optional<Khachhang> getIdKhachhang(@PathVariable("mand") String mand) {
		return repo.findById(mand);
	}
	
	@PostMapping("/khachhang")
	public String postKhachhang(@Validated @RequestBody Khachhang kh) {
		
		List<Khachhang> listKh = repo.findAll();
		for (Khachhang kh1 : listKh) {
			if (kh1.getMakh().equalsIgnoreCase(kh.getMakh())) {
				return "false";
			}
		}
		repo.save(kh);
		return "true";
	}
	
	@PutMapping("/khachhang")
	public String putKhachhang(@Validated @RequestBody Khachhang kh) {
		try {
			repo.save(kh);
		} catch (Exception ex) {
			ex.getMessage();
			return "false";
		}
		return "true";
	}
	
	@DeleteMapping("/khachhang/{mand}")
	public String deleteIdKhachhang(@PathVariable("mand") String mand) {
		try {
			repo.deleteById(mand);
		} catch (Exception e) {
			e.getMessage();
			return "false";
			// TODO: handle exception
		}
		return "true";
	}
	
}
