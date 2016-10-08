/**
 * 福田汽车报名js
 * @type {{init: Function}}
 */
Signup = {
    currentShowCity : '',
    currentShowType : '',
    ctx : '',
    init : function(ctx) {
        this.ctx = ctx;
        this.initSubmit();
        this.initPCinfo();
        this.initCarTypeInfo();
    },
    // 初始化提交按钮
    initSubmit : function(){
        //点击提交按钮开始验证
        $(".btnbao").click(function(){
            var strphone = $.trim($(".phone").val());
            var strname = $(".name").val();
            var province = $("#province").val();
            var city = $("#city").val();
            var carModel = $("#carModel").val();
            var carType = Signup.getCarTypeInfo();
            var dealer = $("#dealer").val();
            var reg = /^1[3|4|5|4|7|8]\d{9}$/;
            if (strname=='') {
                $(".tipp").css("visibility","visible");
                $(".tipp").text("请填写您的姓名");
                return;
            }else if (strphone=='') {
                $(".tipp").css("visibility","visible");
                $(".tipp").text("请您填写电话号码");
            }else if (reg.test(strphone) === false) {
                $(".tipp").css("visibility","visible");
                $(".tipp").text("请您填写正确的电话号码");
                return;
            }else if (province == '' || city == ''){
                $(".tipp").css("visibility","visible");
                $(".tipp").text("请您选择省市信息");
                return;
            }else if(carModel == '' || carType == ''){
                $(".tipp").css("visibility","visible");
                $(".tipp").text("请您选择品牌车系信息");
                return;
            }else if(dealer == ''){
                $(".tipp").css("visibility","visible");
                $(".tipp").text("请您选择经销商信息");
                return;
            }else{
                $(".tipp").css("visibility;","hidden");
                $(".tipp").text("");
                $(".carload").show();
                var param={
                    uname : strname,
                    mobile : strphone,
                    province : province,
                    city : city,
                    brand : carModel,
                    carType : carType,
                    dealerId : dealer
                };
                var data = Util.ajaxPost(Signup.ctx + '/futian/saveSignup.json', param);
                if(data.result){
                    $(".carload").hide();
                    //用户报名信息保存成功跳转页面
                    window.location.href = Signup.ctx + "/location?path=futian/signSuccess";
                }else{
                    $(".carload").hide();
                    $(".tipp").css("visibility","visible");
                    $(".tipp").text(data.msg);
                }
            };
        });
    },
    // 初始化省市经销商信息
    initPCinfo : function(){
        //初始化页面信息
        var param={
            type : 'province'
        };
        var data = Util.ajaxPost(this.ctx + '/futian/getPCInfo.json', param);
        var plist = data.plist;
        for(var i = 0; i < plist.length; i++){
            $("#province").append("<option value='"+plist[i].id+"'>"+plist[i].province+"</option>");
        }
        $("#city").change(function(){
            var param={
                cityId : $("#city").val()
            };
            var data = Util.ajaxPost(Signup.ctx + '/futian/getDealer.json', param);
            var list = data.list;
            $("#dealer").html("");
            for(var i = 0; i < list.length; i++){
                $("#dealer").append("<option add='"+list[i].address+"' value='"+list[i].id+"'>"+list[i].dealerName+"</option>");
                $("#dealeradd").html("地址："+list[i].address);
            }
        });
        $("#dealer").change(function(){
            var add = $('#dealer option:selected').attr("add");
            $("#dealeradd").html("地址："+add);
        });
        $("#province").change(function(){
            var param={
                type : 'city',
                provinceId : $("#province").val()
            };
            var data = Util.ajaxPost(Signup.ctx + '/futian/getPCInfo.json', param);
            var clist = data.clist;
            $("#city").html("");
            for(var i = 0; i < clist.length; i++){
                $("#city").append("<option value='"+clist[i].id+"'>"+clist[i].city+"</option>");
            }
            $("#city").change();
        });

    },
    // 初始化车型车系信息
    initCarTypeInfo : function(){
        $("#carModel").change(function(){
            $("#carModel option").each(function(i,o){
                if($(this).attr("selected")){
                    $(".carType").hide();
                    $(".carType").eq(i).show();
                    Signup.currentShowType=i;
                }
            });
        });
        $("#carModel").change();
    },
    getCarTypeInfo : function(){
        var carType = '';
        $(".carType").each(function(i,o){
            if(i == Signup.currentShowType){
                carType = $(".carType").eq(i).val();
            }
        });
        return carType;
    }
}
