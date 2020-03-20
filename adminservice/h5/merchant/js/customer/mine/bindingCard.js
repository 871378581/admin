ionicApp.controller("bindingCardController", function ($scope, $rootScope, $stateParams,
                                                       $ionicScrollDelegate, $http, httpService, requestContext, $ionicPopup, $ionicLoading) {

  var stateParams = $stateParams.data;
  if (stateParams) {
    $scope.item = JSON.parse(stateParams);
    $scope.formData = {
      'plate': $scope.item.plate,
      "card_id": null,
      "password": null,
      "user_name": $rootScope.userInfo.user_name,
      "phone": $rootScope.userInfo.phone
    }
  } else {
    $scope.formData = {
      "user_name": $rootScope.userInfo.user_name,
      "phone": $rootScope.userInfo.phone
    };
  }
  $scope.checked1 = false;
  $scope.checked2 = false;

  $scope.changeChecked = function (type) {
    switch (type) {
      case 1:
        $scope.checked1 = !$scope.checked1;
        break;
      case 2:
        $scope.checked2 = !$scope.checked2;
        break;
    }
  };

  $scope.changeModalShow = function () {
    $ionicPopup.alert({
      title: 'EGE数联·生态',
      template: '会员权益：\n' +
      '该如何使用会员权益？\n' +
      '便捷的养护流程：\n' +
      '01 购买EGE会员\n' +
      '02完善个人信息\n' +
      '03进入EGE数联生态公众号\n' +
      '04选择预约服务点、时间等，会员预约权益锁定\n' +
      '05到达服务点接受服务\n' +
      '06同步了解养护进程及数据\n' +
      '07养护完成后对施工门店、技师点评\n' +
      '\n' +
      'EGE任享会员权益使用细则\n' +
      '\n' +
      '1.您通过购买并完善个人信息成为EGE任享会员后，即可在一年（365天）期限内免费在本平台合作门店对车辆进行A保养，一卡绑定一车，不限次数，车型匹配为：银卡4缸，金卡6缸，黑金卡8缸；\n' +
      '\n' +
      '2.EGE任享会员权益仅限非营运车辆（包括但不限于出租车，网约车等），一卡绑定一辆车，安所购卡型设置匹配使用；\n' +
      '\n' +
      '3.使用免费养护时，您每次可以预定1个免费服务施工点；\n' +
      '\n' +
      '4.施工并完成养护确认手续后，即可进行新的预定（指同一微信号绑定注册多卡的）。若需要更改订单信息，取消此订单重新下单即可；\n' +
      '\n' +
      '5.预约工位时安所购卡型匹配的机油、机滤、工时费、检查费等均无需以任何方式支付费用。卡型匹配内容以外的费用由门店报价，经会员确认后另行支付。\n' +
      '\n' +
      '6.若您因个人原因无法到达并接受预约养护服务，请务必提前1小时申请取消订单；如您未能提前1小时申请取消订单，平台将扣减您的信用积分50分/次，如您未申请取消订单且为实际到达进行养护服务，平台将扣减您的信用积分200分/次；\n' +
      '\n' +
      '7.若EGE任享会员未能提供真实信息（包括但不限于营运类车辆注册为非营运车辆等），已经发现，即对该卡所有权益进行冻结；\n' +
      '\n' +
      '8.一经购买，会员资格即生效。EGE任享会员有效期自会员资格生效当日起至1年止。每年以365日计。会员资格一经生效，概不退换；\n' +
      '\n' +
      '9.在EGE任享会员使用过程中，可能出现部分服务点、工位、时间段等紧俏的情况，请您密切关注EGE信息，合理安排预约时间。'
    });
  };
  $scope.changeModalShow2 = function () {
    $ionicPopup.alert({
      title: 'EGE数联·生态',
      template: '非运营车辆包括但不限于“出租车”、“滴滴等”'
    });
  };

  $scope.saveData = function () {
    if (!validateFormField($scope.formData.user_name)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入车主姓名'
      });
      return
    }
    if (!validateFormField($scope.formData.phone)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入车主电话'
      });
      return
    } else {
      if (!validatePhoneNum($scope.formData.phone)) {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '请输入正确的11位手机号码'
        });
        return
      }
    }
    if (!validateFormField($scope.formData.plate)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请选择车辆'
      });
      return
    }
    if (!validateFormField($scope.formData.card_id)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入卡号'
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
    if (!$scope.checked1) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请先阅读并同意EGE会员协议'
      });
      return
    }
    if (!$scope.checked2) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请先承诺本车辆为非运营车辆'
      });
      return
    }
    var url = '/card/activateCard';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '激活成功',
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
            $rootScope.goState('carList');
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

  $scope.buyCard = function () {
    window.location.href = 'http://www.hz-allin.cn/Item/detail/id/2765305/AL23/YEtb8/sid/8001975.html?pid=22121438';
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});

