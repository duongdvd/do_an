package com.dovanduong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovanduong.dao.HoaDonDAO;
import com.dovanduong.entity.ChiTietHoaDon;
import com.dovanduong.entity.DanhMucSanPham;
import com.dovanduong.entity.HoaDon;
import com.dovanduong.service.DanhMucService;
import com.dovanduong.service.HoaDonService;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {
	@Autowired
	DanhMucService danhMucService;
	int time = 60*10;
	@GetMapping
	public String Default( HttpSession httpSession){
httpSession.setMaxInactiveInterval(time);
		
		if(null != httpSession.getAttribute("admin")) {
			return "dashboard";
		}
		else {
			return "redirect:/AdminLogin/";
		}
		
	}
	
	@GetMapping("/danhmucsanpham")
	public String Danhmuc(HttpSession httpSession, ModelMap modelMap) {
		
httpSession.setMaxInactiveInterval(time);
		
		if(null != httpSession.getAttribute("admin")) {
			List<DanhMucSanPham> list = danhMucService.LayDanhMuc();
			
			modelMap.addAttribute("danhmuc", list);
			return "danhmucadmin";
		}
		else {
			return "redirect:/AdminLogin/";
		}
	}
	@Autowired
	HoaDonService hoaDonService;
	@GetMapping("/hoadon")
	public String hoadon(HttpSession httpSession, ModelMap modelMap) {
		
httpSession.setMaxInactiveInterval(time);
		
		if(null != httpSession.getAttribute("admin")) {
			List<HoaDon> hoaDons = hoaDonService.Hoadon();
			modelMap.addAttribute("hoadon", hoaDons);
			return "hoadon";
		}
		else {
			return "redirect:/AdminLogin/";
		}
	}
}
