(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]);
        return null;
    };
    $.setCookie = function (c_name, value, expiredays) {
        var exdate = new Date();
        exdate.setDate(exdate.getDate() + expiredays);
        document.cookie = c_name + "=" + escape(value) +
            ((expiredays == null) ? "" : ";expires=" + exdate.toGMTString());
    };
    $.getCookie = function (c_name) {
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(c_name + "=");
            if (c_start != -1) {
                c_start = c_start + c_name.length + 1;
                c_end = document.cookie.indexOf(";", c_start);
                if (c_end == -1) c_end = document.cookie.length;
                return unescape(document.cookie.substring(c_start, c_end));
            }
        }
        return "";
    };
    $.saveVal = function (key, value) {
        window.localStorage.setItem(key, value);
        console.log($.getVal(key));
    };
    $.saveRefLocation = function (key, value) {
        window.localStorage.setItem(key, value + window.location.search);
        console.log($.getVal(key));
    };
    $.getVal = function (key) {
        return window.localStorage.getItem(key);
    }
})(jQuery);

window.isEmpty = function (param) {
  return $.isEmptyObject(param);
};

window.isNotEmpty = function (param) {
    return !$.isEmptyObject(param);
};
