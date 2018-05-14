package com.dovanduong.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dovanduong.daoimp.DanhMucImp;
import com.dovanduong.entity.DanhMucSanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucDAO implements DanhMucImp{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Transactional
	public List<DanhMucSanPham> LayDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		String query = "from danhmucsanpham where trangthai = 1";
		List<DanhMucSanPham> danhMucSanPhams =  new ArrayList<DanhMucSanPham>();
		danhMucSanPhams = session.createQuery(query).getResultList();
		System.out.println(danhMucSanPhams.size());
		return danhMucSanPhams;
	}

	@Transactional
	public boolean editDanhmuc(DanhMucSanPham danhMucSanPham) {
		// TODO Auto-generated method stub
		if(danhMucSanPham.getMadanhmuc() > 0 ) {
		Session session = sessionFactory.getCurrentSession();
		session.update(danhMucSanPham);
		
		}
		else {
			Session session = sessionFactory.getCurrentSession();
			session.save(danhMucSanPham);
		}
		return true;
	}

}
