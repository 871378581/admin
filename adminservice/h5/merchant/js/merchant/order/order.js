ionicApp.controller("orderController", function ($scope, $rootScope, $stateParams,
                                                 $ionicScrollDelegate, $http, httpService, requestContext,
                                                 $ionicLoading, $ionicPopup) {

  $scope.formData = {
    'shop_id': $rootScope.shop_id,
    'currentPage': 1,
    'showCount': 10,
    'keyword': '',
    'search_type': 3, // 1门店名 2机油品牌 3车牌 4车型
    'order_status': 'ALL'
  };
  $scope.list = [];

  var stateParams = $stateParams.data;
  if (stateParams) {
    var parsedData = JSON.parse(stateParams);
    if (parsedData.orderField) {
      $scope.formData.order_status = parsedData.orderField;
    }
  }

  $scope.$watch('formData.keyword', function (newValue, oldValue) {
    if (newValue || oldValue) {
      $scope.refreshData();
    }
  });

  // 获取数据
  $scope.firstLoad = true;
  $scope.getData = function () {
    $scope.firstLoad = false;
    var url = '/order/getOrderListByShopId';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $scope.newListData = [];
      if (res.success) {
        var data = res.data;
        $scope.newListData = data.serviceOrderList;
        if ($scope.newListData.length > 0) {
          for (var i = 0; i < $scope.newListData.length; i++) {
            switch ($scope.newListData[i].car_level) {
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
            switch ($scope.newListData[i].child_status) {
              case 'F':
                $scope.newListData[i].order_status_name = '预约已提交';
                $scope.newListData[i].order_tips = '预约已提交';
                break;
              case 'G':
                $scope.newListData[i].order_status_name = '预约成功';
                $scope.newListData[i].order_tips = '预约成功';
                break;
              case 'H':
                $scope.newListData[i].order_status_name = '门店已修改预约时间,车主待确认';
                $scope.newListData[i].order_tips = '车主待确认';
                break;
              case 'J':
                $scope.newListData[i].order_status_name = '扫码确认订单、会员身份、验证服务资格';
                $scope.newListData[i].order_tips = '准备标准化保养服务';
                break;
              case 'K':
                $scope.newListData[i].order_status_name = '开始标准化保养服务';
                $scope.newListData[i].order_tips = '开始标准化保养服务';
                break;
              case 'L':
                $scope.newListData[i].order_status_name = '保养服务结束,生成检测报告';
                $scope.newListData[i].order_tips = '保养服务结束';
                break;
              case 'M':
                $scope.newListData[i].order_status_name = '保养服务检测无异常';
                $scope.newListData[i].order_tips = '检测无异常';
                break;
              case 'N':
                $scope.newListData[i].order_status_name = '保养服务检测有异常';
                $scope.newListData[i].order_tips = '检测有异常';
                break;
              case 'P':
                $scope.newListData[i].order_status_name = '增值服务待确认';
                $scope.newListData[i].order_tips = '增值服务待确认';
                break;
              case 'Q':
                $scope.newListData[i].order_status_name = '增值服务处理中';
                $scope.newListData[i].order_tips = '增值服务处理中';
                break;
              case 'R':
                $scope.newListData[i].order_status_name = '增值服务维修完成';
                $scope.newListData[i].order_tips = '增值服务维修完成';
                break;
              case 'S':
                $scope.newListData[i].order_status_name = '检测异常已忽略';
                $scope.newListData[i].order_tips = '检测异常已忽略';
                break;
              case 'T':
                $scope.newListData[i].order_status_name = '增值服务检测通过';
                $scope.newListData[i].order_tips = '增值服务检测通过';
                break;
              case 'V':
                $scope.newListData[i].order_status_name = '预约失败';
                $scope.newListData[i].order_tips = '预约失败';
                break;
              case 'W':
                $scope.newListData[i].order_status_name = '支付待确认';
                $scope.newListData[i].order_tips = '支付待确认';
                break;
              case 'U':
                $scope.newListData[i].order_status_name = '待评价';
                $scope.newListData[i].order_tips = '待评价';
                break;
              case 'E':
                $scope.newListData[i].order_status_name = '已完成';
                $scope.newListData[i].order_tips = '已完成';
                break;
              case 'I':
                $scope.newListData[i].order_status_name = '已取消';
                $scope.newListData[i].order_tips = '已取消';
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

  // 检测报告录入
  $scope.enterTestReport = function (item) {
    var data = {
      'orderId': item.id,
      'orderStatus': item.order_status,
      'childStatus': item.child_status,
      'reportId': item.report_id
    };
    $rootScope.goState('enterTestReport', {data: JSON.stringify(data)});
  };

  // 录入费用明细
  $scope.enterChargingItem = function (item) {
    var data = {
      'orderId': item.id,
      'orderStatus': item.order_status,
      'childStatus': item.child_status,
      'reportId': item.report_id
    };
    $rootScope.goState('enterChargingItem', {data: JSON.stringify(data)});
  };

  // 确认已付款
  $scope.confirmPayment = function (item) {
    var confirmPopup = $ionicPopup.confirm({
      title: 'EGE数联·生态',
      template: '是否确认收款',
      buttons: [{
        text: '取消',
        type: 'button-default',
        onTap: function (e) {
        }
      }, {
        text: '确认',
        type: 'button-positive',
        onTap: function (e) {
          return true;
        }
      }]
    });
    confirmPopup.then(function (res) {
      if (res) {
        $scope.selectedItem = item;
        var formData = {
          'shop_user_id': $rootScope.shop_user_id,
          'order_id': item.id,
          'pay_status': true
        };
        var url = '/order/shopConfirmOrderHavePay';
        httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (httpRes) {
          if (httpRes.success) {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: '确认成功'
            });
            $scope.selectedItem.order_status = 'U';
            $scope.selectedItem.order_tips = '待评价';
          } else {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: httpRes.errorMessage
            });
          }
        });
      } else {
        console.log('pressed Cancel');
      }
    });
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
