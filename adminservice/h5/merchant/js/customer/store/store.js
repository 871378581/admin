ionicApp.controller("storeController", function ($scope, $rootScope, $stateParams,
                                                 $ionicScrollDelegate, $http, httpService, requestContext,
                                                 $ionicLoading, $ionicPopup) {

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
    'keyword': '',
    /*'province_name': $rootScope.position.province ? $rootScope.position.province : '',
    'city_name': $rootScope.position.city ? $rootScope.position.city : '',
    'area_name': $rootScope.position.district ? $rootScope.position.district : '',*/
    'area_name': $rootScope.position.district ? $rootScope.position.district : $rootScope.position.city,
    'longitude': $rootScope.position.lng ? $rootScope.position.lng : '',
    'latitude': $rootScope.position.lat ? $rootScope.position.lat : '',
    'order_field': 1,
    'search_type': 1
  };
  $scope.list = [];
  $scope.stars = "12345";

  $scope.$watch('formData.keyword', function (newValue, oldValue) {
    if (newValue || oldValue) {
      $scope.refreshData();
    }
  });

  $rootScope.$watch('showAreaName', function (newValue, oldValue) {
    if (newValue || oldValue) {
      $scope.formData.area_name = $rootScope.showAreaName;
      $scope.refreshData();
    }
  });

  // 获取数据
  $scope.getData = function () {
    var url = '/shop/getShopByKeywordAndArea';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $scope.newListData = [];
      if (res.success) {
        var data = res.data;
        $scope.newListData = data.shops;
        if ($scope.newListData.length > 0) {
          for (var i = 0; i < $scope.newListData.length; i++) {
            var score = parseFloat($scope.newListData[i].score);
            $scope.newListData[i].score = score > 5 ? 5 : score.toFixed(1);
            $scope.newListData[i].starNum = Math.floor(score);
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
    if($scope.formData.currentPage===1){
      return;
    }
    $scope.getData();
  };

  // 更改排序方式
  $scope.changeOrder = function (type) {
    $scope.list.length = 0;
    $scope.formData.currentPage = 1;
    switch (type) {
      case 1:
        $scope.formData.order_field = $scope.formData.order_field === 1 ? 2 : 1;
        break;
      case 3:
        $scope.formData.order_field = $scope.formData.order_field === 3 ? 4 : 3;
        break;
      case 5:
        $scope.formData.order_field = $scope.formData.order_field === 5 ? 6 : 5;
        break;
      case 7:
        $scope.formData.order_field = $scope.formData.order_field === 7 ? 8 : 7;
        break;
    }
    $scope.getData();
  };

  // 展示详情
  $scope.showDetail = function (item) {
    $rootScope.goState('storeDetail', {data: JSON.stringify(item)})
  };

  // 预约
  $scope.appointment = function ($event, item) {
    $event.stopPropagation();
    if ($rootScope.userInfo.has_activated_car) {
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
