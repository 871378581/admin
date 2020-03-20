ionicApp.controller("storeDetailController", function ($scope, $rootScope, $stateParams,
                                                       $ionicScrollDelegate, $http, httpService, requestContext,
                                                       $ionicLoading, $ionicPopup) {

  var swiper;

  if (location.hash.indexOf("?") >= 0) {
    var params = getRequest2();
    if (params.storeId) {
      var detail = {'id': params.storeId};
      $rootScope.goState('storeDetail', {data: JSON.stringify(detail)});
    }
  }

  var stateParams = $stateParams.data;
  if (stateParams) {
    $scope.detail = JSON.parse(stateParams);
    if ($scope.detail.id) { // 车辆列表页来
      localStorage.storeId = $scope.detail.id;
    }
    if ($scope.detail.shop_id) { // 收藏列表页来
      localStorage.storeId = $scope.detail.shop_id;
    }
  }

  // 获取数据
  $scope.getDetailData = function () {
    var url = '/shop/getShopInfoByID?id=' + localStorage.storeId;
    httpService.getRequest(url, $rootScope.getParamsData({})).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
        var score = parseFloat($scope.detail.score);
        $scope.detail.score = score > 5 ? 5 : score.toFixed(1);
        $scope.detail.starNum = Math.floor(score);
        $scope.detail.door_imgs = $scope.detail.door_img_url.split('|');
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
        // 初始化分享按钮
        var shareData = {
          wxData: {
            title: 'EGE数联·生态', //分享给朋友显示的标题
            // imgUrl: '',
            imgUrl: $scope.detail.door_imgs[0], //活动详情的活动介绍图片
            // link: window.location.href,
            link: window.location.href + '?storeId=' + localStorage.storeId,
            desc: $scope.detail.enterprise_name //分享到朋友圈显示的话，这里就是活动的标题
          },
          extraData: {
            'urlType': 'storeDetail',
            'storeId': $scope.detail.id
          }
        };
        window.wxShareSetup(shareData);
      }
    });
  };
  $scope.getDetailData();

  $scope.stars = "12345";

  // 收藏/取消收藏
  $scope.changeCollected = function (status) {
    var formData = {
      'shop_id': $scope.detail.id,
      'status': status
    };
    var url = '/shop/collect';
    httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $scope.detail.is_collected = status;
      }
    });
  };

  // 分享
  $scope.shareStore = function () {
    $('.share-arrow').animate({
      'width': 'toggle',
      'height': 'toggle'
    }, {
      duration: 1000,
      complete: function () {
        $('.share-arrow').css({
          display: 'none'
        })
      }
    }).css({
      display: 'block',
      width: '1rem'
    });
  };

  // 导航
  $scope.openLocation = function (address) {
    /*wx.getLocation({
      type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
      success: function (res) {
        var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
        var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180
        wx.openLocation({
          latitude: latitude, // 纬度，浮点数，范围为90 ~ -90
          longitude: longitude, // 经度，浮点数，范围为180 ~ -180。
          name: '', // 位置名
          address: '', // 地址详情说明
          scale: 18, // 地图缩放级别,整形值,范围从1~28。默认为最大
          infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
        });
      }
    });*/
    wx.openLocation({
      latitude: $scope.detail.latitude, // 纬度，浮点数，范围为90 ~ -90
      longitude: $scope.detail.longitude, // 经度，浮点数，范围为180 ~ -180。
      name: '', // 位置名
      address: '', // 地址详情说明
      scale: 18, // 地图缩放级别,整形值,范围从1~28。默认为最大
      infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
    });
  };

  // 预约
  $scope.appointment = function ($event, item) {
    $event.stopPropagation();
    if($rootScope.userInfo.has_activated_car){
      $rootScope.goState('storeAppointment', {data: JSON.stringify({'shop_id': localStorage.storeId})});
    } else {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '您当前暂无已激活的车辆，请先前往激活'
      });
    }
  };

  // 获取评价列表
  $scope.formListData = {
    'id': localStorage.storeId,
    'currentPage': 1,
    'showCount': 5
  };
  $scope.list = [];
  // 获取数据
  $scope.getListData = function () {
    var url = '/shop/getShopEvaluateInfoByShopID';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formListData)).then(function (res) {
      $scope.newListData = [];
      if (res.success) {
        var data = res.data;
        if (data.evaluateDetailInfos.length > 0) {
          $scope.newListData = data.evaluateDetailInfos;
          $scope.list = $scope.list.concat($scope.newListData);
          $scope.formListData.currentPage++;
        } else {
          $scope.moreText = '暂无更多';
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
    $scope.formListData.currentPage = 1;
    $scope.getListData();
  };
  // 加载更多
  $scope.loadMore = function () {
    $scope.getListData();
  };
  $scope.moreText = '加载更多';
  $scope.loadMore();

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
