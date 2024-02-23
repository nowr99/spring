<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>갤러리글쓰기</title>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
        <!-- Google fonts-->
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
        <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700" rel="stylesheet" type="text/css" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
		<script type="text/javascript">
		 const Toast = Swal.mixin({
             toast: true,
             position: 'center-center',
             showConfirmButton: false,
             timer: 3000,
             timerProgressBar: true,
             didOpen: (toast) => {
               toast.onmouseenter = Swal.stopTimer;
               toast.onmouseleave = Swal.resumeTimer;
             }
           });
		
		function fileCheck() {
			var fileVal = $("#file1").val(); // 파일 이름 가져오기
			if(fileVal == "") {
				alert('파일을 선택하세요');
				return false;
			} else {
				var ext = fileVal.split('.').pop().toLowerCase(); // 확장자분리
				// 아래 확장자가 있는지 체크
				if ($.inArray(ext, ['jpg', 'jpeg', 'gif', 'png']) == -1) {
					alert('jpg,gif,jpeg,png 파일만 업로드 할 수 있습니다!');
					return false;
				}
			}
		}
		
		</script>
	</head>
    <body id="page-top">
        <!-- Navigation-->
        <%@ include file="menu.jsp" %>

		<!-- 갤러리글쓰기 -->
        <section class="page-section" id="gallery">
            <div class="d-flex justify-content-center">
               	<div class="text-center">
               		<h1 class="mt-5">갤러리 글쓰기</h1>
               		<form action="./galleryInsert" method="post" enctype="multipart/form-data" onsubmit="fileCheck()">
               		<div class="galleyTitle mb-3">
						<label for="exampleFormControlInput1" class="form-label" style="float: left">Title</label>
					  	<input type="text" class="form-control" name="gtitle" id="exampleFormControlInput1" placeholder="제목을 입력하세요.">
					</div>
					
					<div class="galleryContent mb-3">
					  	<label for="exampleFormControlTextarea1" class="form-label" style="float: left">Content</label>
					  	<textarea class="form-control" name="gcontent" id="exampleFormControlTextarea1" rows="5"></textarea>
					</div>
               		
               		<div class="input-group mb-3">
  					<input type="file" accept="image/*, image/jpg" name="file1" class="form-control" id="file1">
  					<button class="btn btn-outline-secondary" type="submit">UPLOAD</button>
					</div>
               		</form>
					
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
    
    </body>
</html>
       
