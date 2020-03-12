/**
 * 
 */
//alert("aaaaa");
/*
		$(document).ready(function(){
			$("filedown").on("click",function(){
				
		
			var formObj = $("form[name='readForm']");
			$("#FILE_NO").attr("value", fileNo);
			formObj.attr("action", "/member/fileDown");
			formObj.submit();
		})
		})
	*/	
		function filedown(fileNo){
			var formObj = $("form[name='readForm']");
			$("#FILE_NO").attr("value", fileNo);
			formObj.attr("action", "/fileDown");
			formObj.submit();
		}