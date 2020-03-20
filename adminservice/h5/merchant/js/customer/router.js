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
      templateUrl: 'templates/customer/tabs.html'
    })
    // 首页
    .state('tab.homepage', {
      url: '/homepage',
      views: {
        'tab-homepage': {
          templateUrl: 'templates/customer/homepage/homepage.html',
          controller: 'homepageController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/homepage2.css',
            'js/customer/homepage/homepage.js'
          ])
        }]
      }
    })
    .state('searchPage', {
      url: '/searchPage',
      templateUrl: 'templates/customer/homepage/searchPage.html',
      controller: 'searchPageController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/homepage2.css',
            'js/customer/homepage/searchPage.js'
          ])
        }]
      }
    })
    .state('searchCity', {
      url: '/searchCity',
      templateUrl: 'templates/customer/homepage/searchCity.html',
      controller: 'searchCityController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/homepage2.css',
            'js/customer/homepage/searchCity.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    // 门店
    .state('tab.store', {
      url: '/store',
      views: {
        'tab-store': {
          templateUrl: 'templates/customer/store/store.html',
          controller: 'storeController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/store2.css',
            'js/customer/store/store.js'
          ])
        }]
      },
      params: {data: null}
    })
    .state('storeDetail', {
      url: '/storeDetail',
      templateUrl: 'templates/customer/store/storeDetail.html',
      controller: 'storeDetailController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/store2.css',
            'js/customer/store/storeDetail.js'
          ])
        }]
      },
      params: {data: null}
    })
    .state('storeAppointment', {
      url: '/storeAppointment',
      templateUrl: 'templates/customer/store/storeAppointment.html',
      controller: 'storeAppointmentController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/store2.css',
            'js/customer/store/storeAppointment.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('appointmentResult', {
      url: '/appointmentResult',
      templateUrl: 'templates/customer/store/appointmentResult.html',
      controller: 'appointmentResultController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/store2.css',
            'js/customer/store/appointmentResult.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    // 订单
    .state('tab.order', {
      url: '/order',
      views: {
        'tab-order': {
          templateUrl: 'templates/customer/order/order.html',
          controller: 'orderController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/order2.css',
            'js/customer/order/order.js'
          ])
        }]
      },
      cache: false
    })
    .state('orderDetail', {
      url: '/orderDetail',
      templateUrl: 'templates/customer/order/orderDetail.html',
      controller: 'orderDetailController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/order2.css',
            'js/customer/order/orderDetail.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('orderEvaluate', {
      url: '/orderEvaluate',
      templateUrl: 'templates/customer/order/orderEvaluate.html',
      controller: 'orderEvaluateController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/order2.css',
            'js/customer/order/orderEvaluate.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('orderPayment', {
      url: '/orderPayment',
      templateUrl: 'templates/customer/order/orderPayment.html',
      controller: 'orderPaymentController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/order2.css',
            'js/customer/order/orderPayment.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('testResult', {
      url: '/testResult',
      templateUrl: 'templates/customer/order/testResult.html',
      controller: 'testResultController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/order2.css',
            'js/customer/order/testResult.js'
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
          templateUrl: 'templates/customer/mine/mine.html',
          controller: 'mineController'
        }
      },
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/mine.js'
          ])
        }]
      }
    })
    .state('carList', {
      url: '/carList',
      templateUrl: 'templates/customer/mine/car/carList.html',
      controller: 'carListController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/car/carList.js'
          ])
        }]
      },
      cache: false
    })
    .state('bindingCard', {
      url: '/bindingCard',
      templateUrl: 'templates/customer/mine/bindingCard.html',
      controller: 'bindingCardController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/bindingCard.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('carAdd', {
      url: '/carAdd',
      templateUrl: 'templates/customer/mine/car/carAdd.html',
      controller: 'carAddController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/car/carAdd.js'
          ])
        }]
      },
      params: {data: null},
      cache: false
    })
    .state('informationSetting', {
      url: '/informationSetting',
      templateUrl: 'templates/customer/mine/informationSetting.html',
      controller: 'informationSettingController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/informationSetting.js'
          ])
        }]
      },
      cache: false
    })
    .state('membershipInterest', {
      url: '/membershipInterest',
      templateUrl: 'templates/customer/mine/membershipInterest.html',
      controller: 'membershipInterestController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/membershipInterest.js'
          ])
        }]
      }
    })
    .state('collection', {
      url: '/collection',
      templateUrl: 'templates/customer/mine/collectionList.html',
      controller: 'collectionController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/collectionList.js'
          ])
        }]
      }
    })
    .state('contactUs', {
      url: '/contactUs',
      templateUrl: 'templates/customer/mine/contactUs.html',
      controller: 'contactUsController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/contactUs.js'
          ])
        }]
      },
      cache: false
    })
    .state('businessCooperation', {
      url: '/businessCooperation',
      templateUrl: 'templates/customer/mine/businessCooperation.html',
      controller: 'businessCooperationController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/businessCooperation.js'
          ])
        }]
      },
      cache: false
    })
    .state('bindingPhone', {
      url: '/bindingPhone',
      templateUrl: 'templates/customer/mine/bindingPhone.html',
      controller: 'bindingPhoneController',
      resolve: {
        deps: ['$ocLazyLoad', function ($ocLazyLoad) {
          return $ocLazyLoad.load([
            'css/customer/mine2.css',
            'js/customer/mine/bindingPhone.js'
          ])
        }]
      },
      cache: false
    });

  // 设置默认跳转
  $urlRouterProvider.otherwise('/tab/homepage');

  // 全局禁用缓存
  $ionicConfigProvider.views.maxCache(10);

  // 禁止右划返回
  $ionicConfigProvider.views.swipeBackEnabled(false);

  // 关闭动画效果
  $ionicConfigProvider.views.transition('none');

});
