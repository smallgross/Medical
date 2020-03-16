var ShareToWeiXin = { 
GetShareCodeImgUrl: function (title,Url,ImgUrl, Fun,summary) {
var returnUrl="http://b.bshare.cn/barCode?"+
"site=weixin&type=0&publisherUuid=ceb08f79-b3e9-4dfd-9f66-30987ff1ffb4"+
"&url="+encodeURIComponent(Url)+""+
"&title="+encodeURIComponent(title)+
"&summary="+ (summary===undefined?"":encodeURIComponent(summary) )+
"&pics="+encodeURIComponent(ImgUrl)+
"&video=&vTag=&vUid=&vEmail=&product=&price=0&brand=&tag=&category=&template=1&popcss=&apvuid=&apts=&apsign=&admtest=false&request_locale=zh&lang=zh";
 Fun(1, returnUrl);
}
    /*GetShareCodeImgUrl: function (title,Url,ImgUrl, Fun) {
        $.ajax({
            url: "https://open.weixin.qq.com/qr/set/?a=1&title=" + encodeURI(title) + "&url=" + encodeURI(Url) + "&img=" + ImgUrl + "&appid=wx9f0fd5688bb5dbf3&r=" + String(Math.random()),
            type: "GET",
            dataType: "jsonp",
            jsonpCallback: "showWxBox",
            success: function (text, status) {
                var strCode = text;
                if ($.trim(text) != "") {
                    var strUrl = "https://open.weixin.qq.com/qr/get/" + text + "/";
                    Fun(1,strUrl);
                }
                else {
                    Fun(0);
                }
            }
        });
    }
*/
};