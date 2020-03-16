<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../base/header.jsp"%>
<title>文章列表</title>
</head>
<body>
	<div class="weadmin-nav">
		<span class="layui-breadcrumb"> <a href="">首页</a> <a href="">文章分类管理</a>
			<a> <cite>分类列表</cite></a>
		</span> <a class="layui-btn layui-btn-sm"
			style="line-height: 1.6em; margin-top: 3px; float: right"
			href="javascript:location.replace(location.href);" title="刷新"> <i
			class="layui-icon" style="line-height: 30px">ဂ</i></a>
	</div>
	<div class="weadmin-body">
		<div class="layui-row">
			<form class="layui-form layui-col-md12 we-search" action=""
				method="get">
				
				<div class="layui-inline">
					<input type="text" name="likeclassify" placeholder="请输入需要查找的类型"
						autocomplete="off" class="layui-input">
				</div>
				<button class="layui-btn" lay-submit="" lay-filter="sreach">
					<i class="layui-icon">&#xe615;</i>
				</button>
			</form>
		</div>
		<div class="weadmin-block">
			<button class="layui-btn layui-btn-danger" id="pdelBtn">
				<i class="layui-icon"></i>批量删除
			</button>

			<%--<a class="layui-btn" href="<%=request.getContextPath() %>/admin/adduser"><i class="layui-icon"> </i>添加</a> --%>
			<a class="layui-btn"
				href="<%=request.getContextPath()%>/admin/artice/addclassify"><i
				class="layui-icon"></i>添加</a> <span class="fr"
				style="line-height: 40px">共有数据 ${item.allNum }条</span>
		</div>
		<table class="layui-table">
			<thead>
				<tr>
					<th>
						<div class="layui-unselect header layui-form-checkbox"
							lay-skin="primary">
							<i class="layui-icon">&#xe605;</i>
						</div>
					</th>
					<th>ID</th>
					<th>分类标识</th>
					<th>分类描述</th>
					<th>上级分类</th>
					<th>操作</th>
			</thead>
			<tbody>
				<c:forEach items="${classifylist}" var="item" varStatus="i">
					<tr>
						<td>
							<div class="layui-unselect layui-form-checkbox"
								lay-skin="primary" data-id='${item.id }'>
								<i class="layui-icon">&#xe605;</i>
							</div>
						</td>
						<td>${item.id }</td>
						<td>${item.classify }</td>
						<td>${item.brief }</td>
						<td><c:out value="${item.parentid}" default="最上层分类"></c:out></td>
						<td class="td-manage"><a title="编辑" target="_blank"
							href="<%=request.getContextPath() %>/admin/artice/editclassify?classify=${item.editclassify }">
								<i class="layui-icon">&#xe642;</i>
						</a> <%--<a title="删除"  href="<%=request.getContextPath() %>/admin/deluser?id=${user.id}">  
						<span title="删除" class="delbtn" dataset-id="${user.id}" dataset-username="${user.username }">
								<%--<i class="layui-icon">&#xe640;</i>--%> 
								<span title="删除"class="delbtn" data-id="${item.id}"
							data-classify="${item.classify }"> <i class="layui-icon">&#xe640;</i>
						</span></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="page">
			<div>
				<!-- 判断是否第一页，如果是第一页的话就不让其显示 -->
				<c:if test="${page!='1'}">
					<a class="prev"
						href="<%=request.getContextPath() %>/admin/artice/classify?page=${page-1}">
						&lt;&lt;</a>
				</c:if>

				<span class="current">${page}</span>

				<c:if test="${(page+1)<=allpage}">
					<a class="num"
						href="<%=request.getContextPath() %>/admin/artice/classify?page=${page+1}">${page+1 }</a>
				</c:if>

				<c:if test="${(page+2)<allpage}">
					<a class="num"
						href="<%=request.getContextPath() %>/admin/artice/classify?page=${page+2}">${page+2 }</a>
				</c:if>
				<c:if test="${(page+1)<allpage}">
					<a class="num"
						href="<%=request.getContextPath() %>/admin/artice/classify?page=${allpage}">${allpage }</a>
				</c:if>
				<c:if test="${(page+1)<=allpage}">
					<a class="next"
						href="<%=request.getContextPath() %>/admin/artice/classify?page=${page+1}">&gt;&gt;</a>
				</c:if>
			</div>
		</div>
	</div>

	<script>
	//一般直接写在一个js文件中
	layui.use(['layer', 'form','jquery'], function(){
	  var layer = layui.layer
	  ,form = layui.form;
	  var $=layui.jquery;
	  var tbody = document.querySelector("tbody");
	  tbody.addEventListener("click",function(e){
			if(e.target.parentElement.className=="delbtn"){
					console.log("点击删除按钮");
					//获取删除按钮的id和用户名
					var id =e.target.parentElement.dataset.id;
					var classify=e.target.parentElement.dataset.classify;
					//eg1       
					var alertId=layer.confirm('是否确认id为'+id+"的"+classify+"?", {
					  btn: ['是否确认', '确认'] //可以无限个按钮
					
					}, function(index, layero){
						layer.close(alertId); //此时你只需要把获得的alertId，轻轻地赋予layer.close即可
						  
					}, function(index){
					  //按钮【按钮二】的回调
						  location.href="<%=request.getContextPath() %>/admin/artice/deleteclassify?id="+id;
						
					});
				}
			})
			//全选 按钮的
	var allSelectBtn=document.querySelector(".layui-unselect.header.layui-form-checkbox")
	var isAllSelect=false;
	allSelectBtn.addEventListener("click",function(){
		console.log(123)
		if (isAllSelect) {
			$(".layui-form-checkbox i").css("background","#fff")
			isAllSelect=false;
		}else {
			$(".layui-form-checkbox i").css("background","#1E9FFF")
			isAllSelect=true;
		}
		
		})

		$('.layui-unselect.layui-form-checkbox[data-id]').click(function(e){
			
			if (e.target.style.background=="rgb(30, 159, 255)") {
				//放置原生对象
				$(e.target).css("background","#fff")
			}else {
				$(e.target).css("background","#1E9FFF")
			}
			isAllSelect=false;
			$('.layui-unselect.layui-form-checkbox:eq(0) i').css("background","#fff")
			})
			//批量删除
	$("#pdelBtn").click(function(){
		var allCheckBox=document.querySelectorAll(".layui-unselect.layui-form-checkbox[data-id]");
		var delTdList=[]
		allCheckBox.forEach(function(item,index){
			console.log([item])
			//讲蓝色放入id数组框
			if (item.children[0].style.background=="rgb(30, 159, 255)") {
				delTdList.push(item.dataset.id)
			}
			})
			console.log(delTdList);


		//弹框    
		var alertId=layer.confirm('是否确认批量删除'+delTdList+"?", {
		  btn: ['是否确认', '确认'] //可以无限个按钮
		
		}, function(index, layero){
			layer.close(alertId); //此时你只需要把获得的alertId，轻轻地赋予layer.close即可
			  
		}, function(index){
		  //按钮【按钮二】的回调
			 	//传数据
		$.ajax({
			url:"<%=request.getContextPath() %>/admin/artice/deleteclassify",
				  	method:"post",
				  	data:{
				  		ids:delTdList
				  	},
				  	complete:function(res){
				  		console.log(res)
				  		location.reload();
				}
			})
			});
	
			})
		});
		</script>
	
</body>
</html>