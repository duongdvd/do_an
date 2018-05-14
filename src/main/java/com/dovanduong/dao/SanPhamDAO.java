package com.dovanduong.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dovanduong.daoimp.SanPhamImp;
import com.dovanduong.entity.ChiTietHoaDon;
import com.dovanduong.entity.ChiTietHoaDonId;
import com.dovanduong.entity.ChiTietSanPham;
import com.dovanduong.entity.SanPham;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDAO implements SanPhamImp{

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public List<SanPham> LayDanhSachSanPhamLimit(int spbatdau) {
		Session session = sessionFactory.getCurrentSession();
		List<SanPham> listSanPhams = new ArrayList<SanPham>();
		if(spbatdau < 0){
			String query = "from SANPHAM where trangthai = 1";
			listSanPhams = (List<SanPham>)  session.createQuery(query).getResultList();
		}else{
			listSanPhams = (List<SanPham>) session.createQuery("from SANPHAM where trangthai = 1").setFirstResult(spbatdau).setMaxResults(5).getResultList();
		}
		
		return listSanPhams;
	}
	
	@Transactional
	public SanPham LayDanhSachChiTietSanPhamTheoMa(int masanpham){
		
		Session session = sessionFactory.getCurrentSession();
		String query = "from SANPHAM sp where sp.masanpham="+masanpham;
		SanPham sanPhams = (SanPham) session.createQuery(query).getSingleResult();

		return sanPhams;
	}

	@Transactional
	public List<SanPham> LayDanhSachSanPhamTheoMaDanhMuc(int madanhmuc, int x, int y) {
		Session session = sessionFactory.getCurrentSession();
		String query = "from SANPHAM sp where trangthai = 1 and sp.danhmucsanpham.madanhmuc="+madanhmuc;
		List<SanPham> listSanPhams = new ArrayList<SanPham>();
		if(x >0) {
		
		 listSanPhams = (List<SanPham>)  session.createQuery(query).setFirstResult(y).setMaxResults(5).getResultList();
		}
		else {
			listSanPhams = (List<SanPham>)  session.createQuery(query).getResultList();
		}
		return listSanPhams;
	}

	@Transactional
	public boolean XoaSanPhamTheoMaSanPham(int masanpham) {
		Session session = sessionFactory.getCurrentSession();

		session.createQuery("update SANPHAM set trangthai=0 WHERE masanpham="+masanpham).executeUpdate();
		
		return false;
	}

	@Transactional
	public boolean ThemSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		int id =(Integer) session.save(sanPham);
		
		return false;
	}

	@Transactional
	public boolean CatNhatSanPham(SanPham sanPham) {
		Session session = sessionFactory.getCurrentSession();
		session.update(sanPham);
		
		return false;
	}
	@Transactional
	public List<SanPham> LaySanPhamHot(int sosp) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		String query = "from SANPHAM where trangthai = 1 and masanpham in (SELECT chiTietHoaDonId.machitietsanpham FROM CHITIETHOADON group by chiTietHoaDonId.machitietsanpham order by count(*) desc)";
		List<SanPham> listSanPhams = new ArrayList<SanPham>();
		 listSanPhams = (List<SanPham>)  session.createQuery(query).setFirstResult(0).setMaxResults(sosp).getResultList();
		return listSanPhams;
	}

}
