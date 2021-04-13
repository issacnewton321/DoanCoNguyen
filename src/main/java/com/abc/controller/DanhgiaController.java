package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.CTDH;
import com.abc.entity.Danhgia;
import com.abc.repository.DanhgiaRepository;

@RestController
public class DanhgiaController {
	@Autowired
	DanhgiaRepository repo;

	@GetMapping("/danhgia/{masp}")
	public Float getDanhgia(@PathVariable("masp") String masp) {

		List<Danhgia> list = repo.getDanhgiaByMasp(masp);
		float tong = 0;
		for (Danhgia dg : list) {
			tong += dg.getDanhgia();
		}
		tong = tong / (list.size());
		return tong;
	}

	@PostMapping("/danhgia")
	public String postDanhgia(@Validated @RequestBody Danhgia dg) {

		List<CTDH> list = repo.checkDonhangByUsername(dg.getId().getMasp(), dg.getId().getMand());
		if (list.size() == 0) {
			return "false";
		}
		repo.save(dg);
		return "true";
	}
	
	@DeleteMapping("/danhgia/{mand}/{masp}")
	public String deleteDanhgia(@PathVariable ("mand") String mand, @PathVariable ("masp") String masp) {
		
		try {
			repo.deleteDanhgiaByUsername(mand, masp);
		} catch (Exception e) {
			e.getMessage();
			return "false";
		}
		return "true";
	}

}
