package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Danhmuc;
import com.abc.entity.Sanpham;
import com.abc.repository.DanhmucRepository;

@RestController
public class DanhmucController {
	@Autowired
	DanhmucRepository repo;
	@GetMapping("/danhmuc")
	public List<Danhmuc> getListDM(){
		return repo.findAll();
	}
	@PostMapping("/danhmuc")
	public Danhmuc getListDM(@Validated @RequestBody Danhmuc dm){
		repo.save(dm);
		return dm;
	}
	@DeleteMapping("/danhmuc/{id}")
    public Danhmuc deleteDanhmuc(@Validated Danhmuc dm, String id) {
		repo.deleteById(id);
		return dm;	
	}
	@PutMapping("/danhmuc")
	public Danhmuc editDanhmuc(@Validated @RequestBody Danhmuc dm) {
		repo.save(dm);
		return dm;	
	}
	@GetMapping("/danhmuc/{id}")
	public Danhmuc getIdDanhmuc(@Validated Danhmuc dm, String id) {
		repo.findById(id);
		return dm;
		
	}
}
