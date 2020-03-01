<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title }</title>
<style>
.main{
	width: 800px;
	height:600px;
	/*居中对齐  */
	margin: 0 auto;
	/*,设为Flex布局以后,子元素  */
	display: flex;
	/*弹性项沿着弹性容器的主轴线(mainaxis)对齐  */
	justify-content: center;
	/*居中对齐弹性盒的各项  */
	align-items: center;
	/* 让元素沿垂直主轴从上到下垂直排列 */
	flex-direction: column;
	
}
</style>
</head>
<body>
	<div class="main">
		<img src="<%=request.getContextPath()%>/static/images/sample.gif"/>
		<h3>${title }</h3>
		<p>${infojsp}</p>
		<p><span>3</span>秒后跳转页面</p>
	</div>
	<script>
		
	
		var num = 3;
		setInterval(function() {

			if (num == 0) {
			location.href="<%=request.getContextPath()%>${httpUrl}"
			}
			num--;
			var sapDom = document.querySelector("span")
			sapDom.innerHTML = num;
		}, 1000)
	</script>
</body>
</html>