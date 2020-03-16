<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="base/header.jsp" %>
<title>用户信息</title>
</head>
<body>
    <div class="weadmin-body">
      <form class="layui-form" action="<%=request.getContextPath() %>/admin/adduser" method="post">
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="we-red">*</span>登录名
              </label>
              
              <div class="layui-input-inline">
                  <input type="text" id="username" name="username" required="" lay-verify="required"
                  autocomplete="off" value="" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>将会成为您唯一的登入名
              </div>
          </div>
          <!-- -显示姓名 -->
          <div class="layui-form-item">
              <label for="username" class="layui-form-label">
                  <span class="we-red">*</span>真实姓名
              </label>
              <div class="layui-input-inline">
                  <input type="text" id="username" name="name" required="" lay-verify="required"
                  autocomplete="off" value="" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>将会成为您唯一的登入名
              </div>
          </div>
          <!-- 显示手机号码 -->
          <div class="layui-form-item">
              <label for="phone" class="layui-form-label">
                  <span class="we-red">*</span>手机
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="phone" name="mobile" required="" lay-verify="phone"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>将会成为您唯一的登入名
              </div>
          </div>
          <!-- 显示邮箱 -->
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="we-red">*</span>邮箱
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="L_email" name="mail" required="" lay-verify="email"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>
              </div>
          </div>
          <!-- 显年龄 -->
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="we-red">*</span>年龄
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="L_email" name="age" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>
              </div>
          </div>
          
          <!-- 个人介绍 -->
          <div class="layui-form-item">
              <label for="L_email" class="layui-form-label">
                  <span class="we-red">*</span>自我介绍
              </label>
              <div class="layui-input-inline">
                  <input type="text" value="" id="L_email" name="brief" required="" 
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  <span class="we-red">*</span>
              </div>
          </div>
          
          <div class="layui-form-item">
              <label class="layui-form-label"><span class="we-red">*</span>角色</label>
              <div class="layui-input-block">
             
              	<input type="radio" name="userType" lay-skin="primary" value="admin" title="超级管理员" checked="">
                <input type="radio" name="userType" lay-skin="primary" value="doctor" title="医生人员">
                <input type="radio" name="userType" lay-skin="primary" value="potient" title="患者人员" >
              
              
             
               
              </div>
          </div>
          <div class="layui-form-item">
              <label class="layui-form-label"><span class="we-red">*</span>性别</label>
              <div class="layui-input-block">
              	
                
                
                <input type="radio" name="sex" value="男"lay-skin="primary" title="男" >
                <input type="radio" name="sex"value="女" lay-skin="primary" title="女" >
                
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_pass" class="layui-form-label">
                  <span class="we-red">*</span>密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_pass" name="password" required="" lay-verify="pass"
                  autocomplete="off" class="layui-input">
              </div>
              <div class="layui-form-mid layui-word-aux">
                  6到16个字符
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
                  <span class="we-red">*</span>确认密码
              </label>
              <div class="layui-input-inline">
                  <input type="password" id="L_repass" name="repass" required="" lay-verify="repass"
                  autocomplete="off" class="layui-input">
              </div>
          </div>
          <div class="layui-form-item">
              <label for="L_repass" class="layui-form-label">
              </label>
              <button  class="layui-btn" lay-filter="add" lay-submit="">
                  添加
              </button>
          </div>
      </form>
    </div>
	
    <script type="text/javascript">
    	layui.extend({
				admin: '{/}../../static/js/admin'
			});
	    layui.use(['form','layer','admin'], function(){
	      var form = layui.form,
	      	admin = layui.admin,
	      	layer = layui.layer;
        
          //自定义验证规则
          form.verify({
            nikename: function(value){
              if(value.length < 5){
                return '昵称至少得5个字符啊';
              }
            }
            ,pass: [/(.+){6,12}$/, '密码必须6到12位']
            ,repass: function(value){
                if($('#L_pass').val()!=$('#L_repass').val()){
                    return '两次密码不一致';
                }
            }
          });

          //监听提交
          form.on('submit(add)', function(data){
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("增加成功", {icon: 6},function () {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
          });
          
        });
    </script>
  </body>
</html>