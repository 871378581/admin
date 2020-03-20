ionicApp.controller("collectionController", function ($scope, $rootScope, $stateParams,
                                                      $ionicScrollDelegate, $http, httpService, requestContext, $ionicLoading) {

  $scope.list = [];
  $scope.stars = "12345";

  // 获取数据
  $scope.getData = function () {
    var url = '/shop/getShopCollection';
    httpService.getRequest(url, $rootScope.getParamsData({})).then(function (res) {
      var data = res.data;
      $scope.newListData = [];
      if (data.shopCollectionList.length > 0) {
        $scope.newListData = data.shopCollectionList;
        for (var i = 0; i < $scope.newListData.length; i++) {
          $scope.newListData[i].starNum = Math.floor($scope.newListData[i].score);
          $scope.newListData[i].small_imgs = $scope.newListData[i].small_img_url.split('|');
        }
        $scope.list = $scope.list.concat($scope.newListData);
        $scope.newListData = [];
      }
      $scope.$broadcast('scroll.refreshComplete');
      $scope.$broadcast('scroll.infiniteScrollComplete');
    });
  };
  $scope.getData();

  // 刷新列表
  $scope.refreshData = function () {
    $ionicScrollDelegate.scrollTop(false);
    $scope.list.length = 0;
    // $scope.formData.currentPage = 1;
    $scope.getData();
  };

  // 加载更多
  $scope.loadMore = function () {
    if ($scope.formData.currentPage === 1) {
      return;
    }
    $scope.getData();
  };

  // 收藏/取消收藏
  $scope.changeCollected = function (item, status) {
    var formData = {
      'shop_id': item.id,
      'status': status
    };
    var url = '/shop/collect';
    httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        item.status = status;
      }
    });
  };

  // 展示详情
  $scope.showDetail = function (item) {
    $rootScope.goState('storeDetail', {data: JSON.stringify(item)})
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
