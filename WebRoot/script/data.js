$(function() {
		var idx_name={"idx_1":"省份/市/地区","idx_2":"项目名称","idx_3":"指标1","idx_4":"指标2",
				"idx_5":"指标3","idx_6":"指标4","idx_7":"指标5","idx_source":"信息来源",
				"idx_begin":"起始年份","idx_end":"终止年份"};
 
		var begin;
		var end;
		function init(idx){
			 
			var selects=$("tr select");
			var mapping2={};
			for(var i=0;i<selects.length-2;++i ){
			 	mapping2[$(selects[i]).attr("id")]=$(selects[i]).val();
			 }
	 
			AjaxUnit("project_findIdxInit.action",  mapping2, function(msg) {
				var arrayIdx={};
				 	
				 for(var attr in msg){
					 if(msg[attr]!=""&&msg[attr]!=undefined){
						if(arrayIdx[attr]==undefined){
							arrayIdx[attr]="";
							}
						 arrayIdx[attr]+=msg[attr];
					 }
					}
				for(var attr in arrayIdx){	
					var value=arrayIdx[attr].split(",");
					var option="";
					if(attr !="MaxAndMinYear") 
					  option+="<option value=-1>请选择"+idx_name[attr]+"</option>";
					  else if(attr =="MaxAndMinYear"){
						  option+="<option value=-1>请选择"+idx_name["idx_begin"]+"</option>";
						  }
				 	if($("#"+attr).val()=="-1"||$("#"+attr).val()==undefined )
					if($("#"+attr).attr("id")!=undefined){
					for(var i=0;i<value.length;++i){
						option += "<option value="+value[i]+">" + value[i]
						+ "</option>";
						}
					$("#"+attr).empty();
					$("#"+attr).append(option);
					}else {
						var option2="<option value=-1>终止年份</option>";
					 	if(value[0]!=""){
							
						  begin=value[0];
						  end = value[1];
					  
						for(var i=begin;i<end;i++){
							option += "<option value="+i+">" + i
							+ "</option>";
							}
					 	}else{
							option ="<option value=-1>无数据</option>";
							option2="<option value=-1>无数据</option>";
							} 
						 $("#idx_begin").empty();
						$("#idx_begin").append(option);
						$("#idx_end").empty();
						$("#idx_end").append(option2);
						}
					}
			});
		}
	 	init();
	 	$("#idx_begin").change(function(){
			var begin =$(this).val();
			var option="";
			for(var i=parseInt(begin);i<parseInt(end)+1;i++){
				option += "<option value="+i+">" + i
				+ "</option>";
				} 
			$("#idx_end").empty();
			$("#idx_end").append(option);
		 	});
	 	$(".idx_n").change(function() {
	 		init($(this).attr("id"));
		}); 
		function AjaxUnit(url, params, callBack) {
			$.ajax({
				url : url,
				type : "post",
				dataType : "json",
				data : params,
				success : function(msg) {
					callBack(msg);
				}
			})
		}
		var mapping = {};
		$("#submit")
				.click(
						function() {
							if($("#idx_begin").val()!=-1){
							var selects = $("select");
							for (var i = 0; i < selects.length; ++i) {

								if (selects[i].value != -1) {
									mapping[selects[i].id] = selects[i].value;
								} else {
									mapping[selects[i].id] = "-1";
								}
							}
							console.log(mapping);
							AjaxUnit("projectIdx_findListByIdxs.action",
									mapping, findListByIdxsCallBack);
							function findListByIdxsCallBack(msg) {
								var html = "";
								for ( var attr in msg) {
									var obj = msg[attr];
									$("#showList").empty();
									var idx_value=obj["idx_3"]
									+ ":"+ obj["idx_4"]+":"+ obj["idx_5"]
									+ ":"+ obj["idx_6"]+ ":"+ obj["idx_7"];
									idx_value=idx_value.match("([^:]+:)+");
									var temp=idx_value;
									if(idx_value instanceof Array )	
									 temp=idx_value[0];
									 if(temp!=null)
									 idx_value=temp.substr(0, temp.length-1);
								 	if( idx_value==null)
									 	idx_value=" ";
									var years=obj["technoloYears"];
									 
									for(var attr in years){
								//		console.log(parseInt($("#idx_end").val()));
									if(parseInt(years[attr]["idx_year"])>=parseInt($("#idx_begin").val())
											&&parseInt(years[attr]["idx_year"])<=parseInt($("#idx_end").val()))
									html += "<tr align=center class='showList1'  >"
											+ "<td class='idx_1' width='12%'>"
											+ obj["idx_1"]
											+ "</td>"
											+ "<td class='idx_2' width=\"20%\">"
											+obj["idx_2"] 
											+"</td>"
											+ "<td class='idx_3' width=\"15%\">"
											+idx_value 
											+"</td>"
											+ "<td class='idx_4' width=\"8%\">"
											+ obj['idx_freq']
											+ "</td>"
											+ "<td class='idx_5' width=\"10%\">"
											+ obj['idx_source']
											+ "</td>"
											+"<td class='idx_6' width=\"10%\">"+obj["idx_unit"]+"</td>"
											+ "<td class='idx_7' width=\"10%\">"+years[attr]["idx_year"]+"</td>"
											+"<td class='idx_8' width=\"15%\">"+years[attr]["idx_value"]+"</td>"
											+ "</tr>";
									}
								}
								$("#showList").append(html);
								$(".showList1 td").mouseover(function(){
									$("."+$(this).attr("class")).attr("style","background-color:silver; ");
									$(this).attr("style","color:red");
									 }); 
							 $(".showList1 td ").mouseout(function(){
								 $(this).attr("style","color:black");
									$("."+$(this).attr("class")).attr("style","background-color:white;");
								 }); 
							 $(".showList1").mouseover(function(){
									$(this).children().attr("style","background-color:silver ");
								 }); 
							 $(".showList1").mouseout(function(){
									 
									$(this).children().attr("style","background-color:white");
								 }); 
							}
							}else{
								alert("请选择年份");
								}
							return false;
						});
		$("#exportYearInformExcel").click(function(){
			var href="projectIdx_exportActivityAndYearInformExcel.action?";
			if(mapping.idx_1!=undefined){
			for(var attr in mapping){
				href+=attr+"="+mapping[attr]+"&";
			}
			  window.location.href=href;
			}else{
				alert("请先查询信息");
				}
			});  
		$("#uploadsubmit").click(function(){
			var i = 0;
			 	
			var allowExtention = ".txt,.xls,.xlsx"; //允许上传文件的后缀名document.getElementById("hfAllowPicSuffix").value;
			var extention = $("#upload").val().substring( $("#upload").val().lastIndexOf(".") + 1).toLowerCase();
			var browserVersion = window.navigator.userAgent.toUpperCase();
			//console.log(extention);
			if (allowExtention.indexOf(extention) > -1) {
			 	$("#form").ajaxSubmit({
					url: 'comment_uploadSave.action',
					success: function(data) {
						if(data=="1"){
							alert("上传成功");}else{
								alert("上传失败");}					 
					},
					});
				}
			 else {
				 alert("仅支持" + allowExtention + "为后缀名的文件!");
				 $("#upload").val(""); //清空选中文件
			 }  
		});
	});