ionicApp.controller("mineController",function($scope, $rootScope, $stateParams, $http, httpService, requestContext, $ionicLoading) {

  $rootScope.toHideTabs = true;
  
  // 获取微信用户信息
  function getUserInfo() {
    var url = '/user/getUserInfo';
    var params = {};
    httpService.getRequest(url, $rootScope.getParamsData(params)).then(function (res) {
      $scope.scopeUserInfo = res.data;
      $scope.showName = $scope.scopeUserInfo.user_name ? $scope.scopeUserInfo.user_name : $scope.scopeUserInfo.nick_name;
      if ($scope.scopeUserInfo) {
        switch ($scope.scopeUserInfo.card_level) {
          case '1':
            $scope.scopeUserInfo.card_level_name = '银卡会员';
            $scope.scopeUserInfo.car_level_name = '4缸车';
            break;
          case '2':
            $scope.scopeUserInfo.card_level_name = '金卡会员';
            $scope.scopeUserInfo.car_level_name = '6缸车';
            break;
          case '3':
            $scope.scopeUserInfo.card_level_name = '黑卡会员';
            $scope.scopeUserInfo.car_level_name = '8缸车';
            break;
          default:
            $scope.scopeUserInfo.card_level_name = '普通会员';
            break;
        }
        if ($scope.scopeUserInfo.carListDTO && $scope.scopeUserInfo.carListDTO.cars.length > 0) {
          var cars = $scope.scopeUserInfo.carListDTO.cars;
          for (var i = 0; i < cars.length; i++) {
            if (cars[i].is_default) {
              $rootScope.defaultCar = cars[i];
              switch (cars[i].car_status) {
                case '0':
                  $rootScope.defaultCarStatus = '未激活';
                  break;
                case '1':
                  $rootScope.defaultCarStatus = '使用中';
                  break;
                case '2':
                  $rootScope.defaultCarStatus = '已过期';
                  break;
              }
            }
          }
        }
      }
    });
  }
  getUserInfo();

  $(document).ready(function(){
    $ionicLoading.hide();
  });

});
