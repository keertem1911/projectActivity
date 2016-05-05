regObject={
		isNotAllNumberAndNotIllegalChart:function(str){
			var patt1=new RegExp("^[a-zA-Z][a-zA-Z0-9]+$");
			return patt1.exec(str);
		},
		isIllegalEmail:function(emailName){
			var patt2=new RegExp("^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$");
			return patt2.test(emailName);
		},
		isIllegalPasswd:function(passwd){
			var patt3=new RegExp("[a-zA-Z0-9!@#$%^&*_]{6,18}");
			return patt3.test(passwd);
		}
		 
		
}