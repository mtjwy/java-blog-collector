<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file="../layout/taglib.jsp"%>

<h1>Latest news</h1>
<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Date</th>
				<th>Item</th>
			</tr>	
		</thead>
		<tbody>
			<c:forEach items="${items}" var="item">
				<tr>
					<td>
						<c:out value="${item.publishedDate}" />
						<br />
						<c:out value="${item.blog.name}" />
					
					</td>
					<td>
						<strong>
							<a href="<c:out value="${item.link}" />" target="_blank">
								<c:out value="${item.title}" />
							</a>
						</strong>
						<br />
						${item.description}
						
					</td>
				</tr>
			</c:forEach>
		</tbody>
	
	
	</table>

