$(function() {

$("#bannername").blur(
		function() {
			$("#bannername_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#bannername").after("<span id='bannername_msg' style='color: red'>栏目名称不能为空</span>");
			}
	});

$("#memo").blur(
		function() {
			$("#memo_msg").empty();
			var name = $(this).val();
			if (name == "" || name == null) {
				$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
			}
	});







$('#sub').click(function(){
var bannername = $("#bannername").val();
var memo = $("#memo").val();
$("#bannername_msg").empty();
$("#memo_msg").empty();
if (bannername == "" || bannername == null) {
	$("#bannername").after("<span id='bannername_msg' style='color: red'>栏目名称不能为空</span>");
	return false;
}
if (memo == "" || memo == null) {
	$("#memo").after("<span id='memo_msg' style='color: red'>备注不能为空</span>");
	return false;
}
});
$('#res').click(function() {
$("#bannername_msg").empty();
$("#memo_msg").empty();
});

});
