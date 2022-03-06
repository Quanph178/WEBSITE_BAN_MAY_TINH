<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="offset-4 col-4">
	<form action="ForgotPassword" method="post">
		<div class="card">
			<div class="card-header">
				<b>Forgot Password</b>
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
				<div class="form-group">
					<label for="username">Username</label> <input type="text"
						class="form-control" name="id" id="id"
						aria-describedby="usernameHid" placeholder="Username"> <small
						id="usernameHid" class="form-text text-muted">Username is
						required</small>
				</div>
				<div class="form-group">
					<label for="email">Email</label> <input type="text"
						class="form-control" name="email" id="email"
						aria-describedby="emailHid" placeholder="Email"> <small
						id="emailHid" class="form-text text-muted">Email is
						required</small>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-primary">Retrieve</button>
			</div>
		</div>
	</form>
</div>