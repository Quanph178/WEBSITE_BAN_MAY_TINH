<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col">

	<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
		<li class="nav-item" role="presentation"><a
			class="nav-link active" id="videoEditing-tab" data-toggle="pill"
			href="#videoEditing" role="tab" aria-controls="videoEditing"
			aria-selected="true">Favorites</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="pill" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Favorite Users</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="shareFriends-tab" data-toggle="pill" href="#shareFriends"
			role="tab" aria-controls="shareFriends" aria-selected="false">Share
				Friends</a></li>
	</ul>

	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active col" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<table class="table table-bordered mt-3">
				<tr>
					<td>Video Title</td>
					<td>Favorite Count</td>
					<td>Laster Date</td>
					<td>Oldest Date</td>
				</tr>
				<c:forEach var="item" items="${favList }">
				<tr>
					<td>${item.videoTitle }</td>
					<td>${item.favoriteCount }</td>
					<td>${item.newesDate }</td>
					<td>${item.olesDate }</td>
				</tr>
				</c:forEach>
			</table>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label> <b class="pr-3">Video Title</b> <select name=""
									id="" class="form-control pl-3">
										<option value="">Java</option>
								</select>
								</label>
								<button class="btn btn-info ml-3">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Username</td>
								<td>Password</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
							<tr>
								<td>quanph</td>
								<td>12345</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="shareFriends" role="tabpanel"
			aria-labelledby="shareFriends-tab">
			<form action="" method="get">
				<div class="row mt-3">
					<div class="col">
						<div class="form-inline">
							<div class="form-group">
								<label> <b class="pr-3">Video Title</b> <select name=""
									id="" class="form-control pl-3">
										<option value="">Java</option>
								</select>
								</label>
								<button class="btn btn-info ml-3">Report</button>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col mt-3">
						<table class="table table-bordered">
							<tr>
								<td>Sender Name</td>
								<td>Sender Email</td>
								<td>Receiver Email</td>
								<td>Sent Date</td>
							</tr>
							<tr>
								<td>quanph</td>
								<td>12345</td>
								<td>Email</td>
								<td>Favorite Date</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>