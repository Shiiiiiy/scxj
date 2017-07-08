<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
<title>检察院andriod版新闻管理</title>
<meta name="decorator" content="new_default" />
<script type="text/javascript">
	$(document).ready(function() {

	});
	function page(n, s) {
		$("#pageNo").val(n);
		$("#pageSize").val(s);
		$("#searchForm").submit();
		return false;
	}
	var pictureSource; // picture source
	var destinationType; // sets the format of returned value

	// Wait for device API libraries to load
	//
	document.addEventListener("deviceready", onDeviceReady, false);

	// device APIs are available
	//
	function onDeviceReady() {
		pictureSource = navigator.camera.PictureSourceType;
		destinationType = navigator.camera.DestinationType;
	}

	// Called when a photo is successfully retrieved
	//
	function onPhotoDataSuccess(imageData) {
		// Uncomment to view the base64-encoded image data
		// console.log(imageData);

		// Get image handle
		//
		var smallImage = document.getElementById('smallImage');

		// Unhide image elements
		//
		smallImage.style.display = 'block';

		// Show the captured photo
		// The in-line CSS rules are used to resize the image
		//
		smallImage.src = "data:image/jpeg;base64," + imageData;
	}

	// Called when a photo is successfully retrieved
	//
	function onPhotoURISuccess(imageURI) {
		// Uncomment to view the image file URI
		// console.log(imageURI);

		// Get image handle
		//
		var largeImage = document.getElementById('largeImage');

		// Unhide image elements
		//
		largeImage.style.display = 'block';

		// Show the captured photo
		// The in-line CSS rules are used to resize the image
		//
		largeImage.src = imageURI;
	}

	// A button will call this function
	//
	function capturePhoto() {
		// Take picture using device camera and retrieve image as base64-encoded string
		navigator.camera.getPicture(onPhotoDataSuccess, onFail, {
			quality : 50,
			destinationType : destinationType.DATA_URL
		});
	}

	// A button will call this function
	//
	function capturePhotoEdit() {
		// Take picture using device camera, allow edit, and retrieve image as base64-encoded string
		navigator.camera.getPicture(onPhotoDataSuccess, onFail, {
			quality : 20,
			allowEdit : true,
			destinationType : destinationType.DATA_URL
		});
	}

	// A button will call this function
	//
	function getPhoto(source) {
		// Retrieve image file location from specified source
		navigator.camera.getPicture(onPhotoURISuccess, onFail, {
			quality : 50,
			destinationType : destinationType.FILE_URI,
			sourceType : source
		});
	}

	// Called if something bad happens.
	//
	function onFail(message) {
		alert('Failed because: ' + message);
	}
</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/news/xwcmlawyer/">检察院andriod版新闻列表</a></li>
		<shiro:hasPermission name="news:xwcmlawyer:edit">
			<li><a href="${ctx}/news/xwcmlawyer/form">检察院andriod版新闻添加</a></li>
		</shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="xwcmlawyer"
		action="${ctx}/news/xwcmlawyer/" method="post"
		class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<label>名称 ：</label>
		<form:input path="name" htmlEscape="false" maxlength="50"
			class="input-medium" />
		&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit"
			value="查询" />
	</form:form>
	<tags:message content="${message}" />
	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>名称</th>
				<th>备注</th>
				<shiro:hasPermission name="news:xwcmlawyer:edit">
					<th>操作</th>
				</shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.list}" var="xwcmlawyer">
				<tr>
					<td><a
						href="${ctx}/news/xwcmlawyer/form?id=${xwcmlawyer.lawid}">${xwcmlawyer.name}</a></td>
					<td>${xwcmlawyer.lawfirmid}</td>
					<shiro:hasPermission name="news:xwcmlawyer:edit">
						<td><a
							href="${ctx}/news/xwcmlawyer/form?id=${xwcmlawyer.lawid}">修改</a>
							<a href="${ctx}/news/xwcmlawyer/delete?id=${xwcmlawyer.lawid}"
							onclick="return confirmx('确认要删除该检察院andriod版新闻吗？', this.href)">删除</a>
						</td>
					</shiro:hasPermission>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div class="form-actions">
		<button onclick="capturePhoto();" class="btn btn-primary">Capture
			Photo</button>
		<br>
		<button onclick="capturePhotoEdit();" class="btn btn-primary">Capture
			Editable Photo</button>
		<br>
		<button onclick="getPhoto(pictureSource.PHOTOLIBRARY);"
			class="btn btn-success">From Photo Library</button>
		<br>
		<button onclick="getPhoto(pictureSource.SAVEDPHOTOALBUM);"
			class="btn btn-success">From Photo Album</button>
		<br>
	</div>
	<div class="control-group">
	<img style="display:none;width:60px;height:60px;" id="smallImage" src="" />
    <img style="display:none;" id="largeImage" src="" />
    </div>
	<div class="pagination">${page}</div>
</body>
</html>
