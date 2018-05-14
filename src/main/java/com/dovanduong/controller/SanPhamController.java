package com.dovanduong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovanduong.entity.DanhMucSanPham;
import com.dovanduong.entity.GioHang;
import com.dovanduong.entity.SanPham;
import com.dovanduong.service.DanhMucService;
import com.dovanduong.service.SanPhamService;

@Controller
@RequestMapping("/sanpham")
public class SanPhamController {
	
	@Autowired
	DanhMucService danhMucService;
	
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping("/{id}/{tendanhmuc}")
	public String Default(HttpSession httpSession, ModelMap modelMap,@PathVariable int id,@PathVariable String tendanhmuc){
		if(null != httpSession.getAttribute("giohang")){
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang",gioHangs.size());
		}
		List<SanPham> listSanPhams = sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id,1,0);
		List<SanPham> allSanPham = sanPhamService.LayDanhSachSanPhamTheoMaDanhMuc(id,-1,0);
		List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		
		double tongsopage = Math.ceil((double) allSanPham.size() / 5);
		System.out.println("tong : "+tongsopage);
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		modelMap.addAttribute("tendanhmuc",tendanhmuc);
		modelMap.addAttribute("listSanPham",listSanPhams);
		modelMap.addAttribute("allSanPham", allSanPham);
		modelMap.addAttribute("tongsopage", tongsopage);
		modelMap.addAttribute("madanhmuc", id);
		return "sanpham";
	}
}
