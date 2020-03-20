ionicApp.controller("loginController", function ($scope, $rootScope, $stateParams,
                                                 $ionicScrollDelegate, $http, httpService, requestContext,
                                                 $ionicLoading, $ionicPopup) {

  $scope.formData = {
    'account': '',
    'password': ''
  };

  // 登录
  $scope.doLogin = function () {
    if (!validateFormField($scope.formData.account)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入用户名'
      });
      return
    }
    if (!validateFormField($scope.formData.password)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入密码'
      });
      return
    }
    $ionicLoading.show({
      template: '登录中...'
    });
    var url = '/user/shopUserLogin';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $ionicLoading.hide();
      if (res.success) {
        $.setCookie(COOKIE_NAME_USERNAME, $scope.formData.account, 31);
        $.setCookie(COOKIE_NAME_PASSWORD, $scope.formData.password, 31);
        $.setCookie('LOGINED', true, 31);
        var data = res.data;
        $rootScope.shop_id = data.shop_id;
        $rootScope.shop_user_id = data.shop_user_id;
        $rootScope.userInfo = {
          'user_head': data.user_head,
          'user_name': data.shop_user_name,
          'sex': data.sex,
          'place_city': data.place_city,
          'job': data.job,
          'birth': data.birth
        };
        $rootScope.goState('tab.homepage')
      } else {
        $.setCookie(COOKIE_NAME_USERNAME, null, -1);
        $.setCookie(COOKIE_NAME_PASSWORD, null, -1);
        $.setCookie('LOGINED', null, -1);
        $scope.formData = {
          'account': '',
          'password': ''
        };
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: "请输入正确的用户名和密码"
        });
      }
    });
  };

  // 自动登录验证
  if(validateFormField($.getCookie(COOKIE_NAME_USERNAME)) && validateFormField($.getCookie(COOKIE_NAME_PASSWORD))){
    $scope.formData.account = $.getCookie(COOKIE_NAME_USERNAME);
    $scope.formData.password = $.getCookie(COOKIE_NAME_PASSWORD);
    $scope.doLogin();
  }

});
