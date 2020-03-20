ionicApp.controller("orderController", function ($scope, $rootScope, $stateParams,
                                                 $ionicScrollDelegate, $http, httpService, requestContext,
                                                 $ionicLoading, $ionicPopup) {

  $scope.formData = {
    'currentPage': 1,
    'showCount': 10,
    'keyword': '',
    'order_status': 'ALL'
  };
  $scope.list = [];

  $scope.$watch('formData.keyword', function (newValue, oldValue) {
    if (newValue || oldValue) {
      $scope.refreshData();
    }
  });

  // 获取数据
  $scope.firstLoad = true;
  $scope.getData = function () {
    $scope.firstLoad = false;
    var url = '/order/getOrderList';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $scope.newListData = [];
      if (res.success) {
        var data = res.data;
        $scope.newListData = data.serviceOrderList;
        if ($scope.newListData.length > 0) {
          for (var i = 0; i < $scope.newListData.length; i++) {
            switch ($scope.newListData[i].order_status) {
              case 'A':
                $scope.newListData[i].order_status_name = '预约中';
                switch ($scope.newListData[i].child_status){
                  case 'F':
                    $scope.newListData[i].order_tips = '待门店确认预约';
                    break;
                  case 'G':
                    $scope.newListData[i].order_tips = '预约成功';
                    break;
                  case 'H':
                    $scope.newListData[i].order_tips = '时间修改待确认';
                    break;
                  case 'V':
                    $scope.newListData[i].order_tips = '预约失败';
                    break;
                }
                break;
              case 'B':
                $scope.newListData[i].order_status_name = '服务中';
                $scope.newListData[i].order_tips = '服务中';
                switch ($scope.newListData[i].child_status){
                  case 'P':
                    $scope.newListData[i].order_tips = '有异常';
                    break;
                }
                break;
              case 'C':
                $scope.newListData[i].order_status_name = '待付款';
                $scope.newListData[i].order_tips = '待付款';
                break;
              case 'E':
                $scope.newListData[i].order_status_name = '已完成';
                $scope.newListData[i].order_tips = '已完成';
                break;
              case 'I':
                $scope.newListData[i].order_status_name = '已取消';
                $scope.newListData[i].order_tips = '已取消';
                break;
              case 'U':
                $scope.newListData[i].order_status_name = '待评价';
                $scope.newListData[i].order_tips = '待评价';
                break;
              case 'W':
                $scope.newListData[i].order_status_name = '支付完成待确认';
                $scope.newListData[i].order_tips = '支付完成待确认';
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

  // 更改排序方式
  $scope.changeOrder = function (type) {
    $scope.list.length = 0;
    $scope.formData.order_status = type;
    $scope.formData.currentPage = 1;
    $scope.getData();
  };

  // 取消订单
  $scope.cancelOrder = function (item) {
    var confirmPopup = $ionicPopup.confirm({
      title: 'EGE数联·生态',
      template: '确认取消订单吗？',
      buttons: [{
        text: '确认',
        type: 'button-positive',
        onTap: function (e) {
          return true;
        }
      },{
        text: '关闭',
        onTap: function (e) {
          return false;
        }
      }]
    });
    confirmPopup.then(function (res) {
      if (res) {
        var formData = {
          'user_id': $rootScope.userInfo.user_id,
          'order_id': item.id
        };
        var url = '/order/cancelOrder';
        httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
          if (res.success) {
            var confirmPopup = $ionicPopup.confirm({
              title: 'EGE数联·生态',
              template: '取消成功',
              buttons: [{
                text: '确认',
                type: 'button-positive',
                onTap: function (e) {
                  return true;
                }
              }]
            });
            confirmPopup.then(function (res) {
              if (res) {
                $scope.refreshData();
              }
            });
          }
        });
      }
    });
  };


  // 确认预约时间修改
  $scope.confirmTime = function (item) {
    $scope.selectedOrder = item;
    var confirmPopup = $ionicPopup.confirm({
      title: 'EGE数联·生态',
      template: '您之前的预约时间为' + $scope.selectedOrder.gmt_service_date + ' ' + $scope.selectedOrder.gmt_service_begin_time +
      '，最新的预约时间为' + $scope.selectedOrder.gmt_change_service_date + ' ' + $scope.selectedOrder.gmt_change_service_begin_time,
      buttons: [{
        text: '确认',
        type: 'button-positive',
        onTap: function (e) {
          return true;
        }
      },{
        text: '关闭',
        onTap: function (e) {
          return false;
        }
      }]
    });
    confirmPopup.then(function (res) {
      if (res) {
        var formData = {
          'user_id': $rootScope.userInfo.user_id,
          'order_id': item.id,
          'success': true
        };
        var url = '/order/carUserConfirmOrder';
        httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
          if (res.success) {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: '确认预约时间修改成功'
            });
            $scope.selectedOrder.child_status = 'G';
            $scope.selectedOrder.order_tips = '预约成功';
          }
        });
      }
    });
  };

  // 导航
  $scope.openLocation = function (item) {
    wx.getLocation({
      type: 'wgs84', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
      success: function (res) {
        // var latitude = res.latitude; // 纬度，浮点数，范围为90 ~ -90
        // var longitude = res.longitude; // 经度，浮点数，范围为180 ~ -180
        wx.openLocation({
          latitude: item.latitude, // 纬度，浮点数，范围为90 ~ -90
          longitude: item.longitude, // 经度，浮点数，范围为180 ~ -180。
          name: '', // 位置名
          address: '', // 地址详情说明
          scale: 18, // 地图缩放级别,整形值,范围从1~28。默认为最大
          infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
        });
      }
    });
  };

  // 页面跳转
  $scope.changeState = function (item, state) {
    $rootScope.goState(state, {data: JSON.stringify({'orderId': item.id})})
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
