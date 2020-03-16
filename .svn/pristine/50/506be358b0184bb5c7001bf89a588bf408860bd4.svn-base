<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="base/header.jsp"%>
<title>医疗信息系统</title>

<body class="login-bg">
	<style type="text/css">
input[disabled=disabled] {
	opacity: 0.6;
	cursor: not-allowed !important;
}

input.error {
	border-color: deeppink !important;
}

input.error:hover {
	border-color: deeppink !important;
}
</style>
	</style>
	<div class="login">
		<div class="message">管理员登录——医疗信息系统</div>
		<div id="darkbannerwrap"></div>

		<form method="post"
			action="<%=request.getContextPath()%>/admin/register"
			class="layui-form">
			<input name="username" id="username" placeholder="请输入注册用户"
				type="text" class="layui-input">
			<hr class="hr15">
			<input name="password" id="password" placeholder="请输入注册密码"
				type="password" class="layui-input">
			<hr class="hr15">
			<input name="repassword" id="repassword" placeholder="请重新输入密码"
				type="password" class="layui-input">
			<hr class="hr15">

			<input class="loginin" id="button" value="注册" disabled="disabled"
				style="width: 100%;" type="submit">
			<hr class="hr20">
			
		</form>
	</div>
	<script type="text/javascript">
		var usernameDom = document.querySelector("#username");
		var passwordDom = document.querySelector("#password");
		var repasswordDom = document.querySelector("#repassword");
		var button = document.querySelector("#button");
		layui.use('layer', function() {
			var $ = layui.jquery, layer = layui.layer;
			//username输入的内容，必须是是[A-Z0-9],并且大于等于5个字符以上
			usernameDom.oninput = function() {
				var value = usernameDom.value;
				var regex = /^[A-z0-9_]{5,20}$/i;
				if(regex.test(value)){
					$("#username").removeClass("error")
					//this.style.border = "1px solid #DCDEE0!important";
				} else {
					$("#username").addClass("error")
					console.log("用户名必须由英文名和数字下横线组成")
					//this.style.border = "1px solid deeppink!important";
					//this.style.outline = "1px solid deeppink!important";
					//配置一个透明的询问框
					layer.msg("用户名必须由英文名和数字下横线组成", {
						time : 3000, //10s后自动关闭
						offset : 't'
					})
				}

			}
			passwordDom.oninput = function() {
				var value = passwordDom.value;
				var regex = /.{6,}/;
				if (!regex.test(value)) {
					$("#password").removeClass("error")
					//this.style.border = "1px solid deeppink!important";
					//配置一个透明的询问框
					layer.msg("密码必须是5个字符以上", {
						time : 3000, //10s后自动关闭
						offset : 't'
					})
				} else {
					$("#password").addClass("error")
					//this.style.border = "1px solid #DCDEE0!important";
				}
			}
			repasswordDom.oninput = function() {
				if (passwordDom.value == repasswordDom.value
						&& passwordDom.value.length > 5
						&& usernameDom.value.length >= 5) {
					$("#repassword").removeClass("error")
					button.disabled = false;
					//this.style.border = "1px solid #DCDEE0!important";
				} else {
					//this.style.border = "1px solid deeppink!important";
					$("#repassword").addClass("error")
					//配置一个透明的询问框
					layer.msg("输入密码不一致", {
						time : 3000, //10s后自动关闭
						offset : 't'
					})
				}
			}
		})
	</script>
</body>

</html>