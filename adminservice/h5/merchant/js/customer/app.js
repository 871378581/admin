ROOT_URL = 'http://www.jinlingongyi.cn/ege/api';
COOKIE = '';
COOKIE_NAME = '_999_user_token';

var setLocation;

// 获取用户经纬度
function getLocation() {
  wx.getLocation({
    type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
    success: function (res) {
      firstSetupWx = false;
      localStorage.LATITUDE = res.latitude; // 纬度，浮点数，范围为90 ~ -90
      localStorage.LONGITUDE = res.longitude; // 经度，浮点数，范围为180 ~ -180
      geocoder();
    },
    fail: function (res) {
      console.log('wgs84fail',res);
      setTimeout("getLocation()", 5000);
    }
  });
}

// 经纬度逆解析地址
function geocoder() {
  $.ajax({
    type: 'get',
    url: 'http://apis.map.qq.com/ws/geocoder/v1',
    dataType: 'jsonp',
    data: {
      // key: "IJCBZ-3WZKX-MUY4T-7UB4S-TIVB2-CRB3W",
      key: "HJMBZ-U6FW5-IPNIR-QF375-WYXPQ-X3FLZ",
      location: localStorage.LATITUDE + "," + localStorage.LONGITUDE,
      get_poi: "1",//是否返回周边POI列表：1.返回；0不返回(默认)
      coord_type: "1",//输入的locations的坐标类型,1 GPS坐标
      parameter: {"scene_type": "tohome", "poi_num": 20},//附加控制功能
      output: "jsonp"
    },
    success: function (data, textStatus) {
      if (data.status === 0) {
        localStorage.LOCATION = JSON.stringify(data.result);
        setLocation();
      } else {
        console.log('逆地址解析失败');
        setTimeout("geocoder()", 5000);
      }
    },
    error: function () {
      console.log('逆地址解析失败');
      setTimeout("geocoder()", 5000);
    }
  });
}

var ionicApp = angular.module('ionicApp', [
  'ionic',
  'ui.router',
  'oc.lazyLoad'
]);

ionicApp.controller('appCtrl', function ($scope, $rootScope, $state, $stateParams, httpService, $ionicLoading,
                                         $interval, $timeout) {

  // 初始化分享按钮
  var shareData = {
    wxData: {
      title: 'EGE数联·生态', //分享给朋友显示的标题
      imgUrl: '', //活动详情的活动介绍图片
      link: window.location.href,
      desc: '' //分享到朋友圈显示的话，这里就是活动的标题
    }
  };
  window.wxShareSetup(shareData);

  // 定位
  var timer;
  $rootScope.position = {};
  $rootScope.getLocation = function () {
    getLocation();
  };
  // 设置地址
  setLocation = function () {
    if (localStorage.LOCATION) {
      var LOCATION = JSON.parse(localStorage.LOCATION);
      $rootScope.position = {
        'lat': LOCATION.location.lat,
        'lng': LOCATION.location.lng,
        'nation': LOCATION.address_component.nation, // 国家
        'province': LOCATION.address_component.province, // 省
        'city': LOCATION.address_component.city, // 市
        'district': LOCATION.address_component.district // 区
      };
      // $rootScope.showAreaName = LOCATION.address_component.district;
      $rootScope.showAreaName =  $rootScope.position.district ? $rootScope.position.district : $rootScope.position.city;
      $scope.$apply();
    }
    /*if(timer){
      $interval.cancel(timer);
    }
    timer = $interval(function () { // 每隔10s重新获取定位
      console.log('try to getLocation');
      getLocation();
    }, 10000);*/
  };

  // rem宽度
  $rootScope.remWidth = document.documentElement.clientWidth / 10;

  // data转指定请求数据格式
  $rootScope.getParamsData = function (data, token) {
    data.user_id = COOKIE;
    return data
  };
  $rootScope.getStringifyData = function (data, token) {
    data.user_id = COOKIE;
    return JSON.stringify(data);
  };

  // 省、市、区对象数组
  var getDsy = function () {
    $rootScope.dsy = [];
    var myDsy = new Dsy();
    var provinces = myDsy.provinces();
    for (var i = 0; i < provinces.length; i++) {
      var province = provinces[i];
      var provinceChilds = [];
      for (var j = 0; j < myDsy.city(province).length; j++) {
        var city = myDsy.city(province)[j];
        var cityChilds = [];
        for (var k = 0; k < myDsy.district(province, city).length; k++) {
          var district = myDsy.district(province, city)[k];
          cityChilds.push({
            value: district
          });
        }
        provinceChilds.push({
          value: city,
          childs: cityChilds
        })
      }
      $rootScope.dsy.push({
        value: province,
        childs: provinceChilds
      })
    }
  };
  getDsy();

  // 获取微信用户信息
  $rootScope.getUserInfo = function () {
    var url = '/user/getUserInfo';
    var params = {};
    httpService.getRequest(url, $rootScope.getParamsData(params)).then(function (res) {
      $rootScope.userInfo = res.data;
      if ($rootScope.userInfo) {
        switch ($rootScope.userInfo.card_level) {
          case '1':
            $rootScope.userInfo.card_level_name = '银卡会员';
            $rootScope.userInfo.car_level_name = '4缸车';
            break;
          case '2':
            $rootScope.userInfo.card_level_name = '金卡会员';
            $rootScope.userInfo.car_level_name = '6缸车';
            break;
          case '3':
            $rootScope.userInfo.card_level_name = '黑卡会员';
            $rootScope.userInfo.car_level_name = '8缸车';
            break;
          default:
            $rootScope.userInfo.card_level_name = '普通会员';
            break;
        }
        if ($rootScope.userInfo.carListDTO && $rootScope.userInfo.carListDTO.cars.length > 0) {
          var cars = $rootScope.userInfo.carListDTO.cars;
          for (var i = 0; i < cars.length; i++) {
            if (cars[i].is_default) {
              $rootScope.defaultCar = cars[i];
              switch (cars[i].car_status) {
                case '0':
                  $rootScope.defaultCarStatus = '未激活';
                  break;
                case '1':
                  $rootScope.defaultCarStatus = '使用中';
                  break;
                case '2':
                  $rootScope.defaultCarStatus = '已过期';
                  break;
              }
            }
          }
        }
      }
    });
  };
  $rootScope.getUserInfo();

  if (location.hash.indexOf("?") >= 0) {
    var params = getRequest2();
    if (params.storeId) {
      var detail = {'id': params.storeId};
      $rootScope.goState('storeDetail', {data: JSON.stringify(detail)});
    }
  }

  // 重设输入失去焦点事件
  $rootScope.reSetOnBlurEvent = function () {
    $timeout(function () {
      $("input, textarea").focus(function(){}).blur(function(){
        // 滚动到顶部
        window.scroll(0, 0);
        // 滚动到底部
        window.scrollTo(0, document.documentElement.clientHeight);
      });

      $("select").focus(function(){}).blur(function(){
        // 滚动到顶部
        window.scroll(0, 0);
        // 滚动到底部
        window.scrollTo(0, document.documentElement.clientHeight);
      });
    }, 5000);
  }

});

ionicApp.run(function ($rootScope, $ionicPlatform, $ionicHistory, $ionicViewSwitcher, $state, $ionicLoading) {

  // 页面回退
  $rootScope.back = function () {
    $rootScope.getUserInfo();
    window.history.back();
  };

  // 页面跳转
  $rootScope.goState = function (state, param) {
    $rootScope.getUserInfo();
    $state.go(state, param);
    $ionicViewSwitcher.nextDirection("forward");
  };

  $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
    var historyState = localStorage.historyState ? localStorage.historyState : '';
    if(historyState.indexOf(toState.url)<0){
      $ionicLoading.show({
        template: '加载中...'
      });
      localStorage.historyState = historyState + toState.url;
    }

    $('.mobileSelect').css({
      display: 'none',
      opacity: 0
    });

    // $rootScope.reSetOnBlurEvent();
  });

});

ionicApp.directive('hideTabs', function ($rootScope) {
  return {
    restrict: 'A',
    link: function (scope, element, attributes) {
      scope.$on('$ionicView.beforeEnter', function () {
        scope.$watch(attributes.hideTabs, function (value) {
          $rootScope.hideTabs = value;
        });
      });
      scope.$on('$ionicView.beforeLeave', function () {
        $rootScope.hideTabs = false;
      });
    }
  };
});

ionicApp.constant('requestContext', ROOT_URL);
