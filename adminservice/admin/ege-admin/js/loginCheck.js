function init(){
    setInterval(function(){
        var valid = new Date().getTime();
        var timeOut = localStorage.getItem("timeOut");
        if(timeOut!=null && valid >= timeOut){
            localStorage.removeItem("token");
            console.log("登录失效！");
            var layer;
            layui.use(['form', 'layer'], function () {
                layer = layui.layer;
                if(localStorage.getItem("token") == null){
                    layer.msg('登录失效！',{time:1000}, function(index){
                        localStorage.removeItem("token");
                        localStorage.removeItem("account");
                        localStorage.removeItem("timeOut");
                        location.href="/adminservice/admin/ege-admin/app/login.html";
                    });
                }
            });
        }else{
            var $ = layui.jquery;
            $.ajax({
                url:wholeUrl+"/admin/login/loginCheck?token="+localStorage.getItem("token"),
                method:"post",
                contentType: "application/x-www-form-urlencoded",
                dataType:"json",
                async:false,
                data:{
                },
                success:function(result){
                    console.log(result);
                    if(result.success){
                        //
                    }else{
                        layui.use(['layer'], function () {
                            layer = layui.layer;
                            layer.msg(result.errorMsg,{time:1000}, function(index){
                                localStorage.removeItem("token");
                                localStorage.removeItem("account");
                                localStorage.removeItem("timeOut");
                                location.href="/adminservice/admin/ege-admin/app/login.html";
                            });
                        });
                    }
                }
            });

        }
        console.log("loginCheck current time:"+valid);
    },5*1000);
}

window.onload = function(){
    init();
}