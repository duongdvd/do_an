package com.dovanduong.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.dovanduong.service.NhanVienService;

@Controller
@RequestMapping("AdminLogin/")
@SessionAttributes("admin")
public class AdminLoginController {
	@Autowired
	NhanVienService nhanVienService;
	@GetMapping
	public String Default() {
		
		return "adminLogin";
		}
	
	
	
	@PostMapping
	public String checkLogin(@RequestParam String name, @RequestParam String password, ModelMap modelMap , HttpSession httpSession) {
		
		boolean check = nhanVienService.LoginAdmin(name, password);
		//
		if(check) {
			httpSession.setAttribute("admin", name);
			return "redirect:/themsanpham";
		}
		else {
			modelMap.addAttribute("loginfalie", "Đăng nhập không thành công :((");
			return "adminLogin";
		}
	}
}
