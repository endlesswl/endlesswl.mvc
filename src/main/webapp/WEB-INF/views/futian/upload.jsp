<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=8"/>
    <title>福田汽车新媒体购车专享福利</title>
    <meta name="title" content="福田汽车新媒体购车专享福利">
    <meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1,minimum-scale=1,maximum-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <meta name="format-detection" content="telephone=no">
    <meta name="apple-mobile-web-app-title" content="福田汽车新媒体购车专享福利">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <link rel="stylesheet" type="text/css" href="${ctx}/static/futian/css/style.css"/>

    <link href="${ctx}/static/futian/css/extra.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${ctx}/static/futian/js/jquery-1.5.2.min.js"></script>
    <script src='${ctx}/static/common/util.js'></script>
    <script src="${ctx}/static/common/ajaxfileupload.js"></script>
    <script>
        function uploadImg(fileId, ImgId) {
            $(".carload").show();
            $.ajaxFileUpload({
                url: '${ctx}/fileupload/uploadRu',
                type: 'post',
                secureuri: false, // 一般设置为false
                fileElementId: fileId, // 上传文件的id、name属性名
                dataType: 'text',
                success: function (data, status) {
                    var obj = eval("(" + data + ")");
                    if (!obj.success) {
                        $(".carload").hide();
                        Util.showErrorMessage(obj.msg);
                    } else {
                        $(".carload").hide();
                        $("#" + ImgId).val(obj.msg);
                        $(".content2").find("img").first().attr("src", obj.msg);
                    }
                },
                error: function (data, status, e) {
                    Util.showErrorMessage("上传失败");
                }
            });
        }
        function saveUserImg() {
            var img = $("#avatar").val();
            if (img == '') {
                $(".tipp").text('请上传图片！');
                return;
            } else {
                $(".tipp").text('');
                $(".carload").show();
            }
            //初始化页面信息
            var param = {
                img: img
            };
            var data = Util.ajaxPost('${ctx}/futian/saveUserImg.json', param);
            if (data.result) {
                $(".carload").hide();
                window.location.href = '${ctx}/location?path=futian/uploadSuccess';
            } else {
                $(".carload").hide();
                $(".tipp").text(data.msg);
            }
        }
    </script>
</head>

<body class="uploadbody">
<form class="loadcontent">
    <div class="content1">
        <img id="showImg" src="${ctx}/static/futian/images/hand.png">
        上传示例
    </div>
    <div class="content2"><img src="${ctx}/static/futian/images/piao.jpg"></div>
    <div class="content3">
        <span></span>
        <input id="file" type="file" name='file' onchange="uploadImg('file','avatar')">

    </div>

    <p class="tipp"></p>
    <input type="hidden" value="" id="avatar"/>
    <input type="button" onclick="saveUserImg()" class="surebtn" value="确认上传"/>
</form>
<div class="footer">
    <ul class="clearfix">
<c:choose>
    <c:when test="${v == '1'}">
            <li>
                <a href="${ctx}/futian/ftindex.html">
                    <div><img src="${ctx}/static/futian/images/greyshuo.png"></div>
                    <p>活动说明</p>
                </a>
            </li>
    </c:when>
    <c:otherwise>
            <style>
                .footer ul li{
                    width: 50%;
                }
            </style>
    </c:otherwise>
</c:choose>
        <li>
            <a href="${ctx}/futian/signup.html">
                <div><img src="${ctx}/static/futian/images/greybao.png"></div>
                <p>我要报名</p>
            </a>
        </li>
        <li class="blueli">
            <a href="${ctx}/futian/upload.html">
                <div><img src="${ctx}/static/futian/images/whitechuan.png"></div>
                <p>上传发票</p>
            </a>
        </li>
    </ul>
</div>
<div class="popupceng carload"></div>
<div class="popupcont carload">
    <p>加 载 中 ...</p>
    <div class="popcenter"><img src="${ctx}/static/futian/images/load.gif"></div>
</div>
</body>
</html>

