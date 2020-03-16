<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html">
    <title>医院新闻</title>
    <meta name="Keywords" content="南方医科大学南方医院,南方医院,口腔医学,消化病,器官衰竭">
    <meta name="Description" content="南方医院创建于1941年是南方医科大学第一附属医院，是一所集医疗、教学、科研和预防保健为一体的拥有口腔科,口腔医学,内科,消化病,外科学,病理科,肾内科,围产医学,器官衰竭,恵侨科,创伤骨科等52个科室的大型综合性三级甲等医院，全国首批百佳医院">
    <!--PubLog:IsIncludeFile-->

<meta http-equiv="Cache-Control" content="no-transform">
<link rel="stylesheet" href="./html/css/nfyy_base.css">
<link rel="stylesheet" href="./html/css/nfyy_news.css">
<script type="text/javascript" src="./html/js/jquery.min.js"></script>
<base target="_blank">
 
</head>
<body>
    <!--PubLog:IsIncludeFile-->
<div class="top-bar-wrap">
<div class="top-bar clearfix">
<div class="tb-tools fr">
	<span class="tb-com tb-pop tb-wx fl">
		<span class="tb-pop-tit">
			<a href="javascript:;" target="_self"><font>官方微信</font><i class="arrow"></i></a>
		</span>
		<em></em>
		<span class="tb-pop-con">
			南方医院微信官号
			<br>
			<a href=""><img src="./html/images/pic/img_pic1.jpg" width="117" height="117" alt=""></a>
			<br>
			扫一扫关注南方医院
		</span>
	</span>
	<span class="tb-com fl">
		<span class="tb-wb">
			<span>官方微博</span>
			<a href="" class="sina-wb"></a>
			<a href="" class="qq-wb"></a>	
		</span>
	</span>
	<span class="tb-com fl">
		<a href="">南方医院</a>
	</span>
	<span class="tb-com fl">
		<a href="javascript:;">English</a>
	</span>
</div>
</div>
</div>
    <div class="main">
        <div class="header clearfix">
    <div class="logo fl"></div>
<div class="person-center fr"><a href="">个人中心</a></div>
<div class="search-bar fr">
<span class="search-keyword">
<script type="text/javascript">
var hotTopKeywords=["惠侨楼","消化内镜","侯凡凡"];
   for (var i = 0; i < hotTopKeywords.length;i++)
        {
            document.write('<a href="/search/?keyword=' + encodeURI(hotTopKeywords[i]) + '">' + hotTopKeywords[i] + '</a>')
        }
</script>  
</span>
<form action="/search/">
	<input type="text" class="search-txt" value="侯凡凡院士" name="keyword">
	<input type="submit" value="" class="search-btn">
	</form>	
</div>
</div>
        <!--导航栏部分-->
        <div class="nav" id="topMainNav">
            <ul class="nav-bar clearfix">
                <li class="nav-item home">
    <div class="nav-item-tit" id="nav_home"><a href="<%=request.getContextPath()%>/index.html" target="_self">首页 </a></div>
</li>
<li class="nav-item">
    <div class="nav-item-tit" id="nav_yyjs"><a href="./aboutus/Index.html" target="_self">医院介绍</a></div>
</li>

                <li class="nav-item">
    <div class="nav-item-tit" id="nav_hzfw"><a href="./hzfw/Index.html" target="_self">服务导航</a></div>
        <ul class="nav-item-list">
        <li><a href="./hzfw/k1.html" target="_self">就医指南</a></li>
        <li><a href="./hzfw/k2.html" target="_self">智能分诊</a></li>
        <li><a href="./appointment/appointmentindex.html" target="_self">预约挂号</a></li>
    </ul>

</li>
<li class="nav-item">
    <div class="nav-item-tit" id="nav_mymk"><a href="./articlelistpage" target="_self">名医名科</a></div>
</li>
<li class="nav-item">
    <div class="nav-item-tit" id="nav_xwzx"><a href="./articlelistpage" target="_self">新闻中心</a></div>
    <ul class="nav-item-list">
  
        <li><a href="#" target="_self">医院公告</a></li>
        <li><a href="" target="_self">医院新闻</a></li>
        <li><a href="mtny1.html" target="_self">媒体南医</a></li>
        
        <li><a href="nyyx1.html" target="_self">南医视频</a></li>
        <!--<li class="nobline"><a href="/xwzx/myzj/" target="_self">名医传记</a></li>-->
    </ul>
</li>
<li class="nav-item">
    <div class="nav-item-tit" id="nav_nyxs"><a href="" target="_self">院务管理</a></div>
    <ul class="nav-item-list">
        <li><a href="javascript:;">招生/进修</a></li>
        <li><a href="./jxky.html" target="_self">科研管理</a></li>
        <li class="nobline"><a href="javascript:;" target="_self">学生管理</a></li>
 <li class="nobline"><a href="./index1.html" target="_self">财务管理</a></li>
<li class="nobline"><a href="javascript:;" target="_self">医师考学</a></li>
    </ul>
</li>
<li class="nav-item">
    <div class="nav-item-tit" id="nav_nygy"><a href="./nygy/index.html" target="_self">南医公益</a></div>
    <ul class="nav-item-list">
       
        <li><a href="javascript:;" target="_self">骆老博客</a></li>
        
        <li class="nobline"><a href="/nygy/ylbf" target="_self">医疗帮扶</a></li>-->
    </ul>
</li>
<li class="nav-item">
    <div class="nav-item-tit" id="nav_job"><a href="./job/Index.html" target="_self">人才招聘</a></div>

</li>

            </ul>
        </div>
        <!--导航栏部分-->
    </div>
   <div class="main">
        <div class="web_location">
            <span class="location_text"><a href="<%=request.getContextPath()%>/articlelistpage" title="首页">首页</a> - <a href="./articlelistpage" title="新闻中心" target="_self">新闻中心</a> - <a href="./articlelistpage" title="医院新闻" target="_self">医院新闻</a></span>
        </div>
        <div class="web_mainbox">
		<div class="web_left">
			<div class="list_box">
			<h2>医院新闻</h2>
                <ul class="clearfix">
                
                <c:forEach items="${aList}" var="item">
                    <li class="nopic clearfix">
 					<div class="cont clearfix">
						<h3><a href="<%=request.getContextPath()%>/artcile/a_${item.id}.html">${item.title }</a></h3>
						<em>2019-09-24</em>
						<p></p>
						<span>
                         
						</span>
					</div>
				</li>
				</c:forEach>
                   
                    
	</ul>
		</div>
		<!--web_page-->
		<div class="web_page">
            <a href="javascript:void(0);" target="_self" class="prev page_none">上一页</a><b>1</b><a href="javascript:;" target="_self">2</a><a href="javascript:;" target="_self">3</a><a href="javascript:;" target="_self">4</a><a href="javascript:;" target="_self">5</a><a href="javascript:;" target="_self">6</a><a href="javascript:;" target="_self">7</a><a href="javascript:;" target="_self">8</a>...<a href="javascript:;" class="next" target="_self">下一页</a><span class="page_input">到第 <input type="text" class="page_num" name="page_num" id="txtPageNo12282"> 页</span><input type="button" class="page_btn formbtns" name="page_btn" id="page_btn" value="确定" onclick="if(isNum($('#txtPageNo12282').val()) && $('#txtPageNo12282').val()*1>0){location.href=($('#txtPageNo12282').val()*1)>2?'http://nfyy.com/xwzx/yyxw/index_'+$('#txtPageNo12282').val()+'.html':'http://nfyy.com/xwzx/yyxw/index.html'}else{alert('请输入大于0的数字');$('#txtPageNo12282').val('');$('#txtPageNo12282').focus();}">
			 		</div>
		<!--web_page end-->
</div>
<!--PubLog:IsIncludeFile-->	

<div class="web_right">
<div class="rbox">
<span class="img_nav">
	<a href="./hzfw/k1.html" title="就医指南" class="n1" target="_self">就医指南</a>
	<a href="./ybfw/a_1016011.html" title="医保信息" class="n2" target="_self">医保信息</a>
	<a href="./appointment/appointmentindex.html" title="预约挂号" class="n3">预约挂号</a>
	<a href="./ycyx/Index.html" title="远程会诊" class="n7">远程会诊</a>
	<a href="javascript:;" title="健康体检" class="n6" target="_self">健康体检</a>
	<a href="./hzfw/k8.html" title="特需服务" class="n8" target="_self">特需服务</a>
</span>
</div><div class="rbox">
    <div class="column col1 roll">
        <div class="col-tit roll-nav control">
            <strong>门诊动态</strong>
            <a href="javascript:;" target="_self" class="up" id="up"></a>
            <a href="javascript:;" target="_self" class="down" id="down"></a>
        </div>
        <div class="col-con roll-con" id="roll-ad">
            <ul class="txtlist tl2">
               <li><span class="txt fl"><a href="mzdt/a_101312.html">惠侨医疗中心门诊服务温馨告知</a></span></li><li><span class="txt fl"><a href="mzdt/a_101313.html">南方医院名医诊区简介及出诊安排</a></span></li><li><span class="txt fl"><a href="mzdt/a_101311.html">南方医院全预约服务模式宣传手册</a></span></li><li><span class="txt fl"><a href="mzdt/a_101310.html">“全预约”温馨告知您</a></span></li><li><span class="txt fl"><a href="mzdt/a_101303.html">门诊时间</a></span></li>
            </ul>
        </div>
    </div>
</div><div class="rbox rightPic"><a href="./nyjy/index.html" target="_self"><img src="./html/images/pic/m.jpg" alt=""></a></div>     
<div class="rbox">
    <div class="col-tit"><strong>最新公告</strong></div>
    <ul class="news_rlist txtlist">
          
            	<li><a href="yygg/a_1058231.html">南方医科大学南方医院征集通风橱及排风设备供应商公告（国产）</a></li>            	 
                
            	<li><a href="yygg/a_1058241.html">南方医科大学南方医院征集虚拟仿真实验室功能模块建设供应商公告（国产）</a></li>            	 
                
            	<li><a href="yygg/a_1058221.html">南方医科大学南方医院征集-80℃低温冰箱供应商公告</a></li>            	 
                 
    </ul>
</div> 
    <!--热点视频-->
			<div class="rbox">
				<div class="col-tit"><strong>热点视频</strong></div>
				<div class="shipin"><a href="nyyx/a_101293.html"><img src="./Upload/201411/6355148268667187504266332.jpg" alt=""><i></i><span>腾讯大粤网专访南方医睡眠专家李涛平</span><em class="png"></em></a></div>
			</div>
			<!--热点视频 end-->
     <div class="rbox hot-art">
				<div class="col-tit"><strong>热点文章</strong></div>
				<ul>
     
					<li><i>1</i><span><a href="yyxw/a_101174.html">胸心血管外科蔡开灿完成云南鲁甸抗震救灾任务凯旋</a></span></li> 
		  
					<li><i>2</i><span><a href="yyxw/a_101171.html">心内科举办广州复杂冠脉介入治疗研讨会</a></span></li> 
		  
					<li><i>3</i><span><a href="yyxw/a_101173.html">智发朝教授课题组在GIE上发表NOTES技术诊断不明原因腹水患者研究成果</a></span></li> 
		  
					<li><i>4</i><span><a href="yyxw/a_101172.html">智发朝教授当选为中国健康促进基金会消化内镜发展专项基金管理委员会副主任委员</a></span></li> 
		  
					<li><i>5</i><span><a href="yyxw/a_101175.html">谭万龙当选广东省泌尿生殖协会泌尿腹腔镜学分会首届委员会主任委员</a></span></li> 
		 
                    	</ul>
			</div>
                    <div class="rbox rightPic">	
				<a href="./nygy/Index.html" target="_self"><img src="./html/images/pic/m2.jpg" alt=""></a>
			</div><!--热门标签-->
<div class="rbox clearfix">
    <div class="col-tit"><strong>热门标签</strong></div>
    <div class="hotTag">
<script type="text/javascript">
var hotKeywords=["侯凡凡","糖尿病","微整形","谭万龙","李国新教授","地中海贫血","骆抗先","微创治疗","惠侨科","脂肪肝","侯金林教授","肝病","创伤骨科","薛耀明"];
   for (var i = 0; i < hotKeywords.length;i++)
        {
            document.write('<a href="/search/?keyword=' + encodeURI(hotKeywords[i]) + '">' + hotKeywords[i] + '</a>')
        }
</script>     
    </div>
</div>
<!--热门标签 end-->
 </div>
               </div>
    </div>
    <!--PubLog:IsIncludeFile-->
<div class="footer-wrap">
	
		<ul class="fl ft-ewm">
        	<li>
            	<p><img src="./html/images/ewm1.jpg"></p>
                <p>微信订阅号</p>
            </li>
        	<li>
            	<p><img src="./html/images/ewm2.jpg"></p>
                <p>微信服务号</p>
            </li>
        </ul>
		<div class="ft-contact fr">
            <ul class="ft-list fl">
                <li><a href="./aboutus/Index.html">关于我们</a></li>
			    <li><a href="./hzfw/jyzn/mzzn/a_1015541.html">联系我们</a></li>
			    <li><a href="">加入收藏</a></li>
			    <li><a href="./job/Index.html">人才招聘</a></li>
			    <li><a href="./hzfw/jyzn/mzzn/a_1023251.html">投诉途径</a></li>
            </ul>
		</div>
	</div>
</div>
<div class="right-tools">
	<ul class="rt-list">
		<li class="ewm">
			<a href="javascript:void(0);" target="_self" class="png">
				<div class="ewm_sbox">
					<i></i>
					<span>南方医院微信官号<br>
						<img src="./html/images/pic/img_pic1.jpg" width="117" height="117" alt=""><br>
						扫一扫关注南方医院</span>
				</div>
			</a>
		</li>
		<li class="service"><a href="./hzfw/Index.html" class="png"></a></li>
		<li class="gohome"><a href="./Index.html" class="png"></a></li>
		<li class="gotop"><a href="javascript:void(0);" target="_self" class="png"></a></li>
	</ul>
</div>

<script type="text/javascript" src="./html/js/Marquee.js"></script>
<script type="text/javascript" src="./html/js/jcarousellite.js"></script>
<script type="text/javascript" src="./html/js/common.js"></script>
<script type="text/javascript">
    $(function () {
        var col = document.location.pathname.split('/')[1];
        $('#topMainNav').find("li a").each(function () {

            if (col == "search") {
                $("#nav_home").addClass('on');
                return false;
            }
            if ($(this).attr('href').indexOf(col) > 0) {
                $("#topMainNav").find('div').removeClass('on');
                $(this).parent('div').addClass('on');
                return false;
            };
        });

        $("body a").click(function () {
            var href = $(this).attr("href");
            var host = window.location.host;
            if (href.indexOf('http') != -1) {
                if (href.indexOf(host) == -1) {
                    event.returnValue = confirm("您是否要离开本站点，跳转到其它页面吗？");
                }
            }
        });
    });
</script>


<div style="margin:0px auto; text-align:center;">
    <script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://"); document.write(unescape("%3Cspan id='cnzz_stat_icon_1255838524'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s11.cnzz.com/z_stat.php%3Fid%3D1255838524%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
</div>
<script type="text/javascript">
    var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
    document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fdf36900115c9078dccb665ac42a36e49' type='text/javascript'%3E%3C/script%3E"));
</script>
    </body>
</html>