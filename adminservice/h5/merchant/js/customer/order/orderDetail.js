ionicApp.controller("orderDetailController", function ($scope, $rootScope, $stateParams,
                                                       $ionicScrollDelegate, $http, httpService, requestContext,
                                                       $ionicPopup, $ionicLoading) {

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
    var url = '/order/getOrderInfo';
    var paramsData = {
      id: $scope.orderId
    };
    httpService.getRequest(url, $rootScope.getParamsData(paramsData)).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
        switch ($scope.detail.order_status) {
          case 'A':
            $scope.detail.order_status_name = '预约中';
            switch ($scope.detail.child_status){
              case 'F':
                $scope.detail.order_tips = '待门店确认预约';
                break;
              case 'G':
                $scope.detail.order_tips = '预约成功';
                break;
              case 'H':
                $scope.detail.order_tips = '时间修改待确认';
                break;
              case 'V':
                $scope.detail.order_tips = '预约失败';
                break;
            }
            break;
          case 'B':
            $scope.detail.order_status_name = '服务中';
            $scope.detail.order_tips = '服务中';
            switch ($scope.detail.child_status){
              case 'P':
                $scope.detail.order_tips = '有异常';
                break;
            }
            break;
          case 'C':
            $scope.detail.order_status_name = '待付款';
            $scope.detail.order_tips = '待付款';
            break;
          case 'E':
            $scope.detail.order_status_name = '已完成';
            $scope.detail.order_tips = '已完成';
            break;
          case 'I':
            $scope.detail.order_status_name = '已取消';
            $scope.detail.order_tips = '已取消';
            break;
          case 'U':
            $scope.detail.order_status_name = '待评价';
            $scope.detail.order_tips = '待评价';
            break;
          case 'W':
            $scope.detail.order_status_name = '支付完成待确认';
            $scope.detail.order_tips = '支付完成待确认';
            break;
        }
        switch ($scope.detail.card_level) {
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
      }
    });
  }

  // 取消订单
  $scope.cancelOrder = function () {
    var formData = {
      'user_id': $rootScope.userInfo.user_id,
      'order_id': $scope.orderId
    };
    var url = '/order/cancelOrder';
    httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '取消成功'
        });
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
            getData();
          }
        });
      }
    });
  };

  // 操作异常下
  $scope.confirmException = function (bo) {
    var url = '';
    var template = '';
    if(bo){ // 确认异常
      url = '/order/carUserIgnoreException';
      template = '确认成功';
    } else { // 忽略异常
      url = '/order/carUserIgnoreException';
      template = '忽略成功';
    }
    var formData = {
      'user_id': $rootScope.userInfo.user_id,
      'order_id': $scope.orderId
    };
    httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: template
        });
        getData();
      }
    });
  };

  // 页面跳转
  $scope.changeState = function (item, state) {
    $rootScope.goState(state, {data: JSON.stringify({'orderId': $scope.orderId})});
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
