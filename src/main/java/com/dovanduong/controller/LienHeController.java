package com.dovanduong.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dovanduong.entity.DanhMucSanPham;
import com.dovanduong.entity.GioHang;
import com.dovanduong.service.DanhMucService;
import com.dovanduong.service.SanPhamService;

@Controller
@RequestMapping("/lienhe")
public class LienHeController {
	@Autowired
	DanhMucService danhMucService;
	@Autowired
	SanPhamService sanPhamService;
	
	@GetMapping
	public String Default(ModelMap modelMap,HttpSession httpSession) {	
		if(null != httpSession.getAttribute("giohang")){
			List<GioHang> gioHangs = (List<GioHang>) httpSession.getAttribute("giohang");
			modelMap.addAttribute("soluongsanphamgiohang",gioHangs.size());
		}
List<DanhMucSanPham> danhMucSanPhams = danhMucService.LayDanhMuc();
		if(httpSession.getAttribute("user") != null){
			String email = (String) httpSession.getAttribute("user");
			String chucaidau = email.substring(0, 1);
			modelMap.addAttribute("chucaidau", chucaidau);
		}
		modelMap.addAttribute("danhmuc",danhMucSanPhams);
		return "lienhe";
	}
}
