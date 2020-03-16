<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	
<%@include file="base/header.jsp" %>
<title>医疗信息系统</title>
<body class="login-bg">
    
    <div class="login">
        <div class="message">管理员登录——医疗信息系统</div>
        <div id="darkbannerwrap"></div>
        
        <form method="post" action="<%=request.getContextPath()%>/admin/login" class="layui-form" >
            <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
            <hr class="hr15">
            <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
            <hr class="hr15">
          
            <input class="loginin" value="登录"  style="width:100%;" type="submit">
            <hr class="hr20" >
           
            <div>
            	 <a href="<%=request.getContextPath()%>/admin/register">注册管理员</a>
            </div>
        </form>
       
    </div>

    
   
</body>
</html>