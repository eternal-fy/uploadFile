function getImg(_this, imgId){
	var file = _this.files[0];
	if(window.FileReader) {//判断浏览器是否支持FileReader
		var fileReder = new FileReader();//获得一个FileReader解析对象
		fileReder.readAsDataURL(file);//将文件读取为 DataURL
		fileReder.onload = function(){//文件读取成功完成时触发
			var base64Img = this.result;//文件一旦开始读取，无论成功或失败，实例的 result 属性都会被填充。如果读取失败，则 result 的值为 null ，否则即是读取的结果
			document.getElementById("fileImg").src = base64Img;
		}
	}else{
		var url = "";
		if (window.createObjectURL != undefined) {          // basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) {               // mozilla(firefox)
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) {         // webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
		document.getElementById("fileImg").src = url;
	}
}