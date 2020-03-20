// 删除数组指定下标或指定对象
Array.prototype.remove = function (obj) {
  for (var i = 0; i < this.length; i++) {
    var temp = this[i];
    if (!isNaN(obj)) {
      temp = i;
    }
    if (temp == obj) {
      for (var j = i; j < this.length; j++) {
        this[j] = this[j + 1];
      }
      this.length = this.length - 1;
    }
  }
};

// 验证表单字段是否为空
function validateFormField(obj) {
  return !(undefined === obj || null === obj || '' === obj);
}

// 验证手机号码
function validatePhoneNum(number) {
  var reg = /^((0\d{2,3}-\d{7,8})|(1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}))$/;
  return reg.test(number);
}

// 获取路径内参数
function getRequest() {
  var url = location.search.length > 0 ? location.search.substr(1) : ''; // 获取url中"?"符后的字串
  var items = url.length > 0 ? url.split('&') : [], item = null;
  var params = new Object, key = null, value = null;
  for (i = 0; i < items.length; i++) {
    item = items[i].split('=');
    key = decodeURIComponent(item[0]);
    value = decodeURIComponent(item[1]);
    if (key.length) {
      params[key] = value;
    }
  }
  return params;
}
// 获取路径内参数(单页面)
function getRequest2() {
  var url = location.hash.substring(location.hash.indexOf("?") + 1, location.hash.length); // 获取url中"?"符后的字串
  var items = url.length > 0 ? url.split('&'):[], item = null;
  var params = new Object, key = null, value = null;
  for(i=0; i<items.length; i++){
    item = items[i].split('=');
    key = decodeURIComponent(item[0]);
    value = decodeURIComponent(item[1]);
    if(key.length){
      params[key] = value;
    }
  }
  return params;
}


// 验证图片类型
function validateImgType(obj) {
  var file = obj.files[0];
  var fileType = file.name.substr(file.name.lastIndexOf(".") + 1).toLowerCase();
  if (fileType != 'gif' && fileType != 'png' && fileType != 'jpg' && fileType != 'jpeg') {
    return false;
  }
  return true;
}

// 压缩图片大小
function compressImg(file, targrtWidth, objDiv) {
  var ready = new FileReader();
  ready.readAsDataURL(file);
  ready.onload = function () {
    var re = this.result;
    canvasDataURL(re, targrtWidth, objDiv)
  }
}

function canvasDataURL(path, obj, callback) {
  var img = new Image();
  img.src = path;
  img.onload = function () {
    var that = this;
    // 默认按比例压缩
    var w = that.width,
      h = that.height,
      scale = w / h;
    w = obj.width || w;
    h = obj.height || (w / scale);
    var quality = 0.7;  // 默认图片质量为0.7
    //生成canvas
    var canvas = document.createElement('canvas');
    var ctx = canvas.getContext('2d');
    // 创建属性节点
    var anw = document.createAttribute("width");
    anw.nodeValue = w;
    var anh = document.createAttribute("height");
    anh.nodeValue = h;
    canvas.setAttributeNode(anw);
    canvas.setAttributeNode(anh);
    ctx.drawImage(that, 0, 0, w, h);
    // 图像质量
    if (obj.quality && obj.quality <= 1 && obj.quality > 0) {
      quality = obj.quality;
    }
    // quality值越小，所绘制出的图像越模糊
    var base64 = canvas.toDataURL('image/jpeg', quality);
    // 回调函数返回base64的值
    callback(base64);
  }
}

//验证文件类型，fileType为文件类型数组如["jpeg","jpg"]
function validateFileType(fileObj, fileType) {
  if (fileObj == undefined) {
    return false;
  }
  var fileTypeReg = fileType.join("|");
  regStr = "\\w*\\.(" + fileTypeReg + ")$"
  var reg = new RegExp(regStr, "i")
  return reg.test(fileObj.name);
}

// 验证文件大小，maxSize为限定单位MB的文件大小
function validateFileSize(obj, maxSize) {
  var fileSize = obj.files[0].size;
  if (fileSize > (maxSize * 1024 * 1024)) {
    return false;
  }
  return true;
}


// 日期格式化
Date.prototype.pattern = function(fmt) {
  var o = {
    "M+" : this.getMonth()+1, //月份
    "d+" : this.getDate(), //日
    "h+" : this.getHours()%12 == 0 ? 12 : this.getHours()%12, //小时
    "H+" : this.getHours(), //小时
    "m+" : this.getMinutes(), //分
    "s+" : this.getSeconds(), //秒
    "q+" : Math.floor((this.getMonth()+3)/3), //季度
    "S" : this.getMilliseconds() //毫秒
  };
  var week = {
    "0" : "/u65e5",
    "1" : "/u4e00",
    "2" : "/u4e8c",
    "3" : "/u4e09",
    "4" : "/u56db",
    "5" : "/u4e94",
    "6" : "/u516d"
  };
  if(/(y+)/.test(fmt)){
    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
  }
  if(/(E+)/.test(fmt)){
    fmt=fmt.replace(RegExp.$1, ((RegExp.$1.length>1) ? (RegExp.$1.length>2 ? "/u661f/u671f" : "/u5468") : "")+week[this.getDay()+""]);
  }
  for(var k in o){
    if(new RegExp("("+ k +")").test(fmt)){
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
    }
  }
  return fmt;
};

// 获取月份日期天数
function getMonthDays(year, month) {
  var days = ((month<=7 && month%2===1) || (month>=8 && month%2===0)) ? 31 : 30;
  if(month===2){
    days = ((year%100!==0 && year%4===0) || (year%400===0)) ? 29 :28;
  }
  return days;
}

// 获取后几年时间
var getNextDateTime = function (num) {
  var dateArray = [];
  var currentDate = new Date();
  var currentYear = currentDate.getFullYear();
  for(var i=currentYear; i<currentYear+num; i++){
    var monthChilds = [];
    for(var j=1; j<=12; j++){
      var dayChilds = [];
      for(var k=1; k<=getMonthDays(i, j); k++){
        dayChilds.push({
          id: k,
          value:  (k>=10 ? k : '0'+k) + '日'
        })
      }
      monthChilds.push({
        id: j,
        value: (j>=10 ? j : '0'+j) + '月',
        childs:dayChilds
      })
    }
    dateArray.push({
      id: i,
      value: i + '年',
      childs: monthChilds
    })
  }
  return dateArray;
};

// 获取前几月月份
var getLastMonthTime = function (num) {
  var monthArr = [];
  var date = new Date();
  for(var i=0; i<num; i++){
    monthArr.push({
      year: date.getFullYear(),
      month: date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : ''+(date.getMonth()+1),
      text: date.getFullYear() + '年' + (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : ''+(date.getMonth()+1)) + '月'
    });
    date.setMonth(date.getMonth()-1);
  }
  return monthArr.reverse();
};


// 验证身份证号码 validateIDCard
var vcity = {
  11: "北京", 12: "天津", 13: "河北", 14: "山西", 15: "内蒙古",
  21: "辽宁", 22: "吉林", 23: "黑龙江", 31: "上海", 32: "江苏",
  33: "浙江", 34: "安徽", 35: "福建", 36: "江西", 37: "山东", 41: "河南",
  42: "湖北", 43: "湖南", 44: "广东", 45: "广西", 46: "海南", 50: "重庆",
  51: "四川", 52: "贵州", 53: "云南", 54: "西藏", 61: "陕西", 62: "甘肃",
  63: "青海", 64: "宁夏", 65: "新疆", 71: "台湾", 81: "香港", 82: "澳门", 91: "国外"
};

function validateIDCard(cardNum) {
  // 校验身份证号码规范（长度、类型）
  if (isCardNum(cardNum) === false) {
    return false;
  }
  // 校验省份（取身份证前两位）
  if (checkProvince(cardNum) === false) {
    return false;
  }
  // 校验生日
  if (checkBirthday(cardNum) === false) {
    return false;
  }
  // 校验检验位
  if (checkParity(cardNum) === false) {
    return false;
  }
  return true;
}

// 校验身份证号码规范（长度、类型）
function isCardNum(cardNum) {
  // 身份证号码为15位或者18位，15位时全为数字，18位前17位为数字，最后一位是校验位，可能为数字或字符X
  var reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
  return reg.test(cardNum);
}

// 校验省份（取身份证前两位）
function checkProvince(cardNum) {
  var province = cardNum.substr(0, 2);
  if (vcity[province] == undefined) {
    return false;
  }
  return true;
}

// 校验生日
function checkBirthday(cardNum) {
  // 身份证15位时，次序为省（3位）市（3位）年（2位）月（2位）日（2位）校验位（3位），皆为数字
  if (cardNum.length == '15') {
    var re_fifteen = /^(\d{6})(\d{2})(\d{2})(\d{2})(\d{3})$/;
    var arr_data = cardNum.match(re_fifteen);
    var year = arr_data[2];
    var month = arr_data[3];
    var day = arr_data[4];
    var birthday = new Date('19' + year + '/' + month + '/' + day);
    return verifyBirthday('19' + year, month, day, birthday);
  }
  // 身份证18位时，次序为省（3位）市（3位）年（4位）月（2位）日（2位）校验位（4位），校验位末尾可能为X
  if (cardNum.length == '18') {
    var re_eighteen = /^(\d{6})(\d{4})(\d{2})(\d{2})(\d{3})([0-9]|X)$/;
    var arr_data = cardNum.match(re_eighteen);
    var year = arr_data[2];
    var month = arr_data[3];
    var day = arr_data[4];
    var birthday = new Date(year + '/' + month + '/' + day);
    return verifyBirthday(year, month, day, birthday);
  }
  return false;
}

// 验证生日
function verifyBirthday(year, month, day, birthday) {
  var now = new Date();
  var now_year = now.getFullYear();
  // 年月日是否合理
  if (birthday.getFullYear() == year && (birthday.getMonth() + 1) == month && birthday.getDate() == day) {
    // 判断年份的范围（3岁到100岁之间)
    var time = now_year - year;
    if (time >= 0 && time <= 130) {
      return true;
    }
    return false;
  }
  return false;
}

// 校验检验位
function checkParity(cardNum) {
  // 15位转18位
  cardNum = changeFivteenToEighteen(cardNum);
  var len = cardNum.length;
  if (len == '18') {
    var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
    var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
    var cardTemp = 0, i, valnum;
    for (i = 0; i < 17; i++) {
      cardTemp += cardNum.substr(i, 1) * arrInt[i];
    }
    valnum = arrCh[cardTemp % 11];
    if (valnum == cardNum.substr(17, 1)) {
      return true;
    }
    return false;
  }
  return false;
}

// 15位转18位身份证号
function changeFivteenToEighteen(cardNum) {
  if (cardNum.length == '15') {
    var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
    var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
    var cardTemp = 0, i;
    cardNum = cardNum.substr(0, 6) + '19' + cardNum.substr(6, cardNum.length - 6);
    for (i = 0; i < 17; i++) {
      cardTemp += cardNum.substr(i, 1) * arrInt[i];
    }
    cardNum += arrCh[cardTemp % 11];
    return cardNum;
  }
  return cardNum;
}

// 获取身份证年龄 getAgeByCardNum
function getAgeByCardNum(cardNum) {
  if (cardNum.length == 15) {
    cardNum = changeFivteenToEighteen(cardNum);
  }
  strBirthday = cardNum.substr(6, 4) + "/" + cardNum.substr(10, 2) + "/" + cardNum.substr(12, 2);
  var birthDate = new Date(strBirthday);
  var nowDateTime = new Date();
  var age = nowDateTime.getFullYear() - birthDate.getFullYear();
  //再考虑月、天的因素;.getMonth()获取的是从0开始的，这里进行比较，不需要加1
  if (nowDateTime.getMonth() < birthDate.getMonth() || (nowDateTime.getMonth() == birthDate.getMonth() && nowDateTime.getDate() < birthDate.getDate())) {
    age--;
  }
  return age;
}

// 获取身份证性别 getSexByCardNum
function getSexByCardNum(cardNum) {
  if (cardNum.length == 15) {
    cardNum = changeFivteenToEighteen(cardNum);
  }
  if (parseInt(cardNum.substr(16, 1)) % 2 == 1) {
    return "男";
  } else {
    return "女";
  }
}
