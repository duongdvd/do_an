package com.dovanduong.daoimp;

import java.util.List;

import com.dovanduong.entity.DanhMucSanPham;

public interface DanhMucImp {	
	List<DanhMucSanPham> LayDanhMuc();
	boolean editDanhmuc(DanhMucSanPham danhMucSanPham);
}
