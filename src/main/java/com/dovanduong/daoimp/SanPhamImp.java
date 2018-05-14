package com.dovanduong.daoimp;

import java.util.List;

import com.dovanduong.entity.SanPham;

public interface SanPhamImp {
	List<SanPham> LayDanhSachSanPhamLimit(int spbatdau);
	List<SanPham> LaySanPhamHot(int sosp);
	SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham);
	List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc, int x, int y);
	boolean XoaSanPhamTheoMaSanPham(int masanpham);
	boolean ThemSanPham(SanPham sanPham);
	boolean CatNhatSanPham(SanPham sanPham);
}
