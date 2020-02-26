/**
 * 
 */

var no=$("#reno").val();
var str= "";
$.getJSON("../member/all/"+no,function(data){	
	$(data).each(function(){
		str+="<li data-rno='"+this.rno+"'class='replyLi'>"+this.rtext+"<button></button><li>";
	});
	$("#replies").html(str);
});


$(document).ready(function(){
	//댓글 쓰기 버튼 클릭시
	$("#replyadd").on("click",function(){
		alert("aaaaa");
		var no=$("#reno").val();
		var replyer=$("#rewriter").val();
		var rtext=$("#retext").val();
		
		$.ajax({
			type:"post",
			url:"../member",
			contentType:"application/json",
			data:JSON.stringify({no:no,replyer:replyer,rtext:rtext}),
			dataType:"text",
			success:function(data){
				alert("댓글 작성 ㅇ")
			},
			error:function(err){
				alert("댓글 작성 x")
			}
		})
	})
})//댓글작성 버튼 클릭 end

	//댓글 수정버튼 클릭시
	$("#replies").on("click",".replyLi button",function(){
		var reply=$(this).parent();
		var rno=reply.attr("data-rno");
		var rtext = reply.text();
		
		$(".title").html(rno);
		$("#rtext").val(rtext);
		$("#modDiv").show("slow");
	})//댓글 수정버튼 클릭시 end
	
	$("#replyMod").on("click",function(){
		var rno = $(".title").html();
		var rtext = $("#rtext").val();
		
		$.ajax({
			type:"put",
			url:"../member/"+rno,
			contentType:"application/json",
			data:JSON.stringify({rtext:rtext}),
			dataType:"text",
			success:function(data){
				if(data=="SUCCESS"){
					alert("글 수정o");
					$("#modDiv").hide("slow");
				}
			},
			error:function(err){
				alert("글 수정x");
			}
		})
	})
	//댓글 삭제
	$("#replyDel").on("click",function(){
		var rno=$(".title").html();
		
		$.ajax({
			type:"delete",
			url:"../member/"+rno,
			contentType:"application/json",
			data:JSON.stringify({rtext:rtext}),
			dataType:"text",
			success:function(data){
				if(data=="SUCCESS"){
					alert("삭제 o");
					$("#modDiv").hide("slow");
				}
			},
			error:function(err){
				alert("삭제x");
			}
		})
	})