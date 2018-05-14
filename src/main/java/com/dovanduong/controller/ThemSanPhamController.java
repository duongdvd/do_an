package com.dovanduong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovanduong.entity.DanhMucSanPham;
import com.dovanduong.entity.MauSanPham;
import com.dovanduong.entity.SanPham;
import com.dovanduong.entity.SizeSanPham;
import com.dovanduong.service.DanhMucService;
import com.dovanduong.service.MauSanPhamService;
import com.dovanduong.service.SanPhamService;
import com.dovanduong.service.SizeSanPhamService;

@Controller
@RequestMapping("/themsanpham")
public class ThemSanPhamController {
	
	@Autowired
	SanPhamService sanPhamService;
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	MauSanPhamService mauSanPhamService;
	
	@Autowired
	SizeSanPhamService sizeSanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap, HttpSession httpSession){
	
		httpSession.setMaxInactiveInterval(60*10);
		
		if(null != httpSession.getAttribute("admin")) {
			
		List<SanPham> listSanPhams =  sanPhamService.LayDanhSachSanPhamLimit(0);
		List<SanPham> allSanPham = sanPhamService.LayDanhSachSanPhamLimit(-1);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		List<MauSanPham> listMauSanPham = mauSanPhamService.LayDanhSachMau();
		List<SizeSanPham> listSizeSanPham = sizeSanPhamService.LayDanhSachSize();
		
		double tongsopage = Math.ceil((double) allSanPham.size() / 5);
		modelMap.addAttribute("listSanPham", listSanPhams);
		modelMap.addAttribute("allSanPham", allSanPham);
		modelMap.addAttribute("tongsopage", tongsopage);
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		modelMap.addAttribute("listsize",listSizeSanPham);
		modelMap.addAttribute("listmau",listMauSanPham);
		
		return "themsanpham";
	}
		else {
			return "redirect:/AdminLogin/";
		}
		
	}
}
