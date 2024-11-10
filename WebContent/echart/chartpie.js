$(window).load(function() {
	var loc = $("#basepath").val();
	var url = loc + "chart/chartPie.action";
	$.ajax({
		type : "get",
		url : url,
		dataType : "json",
		success : function(json) {
			var name = json.names.replace("[", "").replace("]", "").split(",");
			var val = json.count.replace("[", "").replace("]", "").split(",");
			var arrNum = [];
			for (var i = 0; i < val.length; i++) {
				arrNum.push({
					"value" : val[i],
					"name" : name[i].replace('"', "").replace('"', "")
				});
			}
			var option = {
				title : {
					text : '用户评价信息统计',
					left : 'center'
				},
				tooltip : {
					trigger : 'item',
					formatter : "{a} <br/>{b} : {c} ({d}%)"
				},
				legend : {
					bottom : 10,
					left : 'center',
					data : name
				},
				calculable : true,
				series : [ {
					type : 'pie',
					radius : '65%',
					center : [ '50%', '50%' ],
					selectedMode : 'single',
					data : arrNum,
					itemStyle : {
						emphasis : {
							shadowBlur : 10,
							shadowOffsetX : 0,
							shadowColor : 'rgba(0, 0, 0, 0.5)'
						}
					}
				} ]
			};
			// 初始化echarts实例
			var myChart = echarts.init(document.getElementById('chartmain'));

			// 使用制定的配置项和数据显示图表
			myChart.setOption(option);
		},
		error : function() {
			alert("ajax请求发生错误3");
		}
	});
});
