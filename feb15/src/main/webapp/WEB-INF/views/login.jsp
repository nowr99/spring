<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>파 전 막 걸 리</title>
        <!-- Favicon-->
        <link rel="apple-touch-icon" sizes="57x57" href="assets/apple-icon-57x57.png">
		<link rel="apple-touch-icon" sizes="60x60" href="assets/apple-icon-60x60.png">
		<link rel="apple-touch-icon" sizes="72x72" href="assets/apple-icon-72x72.png">
		<link rel="apple-touch-icon" sizes="76x76" href="assets/apple-icon-76x76.png">
		<link rel="apple-touch-icon" sizes="114x114" href="assets/apple-icon-114x114.png">
		<link rel="apple-touch-icon" sizes="120x120" href="assets/apple-icon-120x120.png">
		<link rel="apple-touch-icon" sizes="144x144" href="assets/apple-icon-144x144.png">
		<link rel="apple-touch-icon" sizes="152x152" href="assets/apple-icon-152x152.png">
		<link rel="apple-touch-icon" sizes="180x180" href="assets/apple-icon-180x180.png">
		<link rel="icon" type="image/png" sizes="192x192"  href="assets/android-icon-192x192.png">
		<link rel="icon" type="image/png" sizes="32x32" href="assets/favicon-32x32.png">
		<link rel="icon" type="image/png" sizes="96x96" href="assets/favicon-96x96.png">
		<link rel="icon" type="image/png" sizes="16x16" href="assets/favicon-16x16.png">
		<link rel="manifest" href="assets/manifest.json">
		<meta name="msapplication-TileColor" content="#ffffff">
		<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
		<meta name="theme-color" content="#ffffff">
        <link rel="shortcut icon" type="image/x-icon" href="assets/favicon.ico" />
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Font Awesome icons (free version)-->
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
      	<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
</head>

    <body id="page-top" style="background-image: url('/img/15.jpg'); background-size: cover;">
        <!-- Navigation-->
        <%@ include file="menu.jsp" %>

		<!-- login -->
		<section class="page-section" id="login"> 
			<div class="d-flex justify-content-center">
			<div class="card center-block text-center" style="width: 18rem; background-color: rgb(255,255,255,0.0); border: none;">
				<img src="/img/smilebg.png" class="card-img-top" alt="">
				<div class="card-body">
				<h4 class="card-title"></h4>
					<form class="card-text" action="./login" method="post">
						<input type="text" name="id" id="id" placeholder="ID">
						<input type="password" name="pw" id="pw" placeholder="PW" style="margin-top: 5px">
						<div class="" style="margin-top: 10px">
						<button type="reset" id="login" class="btn btn-warning">RESET</button>
						<button type="submit" id="login" class="btn btn-secondary">LOGIN</button>
						<a href="./join" class="btn btn-info">JOIN</a>
						</div>
					</form>
				</div>
			</div>
			</div>
		</section>
       
       <!-- Services-->
        <!-- <section class="page-section" id="services">
            <div class="container">
                <div class="text-center">
                    <h2 class="section-heading text-uppercase">트리니티 코인이란</h2>
                    <h3 class="section-subheading text-muted">작은 노력, 큰 수익! 굼뜬 당신을 위한 코인</h3>
                </div>
                <div class="row text-center">
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-shopping-cart fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">쉬운 구매</h4>
                        <p class="text-muted">지금 당장 1원으로 10코인을 살 수 있습니다. 이래도 투자 안 할 것인가?</p>
                    </div>
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-laptop fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">언제 어디서던 확인</h4>
                        <p class="text-muted">내 코인이 어디에 있나? 내 코인이 어디에 쓰이고 있나? 내 코인을 누구에게 양도했나 다 확인 가능한 트리니티 코인</p>
                    </div>
                    <div class="col-md-4">
                        <span class="fa-stack fa-4x">
                            <i class="fas fa-circle fa-stack-2x text-primary"></i>
                            <i class="fas fa-lock fa-stack-1x fa-inverse"></i>
                        </span>
                        <h4 class="my-3">밀어서 잠금</h4>
                        <p class="text-muted">코인을 현금화 하고 싶다면 자금을 잠금하세요.</p>
                    </div>
                </div>
            </div>
        </section> -->
        
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <!-- * *                               SB Forms JS                               * *-->
        <!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
        <!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
    
    	<!-- 파라미터로 오는 error가 있다면 에러 화면에 출력하기 -->
    	<c:if test="${param.error ne null}">
    		<script type="text/javascript">
				Swal.fire("에엥?", "잘못된 접근입니다.", "error");	
    		</script>
    	</c:if>
    	
  		<c:if test="${param.count ne null }">
  			<script type="text/javascript">
  				let count = ${param.count};
  				if(count<5){
  					Swal.fire("아이디와 비밀번호가 맞지 않습니다.", count+"번 시도했습니다.", "warning")
  				} else {
	  				Swal.fire("계정 잠금", "로그인을 여러번 시도하여 ID가 보호조치 되었습니다. 관리자에게 문의주세요.", "warning")
  				}
  			</script>
  		</c:if>
  
  
  
    </body>
</html>
       
