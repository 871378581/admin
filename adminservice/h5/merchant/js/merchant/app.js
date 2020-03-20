ROOT_URL = 'http://www.jinlingongyi.cn/ege/api';
COOKIE = '';
COOKIE_NAME = '_999_user_token';
COOKIE_NAME_USERNAME = '_999_username_token';
COOKIE_NAME_PASSWORD = '_999_password_token';

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

  // data转指定请求数据格式
  $rootScope.getParamsData = function (data, token) {
    return data
  };
  $rootScope.getStringifyData = function (data, token) {
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

  // 自动登录验证
  $scope.doLogin = function () {
    var formData = {
      'account': $.getCookie(COOKIE_NAME_USERNAME),
      'password': $.getCookie(COOKIE_NAME_PASSWORD)
    };
    var url = '/user/shopUserLogin';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $.setCookie(COOKIE_NAME_USERNAME, formData.account, 31);
        $.setCookie(COOKIE_NAME_PASSWORD, formData.password, 31);
        $.setCookie('LOGINED', true, 31);
        var data = res.data;
        $rootScope.shop_id = data.shop_id;
        $rootScope.shop_user_id = data.shop_user_id;
        $rootScope.userInfo = {
          'user_head': data.user_head,
          'user_name': data.shop_user_name,
          'sex': data.sex,
          'place_city': data.place_city,
          'job': data.job,
          'birth': data.birth
        };
      } else {
        $.setCookie(COOKIE_NAME_USERNAME, '');
        $.setCookie(COOKIE_NAME_PASSWORD, '');
        $.setCookie('LOGINED', false);
      }
    });
  };
  if (validateFormField($.getCookie(COOKIE_NAME_USERNAME)) && validateFormField($.getCookie(COOKIE_NAME_PASSWORD))) {
    $scope.doLogin();
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
    window.history.back();
  };

  // 页面跳转
  $rootScope.goState = function (state, param) {
    $state.go(state, param);
    $ionicViewSwitcher.nextDirection("forward");
  };

  $rootScope.$on('$stateChangeStart', function (event, toState, toParams, fromState, fromParams) {
    var historyState = localStorage.historyState ? localStorage.historyState : '';
    /*if(historyState.indexOf(toState.url)<0 && toState.url !== '/scan'){
      $ionicLoading.show({
        template: '加载中...'
      });
      localStorage.historyState = historyState + toState.url;
    }*/

    if (toState.url !== '/login' && $.getCookie('LOGINED') !== 'true') {
      event.preventDefault();//该方法是阻止页面进入先进行下面的判断
      $state.go('login');
    }

    $('.mobileSelect').css({
      display: 'none',
      opacity: 0
    });

    // $rootScope.reSetOnBlurEvent();
  })

});

ionicApp.directive('hideTabs', function ($rootScope) {
  return {
    restrict: 'A',
    link: function (scope, element, attributes) {
      scope.$on('$ionicView.beforeEnter', function () {
        scope.$watch(attributes.hideTabs, function (value) {
          $rootScope.hideTabs = value;
        });
        /*$ionicLoading.show({
          template: '加载中...'
        });*/
      });
      scope.$on('$ionicView.beforeLeave', function () {
        $rootScope.hideTabs = false;
      });
    }
  };
});

ionicApp.constant('requestContext', ROOT_URL);
