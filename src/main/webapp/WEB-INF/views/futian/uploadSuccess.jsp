<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
 
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=8" />
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
 </head>

<body class="uploadbody">
    <div class="successtip">
        <div class="successdiv">
            <img src="${ctx}/static/futian/images/right.png">
            <p>上传成功</p>
        </div>
    </div>
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
</body>
</html>
