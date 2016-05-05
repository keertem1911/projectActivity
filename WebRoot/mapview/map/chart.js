$(function() {
	var html="<option value='安徽'>安徽</optiopn>"
		+"<option value='新疆'>新疆</optiopn>"
		+"<option value='北京'>北京</optiopn>"
		+"<option value='福建'>福建</optiopn>"
		+"<option value='甘肃'>甘肃</optiopn>"
		+"<option value='广东'>广东</optiopn>"
		+"<option value='广西'>广西</optiopn>"
		+"<option value='贵州'>贵州</optiopn>"
		+"<option value='海南'>海南</optiopn>"
		+"<option value='河南'>河南</optiopn>"
		+"<option value='黑龙江'>黑龙江</optiopn>"
		+"<option value='湖北'>湖北</optiopn>"
		+"<option value='湖南'>湖南</optiopn>"
		+"<option value='吉林'>吉林</optiopn>"
		+"<option value='江苏'>江苏</optiopn>"
		+"<option value='江西'>江西</optiopn>"
		+"<option value='辽宁'>辽宁</optiopn>"
		+"<option value='内蒙古'>内蒙古</optiopn>"
		+"<option value='宁夏'>宁夏</optiopn>"
		+"<option value='青海'>青海</optiopn>"
		+"<option value='山东'>山东</optiopn>"
		+"<option value='山西'>山西</optiopn>"
		+"<option value='陕西'>陕西</optiopn>"
		+"<option value='四川'>四川</optiopn>"
		+"<option value='天津'>天津</optiopn>"
		+"<option value='西藏'>西藏</optiopn>"
		+"<option value='云南'>云南</optiopn>"
		+"<option value='浙江'>浙江</optiopn>"
		+"<option value='重庆'>重庆</optiopn>"
		+"<option value='上海'>上海</optiopn>"
		+"<option value='河北'>河北</optiopn>";
	function ajaxUnit(url, param, callback) {
		$.ajax({
			url : url,
			type : "post",
			dataType : "json",
			data : param,
			success : function(msg) {
				callback(msg);
			}
		});
	}
	function findIdx_3Unit(msg) {
		$("#idx_3").empty();
		var option = "<option value='-1'>请选择指标 </option>";
		if (msg[0] != "")
			for (var i = 0; i < msg.length; ++i) {
				option += "<option value='" + msg[i] + "'>" + msg[i]
						+ "</option>";
			}
		else {
			option = "<option value='-1'>无数据 </option>";
		}
		$("#idx_3").append(option);
	}
	$("#idx_2").change(function() {
		if ($(this).val() != "-1")
			ajaxUnit("project_findIdxByAllProvince.action", {
				"idx_2" : $(this).val()
			}, findIdx_3Unit);
		else {
			alert("请先选择项目名称");
		}
	});
	function findIdx_2Unit(msg) {
		$("#idx_2").empty();
		var option = "<option value='-1'>请选择项目名称</option>";
		for (var i = 0; i < msg.length; ++i) {
			option += "<option value='" + msg[i] + "'>" + msg[i] + "</option>";
		}
		
		$("#idx_2").append(option);
		$("#idx_3").empty();
		$("#idx_3").append("<option value='-1'>请选择指标</option>");
	}
	ajaxUnit("project_findIdxByAllProvince.action", {
		"idx_2" : "-1",
		"idx_3" : "-1"
	}, findIdx_2Unit);
	 
	$("#showbut").click(function() {
		var contents=$(".content-map");
		
		for(var i=0;i<contents.length;++i)
			if($(contents[i]).css("display") =='block'){
					current_content=$(contents[i]).attr("id");
			}
	var BJData = [];
		if ($("#idx_2").val() != "-1") {
			
			var cnt = 0;
			if(current_content=="containerl"){
				if($("#idx_11").val()!=$("#idx_12").val()&&$("#idx_11").val()!="-1"&&$("#idx_12").val()!="-1")
				
					ajaxUnit("project_findAllYearValueToLineChart.action",
						{"idx_1":$("#idx_11").val()+":"+$("#idx_12").val(),"idx_2":$("#idx_2").val(),"idx_3":$("#idx_3").val()}, callbackShowmap);
				else{
					if($("#idx_11").val()=="-1"||$("#idx_12").val()=="-1")
						alert("请选择省份");
					else{
						alert("不能选择相同省份");
					}
				}
			} else{
			ajaxUnit("project_showMap.action", {
				"idx_2" : $("#idx_2").val(),
				"idx_3" : $("#idx_3").val()
			}, function(msg) {
				console.log(msg);
				var i = 0;
				var idx_unit;
				for ( var attr in msg) {
					BJData[i++] = [ {}, {
						name : attr,
						value : msg[attr]
					} ];
					cnt += parseInt(msg[attr][0]);
				}
				var idx = "";
				if ($("#idx_3").val() != "-1")
					idx = ":" + $("#idx_3").val();
				showmap1(BJData, cnt, $("#idx_2").val() + idx);
				var idxName=$("#idx_2").val() + idx;
				showBarGraph(msg,idxName);
			});
			}
		  
		}else
			alert("请先选择项目名称");
	});
  	showmap1([ [ {}, {
			name : '北京',
			value : [ 0, " " ]
		} ] ], 10, " ");
	 
	function callbackShowmap(msg){
		var idx="";
		if ($("#idx_3").val() != "-1")
		  idx = ":" + $("#idx_3").val();
		 
	 	showLineChart(msg,$("#idx_2").val() + idx);
	}
	var current_content;
	$("#showmap1,#showBarGraph,#showmap2").click(function(){
		$(".selectIdx select,input").attr("style","display:block;width:150px;");
		$("#idx_11").attr("style","display:none");
	//	$("#idx_11").append("<option value='-1'>无省份</option>");
		$("#idx_12").attr("style","display:none");
	//	$("#idx_12").append("<option value='-1'>无省份</option>");
	});
	$("#showLineChart").click(function(){
		$(".selectIdx select,input").attr("style","display:block;width:150px;");
		$("#idx_11").attr("style","display:block;;width:150px;");
		$("#idx_11").empty();
		$("#idx_11").append(html);
		$("#idx_12").attr("style","display:block;;width:150px;");
		$("#idx_12").empty();
		$("#idx_12").append(html);
	});
	//$(".selectIdx select,input").attr("style","display:none");
});
function showmap1(BJData, cnt, idxName) {
	var geoCoordMap = {
		'上海' : [ 121.4648, 31.2891 ],
		'新疆' : [ 87.9236, 43.5883 ],
		'甘肃' : [ 103.5901, 36.3043 ],
		'北京' : [ 116.4551, 40.2539 ],
		'江苏' : [ 118.8062, 31.9208 ],
		'广西' : [ 108.479, 23.1152 ],
		'江西' : [ 116.0046, 28.6633 ],
		'安徽' : [ 117.29, 32.0581 ],
		'内蒙古' : [ 111.4124, 40.4901 ],
		'黑龙江' : [ 127.9688, 45.368 ],
		'天津' : [ 117.4219, 39.4189 ],
		'山西' : [ 112.3352, 37.9413 ],
		'广东' : [ 113.5107, 23.2196 ],
		'四川' : [ 103.9526, 30.7617 ],
		'西藏' : [ 91.1865, 30.1465 ],
		'云南' : [ 102.9199, 25.4663 ],
		'浙江' : [ 119.5313, 29.8773 ],
		'湖北' : [ 114.3896, 30.6628 ],
		'辽宁' : [ 123.1238, 42.1216 ],
		'山东' : [ 117.1582, 36.8701 ],
		'海南' : [ 110.3893, 19.8516 ],
		'河北' : [ 114.4995, 38.1006 ],
		'福建' : [ 119.4543, 25.9222 ],
		'青海' : [ 101.4038, 36.8207 ],
		'陕西' : [ 109.1162, 34.2004 ],
		'贵州' : [ 106.6992, 26.7682 ],
		'河南' : [ 113.4668, 34.6234 ],
		'重庆' : [ 107.7539, 30.1904 ],
		'宁夏' : [ 106.3586, 38.1775 ],
		'吉林' : [ 125.8154, 44.2584 ],
		'湖南' : [ 113.0823, 28.2568 ],
	};
	// 地图
	var dom0 = document.getElementById("container0");
	var myChart0 = echarts.init(dom0);
	option = null;

	// 地图
	// 0
	var color = [ '#a6c84c', '#ffa022', '#46bee9' ];
	var series = [];
	[ [ idxName, BJData ] ].forEach(function(item, i) {
		series.push({
			name : item[0] + idxName,
			type : 'lines',
			zlevel : 1,
			tooltip : { // Series config.

				formatter : "Series formatter: {item}<br/>"
			},
			effect : {
				show : true,
				period : 6,
				trailLength : 0.7,
				color : '#fff',
				symbolSize : 3
			},
			lineStyle : {
				normal : {
					color : color[i],
					width : 0,
					curveness : 0.2
				}
			},
			data : []
		}, {
			name : item[0] + '',
			type : 'lines',
			zlevel : 2,
			effect : {
				show : true,
				period : 6,
				trailLength : 0,
				symbolSize : 1
			},
			lineStyle : {
				normal : {
					color : color[i],
					width : 1,
					opacity : 0.4,
					curveness : 0.2
				}
			},
			data : []
		}, {
			name : item[0] + ' ',
			type : 'effectScatter',
			coordinateSystem : 'geo',
			zlevel : 2,
			rippleEffect : {
				brushType : 'stroke'
			},
			label : {
				normal : {
					show : true,
					position : 'top',
					formatter : '{b}'
				}
			},
			symbolSize : function(val) {
				var por = val[2][0] / cnt;
				return (val[2][0] / cnt) * 100 + 5;
			},
			itemStyle : {
				normal : {
					color : color[i]
				}
			},
			data : item[1].map(function(dataItem) {
				return {
					name : dataItem[1].name,
					value : geoCoordMap[dataItem[1].name]
							.concat([ dataItem[1].value ])
				};
			})
		});
	});

	option = {
		backgroundColor : '#404a59',
		title : {

			text : '数据区域分布-' + idxName,
			subtext : '年份总和',
			left : 'center',
			textStyle : {
				color : '#fff'
			}
		},
		tooltip : {
			formatter : function(item) {

				return item.seriesName + "<br/>" + item.name + "<br/>"
						+ parseInt(item.value[2][0]) + item.value[2][1];
			},
			trigger : 'item'
		},
		legend : {
			orient : 'vertical',
			top : 'bottom',
			left : 'right',
			data : [ '' ],
			textStyle : {
				color : '#fff'
			},
			selectedMode : 'single'
		},
		geo : {
			map : 'china',
			label : {
				emphasis : {
					show : false
				}
			},
			roam : true,
			itemStyle : {
				normal : {
					areaColor : '#323c48',
					borderColor : '#404a59'
				},
				emphasis : {
					areaColor : '#2a333d'
				}
			}
		},
		series : series
	};
	if (option && typeof option === "object") {
		var startTime = +new Date();
		myChart0.setOption(option, true);
		var endTime = +new Date();
		var updateTime = endTime - startTime;
		console.log("Time used:", updateTime);
	}
}
// 折线
function showLineChart(msg,idxName) {
	// 折线
	var doml = document.getElementById("containerl");
	var myChartl = echarts.init(doml);
	optionl = null;


	optionl = {
			title : {
				text : '数据各年份对比-'+idxName,
				subtext : '单位/'+msg[0].value[0][2],
				subtextStyle : {
			color:'blue',
			fontWeight:"80px"
				}
			},
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:[msg[0].name, msg[1].name]
		    },
		    
		    xAxis:  {
		        type: 'category',
		        boundaryGap: false,
		        data: function(){
					var dataArray=[];
					  for(var i=0;i<msg[0].value.length;++i){
					  	dataArray[i]=parseInt(msg[0].value[i][0]);
					  }
					  return dataArray;
				} ()
		    },
		    yAxis: {
		        type: 'value',
		        axisLabel: {
		            formatter: '{value}'
		        }
		    },
		    series: [
		        {
		            name:msg[0].name,
		            type:'line',
		            data:function(){
						var arrayValue=[];
						 
						for(var i=0;i<msg[0].value.length;++i){
							arrayValue[i]=parseInt(msg[0].value[i][1]);
						}
						
						return arrayValue;
					}(),
		            markPoint: {
		                data: [
		                    {type: 'max', name: '最大值'},
		                    {type: 'min', name: '最小值'}
		                ]
		            },
		            markLine: {
		                data: [
		                    {type: 'average', name: '平均值'}
		                ]
		            }
		        },
		        {
		            name:msg[1].name,
		            type:'line',
		            data:function(){
						var arrayValue=[];
						 
						for(var i=0;i<msg[1].value.length;++i){
							arrayValue[i]=parseInt(msg[1].value[i][1]);
						}
						
						return arrayValue;
					}(),
		            markPoint: {
		                data: [
		                    {type: 'max', name: '最大值'},
		                    {type: 'min', name: '最小值'}
		                ]
		            },
		            markLine: {
		                data: [
		                    {type: 'average', name: '平均值'}
		                ]
		            }
		        }
		    ]
};
	if (optionl && typeof optionl === "object") {
		myChartl.setOption(optionl, true);
	}
}
// 柱状
function showBarGraph(msg,idxName) {
	// 柱状图
	var domZ = document.getElementById("containerZ");
	var myChartZ = echarts.init(domZ);
	optionZ = null;
	optionZ = {
			title : {
				text : '数据区域分布-' + idxName,
				subtext : '年份总和/'+msg["上海"][1],
				left : 'left',
				textStyle : {
					color : 'black'
				},
				subtextStyle:{
					color : 'bule'
				}
			},
		tooltip : {
			trigger : 'axis',
			axisPoer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		//图例 
		legend : {
			data : [idxName] //idxName
		},
		//方格 
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : //[ '周一', '周二', '周三', '周四', '周五', '周六', '周日' ]
		//省份值
		function(){
				var arraypro=[];
				 var i=0;
				for(var attr in msg){
					arraypro[i++]=attr;
				}
				return arraypro;
			}()
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : idxName,//idxName
			type : 'bar',
			data : 
				function(){
				var arrayProValue=[];
				var i=0;
				for(var attr in msg){
					 	 
					arrayProValue[i++]=msg[attr][0];
				}
				return arrayProValue;
			}()
		}/*, {
			name : '邮件营销',
			type : 'bar',
			stack : '广告',
			data : [ 1020, 1302, 1010, 1340, 1090, 1230, 2110 ]
		}, {
			name : '联盟广告',
			type : 'bar',
			stack : '广告',
			data : [ 220, 182, 191, 234, 290, 330, 310 ]
		}, {
			name : '视频广告',
			type : 'bar',
			stack : '广告',
			data : [ 150, 232, 201, 154, 190, 330, 410 ]
		}, {
			name : '搜索引擎',
			type : 'bar',
			data : [ 862, 1018, 964, 1026, 1679, 1600, 1570 ],
			markLine : {
				lineStyle : {
					normal : {
						type : 'dashed'
					}
				},
				data : [ [ {
					type : 'min'
				}, {
					type : 'max'
				} ] ]
			}
		}, {
			name : '百度',
			type : 'bar',
			barWidth : 5,
			stack : '搜索引擎',
			data : [ 620, 732, 701, 734, 1090, 1130, 1120 ]
		}, {
			name : '谷歌',
			type : 'bar',
			stack : '搜索引擎',
			data : [ 120, 132, 101, 134, 290, 230, 220 ]
		}, {
			name : '必应',
			type : 'bar',
			stack : '搜索引擎',
			data : [ 60, 72, 71, 74, 190, 130, 110 ]
		}, {
			name : '其他',
			type : 'bar',
			stack : '搜索引擎',
			data : [ 62, 82, 91, 84, 109, 110, 120 ]
		}*/
		]
	};
	if (optionZ && typeof optionZ === "object") {
		myChartZ.setOption(optionZ, true);
	}
}
function showmap2() {
	var geoCoordMap = {
			'上海' : [ 121.4648, 31.2891 ],
			'新疆' : [ 87.9236, 43.5883 ],
			'甘肃' : [ 103.5901, 36.3043 ],
			'北京' : [ 116.4551, 40.2539 ],
			'江苏' : [ 118.8062, 31.9208 ],
			'广西' : [ 108.479, 23.1152 ],
			'江西' : [ 116.0046, 28.6633 ],
			'安徽' : [ 117.29, 32.0581 ],
			'内蒙古' : [ 111.4124, 40.4901 ],
			'黑龙江' : [ 127.9688, 45.368 ],
			'天津' : [ 117.4219, 39.4189 ],
			'山西' : [ 112.3352, 37.9413 ],
			'广东' : [ 113.5107, 23.2196 ],
			'四川' : [ 103.9526, 30.7617 ],
			'西藏' : [ 91.1865, 30.1465 ],
			'云南' : [ 102.9199, 25.4663 ],
			'浙江' : [ 119.5313, 29.8773 ],
			'湖北' : [ 114.3896, 30.6628 ],
			'辽宁' : [ 123.1238, 42.1216 ],
			'山东' : [ 117.1582, 36.8701 ],
			'海南' : [ 110.3893, 19.8516 ],
			'河北' : [ 114.4995, 38.1006 ],
			'福建' : [ 119.4543, 25.9222 ],
			'青海' : [ 101.4038, 36.8207 ],
			'陕西' : [ 109.1162, 34.2004 ],
			'贵州' : [ 106.6992, 26.7682 ],
			'河南' : [ 113.4668, 34.6234 ],
			'重庆' : [ 107.7539, 30.1904 ],
			'宁夏' : [ 106.3586, 38.1775 ],
			'吉林' : [ 125.8154, 44.2584 ],
			'湖南' : [ 113.0823, 28.2568 ],
		};
	// 地图
	var dom1 = document.getElementById("container1");
	var myChart1 = echarts.init(dom1);
	option1 = null;
	var dom2 = document.getElementById("container2");
	var myChart2 = echarts.init(dom2);
	option2 = null;
	var dom3 = document.getElementById("container3");
	var myChart3 = echarts.init(dom3);
	option3 = null;
	var dom4 = document.getElementById("container4");
	var myChart4 = echarts.init(dom4);
	option4 = null;
	var dom5 = document.getElementById("container5");
	var myChart5 = echarts.init(dom5);
	option5 = null;
	// 1
	option1 = {
		backgroundColor : '#1C7887',
		title : {
			text : '全国主要城市空气质量',
			subtext : 'data from PM25.in',
			sublink : 'http://www.pm25.in',
			x : 'center',
			textStyle : {
				color : '#red',
					fontWeight:bold
			}
		},
		tooltip : {
			trigger : 'item',
			formatter : function(params) {
				return params.name + ' : ' + params.value[2];
			}
		},
		legend : {
			orient : 'vertical',
			y : 'bottom',
			x : 'right',
			data : [ 'pm2.5' ],
			textStyle : {
				color : '#fff'
			}
		},
		dataRange : {
			min : 0,
			max : 200,
			calculable : true,
			color : [ '#d94e5d', '#eac736', '#50a3ba' ],
			textStyle : {
				color : '#fff'
			}
		},
		geo : {
			map : 'china',
			label : {
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				normal : {
					areaColor : '#26BCD5',
					borderColor : '#90467F'
				},
				emphasis : {
					areaColor : '#7B9DAE'
				}
			}
		},
		series : [ {
			name : 'pm2.5',
			type : 'scatter',
			coordinateSystem : 'geo',
			data : [],
			symbolSize : 12,
			label : {
				normal : {
					show : false
				},
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				emphasis : {
					borderColor : '#fff',
					borderWidth : 1
				}
			}
		} ]
	}
	// 2
	option2 = {
		backgroundColor : '#4E1D4C',
		title : {
			text : '全国主要城市空气质量',
			subtext : 'data from PM25.in',
			sublink : 'http://www.pm25.in',
			x : 'center',
			textStyle : {
				color : '#fff'
			}
		},
		tooltip : {
			trigger : 'item',
			formatter : function(params) {
				return params.name + ' : ' + params.value[2];
			}
		},
		legend : {
			orient : 'vertical',
			y : 'bottom',
			x : 'right',
			data : [ 'pm2.5' ],
			textStyle : {
				color : '#fff'
			}
		},
		dataRange : {
			min : 0,
			max : 200,
			calculable : true,
			color : [ '#d94e5d', '#eac736', '#50a3ba' ],
			textStyle : {
				color : '#fff'
			}
		},
		geo : {
			map : 'china',
			label : {
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				normal : {
					areaColor : '#773460',
					borderColor : '#90467F'
				},
				emphasis : {
					areaColor : '#450C3E'
				}
			}
		},
		series : [ {
			name : 'pm2.5',
			type : 'scatter',
			coordinateSystem : 'geo',
			data : [],
			symbolSize : 12,
			label : {
				normal : {
					show : false
				},
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				emphasis : {
					borderColor : '#fff',
					borderWidth : 1
				}
			}
		} ]
	}

	// 3
	option3 = {
		backgroundColor : '#5CA7BA',
		title : {
			text : '全国主要城市空气质量',
			subtext : 'data from PM25.in',
			sublink : 'http://www.pm25.in',
			x : 'center',
			textStyle : {
				color : '#fff'
			}
		},
		tooltip : {
			trigger : 'item',
			formatter : function(params) {
				return params.name + ' : ' + params.value[2];
			}
		},
		legend : {
			orient : 'vertical',
			y : 'bottom',
			x : 'right',
			data : [ 'pm2.5' ],
			textStyle : {
				color : '#fff'
			}
		},
		dataRange : {
			min : 0,
			max : 200,
			calculable : true,
			color : [ '#d94e5d', '#eac736', '#50a3ba' ],
			textStyle : {
				color : '#fff'
			}
		},
		geo : {
			map : 'china',
			label : {
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				normal : {
					areaColor : '#26BCD5',
					borderColor : '#AED7ED'
				},
				emphasis : {
					areaColor : '#C6EDE8'
				}
			}
		},
		series : [ {
			name : 'pm2.5',
			type : 'scatter',
			coordinateSystem : 'geo',
			data : [],
			symbolSize : 12,
			label : {
				normal : {
					show : false
				},
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				emphasis : {
					borderColor : '#fff',
					borderWidth : 1
				}
			}
		} ]
	}
	// 4
	option4 = {
		backgroundColor : '#752423',
		title : {
			text : '全国主要城市空气质量',
			subtext : 'data from PM25.in',
			sublink : 'http://www.pm25.in',
			x : 'center',
			textStyle : {
				color : '#fff'
			}
		},
		tooltip : {
			trigger : 'item',
			formatter : function(params) {
				return params.name + ' : ' + params.value[2];
			}
		},
		legend : {
			orient : 'vertical',
			y : 'bottom',
			x : 'right',
			data : [ 'pm2.5' ],
			textStyle : {
				color : '#fff'
			}
		},
		dataRange : {
			min : 0,
			max : 200,
			calculable : true,
			color : [ '#d94e5d', '#eac736', '#50a3ba' ],
			textStyle : {
				color : '#fff'
			}
		},
		geo : {
			map : 'china',
			label : {
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				normal : {
					areaColor : '#A12F2F',
					borderColor : '#C74D58'
				},
				emphasis : {
					areaColor : '#752423'
				}
			}
		},
		series : [ {
			name : 'pm2.5',
			type : 'scatter',
			coordinateSystem : 'geo',
			data : [],
			symbolSize : 12,
			label : {
				normal : {
					show : false
				},
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				emphasis : {
					borderColor : '#fff',
					borderWidth : 1
				}
			}
		} ]
	}
	option5 = {
		backgroundColor : '#113F3D',
		title : {
			text : '全国主要城市空气质量',
			subtext : 'data from PM25.in',
			sublink : 'http://www.pm25.in',
			x : 'center',
			textStyle : {
				color : '#fff'
			}
		},
		tooltip : {
			trigger : 'item',
			formatter : function(params) {
				return params.name + ' : ' + params.value[2];
			}
		},
		legend : {
			orient : 'vertical',
			y : 'bottom',
			x : 'right',
			data : [ 'pm2.5' ],
			textStyle : {
				color : '#fff'
			}
		},
		dataRange : {
			min : 0,
			max : 200,
			calculable : true,
			color : [ '#d94e5d', '#eac736', '#50a3ba' ],
			textStyle : {
				color : '#fff'
			}
		},
		geo : {
			map : 'china',
			label : {
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				normal : {
					areaColor : '#316253',
					borderColor : '#8ABEB2'
				},
				emphasis : {
					areaColor : '#ccc'
				}
			}
		},
		series : [ {
			name : 'pm2.5',
			type : 'scatter',
			coordinateSystem : 'geo',
			data : [],
			symbolSize : 12,
			label : {
				normal : {
					show : false
				},
				emphasis : {
					show : false
				}
			},
			itemStyle : {
				emphasis : {
					borderColor : '#fff',
					borderWidth : 1
				}
			}
		} ]
	}
	if (option1 && typeof option1 === "object") {
		myChart1.setOption(option1, true);
	}
	if (option2 && typeof option2 === "object") {
		myChart2.setOption(option2, true);
	}
	if (option3 && typeof option3 === "object") {
		myChart3.setOption(option3, true);
	}
	if (option4 && typeof option4 === "object") {
		myChart4.setOption(option4, true);
	}
	if (option5 && typeof option5 === "object") {
		myChart5.setOption(option5, true);
	}
}