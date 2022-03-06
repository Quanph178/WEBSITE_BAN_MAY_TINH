<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="offset-3 col-6 mt-5 mb-5">
	<form action="" method="post">
		<div class="card">
			<div class="card-header">Sen Video to Your Friends</div>
			<div class="card-body">
				<div class="form-group">
					<label for="email">Your Friends email:</label> <input type="text"
						class="form-control" name="email" id="email"
						aria-describedby="emailHelperId" placeholder="Emails"> <small
						id="emailHelperId" class="form-text text-muted">Email is
						required</small>
				</div>
			</div>
			<div class="card-footer mb-0 p-0 ">
				<button class="btn btn-success">Send</button>
			</div>
		</div>
	</form>
</div>