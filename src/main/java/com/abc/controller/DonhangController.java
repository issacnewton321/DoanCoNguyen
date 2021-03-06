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

import com.abc.entity.Donhang;
import com.abc.repository.DonhangRepositoty;

@RestController
public class DonhangController {
	@Autowired
	DonhangRepositoty repo;
	
	@GetMapping("/donhang")
    public ResponseEntity<List<Donhang>> getDonhang() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
	
	@GetMapping("/donhang/{username}/{madh}")// ?username làm biến ảo (không trùng với các method get khác) có thể nhập sai trường username :)
	public Optional<Donhang> getIdDonhang(@PathVariable("madh") String madh) {
		return repo.findById(madh);
	}
	
	@GetMapping("/donhang/{username}")
	public List<Donhang> getDonhangByUsername(@PathVariable("username") String username){
		return repo.getDonhangByUsername(username);
	}
	
	@PostMapping("/donhang")
	public String postDonhang(@Validated @RequestBody Donhang dh) {
		
		List<Donhang> listDh = repo.findAll();
		for (Donhang dh1 : listDh) {
			if (dh1.getMadh().equalsIgnoreCase(dh.getMadh())) {
				return "false";
			}
		}
		repo.save(dh);
		return "true";
	}
	
	@PutMapping("/donhang")
	public String putDonhang(@Validated @RequestBody Donhang dh) {
		try {
			repo.save(dh);
		} catch (Exception ex) {
			ex.getMessage();
			return "false";
		}
		return "true";
	}
	
	@DeleteMapping("/donhang/{madh}")
	public String deleteIdDonhang(@PathVariable("madh") String madh) {
		try {
			repo.deleteById(madh);
		} catch (Exception e) {
			e.getMessage();
			return "false";
			// TODO: handle exception
		}
		return "true";
	}
}
