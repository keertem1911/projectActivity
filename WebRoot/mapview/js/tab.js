window.onload = function() {
	/*var data = document.getElementById("data");
	var section = document.getElementById("content");*/
	var section = document.getElementById("section");
	var list = getClass(section,"list");
	var list_title = getClass(section,"list-title");

	var list_content = getClass(section,"list-content");
	var content_map = getClass(section,"content-map");
	console.log(list_content.length);
	console.log(content_map.length+" s");

	for(var i = 0; i < list_title.length; i++) {
		(function(i){
			list_title[i].onclick = function(){
				var list_ul = list[i].getElementsByTagName("ul")[0];

				if(list_ul.style.display === "block") {
					list_ul.style.display = "none";
				} else {
					list_ul.style.display = "block";
				}
			}
		})(i);
	}

	for(var i = 0; i < list_content.length; i++){
		(function(i){
			list_content[i].onclick = function() {
				for(var j = 0; j < content_map.length;j++){
					content_map[j].style.display = "none";
				}
				content_map[i].style.display = "block";
			}
		})(i);
	}
}
function getClass(obj, cls) {
 	if (obj.getElementsByClassName) {
 		return obj.getElementsByClassName(cls);
 	} else {
 		var result = [];
 		var childs = obj.getElementsByTagName("*");
 		for (var i = 0; i < childs.length; i++) {
 			if(childs[i].className === cls) {
 				result.push(childs[i]);
 			}
 		}
 		return result;
 	}
}
