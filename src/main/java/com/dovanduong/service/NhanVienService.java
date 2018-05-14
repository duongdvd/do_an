package com.dovanduong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovanduong.dao.NhanVienDAO;
import com.dovanduong.daoimp.NhanVienImp;
import com.dovanduong.entity.NhanVien;

@Service
public class NhanVienService implements NhanVienImp {
	
	@Autowired
	NhanVienDAO nhanVienDAO;

	public boolean KiemTraDangNhap(String email, String matkhau) {
		boolean kiemtra = nhanVienDAO.KiemTraDangNhap(email, matkhau);
		return kiemtra;
	}

	public boolean ThemNhanVien(NhanVien nhanVien) {
		boolean ktThem = nhanVienDAO.ThemNhanVien(nhanVien);
		return ktThem;
	}

	public boolean LoginAdmin(String email, String matkhau) {
		// TODO Auto-generated method stub
		return nhanVienDAO.LoginAdmin(email, matkhau);
	}
	
	
}
