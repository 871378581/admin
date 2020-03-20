ionicApp.controller("bindingPhoneController", function ($scope, $rootScope, $stateParams,
                                                        $ionicScrollDelegate, $http, httpService, requestContext, $interval, $ionicPopup, $ionicLoading) {

  $scope.formData = {
    'phone': ''
  };
  $scope.showCodeGet = true;
  var timer;

  // 获取验证码
  $scope.getVerifyCode = function () {
    if (!validatePhoneNum($scope.formData.phone)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入正确的手机号码'
      });
      return
    }
    var url = '/user/auth/getVerifyCode';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        // 设置倒计时
        timer = $interval(function () {
          var sec = $("#sec").text();
          $("#sec").text(--sec);
          if (sec <= 0) {
            $("#sec").text(60);
            $scope.showCodeGet = true;
            $interval.cancel(timer);
          }
        }, 1000);
        $scope.showCodeGet = false;
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '已发送'
        });
      } else {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: res.errorMessage
        });
      }
    });
  };

  // 绑定手机号
  $scope.saveData = function () {
    if (!validatePhoneNum($scope.formData.phone)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入正确的手机号码'
      });
      return
    }
    if (!validateFormField($scope.formData.code)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入验证码'
      });
      return
    }
    var url = '/user/auth/verify';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '绑定成功',
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
            $rootScope.goState('tab.mine');
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
