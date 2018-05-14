package com.dovanduong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dovanduong.dao.HoaDonDAO;
import com.dovanduong.daoimp.HoaDonImp;
import com.dovanduong.entity.HoaDon;

@Service
public class HoaDonService implements HoaDonImp {
	
	@Autowired
	HoaDonDAO hoaDonDAO;

	public int ThemHoaDon(HoaDon hoaDon) {
		return hoaDonDAO.ThemHoaDon(hoaDon);
	}
	
	public List<HoaDon> Hoadon() {
		// TODO Auto-generated method stub
		return hoaDonDAO.Hoadon();
	}
	
	
}
