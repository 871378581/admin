ionicApp.controller("mineController",function($scope, $rootScope, $stateParams,
                                              $ionicScrollDelegate, $http, httpService, requestContext,
                                              $ionicLoading, $ionicPopup) {

  // 退出登录
  $scope.logout = function () {
    $.setCookie(COOKIE_NAME_USERNAME, null, -1);
    $.setCookie(COOKIE_NAME_PASSWORD, null, -1);
    $.setCookie('LOGINED', null, -1);
    $rootScope.goState('login');
  };

  // 登录以获取用户信息
  function doLogin() {
    var formData = {
      'account': $.getCookie(COOKIE_NAME_USERNAME),
      'password': $.getCookie(COOKIE_NAME_PASSWORD)
    };
    var url = '/user/shopUserLogin';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        var data = res.data;
        $scope.scopeUserInfo = {
          'user_head': data.user_head,
          'user_name': data.shop_user_name,
          'sex': data.sex,
          'place_city': data.place_city,
          'job': data.job,
          'birth': data.birth
        };
      }
    });
  }
  doLogin();

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
