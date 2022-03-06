<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col-8 offset-2 mt-3 mb-5">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">
				<b>Registration</b>
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
					<div class=" col">
						<div class="form-group">
							<label for="id">Username</label> <input type="text"
								class="form-control" name="id" id="id" value="${user.username }"
								aria-describedby="usernameHid" placeholder="Username"> <small
								id="usernameHid" class="form-text text-muted">Username
								is required</small>
						</div>
						<div class="form-group">
							<label for="fullname">Fullname</label> <input type="text"
								class="form-control" name="fullname" id="fullname"
								value="${user.fullname }" aria-describedby="fullnameHid"
								placeholder="Fullname"> <small id="fullnameHid"
								class="form-text text-muted">Fullname is required</small>
						</div>
						<div class="form-check form-check-inline ">
							<label class="mr-3"><input type="radio"
								class="form-check-input" value="true" name="admins" id="status">Admin
							</label> <label><input type="radio" class="form-check-input  "
								value="false" name="admins" id="status">User</label>
						</div>
					</div>
					<div class="col">
						<div class="form-group">
							<label for="password">Password</label> <input type="password"
								class="form-control" name="passwords" id="password"
								aria-describedby="passwordHid" placeholder="Password"> <small
								id="passwordHid" class="form-text text-muted">Password
								is required</small>
						</div>
						<div class="form-group">
							<label for="email">Email</label> <input type="text"
								class="form-control" name="email" id="email"
								value="${user.email }" aria-describedby="emailHid"
								placeholder="Email"> <small id="emailHid"
								class="form-text text-muted">Email is required</small>
						</div>

					</div>
				</div>
			</div>
			<div class="card-footer text-muted">
				<button class="btn btn-primary"
					formaction="${pageContext.request.contextPath}/Registration">Sign
					Up</button>
			</div>
		</div>
	</form>
</div>