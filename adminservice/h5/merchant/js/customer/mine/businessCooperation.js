ionicApp.controller("businessCooperationController", function ($scope, $rootScope, $stateParams,
                                                               $ionicScrollDelegate, $http, httpService, requestContext,
                                                               $ionicPopup, $ionicLoading) {

  // 联系
  $scope.merchant_type_name = '门店';
  $scope.formData = {
    'merchant_type': 1,
    'name': '',
    'phone': '',
    'shop_name': '',
    'shop_area_size': '',
    'shop_address': ''
  };

  // 选择性别
  new MobileSelect({
    trigger: '#merchant_type',
    title: '请选择合作类型',
    wheels: [
      {data: ['门店', '渠道']}
    ],
    position: [0],
    transitionEnd: function (indexArr, data) {
      console.log(data);
    },
    callback: function (indexArr, data) {
      $scope.formData.merchant_type = data[0] === '门店' ? 1 : 2;
      $scope.$apply();
    }
  });

  $scope.checked = false;
  $scope.changeModalShow = function () {
    $ionicPopup.alert({
      title: 'EGE数联·生态',
      template: '我们保证所使用的机油等产品均为正品，一经发现违规，接受平台处罚'
    });
  };
  $scope.changeChecked = function () {
    $scope.checked = !$scope.checked;
  };

  $scope.doCooperate = function () {
    if (!validateFormField($scope.formData.name)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入姓名'
      });
      return
    }
    if (!validatePhoneNum($scope.formData.phone)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入正确的11位手机号码'
      });
      return
    }
    if ($scope.formData.merchant_type === 1) {
      if (!validateFormField($scope.formData.shop_name)) {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '请输入门店名称'
        });
        return
      }
      if (!validateFormField($scope.formData.shop_area_size)) {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '请输入门店面积'
        });
        return
      }
      if (!validateFormField($scope.formData.shop_address)) {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '请输入门店地址'
        });
        return
      }
    }
    if (!$scope.checked) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请先阅读阅读并遵守条款'
      });
      return
    }
    var url = '/header/commitBusinessCooperate';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '提交成功！',
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
