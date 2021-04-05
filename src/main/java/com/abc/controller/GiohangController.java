package com.abc.controller;

import java.util.List;
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

import com.abc.entity.Binhluan;
import com.abc.entity.Giohang;
import com.abc.entity.Giohang_ID;
import com.abc.repository.GiohangRepository;

@RestController
public class GiohangController {
	@Autowired
	GiohangRepository repo;
	
	@GetMapping("/giohang/{username}")
    public List<Giohang> getGiohang(@PathVariable("username") String username) {
		List<Giohang> list = repo.getGiohangByUsername(username);
		return list;
    }
	
	@DeleteMapping("/giohang/{username}")
	public String deleteGiohangOfKhachhang(@PathVariable("username") String username) {
		try {
			repo.deleteGiohangByUsername(username);
		} catch (Exception e) {
			e.getMessage();
			return "false";
			// TODO: handle exception
		}
		return "true";
	}
	
	@DeleteMapping("/giohang/{username}/{masp}")
	public String deleteGiohangById(@PathVariable("username") String username, @PathVariable("masp") String masp) {
		try {
			repo.deleteGiohangByUsernameAndMasp(username, masp);
		} catch (Exception e) {
			e.getMessage();
			return "false";
		}
		return "true";
	}
	
}
