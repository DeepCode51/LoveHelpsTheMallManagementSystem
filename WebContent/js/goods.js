$(function() {

$("#usersid").blur(
		function() {
			$("#usersid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#usersid").after("<span id='usersid_msg' style='color: red'>发布人不能为空</span>");
			}
	});

$("#goodsname").blur(
		function() {
			$("#goodsname_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#goodsname").after("<span id='goodsname_msg' style='color: red'>商品名称不能为空</span>");
			}
	});

$("#image").blur(
		function() {
			$("#image_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
			}
	});

$("#cateid").blur(
		function() {
			$("#cateid_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#cateid").after("<span id='cateid_msg' style='color: red'>商品类型不能为空</span>");
			}
	});

$("#price").blur(
		function() {
			$("#price_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#price").after("<span id='price_msg' style='color: red'>销售单价不能为空</span>");
			}
	});

$("#storage").blur(
		function() {
			$("#storage_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#storage").after("<span id='storage_msg' style='color: red'>库存数量不能为空</span>");
			}
	});

$("#contents").blur(
		function() {
			$("#contents_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#contents").after("<span id='contents_msg' style='color: red'>商品详情不能为空</span>");
			}
	});







$('#sub').click(function(){
var usersid = $("#usersid").val();
var goodsname = $("#goodsname").val();
var image = $("#image").val();
var cateid = $("#cateid").val();
var price = $("#price").val();
var storage = $("#storage").val();
var contents = $("#contents").val();
$("#usersid_msg").empty();
$("#goodsname_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#price_msg").empty();
$("#storage_msg").empty();
$("#contents_msg").empty();
if (usersid == "" || usersid == null) {
	$("#usersid").after("<span id='usersid_msg' style='color: red'>发布人不能为空</span>");
	return false;
}
if (goodsname == "" || goodsname == null) {
	$("#goodsname").after("<span id='goodsname_msg' style='color: red'>商品名称不能为空</span>");
	return false;
}
if (image == "" || image == null) {
	$("#image").after("<span id='image_msg' style='color: red'>图片不能为空</span>");
	return false;
}
if (cateid == "" || cateid == null) {
	$("#cateid").after("<span id='cateid_msg' style='color: red'>商品类型不能为空</span>");
	return false;
}
if (price == "" || price == null) {
	$("#price").after("<span id='price_msg' style='color: red'>销售单价不能为空</span>");
	return false;
}
if (storage == "" || storage == null) {
	$("#storage").after("<span id='storage_msg' style='color: red'>库存数量不能为空</span>");
	return false;
}
if (contents == "" || contents == null) {
	$("#contents").after("<span id='contents_msg' style='color: red'>商品详情不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#usersid_msg").empty();
$("#goodsname_msg").empty();
$("#image_msg").empty();
$("#cateid_msg").empty();
$("#price_msg").empty();
$("#storage_msg").empty();
$("#contents_msg").empty();
});

});
