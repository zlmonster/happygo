var TT = HAPPYGO = {
	checkLogin : function(){
		var _token = $.cookie("TT_TOKEN");
		if(!_token){
			return ;
		}
		$.ajax({
			url : "http://ssoquery.happygo.com/user/" + _token,
			dataType : "jsonp",
			type : "GET",
			success : function(data){
				var html =data.username+"，欢迎来到快乐购！<a href=\"http://www.happygo.com/user/logout.html\" class=\"link-logout\">[退出]</a>";
				$("#loginbar").html(html);
			}
		});
	}
}

$(function(){
	// 查看是否已经登录，如果已经登录查询登录信息
	TT.checkLogin();
});