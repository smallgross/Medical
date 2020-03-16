<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="../base/header.jsp"%>
<title>信息修改</title>
</head>
<body>
	<div class="weadmin-body">
		<form class="layui-form"
			action="<%=request.getContextPath()%>/admin/artice/editclassify"
			method="post">
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="we-red">*</span>分类标识
				</label>

				<div class="layui-input-inline">
					<input type="text" name="classify" 
						lay-verify="required" autocomplete="off" value="${item.classify }"
						class="layui-input">
				</div>

			</div>
			<!-- -显示姓名 -->
			<div class="layui-form-item">
				<label for="username" class="layui-form-label"> <span
					class="we-red">*</span>分类描述
				</label>
				<div class="layui-input-inline">
					<input type="text" name="brief" required="" lay-verify="required"
						autocomplete="off" value="${item.brief }" class="layui-input">
				</div>

			</div>
			<!-- 显示手机号码 -->
			<div class="layui-form-item">
				<label for="phone" class="layui-form-label"> <span
					class="we-red"></span>父级分类
				</label>
				<div class="layui-input-inline">
					<select name="clist">
						<option value="0">最上层分类</option>
						<c:forEach items="${clist}" var="item">
							<option value="${item.id}">${item.classify }</option>
						</c:forEach>
					</select>
				</div>

			</div>

			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn">修改</button>
			</div>
		</form>
	</div>

	<script type="text/javascript">
		layui.extend({
			admin : '{/}../../static/js/admin'
		});
		layui.use([ 'form', 'layer', 'admin' ], function() {
			var form = layui.form, admin = layui.admin, layer = layui.layer;

			//自定义验证规则
			form.verify({
				nikename : function(value) {
					if (value.length < 5) {
						return '昵称至少得5个字符啊';
					}
				},
				pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
				repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				}
			});

			//监听提交
			/*   form.on('submit(add)', function(data){
			       console.log(data);
			       //发异步，把数据提交给php
			       layer.alert("增加成功", {icon: 6},function () {
			           // 获得frame索引
			           var index = parent.layer.getFrameIndex(window.name);
			           //关闭当前frame
			           parent.layer.close(index);
			       });
			       return false;
			     });*/

		});
	</script>
</body>
</html>