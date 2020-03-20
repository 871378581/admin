ionicApp.controller("testResultController", function ($scope, $rootScope, $stateParams,
                                                       $ionicScrollDelegate, $http, httpService, requestContext,
                                                       $ionicLoading) {

  var swiper;

  if (location.hash.indexOf("?") >= 0) {
    var params = getRequest2();
    if (params.orderId) {
      var detail = {'orderId': params.orderId};
      $rootScope.goState('orderDetail', {data: JSON.stringify(detail)});
    }
  }

  var stateParams = $stateParams.data;
  if (stateParams) {
    var parsedData = JSON.parse(stateParams);
    if (parsedData.orderId) {
      $scope.orderId = parsedData.orderId;
      localStorage.orderId = $scope.orderId;
      getData();
    }
  } else {
    $scope.orderId = localStorage.orderId;
    getData();
  }
  
  // 获取数据
  function getData() {
    var formData = {
      'order_id': $scope.orderId
    };
    var url = '/testItem/getTestItem';
    httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      $scope.detail = res.data;
      $scope.report_items = $scope.detail.report_items;
      switch ($scope.detail.car_level) {
        case '1':
          $scope.detail.card_level_name = '银卡会员';
          $scope.detail.car_level_name = '4缸车';
          break;
        case '2':
          $scope.detail.card_level_name = '金卡会员';
          $scope.detail.car_level_name = '6缸车';
          break;
        case '3':
          $scope.detail.card_level_name = '黑卡会员';
          $scope.detail.car_level_name = '8缸车';
          break;
        default:
          $scope.detail.card_level_name = '普通会员';
          break;
      }
    });
  }

  $scope.showItemLiveImg = false;
  $scope.toShowItemLiveImg = function (item) {
    $scope.showItemLiveImg = true;
    $scope.live_imgs = item.photos.split(',');
    swiper = new Swiper('.swiper-container', {
      autoplay: true,
      delay: 3000,
      speed: 500,
      pagination: {
        el: '.swiper-pagination',
        clickable: true
      },
      navigation: {
        nextEl: '.swiper-button-next',
        prevEl: '.swiper-button-prev'
      },
      observer: true,//修改swiper自己或子元素时，自动初始化swiper
      observeParents: true//修改swiper的父元素时，自动初始化swiper
    });
    swiper.init();
  };

  $scope.closeLiveImg = function(){
    $scope.live_imgs = [];
    $scope.showItemLiveImg = false;
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
