ionicApp.controller("passwordSettingController", function ($scope, $rootScope, $stateParams,
                                                              $ionicScrollDelegate, $http, httpService, requestContext,
                                                              $ionicPopup, $ionicLoading) {

  $scope.formData = {
    'shop_user_id': $rootScope.shop_user_id,
    'old_password': '',
    'new_password': '',
    'new_password_repeat': ''
  };

  $scope.saveData = function () {
    if (!validateFormField($scope.formData.old_password)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入旧密码'
      });
      return
    }
    if (!validateFormField($scope.formData.new_password)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入新密码'
      });
      return
    }
    if (!validateFormField($scope.formData.new_password_repeat)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请再次输入新密码'
      });
      return
    }
    if($scope.formData.new_password!==$scope.formData.new_password_repeat){
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '两次输入的新密码不一致'
      });
      $scope.formData.new_password = '';
      $scope.formData.new_password_repeat = '';
      return
    }
    delete $scope.formData.new_password_repeat;
    var url = '/user/updateShopUserPassword';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '更新成功',
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
