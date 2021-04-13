package com.abc.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.Binhluan;
import com.abc.entity.Giohang;
import com.abc.entity.Giohang_ID;
import com.abc.entity.Nguoidung;
import com.abc.entity.Sanpham;
import com.abc.repository.GiohangRepository;

@RestController
@CrossOrigin
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
		Giohang gh = new Giohang();
		gh.setId(new Giohang_ID(username, masp));
		try {
			repo.delete(gh);
		} catch (Exception e) {
			e.getMessage();
			e.printStackTrace();
			return "false";
		}
		return "true";
	}
	@PostMapping("/giohang/{username}/{masp}")
	public String addCart(@PathVariable("username") String username, @PathVariable("masp") String masp,@RequestParam("soluong") int soluong) {
		Giohang_ID id = new Giohang_ID(username, masp);
		Giohang gh = new Giohang();
		gh.setId(id);
		gh.setSoluong(soluong);
		Sanpham sp = new Sanpham();
		sp.setMasp(masp);
		Nguoidung nd = new Nguoidung();
		nd.setUsername(username);
		gh.setSanpham(sp);
		gh.setNguoidung(nd);
		
		List<Giohang> listGH = repo.findAll();
		for(Giohang i:listGH) {
			if(i.getId().getMasp().equalsIgnoreCase(masp) && i.getId().getUsername().equalsIgnoreCase(username)) {
				gh.setSoluong(soluong +i.getSoluong());
			}
		}
		try {
			repo.save(gh);
			return "true";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "false";
	}
	
}
