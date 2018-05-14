<%@page import="java.util.List"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div id="header-chitiet" class="container-fluid">
		<nav class="navbar navbar-default none_nav">
		  <div class="container-fluid">
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		      <a class="navbar-brand" href="#"><img src='<c:url value="/resources/Image/icon_yame_shop.png"/>'></a>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		      <ul class="nav navbar-nav navbar-center">
		        <li class="active"><a href="/shoppeeee/">TRANG CHỦ</a></li>
		        <li 	class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Sản phẩm <span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <c:forEach var="value" items="${danhmuc }"> 
						<li><a href='<c:url value="/sanpham/${value.getMadanhmuc()}/${value.getTendanhmuc() }"/>'>${value.getTendanhmuc() }</a></li>
						<li role="separator" class="divider"></li>
					</c:forEach>
		          </ul>
		        </li>
		        <li><a href="#">DỊCH VỤ</a></li>
		        <li><a href="#">LIÊN HỆ</a></li>
		        
		      </ul>
		      
		      <ul class="nav navbar-nav navbar-right">
		      	<c:choose>
		      		<c:when test="${chucaidau != null }">
		      			 <li><a class="circle-avartar" href="dangnhap/"><span>${chucaidau }</span></a></li>
		      		</c:when>
		      		
		      		<c:otherwise>
		      			 <li><a href="dangnhap/">ĐĂNG NHẬP</a></li>
		      		</c:otherwise>
		      	</c:choose>
		      	
		      	<li id="giohang"><a href="giohang/" ><img src='<c:url value="/resources/Image/ic_shopping_cart_white_24dp_1x.png"/>'>
		      		<c:if test="${soluongsanphamgiohang > 0 }">
			        	<div class="circle-giohang"><span>${soluongsanphamgiohang }</span></div>
			        </c:if>
			        
			        <c:if test="${soluongsanphamgiohang <= 0 || soluongsanphamgiohang == null  }">
			        	<div><span>${soluongsanphamgiohang }</span></div>
			        </c:if>
		      	</a></li>
		      	
		        
		        
		       
		      </ul>
		    </div><!-- /.navbar-collapse -->
		  </div><!-- /.container-fluid -->
		</nav>
	</div>
	
	<div class="container-fluid">
	
  <div class="row">
    <div class="col-sm-12">
    <br>
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d7447.451204624859!2d105.7803149!3d21.043662600000005!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x313454cc9e0c5bb3%3A0x73c8398b9d7a04c8!2zTmfDtSAyIFBo4bqhbSBWxINuIMSQ4buTbmcsIE1haSBE4buLY2gsIEPhuqd1IEdp4bqleSwgSMOgIE7hu5lpLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1513098638915" width="100%" height="600" frameborder="0" style="border:0" allowfullscreen></iframe>
    </div>
    <div class="col-sm-12">
    <br>
      <div class="section-content">
				
				<h3>Hãy liên hệ với chúng tôi </h3>
			</div>
			<div class="contact-section">
			<div class="container">
				<form>
					<div class="col-md-6 form-line">
			  			<div class="form-group">
			  				<label for="exampleInputUsername">Tên của bạn</label>
					    	<input type="text" class="form-control" id="" placeholder=" Enter Name">
				  		</div>
				  		<div class="form-group">
					    	<label for="exampleInputEmail">Email</label>
					    	<input type="email" class="form-control" id="exampleInputEmail" placeholder=" Enter Email id">
					  	</div>	
					  	<div class="form-group">
					    	<label for="telephone">Số điện thoại</label>
					    	<input type="tel" class="form-control" id="telephone" placeholder=" Enter 10-digit mobile no.">
			  			</div>
			  		</div>
			  		<div class="col-md-6">
			  			<div class="form-group">
			  				<label for ="description"> Lời nhắn</label>
			  			 	<textarea  class="form-control" id="description" placeholder="Enter Your Message"></textarea>
			  			</div>
			  			<div>

			  				<button type="button" class="btn btn-default submit"><i class="fa fa-paper-plane" aria-hidden="true"></i>  Gửi</button>
			  			</div>
			  			
					</div>
				</form>
			</div>
    </div>
  </div>
</div>
	
	<div id="footer" class="container-fluid">
		<div class="row">
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">THÔNG TIN SHOP</span></p>
				<span>Yame là một thương hiệu thời trang đầy uy tín, luôn đảm bảo chất lượng sản phẩm tốt nhất cho khách hàng.</span>
			</div>
			
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">LIÊN HỆ</span></p>
				<span>Ngõ 2 Phạm Văn Đồng , Hà Nội</span>
				<span>dovanduong09@gmail.com</span>
				<span>01629727328</span>
			</div>
			
			<div class="col-sm-4 col-md-4 wow tada">
				<p><span class="title-footer">GÓP Ý</span></p>
				<form action="" method="post">
					<input name="tenNhanVien" class="material-textinput" style="margin-bottom: 8px" type="text" placeholder="Email"/>
					<textarea name="tuoi" style="margin-bottom: 8px" rows="4" cols="50" placeholder="Nội dung"></textarea>
					<button class="material-primary-button">ĐỒNG Ý</button>
				</form>
				
			</div>
		</div>
		
	</div>
	
	<jsp:include page="footer.jsp"/>
</body>


</html>