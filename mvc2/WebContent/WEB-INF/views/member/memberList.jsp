<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath}"/>  

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script type="text/javascript">
	function insertForm(){
		location.href = "${cpath}/insertForm.do";
		//html이나 jsp로 바로 가는게 아니라, controll을 거쳐서 가야하는게 국룰임
		
		//tern : 우클릭->configure 머였냐,,,
	}
	
	function deleteFn(num){
		location.href = "${cpath}/delete.do?num="+num; //겟방식
		
	}
	
</script>

</head>
<body>
리스트 보기
	<table border="1px">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>전화번호</td>
			<td>주소</td>
			<td>위도</td>
			<td>경도</td>
			<td>삭제</td>
		</tr>

		<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.num}</td>
				<td><a href="${cpath}/content.do?num=${vo.num}">${vo.name}</a></td>
					<!-- num을 하나 가지고 가야함. num을 기준으로 상세 content를 보여주기 위함. -->
				<td>${vo.phone}</td>
				<td>${vo.addr}</td>
				<td>${vo.lat}</td>
				<td>${vo.lng}</td>
				<td><input type="button" value="삭제" onclick="deleteFn(${vo.num})"/></td>
			</tr>
		</c:forEach>

		<tr>
			<td colspan="6" align="left">
				<input type="button" value="회원가입" onclick="insertForm()"/>
			</td>
		</tr>
		
		
		
		
	</table>
	
	

</body>
</html>