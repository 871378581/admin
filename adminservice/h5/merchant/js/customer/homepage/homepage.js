ionicApp.controller("homepageController", function ($scope, $rootScope, $stateParams,
                                                    $ionicScrollDelegate, $http, httpService, requestContext,
                                                    $ionicLoading, $ionicPopup, $timeout) {

  if(!$rootScope.position.lng || !$rootScope.position.lat){
    if(localStorage.LOCATION){
      var LOCATION = JSON.parse(localStorage.LOCATION);
      $rootScope.position.lng = LOCATION.location.lng;
      $rootScope.position.lat = LOCATION.location.lat;
    }
  }

  $scope.formData = {
    'currentPage': 1,
    'showCount': 10,
    'longitude': $rootScope.position.lng ? $rootScope.position.lng : '',
    'latitude': $rootScope.position.lat ? $rootScope.position.lat : ''
  };
  $scope.list = [];
  $scope.stars = "12345";
  var swiper;

  // 获取banner数据
  $scope.getBannerData = function () {
    var url = '/header/getBannerList';
    httpService.getRequest(url, {}).then(function (res) {
      if (res.success) {
        $scope.bannerList = res.data.banners;
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
      } else {
        // alert(res.errorMessage);
      }
    });
  };
  $scope.getBannerData();
  $scope.changePage = function (banner) {
    window.location.href = banner.url;
  };

  // 获取热门推荐
  $scope.getRecommendData = function () {
    var url = '/header/getHotRecommendList';
    httpService.getRequest(url, {}).then(function (res) {
      if (res.success) {
        $scope.hotRecommendInfos = res.data.hotRecommendInfos;
        if ($scope.hotRecommendInfos.length > 0) {
          for (var i = 0; i < $scope.hotRecommendInfos.length; i++) {
            var score = parseFloat($scope.hotRecommendInfos[i].score);
            $scope.hotRecommendInfos.score = score > 5 ? 5 : score.toFixed(1);
            $scope.hotRecommendInfos.starNum = Math.floor(score);
          }
        }
      } else {
        // alert(res.errorMessage);
      }
    });
  };
  $scope.getRecommendData();

  // 获取推荐门店
  $scope.getData = function () {
    var url = '/shop/getShopRecommend';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $scope.newListData = [];
      if (res.success) {
        var data = res.data;
        if (data.dtos.length > 0) {
          $scope.newListData = data.dtos;
          for (var i = 0; i < $scope.newListData.length; i++) {
            $scope.newListData[i].score = $scope.newListData[i].score > 5 ? 5 : $scope.newListData[i].score;
            $scope.newListData[i].starNum = Math.floor($scope.newListData[i].score);
            $scope.newListData[i].small_imgs = $scope.newListData[i].small_img_url.split('|');
          }
          $scope.list = $scope.list.concat($scope.newListData);
          $scope.formData.currentPage++;
        }
      }
      $scope.$broadcast('scroll.refreshComplete');
      $scope.$broadcast('scroll.infiniteScrollComplete');
    });
  };

  // 刷新列表
  $scope.refreshData = function () {
    $ionicScrollDelegate.scrollTop(false);
    $scope.list.length = 0;
    $scope.formData.currentPage = 1;
    $scope.getData();
  };

  // 加载更多
  $scope.loadMore = function () {
    $scope.getData();
  };

  // 展示详情
  $scope.showDetail = function (item) {
    $rootScope.goState('storeDetail', {data: JSON.stringify(item)})
  };

  // 预约
  $scope.appointment = function ($event, item) {
    $event.stopPropagation();
    if($rootScope.userInfo.has_activated_car){
      $rootScope.goState('storeAppointment', {data: JSON.stringify({'shop_id': item.id})});
    } else {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '您当前暂无已激活的车辆，请先前往激活'
      });
    }
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
