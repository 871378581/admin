ionicApp.controller("homepageController", function ($scope, $rootScope, $stateParams,
                                                    $ionicScrollDelegate, $http, httpService, requestContext,
                                                    $ionicLoading, $ionicPopup, $timeout) {

  // 获取数据
  function getData() {
    var formData = {
      'shop_id': $rootScope.shop_id,
      'shop_user_id': $rootScope.shop_user_id
    };
    var url = '/order/getShopOrderSumInfo';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
      }
    });
  }
  getData();

  // 页面跳转
  $scope.changeState = function (type, state) {
    $rootScope.goState(state, {data: JSON.stringify({'orderField': type})})
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
