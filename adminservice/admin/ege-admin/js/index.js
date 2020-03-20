/**
 * @name:   配置扩展方法路径
 * @author: hxj
 */
layui.config({
    base: '/adminservice/admin/ege-admin/frame/static/js/'   // 模块目录
}).extend({                         // 模块别名
    vip_nav: 'vip_nav'
    , vip_tab: 'vip_tab'
    , vip_table: 'vip_table'
});

//全局接口变量
var port=":8080";
//var port="";
var prefix = "/ege/api";
var wholeUrl = window.location.protocol+"//"+window.location.host+port+prefix;
var downUrl = window.location.protocol+"//"+window.location.host;
