ionicApp.config(function ($stateProvider, $urlRouterProvider, $ocLazyLoadProvider, $provide, $compileProvider,
                          $controllerProvider, $filterProvider, $ionicConfigProvider) {

  // 登录验证
  function exec() {
    COOKIE = $.getCookie(COOKIE_NAME);
    if ($.isEmptyObject(COOKIE)) {
      //alert("not login. redirect to wechat auth.");
      var state = "abc";
      // $.saveRefLocation(state, "/adminservice/h5/merchant/index.html");
      $.saveRefLocation(state, location.pathname + window.location.hash);
      location.href = "/ege/api/wechat/browser/auth?state=" + state;
    } else {
      //alert("login success. with token:" + cookie);
    }
  }

  exec();

  ionicApp.controller = $controllerProvider.register;
  ionicApp.directive = $compileProvider.directive;
  ionicApp.filter = $filterProvider.register;
  ionicApp.factory = $provide.factory;
  ionicApp.service = $provide.service;
  ionicApp.constant = $provide.constant;

  $ocLazyLoadProvider.config({
    debug: false,
    modules: []
  });

  $ionicConfigProvider.tabs.position('bottom');

  $stateProvider
    .state('tab', {
      url: '/tab',
      templateUrl: 'templates/merchant/tabs.html'
    })
    // 首页
    .state('tab.homepage', {
      url: '/homepage',
      views: {
        'tab-homepage': {
          templateUrl: 'templates/merchant/homepage/homepage.html',
          controller: 'homepageController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/homepage2.css',
            'js/merchant/homepage/homepage.js'
          ])
        }]
      }
    })
    // 扫一扫
    .state('tab.scan', {
      url: '/scan',
      views: {
        'tab-scan': {
          templateUrl: 'templates/merchant/scan/scan.html',
          controller: 'scanController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'js/merchant/scan/scan.js'
          ])
        }]
      }
    })
    .state('startService', {
      url: '/startService',
      templateUrl: 'templates/merchant/scan/startService.html',
      controller: 'startServiceController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/scan2.css',
            'js/merchant/scan/startService.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    // 服务中心
    .state('tab.order', {
      url: '/order',
      views: {
        'tab-order': {
          templateUrl: 'templates/merchant/order/order.html',
          controller: 'orderController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/order2.css',
            'js/merchant/order/order.js'
          ])
        }]
      },
      params: {data: null}
    })
    .state('enterTestReport', {
      url: '/enterTestReport',
      templateUrl: 'templates/merchant/order/enterTestReport.html',
      controller: 'enterTestReportController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/order2.css',
            'js/merchant/order/enterTestReport.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('enterChargingItem', {
      url: '/enterChargingItem',
      templateUrl: 'templates/merchant/order/enterChargingItem.html',
      controller: 'enterChargingItemController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/order2.css',
            'js/merchant/order/enterChargingItem.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    // 我的
    .state('tab.mine', {
      url: '/mine',
      views: {
        'tab-mine': {
          templateUrl: 'templates/merchant/mine/mine.html',
          controller: 'mineController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/mine2.css',
            'js/merchant/mine/mine.js'
          ])
        }]
      }
    })
    .state('informationSetting', {
      url: '/informationSetting',
      templateUrl: 'templates/merchant/mine/informationSetting.html',
      controller: 'informationSettingController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/mine2.css',
            'js/merchant/mine/informationSetting.js'
          ])
        }]
      },
      cache: false
    })
    .state('passwordSetting', {
      url: '/passwordSetting',
      templateUrl: 'templates/merchant/mine/passwordSetting.html',
      controller: 'passwordSettingController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/mine2.css',
            'js/merchant/mine/passwordSetting.js'
          ])
        }]
      },
      cache: false
    })
    // 登录
    .state('login', {
      url: '/login',
      templateUrl: 'templates/merchant/login.html',
      controller: 'loginController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/merchant/login2.css',
            'js/merchant/login.js'
          ])
        }]
      }
    });

  // 设置默认跳转
  $urlRouterProvider.otherwise('/login');

  // 全局禁用缓存
  $ionicConfigProvider.views.maxCache(0);

  // 禁止右划返回
  $ionicConfigProvider.views.swipeBackEnabled(false);

  // 关闭动画效果
  $ionicConfigProvider.views.transition('none');

});
