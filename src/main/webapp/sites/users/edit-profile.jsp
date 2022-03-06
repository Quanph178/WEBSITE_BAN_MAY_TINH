<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-8 offset-2">
	<form action="EditProfile" method="post">
		<div class="card">
			<div class="card-header">
				<b>Edit Profile</b>
			</div>
			<div class="card-body">
			<c:if test="${not empty message }">
					<div class="row">
						<div class="col">
							<div class="alert alert-success">${message }</div>
						</div>
					</div>
				</c:if>
				<c:if test="${not empty error }">
					<div class="row">
						<div class="col">
							<div class="alert alert-denger">${error }</div>
						</div>
					</div>
				</c:if>
				<div class="row">
					<div class="col">
						<div class="form-group">
							<label for="id">Username</label> <input type="text"
								class="form-control" name="id" id="id" value="${user.id }"
								aria-describedby="usernameHid" placeholder="Username"> <small
								id="usernameHid" class="form-text text-muted">Username
								is required</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname" value="${user.fullname }"
								aria-describedby="fullnameHid" placeholder="Fullname"> <small
								id="fullnameHid" class="form-text text-muted">Fullname
								is required</small>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="passwords">Password</label> <input type="password"
								class="form-control" name="passwords" id="passwords" value="${user.passwords }"
								placeholder="Password">
						</div>
						<div class="form-group">
							<label for="email">Email Address</label> <input type="text"
								class="form-control" name="email" id="email" value="${user.email }"
								aria-describedby="emailHid" placeholder="Email Address">
							<small id="emailHid" class="form-text text-muted">Email
								is required</small>
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success" formaction="${pageContext.request.contextPath}/EditProfile">Update</button>
			</div>
		</div>
	</form>
</div>