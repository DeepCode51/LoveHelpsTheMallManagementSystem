$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
			}
	});

$("#goodsid").blur(
		function() {
			$("#goodsid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#goodsid").after("<span id='goodsid_msg' style='color: red'>商品不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
			}
	});

$("#num").blur(
		function() {
			$("#num_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
			}
	});

$("#addtime").blur(
		function() {
			$("#addtime_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#addtime").after("<span id='addtime_msg' style='color: red'>加入日期不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var goodsid = $("#goodsid").val();
var price = $("#price").val();
var num = $("#num").val();
var addtime = $("#addtime").val();
$("#usersid_msg").empty();
$("#goodsid_msg").empty();
$("#price_msg").empty();
$("#num_msg").empty();
$("#addtime_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>用户不能为空</span>");
	return false;
}
if (goodsid == "" || goodsid == null) {
	$("#goodsid").after("<span id='goodsid_msg' style='color: red'>商品不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>单价不能为空</span>");
	return false;
}
if (num == "" || num == null) {
	$("#num").after("<span id='num_msg' style='color: red'>数量不能为空</span>");
	return false;
}
if (addtime == "" || addtime == null) {
	$("#addtime").after("<span id='addtime_msg' style='color: red'>加入日期不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#goodsid_msg").empty();
$("#price_msg").empty();
$("#num_msg").empty();
$("#addtime_msg").empty();
});

});
