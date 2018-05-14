package com.dovanduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovanduong.dao.MauSanPhamDAO;
import com.dovanduong.daoimp.MauSanPhamImp;
import com.dovanduong.entity.MauSanPham;

@Service
public class MauSanPhamService implements MauSanPhamImp{
	
	@Autowired
	MauSanPhamDAO mauSanPhamDAO;
	
	public List<MauSanPham> LayDanhSachMau() {
		// TODO Auto-generated method stub
		return mauSanPhamDAO.LayDanhSachMau();
	}

}
