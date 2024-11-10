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

$("#hits").blur(
		function() {
			$("#hits_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#hits").after("<span id='hits_msg' style='color: red'>点击数不能为空</span>");
			}
	});

$("#repnum").blur(
		function() {
			$("#repnum_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#repnum").after("<span id='repnum_msg' style='color: red'>回复数不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var title = $("#title").val();
var contents = $("#contents").val();
var addtime = $("#addtime").val();
var hits = $("#hits").val();
var repnum = $("#repnum").val();
$("#usersid_msg").empty();
$("#title_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
$("#hits_msg").empty();
$("#repnum_msg").empty();
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
if (hits == "" || hits == null) {
	$("#hits").after("<span id='hits_msg' style='color: red'>点击数不能为空</span>");
	return false;
}
if (repnum == "" || repnum == null) {
	$("#repnum").after("<span id='repnum_msg' style='color: red'>回复数不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#title_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
$("#hits_msg").empty();
$("#repnum_msg").empty();
});

});
