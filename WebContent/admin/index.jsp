<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="base/header.jsp" %>
<!DOCTYPE html PUBLIC >

<html lang="en">

	<title>后台医疗信息系统</title>

	<body>
		<!-- 顶部开始 -->
		<div class="container">
			<div class="logo">
				<a href="./index">医疗信息后台管理系统</a>
			</div>
			<div class="left_open">
				<!-- <i title="展开左侧栏" class="iconfont">&#xe699;</i> -->
				<i title="展开左侧栏" class="layui-icon layui-icon-shrink-right"></i>
				
			</div>
			
			<ul class="layui-nav right" lay-filter="">
				<li class="layui-nav-item">
					<a href="javascript:;">${username}</a>
					<dl class="layui-nav-child">
						<!-- 二级菜单 -->
						<dd>
							<a onclick="WeAdminShow('个人信息','./userPersonal')">个人信息</a>
						</dd>
						<dd>
							<a href="./login">切换帐号</a>
						</dd>
						<dd>
							<a class="loginout" href="./loginout">退出</a>
						</dd>
					</dl>
				</li>
				<li class="layui-nav-item to-index">
					<a href="./index">前台首页</a>
				</li>
			</ul>

		</div>
		<!-- 顶部结束 -->
		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<div class="left-nav">
			<div id="side-nav">
				<ul id="nav">
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe6b8;</i>
							<cite>用户管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="<%=request.getContextPath()%>/admin/userlist">
									<i class="iconfont">&#xe6a7;</i>
									<cite>用户列表</cite>

								</a>
							</li>
							
						</ul>
					</li>
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe705;</i>
							<cite>文章管理</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							<li>
								<a _href="<%=request.getContextPath()%>/admin/artice/articlelist">
									<i class="iconfont">&#xe6a7;</i>
									<cite>文章列表</cite>
								</a>
							</li>
							<li>
								<a _href="<%=request.getContextPath()%>/admin/artice/classify">
									<i class="iconfont">&#xe6a7;</i>
									<cite>分类管理</cite>
								</a>
							</li>
						</ul>
					</li>

							<li>
					<li>
						<a href="javascript:;">
							<i class="iconfont">&#xe6ce;</i>
							<cite>系统统计</cite>
							<i class="iconfont nav_right">&#xe697;</i>
						</a>
						<ul class="sub-menu">
							
							
							<li>
								<a _href="<%=request.getContextPath()%>/pages/echarts/echarts3.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>地图</cite>
								</a>
							</li>
							
							<li>
								<a _href="<%=request.getContextPath()%>/pages/echarts/echarts5.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>雷达图</cite>
								</a>
							</li>
							
							<li>
								<a _href="<%=request.getContextPath()%>/pages/echarts/echarts7.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>热力图</cite>
								</a>
							</li>
							<li>
								<a _href="<%=request.getContextPath()%>/pages/echarts/echarts8.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>仪表图</cite>
								</a>
							</li>
							<li>
								<a _href="<%=request.getContextPath()%>/pages/echarts/echarts9.html">
									<i class="iconfont">&#xe6a7;</i>
									<cite>地图DIY实例</cite>
								</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</div>
		<!-- <div class="x-slide_left"></div> -->
		<!-- 左侧菜单结束 -->
		<!-- 右侧主体开始 -->
		<div class="page-content">
			<div class="layui-tab tab" lay-filter="wenav_tab" id="WeTabTip" lay-allowclose="true">
				<ul class="layui-tab-title" id="tabName">
					<li>我的桌面</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show">
						<iframe src='<%=request.getContextPath()%>/pages/welcome.html' frameborder="0" scrolling="yes" class="weIframe"></iframe>
					</div>
				</div>
			</div>
		</div>
		<div class="page-content-bg"></div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		<!-- 底部开始 -->
		<div class="footer">
			<div class="copyright">luoli</div>
		</div>
		<!-- 底部结束 -->
		<script type="text/javascript">
//			layui扩展模块的两种加载方式-示例
//		    layui.extend({
//			  admin: '{/}../../static/js/admin' // {/}的意思即代表采用自有路径，即不跟随 base 路径
//			});
//			//使用拓展模块
//			layui.use('admin', function(){
//			  var admin = layui.admin;
//			});
			layui.config({
				 base: '<%=request.getContextPath() %>/static/js/'
			  ,version: '101100'
			}).use('admin');
			layui.use(['jquery','admin'], function(){

					
					var $ = layui.jquery;
			});

		</script>
	</body>
	<!--Tab菜单右键弹出菜单-->
	<ul class="rightMenu" id="rightMenu">
        <li data-type="fresh">刷新</li>
        <li data-type="current">关闭当前</li>
        <li data-type="other">关闭其它</li>
        <li data-type="all">关闭所有</li>
    </ul>

</html>