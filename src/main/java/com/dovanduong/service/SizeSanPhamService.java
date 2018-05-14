package com.dovanduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovanduong.dao.SizeSanPhamDAO;
import com.dovanduong.daoimp.SizeSanPhamImp;
import com.dovanduong.entity.SizeSanPham;

@Service
public class SizeSanPhamService implements SizeSanPhamImp{
	
	@Autowired
	SizeSanPhamDAO sizeSanPhamDAO;
	
	public List<SizeSanPham> LayDanhSachSize() {
		// TODO Auto-generated method stub
		return sizeSanPhamDAO.LayDanhSachSize();
	}

}
