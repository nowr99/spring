<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>

<script type="text/javascript">
	function linkPage(pageNo){
		location.href="./notice?pageNo="+pageNo
	}
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
                    <h1 class="h3 mb-4 text-gray-800">공쥐공쥐공주이공지</h1>
				
				<div class = "m-2 row">
					<select name="perPage" id="perPage" class="form-control col-1">
						<option>10개씩</option>
						<option>20개씩</option>
						<option>30개씩</option>
						<option>40개씩</option>
						<option>50개씩</option>
						<option>60개씩</option>
					</select>
				</div>
				<table class="table table-hover">
					<thead>
						<tr class="row">
							<th class="col-1 text-center">번호</th>
							<th class="col-5 text-center">제목</th>
							<th class="col-4 text-center">날짜</th>
							<th class="col-1 text-center">읽음</th>
							<th class="col-1 text-center">삭제</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list }" var="row">
						<tr class="row">
							<td class="col-1 text-center">${row.nno }</td>
							<td class="col-5"><a href="/noticeDetail?no=${row.nno}">${row.ntitle }</a></td>
							<td class="col-4 text-center">${row.ndate }</td>
							<td class="col-1 text-center">${row.nread }</td>
							<td class="col-1 text-center">${row.ndel }</td>
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