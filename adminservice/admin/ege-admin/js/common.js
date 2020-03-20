//判断是否登陆
// layui方法
var layer;
layui.use(['form', 'layer'], function () {
  layer = layui.layer;
  if(localStorage.getItem("token") == null){
      layer.msg('未登陆！',{time:700}, function(index){
         location.href="/egecarservice/admin/ege-admin/app/login.html";
      });
  }
});

//logout
function logout(){
  localStorage.removeItem('token');
  // $ajax({
  //   url:"",
  //   data:{},
  //   success:function(){
  //
  //   }
  // });
  layer.msg('已退出！',{time:700}, function(index){
     location.href="/egecarservice/admin/ege-admin/app/login.html"
  });
}
