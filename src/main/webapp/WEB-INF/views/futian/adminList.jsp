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
    <style>
        <!--
        .datalist{
            border:1px solid #0058a3;   /* 表格边框 */
            font-family:Arial;
            border-collapse:collapse;   /* 边框重叠 */
            background-color:#eaf5ff;   /* 表格背景色 */
            font-size:14px;
        }
        .datalist caption{
            padding-bottom:5px;
            font:bold 1.4em;
            text-align:left;
        }
        .datalist th{
            border:1px solid #0058a3;   /* 行名称边框 */
            background-color:#4bacff;   /* 行名称背景色 */
            color:#FFFFFF;              /* 行名称颜色 */
            font-weight:bold;
            padding-top:4px; padding-bottom:4px;
            padding-left:12px; padding-right:12px;
            text-align:center;
        }
        .datalist td{
            border:1px solid #0058a3;   /* 单元格边框 */
            text-align:left;
            padding-top:4px; padding-bottom:4px;
            padding-left:10px; padding-right:10px;
        }
        .datalist tr.altrow{
            background-color:#c7e5ff;   /* 隔行变色 */
        }
        -->
    </style>

</head>

<body>
    <table class="datalist">
        <caption>用户报名列表</caption>
        <tr>
            <th scope="col">用户名</td>
            <th scope="col">手机</td>
            <th scope="col">车型</td>
            <th scope="col">车系</td>
            <th scope="col">省</td>
            <th scope="col">市</td>
            <th scope="col">经销商</td>
            <th scope="col">报名时间</td>
        </tr>
        <c:forEach items="${list }" var="map" varStatus="status">
        <tr <c:if test="${(status.index + 1)%2 ==0}">class="altrow"</c:if>>
            <td>${map.uname}</td>
            <td>${map.mobile}</td>
            <td>${map.brand}</td>
            <td>${map.carType}</td>
            <td>${map.province}</td>
            <td>${map.city}</td>
            <td>${map.dealerName}</td>
            <td>${map.createTime}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>


