package com.dovanduong.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dovanduong.daoimp.HoaDonImp;
import com.dovanduong.entity.HoaDon;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HoaDonDAO implements HoaDonImp {

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public int ThemHoaDon(HoaDon hoaDon) {
		Session session = sessionFactory.getCurrentSession();
		int id = (Integer) session.save(hoaDon);
		if(0 < id){
			return id;
		}else{
			return 0;
		}
		
	}
	@Transactional
	public List<HoaDon> Hoadon() {
		Session session = sessionFactory.getCurrentSession();
		List<HoaDon> list = session.createQuery("from HOADON").getResultList();
		return list;
	}

}
