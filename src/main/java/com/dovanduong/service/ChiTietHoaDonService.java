package com.dovanduong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovanduong.dao.ChiTietHoaDonDAO;
import com.dovanduong.daoimp.ChiTietHoaDonImp;
import com.dovanduong.entity.ChiTietHoaDon;

@Service
public class ChiTietHoaDonService implements ChiTietHoaDonImp {
	
	@Autowired
	ChiTietHoaDonDAO chiTietHoaDonDAO;

	public boolean ThemChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		
		return chiTietHoaDonDAO.ThemChiTietHoaDon(chiTietHoaDon);
	}

}
