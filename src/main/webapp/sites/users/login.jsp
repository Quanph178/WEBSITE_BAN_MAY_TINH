<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="col m-3 ">
	<div class="offset-4 col-4">
		<form action="" method="post">
			<div class="card">
				<div class="card-header">
					<b>Login to System</b>
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
					<div class="form-grouUsernamep">
						<label for="id">Username</label> <input type="text"
							class="form-control" name="id" id="id"
							aria-describedby="usernameHid" placeholder="Username"> <small
							id="UsernameHid" class="form-text text-muted">Username is
							required</small>
					</div>
					<div class="form-group">
						<label for="passwords">Password</label> <input type="text"
							class="form-control" name="passwords" id="passwords"
							aria-describedby="passwordHid" placeholder="Password"> <small
							id="passwordHid" class="form-text text-muted">Password is
							required</small>
					</div>
					<div class="form-check form-check-inline">
						<label> <input type="checkbox" class="form-check-input"
							name="remember"> Remember me
						</label>
					</div>
				</div>
				<div class="card-footer text-muted">
					<button class="btn btn-success"
						formaction="${pageContext.request.contextPath}/Login">Login</button>
				</div>
			</div>
		</form>
	</div>
</div>