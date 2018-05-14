package com.dovanduong.daoimp;

import com.dovanduong.entity.NhanVien;

public interface NhanVienImp {
	boolean KiemTraDangNhap(String email,String matkhau);
	boolean ThemNhanVien(NhanVien nhanVien);
	boolean LoginAdmin(String email,String matkhau);
	
}
