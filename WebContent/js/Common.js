//if ($.dialog) {
//    window.alert = function (info) {
//        info = String(info).replace(new RegExp(/\n/), "<br/>");
//        $.dialog.alert(info, function () { return true; });
//    };
//}  
var Request = {
    "init": ""
  , "getParameter": function (name) {
      var url = document.location.href;
      var start = url.indexOf("?") + 1;
      if (start == 0) {
          return "";
      }
      var value = "";
      var queryString = url.substring(start);
      var paraNames = queryString.split("&");
      for (var i = 0; i < paraNames.length; i++) {
          if (name == this.getParameterName(paraNames[i])) {
              value = this.getParameterValue(paraNames[i])
          }
      }
      return value;
  }
  , "getParameterName": function (str) {
      var start = str.indexOf("=");
      if (start == -1) {
          return str;
      }
      return str.substring(0, start);
  }

  , "getParameterValue": function (str) {
      var start = str.indexOf("=");
      if (start == -1) {
          return "";
      }
      return str.substring(start + 1);
  }
}
jQuery.extend(
 {
     /**
     * @see  将json字符串转换为对象
     * @param   json字符串
     * @return 返回object,array,string等对象
     */
     evalJSON: function (strJson) {
         return eval("(" + strJson + ")");
     }
 });
jQuery.extend(
 {
     /**
     * @see  将javascript数据类型转换为json字符串
     * @param 待转换对象,支持object,array,string,function,number,boolean,regexp
     * @return 返回json字符串
     */
     toJSON: function (object) {
         var type = typeof object;
         if ('object' == type) {
             if (Array == object.constructor)
                 type = 'array';
             else if (RegExp == object.constructor)
                 type = 'regexp';
             else
                 type = 'object';
         }
         switch (type) {
             case 'undefined':
             case 'unknown':
                 return;
                 break;
             case 'function':
             case 'boolean':
             case 'regexp':
                 return object.toString();
                 break;
             case 'number':
                 return isFinite(object) ? object.toString() : 'null';
                 break;
             case 'string':
                 return '"' + object.replace(/(\\|\")/g, "\\$1").replace(/\n|\r|\t/g,
       function () {
           var a = arguments[0];
           return (a == '\n') ? '\\n' :
                       (a == '\r') ? '\\r' :
                       (a == '\t') ? '\\t' : ""
       }) + '"';
                 break;
             case 'object':
                 if (object === null) return 'null';
                 var results = [];
                 for (var property in object) {
                     var value = jQuery.toJSON(object[property]);
                     if (value !== undefined)
                         results.push(jQuery.toJSON(property) + ':' + value);
                 }
                 return '{' + results.join(',') + '}';
                 break;
             case 'array':
                 var results = [];
                 for (var i = 0; i < object.length; i++) {
                     var value = jQuery.toJSON(object[i]);
                     if (value !== undefined) results.push(value);
                 }
                 return '[' + results.join(',') + ']';
                 break;
         }
     }
 }); 
 var CmsUtil = {
     "init": "",
     "getBytes": function (str) {
         if (str == null) {
             return 0;
         }
         var bytes = 0;
         for (i = 0; i < str.length; i++) {
             var c = str.charCodeAt(i);
             if ((c >= 0 && c <= 255) || (c >= 0xff61 && c <= 0xff9f)) {
                 bytes += 1;
             } else {
                 bytes += 2;
             }
         }
         return bytes;
     },
     "setCookies": function (sName, sValue, oExpires, sPath, sDomain, Bsecure) {
         var sCookie = sName + "=" + encodeURIComponent(sValue);
         if (oExpires) sCookie += "; expires=" + oExpires.toGMTString();
         if (sPath) sCookie += "; path=" + sPath;
         if (sDomain) sCookie += "; domain=" + sDomain;
         if (Bsecure) sCookie += "; secure";
         document.cookie = sCookie;
     },
     "getCookies": function (sName) {
         var sRE = "(?:; )?" + sName + "=([^;]*);?";
         var oRE = new RegExp(sRE);
         if (oRE.test(document.cookie)) {
             return decodeURIComponent(RegExp["$1"]);
         }
         return null;
     }
 } 
function isNum(text) {
    return !isNaN(parseInt(text));
} 
function setClipboard(txt) {
    if (window.clipboardData) {
        window.clipboardData.setData("Text", txt);
    } else if (navigator.userAgent.indexOf("Opera") != -1) {
        window.location = txt;
    } else if (window.netscape) {
        try {
            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
        } catch (e) {
            alert("您的firefox安全限制限制您进行剪贴板操作，请打开’about:config’将signed.applets.codebase_principal_support’设置为true’之后重试");
            return false;
        }
        var clip = Components.classes['@mozilla.org/widget/clipboard;1'].createInstance(Components.interfaces.nsIClipboard);
        if (!clip)
            return;
        var trans = Components.classes['@mozilla.org/widget/transferable;1'].createInstance(Components.interfaces.nsITransferable);
        if (!trans)
            return;
        trans.addDataFlavor('text/unicode');
        var str = new Object();
        var len = new Object(); 
        var str = Components.classes["@mozilla.org/supports-string;1"].createInstance(Components.interfaces.nsISupportsString);
        var copytext = txt;
        str.data = copytext;
        trans.setTransferData("text/unicode", str, copytext.length * 2);
        var clipid = Components.interfaces.nsIClipboard;
        if (!clip)
            return false;
        clip.setData(trans, null, clipid.kGlobalClipboard);
    }
    else {
        alert("抱歉，您的浏览器暂不支持剪贴板操作！（目前仅支持IE及火狐浏览器）");
        return false;
    }
    return true;
}
function bindLetterTotal() {
    //页面加载及输入时计算textbox及textarea输入框中的字符数
    $(":text[txtAlert],textarea[txtAlert]").each(function () {
        $("#" + $(this).attr("txtAlert")).text(0.5 * CmsUtil.getBytes($(this).val()) + "字");
        $(this).keyup(function () {
            $("#" + $(this).attr("txtAlert")).text(0.5 * CmsUtil.getBytes($(this).val()) + "字");
        });
        $(this).change(function () {
            $("#" + $(this).attr("txtAlert")).text(0.5 * CmsUtil.getBytes($(this).val()) + "字");
        });
    });
    $("a[txtAlert]").each(function () {
        $("#" + $(this).attr("txtAlert")).text(0.5 * CmsUtil.getBytes($(this).text()) + "字");
    });
}
function bindTextLimit() {
    $("input[limit]").each(function () {
        $(this).keyup(function () {
            var limit = [[/\"(^\")*?\"/g, "“$1”"], [/\"/g, "“"], [/,/g, "，"], [/:/g, "："], [/\?/g, "？"], [/!/g, "！"], [/\\/g, "/"]]
            var lString = $(this).attr("limit");
            if (lString != "")
                limit = $.parseJSON(lString);
            for (i = 0; i < limit.length; i++) {
                if (limit[i][0].test($(this).val()))
                    $(this).val($(this).val().replace(limit[i][0], limit[i][1]));

            }
        });
    });
    $("textarea[limit]").each(function () {
        $(this).keyup(function () {
            var limit = [[/\"(^\")*?\"/g, "“$1”"], [/\"/g, "“"], [/,/g, "，"], [/:/g, "："], [/\?/g, "？"], [/!/g, "！"], [/[\n\r]+/g, ""]]
            var lString = $(this).attr("limit");
            if (lString != "")
                limit = $.parseJSON(lString);
            for (i = 0; i < limit.length; i++) {
                if (limit[i][0].test($(this).val()))
                    $(this).val($(this).val().replace(limit[i][0], limit[i][1]));

            }
        });
    });
}
function checkhHtml5() { if (typeof (Worker) !== "undefined") { return true; } else { return false; } }