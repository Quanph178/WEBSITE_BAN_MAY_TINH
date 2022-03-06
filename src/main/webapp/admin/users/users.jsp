<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col">
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
	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="pill"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">User Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="pill" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">User List</a></li>
	</ul>

	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active col" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype='multipart/form-data'>
				<div class="card">
					<div class="card-body">
						<div class="row">
							<div class=" col">
								<div class="form-group">
									<label for="id">Username</label> <input type="text"
										class="form-control" name="id" id="id"
										value="${user.id }" aria-describedby="usernameHid"
										placeholder="Username"> <small id="usernameHid"
										class="form-text text-muted">Username is required</small>
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
										class="form-check-input" value="true" name="admins"
										${user.admins? 'checked':'' } id="actives"> Active </label>
									<label><input type="radio" class="form-check-input  "
										value="false" name="admins" ${!user.admins? 'checked':'' }
										id="actives">Inactive</label>
								</div>
							</div>
							<div class="col">
								<div class="form-group">
									<label for="passwords">Password</label> <input type="password"
										class="form-control" name="passwords" id="passwords"
										aria-describedby="passwordHid" placeholder="Password">
									<small id="passwordHid" class="form-text text-muted">Password
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
							formaction="Admin/UsersManagementServlet/create">Create</button>
						<button class="btn btn-success"
							formaction="Admin/UsersManagementServlet/update">Update</button>
						<button class="btn btn-danger"
							formaction="Admin/UsersManagementServlet/delete">Delete</button>
						<button class="btn btn-info"
							formaction="Admin/UsersManagementServlet/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Username</td>
					<td>Fullname</td>
					<td>Email</td>
					<td>Admin</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${users }">
					<tr>
						<td>${item.id }</td>
						<td>${item.fullname }</td>
						<td>${item.email }</td>
						<td>${item.admins? 'Admin': 'User' }</td>
						<td><a
							href="Admin/UsersManagementServlet/edit?id=${item.id }"><i
								class="fa fa-edit m-2" aria-hidden="true"></i>Edit</a> <a
							href="Admin/UsersManagementServlet/delete?id=${item.id }"><i
								class="fa fa-trash m-2" aria-hidden="true"></i>Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>