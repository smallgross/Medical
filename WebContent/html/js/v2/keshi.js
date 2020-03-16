$(document).ready(function () {
    //兼容非谷歌内核的浏览器
    function wordlimit(cname,wordlength){  //参数分别为：类名，要显示的字符串长度
        var cname=document.getElementsByClassName(cname); //需要加省略符号的元素对象
        for(var i=0;i<cname.length;i++){
            var nowhtml=cname[i].innerHTML;    //元素的内容
            var nowlength=cname[i].innerHTML.length;     //元素文本的长度
            if(nowlength>wordlength){
                cname[i].innerHTML=nowhtml.substr(0,wordlength)+'...';  //截取元素的文本的长度并加上省略号
            }
        }

    }

    wordlimit("ksgg-desc", 53);
    wordlimit("good",50);
    wordlimit("icu-name",22);
    wordlimit("icu-desc",28);
    wordlimit("list-desc",198);
})
