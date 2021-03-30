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

import com.abc.entity.Nguoidung;
import com.abc.repository.NguoidungRepository;

@RestController
public class NguoidungController {
	@Autowired
	NguoidungRepository repo;
	
	@GetMapping("/nguoidung")
    public ResponseEntity<List<Nguoidung>> getNguoidung() {
        return new ResponseEntity<>(repo.findAll(), HttpStatus.OK);
    }
	
	@GetMapping("/nguoidung/{username}")
	public Optional<Nguoidung> getUsernameNguoidung(@PathVariable("username") String username) {
		return repo.findById(username);
	}
	
	@PostMapping("/nguoidung")
	public String postNguoidung(@Validated @RequestBody Nguoidung nd) {
		
		List<Nguoidung> listNd = repo.findAll();
		for (Nguoidung nd1 : listNd) {
			if (nd1.getUsername().equalsIgnoreCase(nd.getUsername())) {
				return "false";
			}
		}
		repo.save(nd);
		return "true";
	}
	
	@PutMapping("/nguoidung")
	public String putNguoidung(@Validated @RequestBody Nguoidung nd) {
		try {
			repo.save(nd);
		} catch (Exception ex) {
			ex.getMessage();
			return "false";
		}
		return "true";
	}
	
	@DeleteMapping("/mguoidung/{username}")
	public String deleteUsernameNguoidung(@PathVariable("username") String username) {
		try {
			repo.deleteById(username);
		} catch (Exception e) {
			e.getMessage();
			return "false";
			// TODO: handle exception
		}
		return "true";
	}
}
