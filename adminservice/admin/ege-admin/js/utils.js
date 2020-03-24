function Format(date,fmt) {
    if (date == null || date == '' || date == 'undefined') {
        return '';
    }
    date = date + '';
    date = date.replace(/\-/g, "/");
    if (date.indexOf('GMT') == -1) {
        date = date.replace(/\T/g, " ");
    }
    if (date.indexOf('.') != -1) {
        date = date.substr(0, date.indexOf('.'));
    }
    date = new Date(date);
    fmt = fmt || "yyyy-MM-dd hh:mm:ss";
    var o = {
        "M+": date.getMonth() + 1, //月份
        "d+": date.getDate(), //日
        "h+": date.getHours(), //小时
        "m+": date.getMinutes(), //分
        "s+": date.getSeconds(), //秒
        "q+": Math.floor((date.getMonth() + 3) / 3), //季度
        "S": date.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function CheckPassWord(password) {//密码必须包含数字和字母
    var str = password;
    var reg = new RegExp(/^(?![^a-zA-Z]+$)(?!\D+$)/);
    if (reg.test(str))
        return true;
}

function getIcon(id){
    var map = new Map()
    map.set("1","&#xe68f;");
    map.set("2","&#xe68c;");
    map.set("3","&#xe748;");
    map.set("4","&#xe68d;");
    map.set("5","&#xe627;");
    map.set("6","&#xe626;");
    map.set("7","&#xe66d;");
    map.set("8","&#xe6c9;");
    map.set("9","&#xe67a;");
    map.set("10","&#xe66f;");
    map.set("11","&#xe68e;");
    map.set("12","&#xe66e;");
    map.set("13","&#xe702;");
    map.set("14","&#xe66c;");
    map.set("15","&#xe716;");
    map.set("16","&#xe665;");
    map.set("17","&#xe653;");
    map.set("18","&#xe65f;");
    map.set("19","&#xe671;");
    map.set("20","&#xe715;");
    map.set("21","&#xe705;");
    map.set("22","&#xe857;");
    map.set("23","&#xe770;");
    map.set("24","&#xe670;");
    map.set("25","&#xe631;");
    map.set("26","&#xe623;");
    map.set("27","&#xe620;");
    map.set("28","&#xe614;");
    map.set("29","&#xe658;");
    map.set("30","&#xe606;");
    return map.get(id);
}
