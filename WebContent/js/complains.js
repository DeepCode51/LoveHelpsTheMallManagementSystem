$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>发布人不能为空</span>");
			}
	});

$("#title").blur(
		function() {
			$("#title_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>发布日期不能为空</span>");
			}
	});

$("#status").blur(
		function() {
			$("#status_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#status").after("<span id='status_msg' style='color: red'>状态不能为空</span>");
			}
	});

$("#reps").blur(
		function() {
			$("#reps_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#reps").after("<span id='reps_msg' style='color: red'>管理员回复不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var title = $("#title").val();
var contents = $("#contents").val();
var addtime = $("#addtime").val();
var status = $("#status").val();
var reps = $("#reps").val();
$("#usersid_msg").empty();
$("#title_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
$("#status_msg").empty();
$("#reps_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>发布人不能为空</span>");
	return false;
}
if (title == "" || title == null) {
	$("#title").after("<span id='title_msg' style='color: red'>标题不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>发布日期不能为空</span>");
	return false;
}
if (status == "" || status == null) {
	$("#status").after("<span id='status_msg' style='color: red'>状态不能为空</span>");
	return false;
}
if (reps == "" || reps == null) {
	$("#reps").after("<span id='reps_msg' style='color: red'>管理员回复不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#title_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
$("#status_msg").empty();
$("#reps_msg").empty();
});

});
