package com.dovanduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovanduong.dao.DanhMucDAO;
import com.dovanduong.daoimp.DanhMucImp;
import com.dovanduong.entity.DanhMucSanPham;

@Service
public class DanhMucService implements DanhMucImp{

	@Autowired
	DanhMucDAO danhMucDAO;
	
	public List<DanhMucSanPham> LayDanhMuc() {
		return danhMucDAO.LayDanhMuc();
	}

	public boolean editDanhmuc(DanhMucSanPham danhMucSanPham) {
		// TODO Auto-generated method stub
		
		return danhMucDAO.editDanhmuc(danhMucSanPham);
	}

}
