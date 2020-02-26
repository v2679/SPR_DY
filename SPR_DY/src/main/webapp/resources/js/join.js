/**
 * 
 */
$(document).ready(function(){
	var idcheck=RegExp(/^[a-zA-Z0-9]{5,12}$/);
	var pwcheck=RegExp(/^[a-zA-Z0-9]{6,12}$/);
$("#id").keyup(function(){
	if(!(idcheck.test($("#id").val()))){
		$("#idcheck").html("5~12자 영문 대 소문자,숫자를 사용하세요.");
	}else{
		$("#idcheck").html("사용가능한 ID입니다.");
	}
});
$("#pw").keyup(function(){
	if(!(pwcheck.test($("#pw").val()))){
		$("#pwcheck").html("6~12자 영문 대 소문자,숫자를 사용하세요.");
	}else{
		$("#pwcheck").html("사용가능한 비밀번호입니다.");
	}
});
$("#repw").keyup(function(){
	var pw=$("#pw").val();
	var repw=$("#repw").val();
	if(pw==repw){
		$("#repwck").html("비밀번호 재확인 되었습니다.");
	}else{
		$("#repwck").html("비밀번호 확인해 주세요.");
	}
})
});

function ovcheck(){
	$.ajax({
		url : "ovcheck",
		type : "post",
		dataType : "json",
		data : {"id":$("#id").val()},
		success : function(data){
			if(data==1){
				alert("중복된 아이디입니다.");
			}else if(data==0){
				alert("사용가능한 아이디입니다.")
			}
		}
	})
}