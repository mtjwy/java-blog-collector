<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp" %>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>

			<th>user name</th>
			<th>operation</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>
					<a href="<spring:url value="/users/${user.id}.html" />">
						${user.name} 
					</a>
				</td>
				
				<td>
					<a href="<spring:url value="/users/remove/${user.id}.html" />" class="btn btn-danger">
						remove 
					</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


