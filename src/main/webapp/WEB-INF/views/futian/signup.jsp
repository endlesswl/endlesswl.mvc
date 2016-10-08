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
    <script type="text/javascript" src="${ctx}/static/futian/js/signup.js"></script>
    <script type="text/javascript">
        $(function () {
            Signup.init('${ctx}');
        });
    </script>
</head>

<body class="signbody">
<div class="imggai"><img src="${ctx}/static/futian/images/fuimg.png"></div>
<form class="formlist">
    <p><input class="name" type="text" autocomplete="off" placeholder="姓名"/></p>

    <p><input class="phone" maxlength="11" type="text" autocomplete="off" placeholder="电话"/></p>

    <div class="clearfix selectshot">
        <select id="province">
            <option style="display: none;" value="">省</option>
        </select>
        <select id="city">
            <option style="display: none;" value="">市</option>
        </select>
    </div>
    <select id="carModel">
        <option value="" style="display: none;">意向品牌</option>
        <option>伽途</option>
        <option>欧曼</option>
        <option>欧马可</option>
        <option>福田金刚</option>
        <option>福田骁运</option>
        <option>福田风景</option>
        <option>萨普</option>
        <option>萨瓦纳</option>
        <option>图雅诺</option>
        <option>时代</option>
        <option>瑞沃</option>
        <option>奥铃</option>
        <option>拓陆者</option>
        <option>迷迪</option>
        <option>蒙派克</option>
    </select>
    <select class="carType">
        <option value="">意向车系</option>
    </select>
    <select class="carType">
        <option>伽途ix5</option>
        <option>伽途ix7</option>
        <option>伽途T3S</option>
        <option>伽途T3</option>
        <option>伽途V3</option>
        <option>伽途V5</option>
    </select>
    <select class="carType">
        <option>欧曼TX</option>
        <option>欧曼GTL</option>
        <option>欧曼VT</option>
        <option>欧曼EST</option>
    </select>
    <select class="carType">
        <option>欧马可1系</option>
        <option>欧马可3系</option>
        <option>欧马可5系</option>
    </select>
    <select class="carType">
        <option>福田金刚L</option>
        <option>福田金刚T</option>
    </select>
    <select class="carType">
        <option>福田骁运L</option>
        <option>福田骁运T</option>
    </select>
    <select class="carType">
        <option>福田风景快运</option>
        <option>福田风景G7</option>
        <option>福田风景G9</option>
    </select>
    <select class="carType">
        <option>萨普Z</option>
        <option>萨普V</option>
        <option>萨普T</option>
    </select>
    <select class="carType">
        <option>萨瓦纳VX3</option>
    </select>
    <select class="carType">
        <option>图雅诺S</option>
        <option>图雅诺E</option>
    </select>
    <select class="carType">
        <option>时代领航</option>
        <option>时代康瑞K</option>
        <option>时代康瑞H</option>
        <option>时代祥龙</option>
        <option>时代小卡之星</option>
        <option>时代驭菱（汽油）</option>
        <option>时代驭菱（柴油）</option>
        <option>时代骁运</option>
        <option>时代骁运L</option>
        <option>时代骁运H</option>
        <option>时代金刚</option>
        <option>时代金刚L</option>
        <option>时代金刚H</option>
        <option>时代威龙</option>
    </select>
    <select class="carType">
        <option>中卡</option>
        <option>中型</option>
        <option>重型</option>
    </select>
    <select class="carType">
        <option>奥铃捷运</option>
        <option>奥铃CTX</option>
        <option>奥铃TX</option>
    </select>
    <select class="carType">
        <option>拓陆者S</option>
        <option>拓陆者E5</option>
        <option>拓陆者E3</option>
    </select>
    <select class="carType">
        <option>迷迪C</option>
    </select>
    <select class="carType">
        <option>蒙派克S级</option>
        <option>蒙派克E</option>
    </select>
    <select id="dealer">
        <option value="">选择经销商</option>
    </select>
    <p id="dealeradd" class="textp"></p>
    <p class="textp">此活动唯一解释权归福田汽车所有</p>

    <p class="tipp" style="visibility:hidden;">请您填写正确的电话号码</p>
    <input type="button" class="surebtn btnbao" value="确认提交"/>

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
        <li class="blueli">
            <a href="${ctx}/futian/signup.html">
                <div><img src="${ctx}/static/futian/images/whitebao.png"></div>
                <p>我要报名</p>
            </a>
        </li>
        <li>
            <a href="${ctx}/futian/upload.html">
                <div><img src="${ctx}/static/futian/images/greychuan.png"></div>
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


