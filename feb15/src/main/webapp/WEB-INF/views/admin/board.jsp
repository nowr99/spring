<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<html lang="ko">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js" integrity="sha512-v2CJ7UaYy4JwqLDIrZUI/4hqeoQieOmAZNXBeQyjo21dadnwR+8ZaIJVT8EE2iyI61OV8e6M8PP2/4hpQINQ/g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript">
	function linkPage(pageNo){
		location.href = "./board?pageNo="+pageNo+"&perPage=${perPage}&searchTitle=${searchTitle}&search=${search}";
	}
	function postDel(no){
		location.href="./postDel?no="+no;
	}
	
	$(function(){
		$('#perPage').change(function(){
			location.href="./board?pageNo=1&perPage="+$('#perPage').val()+"&search=${search}"; 
		});
		$('#searchBtn').click(function(){
			location.href="./board?pageNo=1&perPage=${perPage}&searchTitle="+$('#searchTitle').val()+"&search="+$('#search').val();
		});
		
		$('#reset').click(function(){
			location.href="./board";
		});
	});
</script>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>관리관리관리자</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
	
</head>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">
	 <%@ include file="menu.jsp" %>
        

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
			 <%@ include file="topbar.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-4 text-gray-800">게시글임다</h1>
					
					<div class="m-2 row">
						<select name="perPage" id="perPage" class="form-control col-1">
							<option value="1" <c:if test="${perPage eq 1 }"> selected="selected"</c:if>>10개씩 보기</option>
							<option value="2" <c:if test="${perPage eq 2 }"> selected="selected"</c:if>>20개씩 보기</option>
							<option value="3" <c:if test="${perPage eq 3 }"> selected="selected"</c:if>>30개씩 보기</option>
							<option value="4" <c:if test="${perPage eq 4 }"> selected="selected"</c:if>>40개씩 보기</option>
							<option value="5" <c:if test="${perPage eq 5 }"> selected="selected"</c:if>>50개씩 보기</option>
							<option value="10" <c:if test="${perPage eq 10 }"> selected="selected"</c:if>>100개씩 보기</option>
						</select>
						<div class="input-group col-7">
							<select name="searchTitle" id="searchTitle" class="form-control col-3">
								<option value="1" <c:if test="${searchTitle eq 1 }"> selected="selected"</c:if>>제목</option>
								<option value="2" <c:if test="${searchTitle eq 2 }"> selected="selected"</c:if>>본문</option>
								<option value="3" <c:if test="${searchTitle eq 3 }"> selected="selected"</c:if>>작성자</option>
							</select>
								<input type="text" name="search" id="search" class="form-control" value="${search }">
								<button type="button" class="btn btn-secondary" id="searchBtn">검색</button>
						</div>
						<button type="button" id="reset" class="btn btn-success col-4">초기화</button>
					</div>
					<table class="table table-hover">
					<thead>
						<tr class="row">
							<th class="col-1 text-center">번호</th>
							<th class="col-4 text-center">제목</th>
							<th class="col-2 text-center">글쓴이</th>
							<th class="col-3 text-center">날짜</th>
							<th class="col-1 text-center">IP</th>
							<th class="col-1 text-center">삭제</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${list }" var="row">
						<tr class="row <c:if test="${row.board_del eq 0 }"> bg-dark</c:if>"">
						<td class="col-1 text-center">${row.board_no }</td>
						<td class="col-4"><a href="/detail?no=${row.board_no }">${row.board_title }</a></td>
						<td class="col-2">
						<a href="./board?searchTitle=3&search=${row.mname }">${row.mname }</a>
						</td>
						<td class="col-3">${row.board_date }</td>
						<td class="col-1">${row.board_ip }</td>
						<td class="col-1 text-center">
						<c:choose>
							<c:when test="${row.board_del eq 1}">
								<i class="fa fa-eye" aria-hidden="true" onclick="postDel(${row.board_no})"></i>
							</c:when>
							<c:otherwise>
								<i class="fa fa-eye-slash" aria-hidden="true" onclick="postDel(${row.board_no})"></i>
							</c:otherwise>
						</c:choose>
						</td>
						</tr>
					</c:forEach>
					</tbody>
					</table>
               	<div class="m-2 text-center">
               		<ui:pagination paginationInfo="${paginationInfo }" type="text" jsFunction="linkPage"/>
               	</div>
               	
                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->
			<%@ include file="footer.jsp" %>

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>