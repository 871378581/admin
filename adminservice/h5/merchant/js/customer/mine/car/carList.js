ionicApp.controller("carListController", function ($scope, $rootScope, $stateParams,
                                                   $ionicScrollDelegate, $http, httpService, requestContext, $ionicPopup, $ionicLoading) {

  $scope.formData = {
    currentPage: 1,
    showCount: 10
  };
  $scope.list = [];

  // 获取数据
  $scope.getData = function () {
    var url = '/car/getCarsInfo';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $scope.newListData = [];
      if (res.success) {
        var data = res.data;
        $scope.newListData = data.cars;
        if ($scope.newListData.length > 0) {
          for (var i = 0; i < $scope.newListData.length; i++) {
            switch ($scope.newListData[i].car_status) {
              case '0':
                $scope.newListData[i].car_status_name = '未激活';
                break;
              case '1':
                $scope.newListData[i].car_status_name = '使用中';
                break;
              case '2':
                $scope.newListData[i].car_status_name = '已过期';
                break;
            }
            switch ($scope.newListData[i].card_level) {
              case '1':
                $scope.newListData[i].card_level_name = '银卡会员';
                break;
              case '2':
                $scope.newListData[i].card_level_name = '金卡会员';
                break;
              case '3':
                $scope.newListData[i].card_level_name = '黑卡会员';
                break;
              default:
                $scope.newListData[i].card_level_name = '普通会员';
                break;
            }
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
    $rootScope.goState('withdrawalDetail', {data: JSON.stringify(item)})
  };

  // 续/绑卡
  $scope.toBindingCard = function (item, $event) {
    $event.stopPropagation();
    $rootScope.goState('bindingCard', {data: JSON.stringify(item)})
  };
  // 编辑车辆信息
  $scope.toEditCar = function (item, $event) {
    $event.stopPropagation();
    $rootScope.goState('carAdd', {data: JSON.stringify(item)})
  };

  // 删除车辆
  $scope.toDelCar = function (item, $event) {
    $event.stopPropagation();
    var confirmPopup = $ionicPopup.confirm({
      title: 'EGE数联·生态',
      template: '确认删除？',
      buttons: [{
        text: '取消',
        type: 'button-default',
        onTap: function(e) {
        }
      }, {
        text: '确认',
        type: 'button-positive',
        onTap: function(e) {
          return true;
        }
      }]
    });
    confirmPopup.then(function(res) {
      if(res) {
        var formData = {
          'id': item.id
        };
        var url = '/car/deleteCarById';
        httpService.postRequest(url, $rootScope.getStringifyData(formData)).then(function (res) {
          if (res.success) {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: '删除成功'
            });
            $scope.refreshData();
          } else {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: res.errorMessage
            });
          }
        });
      } else {
        console.log('pressed Cancel');
      }
    });
  };

  $(document).ready(function(){
    $ionicLoading.hide();
  });

});
