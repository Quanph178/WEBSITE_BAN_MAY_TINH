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
			aria-selected="true">Video Editing</a></li>
		<li class="nav-item" role="presentation"><a class="nav-link"
			id="videoList-tab" data-toggle="pill" href="#videoList" role="tab"
			aria-controls="videoList" aria-selected="false">Video List</a></li>

	</ul>

	<div class="tab-content" id="myTabContent">
		<div class="tab-pane fade show active col" id="videoEditing"
			role="tabpanel" aria-labelledby="videoEditing-tab">
			<form action="" method="post" enctype='multipart/form-data'>
				<div class="card">
					<div class="card-body">
						<div class="row ">
							<div class="col-3">
								<div class="border p-3 ">
									<img
										src="${video.poster != null?video.poster : './image/desktop.jpg' }"
										alt="" class="card-img-top " style="max-width: 300px;max-height: 300px;">
									<div class="input-group ">
										<form>
											<div class="form-group">
												<input type="file" class="form-control-file"
													id="exampleFormControlFile1" name="cover"
													value="${video.poster }">
											</div>
										</form>
									</div>
								</div>
							</div>
							<div class="col-9">
								<div class="form-group">
									<label for="id">Youtube ID</label> <input type="text"
										class="form-control" name="id" id="id" value="${video.id }"
										aria-describedby="youtubeIdHid" placeholder="Youtube ID">
									<small id="youtubeIdHid" class="form-text text-muted">Youtube
										id is required</small>
								</div>
								<div class="form-group">
									<label for="title">Video Title</label> <input type="text"
										class="form-control" name="title" id="title"
										value="${video.title }" aria-describedby="videoTitle"
										placeholder="Video Title"> <small id="videoTitle"
										class="form-text text-muted">Video title is required</small>
								</div>
								<div class="form-group">
									<label for="views">View Count</label> <input type="text"
										class="form-control" name="views" id="views"
										value="${video.views }" aria-describedby="viewCountHid"
										placeholder="View Count"> <small id="viewCountHid"
										class="form-text text-muted">View count is required</small>
								</div>
								<div class="form-check form-check-inline ">
									<label class="mr-3"><input type="radio"
										class="form-check-input" value="true" name="actives"
										${video.actives? 'checked':'' } id="actives"> Active </label>
									<label><input type="radio" class="form-check-input  "
										value="false" name="actives" ${!video.actives? 'checked':'' }
										id="actives">Inactive</label>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col">
								<label for="descriptions">Description</label>
								<textarea name="descriptions" id="descriptions" cols="30"
									rows="3" class="form-control">${video.descriptions }</textarea>
							</div>
						</div>
					</div>
					<div class="card-footer text-muted">
						<button class="btn btn-primary"
							formaction="Admin/VideosManagement/create">Create</button>
						<button class="btn btn-success"
							formaction="Admin/VideosManagement/update">Update</button>
						<button class="btn btn-danger"
							formaction="Admin/VideosManagement/delete">Delete</button>
						<button class="btn btn-info"
							formaction="Admin/VideosManagement/reset">Reset</button>
					</div>
				</div>
			</form>
		</div>
		<div class="tab-pane fade" id="videoList" role="tabpanel"
			aria-labelledby="videoList-tab">
			<table class="table table-stripe">
				<tr>
					<td>Youtube ID</td>
					<td>Video Title</td>
					<td>View Count</td>
					<td>Status</td>
					<td>&nbsp;</td>
				</tr>
				<c:forEach var="item" items="${videos }">
					<tr>
						<td>${item.id }</td>
						<td>${item.title }</td>
						<td>${item.views }</td>
						<td>${item.actives? 'Active': 'Deactive' }</td>
						<td><a href="Admin/VideosManagement/edit?id=${item.id }"><i
								class="fa fa-edit m-2" aria-hidden="true"></i>Edit</a> <a
							href="Admin/VideosManagement/delete?id=${item.id }"><i
								class="fa fa-trash m-2" aria-hidden="true"></i>Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</div>