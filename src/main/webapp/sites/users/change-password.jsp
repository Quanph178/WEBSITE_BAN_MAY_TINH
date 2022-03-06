<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-3 col-6 mt-4">
	<form action="ChangePassword" method="post">
		<div class="card">
			<div class="card-header">Change password</div>
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
								class="form-control" name="id" id="username" value="${id }"
								aria-describedby="usernameHid" placeholder="Username"> <small
								id="usernameHid" class="form-text text-muted">Username
								is required</small>
						</div>
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="passwords" id="password"
								placeholder="Password">
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="currentPassword">Current Password</label> <input
								type="password" class="form-control" name="currentPassword"
								id="currentPassword" placeholder="Current Password">
						</div>
						<div class="form-group">
							<label for="confirmPassword">Confirm Password </label> <input
								type="password" class="form-control" name="confirmPassword"
								id="confirmPassword" placeholder="Confirm Password">
						</div>
					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-success">Change Password</button>
			</div>
		</div>
	</form>
</div>
