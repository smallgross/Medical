(function($){
	$('.nav .nav-bar .nav-item, .tb-wx, .search-btn, .side-nav-item, .rt-list li.ewm, .org_list ul li, .search-list ul li, .news_list li, .list_h li').hover(function() {
		$(this).addClass('hover');
	}, function() {
		$(this).removeClass('hover');
	});

	$('.tabbox .tabnav li').hover(function() {
		$(this).addClass('curr').siblings('li').removeClass('curr');
		$(this).parents('.tabbox').find('.tabcon .tabitem').eq($(this).index()).show().siblings('.tabitem').hide();
	});
	
	$(".user-name").focus(function(){
		if($(this).val() == this.defaultValue){
			$(this).val("").addClass("user-name-f");
		}
	}).blur(function(){
		if($(this).val() == ""){
			$(this).val(this.defaultValue).removeClass("user-name-f");
		}
	});
	
	$(".forminputs").focus(function(){
		if($(this).val() == this.defaultValue){
			$(this).val("").addClass("forminputs_f");
		}
	}).blur(function(){
		if($(this).val() == ""){
			$(this).val(this.defaultValue).removeClass("forminputs_f");
		}
	});
	
	//顶部登录框密码项
	$(".pass-word2").focus(function() {
		if ($(this).val() == this.defaultValue) {
			$(this).hide();
			$(this).siblings(".pass-word").show().focus();
		}
	});
	$(".pass-word").blur(function(){
		if ($(this).val() == "") {
			$(this).hide();
			$(this).siblings(".pass-word2").show();
		}
	});
	
	$(".formbtns").hover(function(){
		$(this).addClass("formbtns_h");
	},function(){
		$(this).removeClass("formbtns_h");
	});
	
	$(".search-txt").focus(function(){
		if($(this).val() == this.defaultValue){
			$(this).val("").addClass("search-txt-f");
		}
		$(this).parents(".search-bar").addClass("search-bar-f");
	}).blur(function(){
		if($(this).val() == ""){
			$(this).val(this.defaultValue).removeClass("search-txt-f");
		}
		$(this).parents(".search-bar").removeClass("search-bar-f");
	});
	
	$(".rt-list .gotop").click(function(){
		goto($("body").offset().top,50);
	});
	$(window).scroll(function(){
		var theScrollTop = document.body.scrollTop || document.documentElement.scrollTop;
		if(theScrollTop>10){
		    $(".rt-list .gotop").show();
		    $(".rer").addClass("rer-top")
		}else{
		    $(".rt-list .gotop").hide();
		    $(".rer").removeClass("rer-top")
		}
	});
	
	$('.list_box li:last').css("border","none");
	
	// organization
	if($("#organization_box").length > 0) {
		$("#organization_box").find("div.ors").find("a.show_ors_ul").click(function() {
			var $ors_ul = $(this).parent("div.ors_bt").siblings("ul");
			if($ors_ul.is(":hidden")) {
				$(this).addClass("show_ors_ul2").text("收起");
				$ors_ul.slideDown(200);
			}else{
				$(this).removeClass("show_ors_ul2").text("展开");
				$ors_ul.slideUp(200);
			}
		});
	}
	
	//用户名长度截取
	var rUsernameWidth=$(".login-info span b").width();
	if(rUsernameWidth - 110 > 0){
		$(".login-info span b").css("width","110px");
	}
	
	//预约挂号医生简介展开与收起
	var yDocH=$(".yygh_doc_jj .doc_jj_con").height();
	if(yDocH - 72 > 0){$(".yygh_doc_jj .doc_jj_con").css("height","72px");}
	$(".yygh_doc_jj .doc_jj_tit .show_ors_ul").click(function() {
		if(!$(this).hasClass("show_ors_ul2")){
			$(this).addClass("show_ors_ul2");
			$(this).text("收起");
			$(this).parents(".yygh_doc_jj").find(".doc_jj_con").css("height","auto");
			$(this).parents(".yygh_doc_jj").find(".doc_jj_con").css("max-height","none");
		}else{
			$(this).removeClass("show_ors_ul2");
			$(this).text("展开");
			$(this).parents(".yygh_doc_jj").find(".doc_jj_con").css("height","72px");
			$(this).parents(".yygh_doc_jj").find(".doc_jj_con").css("max-height","72px");
		}
	});
	
})(jQuery);

(function($){
	var _index=0;
	$('.slide-img').hover(function() {
		$(this).find('.prev,.next').show();
	}, function() {
		$(this).find('.prev,.next').hide();
	});
	$('.slide-img .prev').click(function() {
		_index--;
		if (_index<0) {
			_index =$(this).siblings('.slide-imglist').find('li').size()-1;
		}
		$(this).siblings('.slide-imglist').find('li').eq(_index).fadeIn('500').siblings('li').fadeOut('500');
	});
	$('.slide-img .next').click(function() {
		_index++;
		if (_index == $(this).siblings('.slide-imglist').find('li').size()) {
			_index=0;
		}

		$(this).siblings('.slide-imglist').find('li').eq(_index).fadeIn('slow').siblings('li').fadeOut('fast');
	});

})(jQuery);

(function($){
	var _index=0;
	$('.focus .focus-nav li').click(function() {
		_index = $(this).index();
		$(this).addClass('curr').siblings('li').removeClass('curr');
		focush(_index);
	});

	function focush(n){
		$('.focus .focus-con').stop().animate({top:-n*195}, 500);
		$('.focus .focus-nav').find('li').eq(n).addClass('curr').siblings('li').removeClass('curr');	
	}

	/*
	var auto = setInterval(function(){
		_index++;
		if (_index==$('.focus .focus-con').find('.focus-list').size()) {
			_index=0;
		}
		focush(_index);
	},5000);

	$('.focus').hover(function() {
		clearInterval(auto);
	}, function() {
		auto = setInterval(function(){
		_index++;
		if (_index==$('.focus .focus-con').find('.focus-list').size()) {
			_index=0;
		}
		focush(_index);
	},5000);
	});*/

	$('.focus-list li, .mymk_imglist li .mymk_img').hover(function() {
		$(this).find('p').stop().animate({marginTop:-95}, 300).siblings('i').stop().animate({top:0}, 300);
	}, function() {
		$(this).find('p').stop().animate({marginTop:0}, 300).siblings('i').stop().animate({top:95}, 300);;
	});
})(jQuery);

//返回锚点
function goto(art1,speed){
	var _top=0;
	if(typeof art1 =="string"){
		var art=jQuery("a[name="+name+"]");
		if(art.length>0)
			_top=art.offset().top;
	}else if(typeof art1 == "number"){
		_top=art1;
	}
	(function to(num,speed){
		var top =$(window).scrollTop();
		var deta =num-top;
		var v=(deta>0)?speed:-speed;
		var _timer = window.setTimeout(function(){
			if(Math.abs(deta)<speed){
				$(window).scrollTop(num);
				window.clearTimeout(_timer);
				_timer=null;
			}else{
				top=parseInt(top+v);
				$(window).scrollTop(top);
				deta-=v;
				_timer=window.setTimeout(arguments.callee,5);
			}
		},1);
	})(_top,speed);
}

//模拟select控件
function selectBox(thisID){
	$(thisID).children("dt").click(function(){
		$(".selectBox").children("dd").hide();
		$(thisID).children("dd").show();
		return false;
	});
	$(thisID).click(function(event){  
		 event.stopPropagation();
	});
	$('html, body').click(function(e) {
		$(thisID).children("dd").hide();
	});
	$(thisID).find("a").click(function() {
		var stext=$(this).text();
		$(thisID).children("dt").text(stext);
		$(thisID).children("dd").hide();
	});
	$(thisID).find("i.close").click(function() {
		$(thisID).children("dd").hide();
	});
}

//选卡切换 showTabs(切换按钮,切换的内容,当前按钮样式,选卡的触发方式：click/hover,默认为click )
function showTabs(TabItem,TabContent,Tabclass,Tabway){
	var tnav=$(TabItem);
	var tcon=$(TabContent);
	var tclass=Tabclass;
	if(Tabway == "hover"){
		tnav.hover(function(e) {
			var index = tnav.index(this);
			tnav.removeClass(tclass);
			$(this).addClass(tclass);
			if(!tcon==""){
				tcon.hide();
				tcon.eq(index).show();
			}
		});
	}else{
		tnav.click(function(e) {
			var index = tnav.index(this);
			$(this).siblings().removeClass(tclass);
			$(this).addClass(tclass);
			if(!tcon==""){
				tcon.hide();
				tcon.eq(index).show();
			}
		});
	}
}
//选卡折叠效果
function doubleClick(TabItem,TabContent,Tabclass){
	var tnav=$(TabItem);
	var tcon=$(TabContent);
	var tclass=Tabclass;
	tnav.click(function(e) {
		var index = tnav.index(this);
		if(!$(this).hasClass(Tabclass)){
			var index = tnav.index(this);
			$(this).siblings().removeClass(tclass);
			$(this).addClass(tclass);
			if(!tcon==""){
				tcon.hide();
				tcon.eq(index).show();
			}
		}else{
			$(this).removeClass(tclass);
			tcon.eq(index).hide();
		}
	});
}