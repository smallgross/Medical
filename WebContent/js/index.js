$.ajax({
	url:"http://localhost:8080/Medical/json/articleList", 
	complete:function(res){
		console.log(res)
	var newList=res.responseJSON;
	$(".txtlist").html("");
	newList.forEach(function(item,index){
		$(".txtlist").append(`
				<li><span class="tl_title"><a href="./artcile/a_${item.id}.html">${item.title}</a></span><i class="tl_time">昨天</i></li>
			`)
	})
	
		
	}
})