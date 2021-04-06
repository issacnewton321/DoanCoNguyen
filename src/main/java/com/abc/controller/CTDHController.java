package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.entity.CTDH;
import com.abc.entity.Danhgia;
import com.abc.entity.Donhang;
import com.abc.repository.CTDHRepository;

@RestController
public class CTDHController {
	
	@Autowired
	CTDHRepository repo;
	
	@GetMapping("/ctdh/{madh}")
	public List<CTDH> getCTDH(@PathVariable("madh") String madh){
		List<CTDH> list = repo.getCTDHByMadh(madh);
		return list;
	}
	
//	@PostMapping("/ctdh/{madh}/{username}")
//	public String postCTDH(@Validated @RequestBody CTDH ct) {
//		
//		List<CTDH> list = repo.checkCTDHByUsername(ct.getId().getMadh());
//		if(list.size()==0) {
//			return "false";
//		}
//		repo.save()
//		
//	}
}
