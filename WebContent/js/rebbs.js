$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>回复人不能为空</span>");
			}
	});

$("#bbsid").blur(
		function() {
			$("#bbsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bbsid").after("<span id='bbsid_msg' style='color: red'>留言不能为空</span>");
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
				$("#addtime").after("<span id='addtime_msg' style='color: red'>回复日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var bbsid = $("#bbsid").val();
var contents = $("#contents").val();
var addtime = $("#addtime").val();
$("#usersid_msg").empty();
$("#bbsid_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>回复人不能为空</span>");
	return false;
}
if (bbsid == "" || bbsid == null) {
	$("#bbsid").after("<span id='bbsid_msg' style='color: red'>留言不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>内容不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>回复日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#bbsid_msg").empty();
$("#contents_msg").empty();
$("#addtime_msg").empty();
});

});
