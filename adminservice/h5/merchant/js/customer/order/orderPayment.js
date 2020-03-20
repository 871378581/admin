ionicApp.controller("orderPaymentController", function ($scope, $rootScope, $stateParams,
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
    var formData = {
      'id': $scope.orderId
    };
    var url = '/order/getPayInfo';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
      }
    });
  }

  $scope.formData = {
    'user_id': $rootScope.userInfo.user_id,
    'order_id': $scope.orderId,
    // 'pay_mode': 1
    'pay_mode': 2 // 线下支付
  };
  $scope.changePayMode = function (type) {
    $scope.formData.pay_mode = type;
  };

  // 确认付款
  $scope.confirmPay = function () {
    var url = '/order/carUserPay';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '支付申请已提交，请稍等门店确认',
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
            $rootScope.goState('orderDetail', {data: JSON.stringify({'orderId': $scope.orderId})})
          } else {
            console.log('pressed Cancel');
          }
        });
      } else {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: res.errorMessage
        });
      }
    });
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
