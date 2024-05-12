<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
</head>
<c:import url="/header" />
<body>
	<section id="cars">
		<h1>예약 가능한 차 목록</h1>

		<div class='container'>
			<c:forEach var="car" items="${carList}">
				<div class='carInfo'>
					<a href="/CarsDetail?car_code=${car.carCode }&startDate=${startDatetime}&endDate=${endDatetime}&carPrice=${car.carPrice}" ><c:choose>
							<c:when test="${car.carName eq '소나타'}">
								<img
									src="https://search.pstatic.net/sunny/?src=https%3A%2F%2Fd2u3dcdbebyaiu.cloudfront.net%2Fuploads%2Fatch_img%2F969%2Fd726ef92ee155f0dd5cba406f0ee0006_res.jpeg&type=sc960_832">
							</c:when>
							<c:when test="${car.carName eq '320i'}">
								<img
									src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDA0MjNfMjkw%2FMDAxNzEzODUxMjQ5OTE2.MoOzPR1E8GDqvoEoWAwn1ktj5RFDPQCdFJ7MRjDi804g.Z_SW-3atyw2H8FgGTC8mq8yudV5ooZ34D4xJM351Rf0g.PNG%2F2024-04-23_14%253B45%253B11.PNG&type=sc960_832">
							</c:when>
							<c:when test="${car.carName eq '쏘렌토'}">
								<img
									src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAxMjVfMjM3%2FMDAxNzA2MTYwNTk5MzI1.ubEEyInpyHKpDgjz62DZ9SiwF6H-t687NhC4UAhuidQg.iPnBjG8YyXh7qaBjVkd0LTuMi8H_VWA6P9GBNnf6n0Ig.PNG.ahenglaso%2Fimage.png&type=sc960_832">
							</c:when>
							<c:when test="${car.carName eq '카니발'}">
								<img
									src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyNDAyMTZfMTYy%2FMDAxNzA4MDU3NTY3NDI0.8RmdRR8idnOCR9KVCKabHmE44w6rbxmcABfoIZ_u5HUg.uw1IO_rwfPlIS5lK2rFszh5IRZdiZTxL3ubKcosDmvMg.PNG.inmotion99%2Fcarnival_q_isg.png&type=sc960_832">
							</c:when>
							<c:when test="${car.carName eq 'r8'}">
								<img
									src="https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMjExMjlfODAg%2FMDAxNjY5NzA5ODk2NzE4.bvcUZqSInzCQmlWZbwANXWY595F-09RtgWTai1ZzsQkg.4Ai1znOi5b2D_N3AlY_cb6HAnt0kP1E53777sGhmk9Mg.JPEG.qkrgowls6155%2Frewqfgw.JPG&type=sc960_832">
							</c:when>
						</c:choose> </a>
					<h4>${car.carBrand}${car.carName }</h4>
					<h3 id='price'>
						시간당
						<fmt:formatNumber value="${car.carPrice}" pattern="#,###" />
						원
					</h3>
					<p>${car.carYear}년식|${car.carOil}</p>
					<p>${car.carType} | ${car.carSeat }인승 | ${car.carNum }</p>
				</div>
			</c:forEach>
		</div>

	</section>
</body>
<jsp:include page="/footer"></jsp:include>
</html>