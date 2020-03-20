ionicApp.controller("startServiceController", function ($scope, $rootScope, $stateParams,
                                                        $ionicScrollDelegate, $http, httpService, requestContext,
                                                        $ionicLoading, $ionicPopup) {

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

  $scope.formData = {
    "order_id": $scope.orderId,
    "shop_user_id": $rootScope.shop_user_id,
    "car_front_photo_url": "",
    "car_dashboard_photo_url": "",
    "curr_miles": null
  };

  // 选择机油
  $scope.selectOil = function (oil) {
    for (var i = 0; i < $scope.oilList.length; i++) {
      $scope.oilList[i].selected = false;
    }
    oil.selected = !oil.selected;
  };

  // 获取数据
  function getData() {
    var formData = {
      'shop_user_id': $rootScope.shop_user_id,
      'id': $scope.orderId
    };
    var url = '/order/getScanOrderInfo';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
        if ($scope.detail.oils.length > 0) {
          $scope.oilList = $scope.detail.oils;
        } else {
          $scope.oilList = [];
        }
        if ($scope.detail.oil_id) {
          for (var i = 0; i < $scope.oilList.length; i++) {
            if ($scope.oilList[i].oil_id === $scope.detail.oil_id) {
              $scope.selectOil($scope.oilList[i]);
            }
          }
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

  $scope.fileList = ["", ""];
  // 选择输入项实况图片上传
  $scope.addFile = function (index) {
    $("#pictureFile" + index).click();
  };
  $scope.removeFile = function (index) {
    $scope.fileList[index] = "";
  };
  $scope.uploadFile = function (index) {
    var sendData = new FormData();
    var files = document.querySelector('#pictureFile' + index).files;
    if (files && files.length > 0) {
      sendData.append('file', files[0]);
    }
    // 执行上传
    $ionicLoading.show({
      template: '图片上传中...'
    });
    $http({
      method: "POST",
      url: ROOT_URL + "/file/upload",
      data: sendData,
      headers: {'Content-Type': undefined},
      transformRequest: angular.identity
    }).then(function (res) {
      var data = res.data;
      $scope.fileList[index] = data.url;
      $("#pictureFile" + index).val("");
      $ionicLoading.hide();
    }, function error() {
      $ionicLoading.hide();
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '图片上传失败'
      });
    });
  };

  // 确认预约
  $scope.saveData = function () {
    if ($scope.detail.have_risk) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '抱歉，您的车辆当前通过风控检测，暂时无法开始服务'
      });
      return
    }
    if (!validateFormField($scope.fileList[0])) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请上传车辆正面照'
      });
      return
    } else {
      $scope.formData.car_front_photo_url = $scope.fileList[0];
    }
    if (!validateFormField($scope.fileList[1])) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请上传仪表盘照'
      });
      return
    } else {
      $scope.formData.car_dashboard_photo_url = $scope.fileList[1];
    }
    if (!validateFormField($scope.formData.curr_miles)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入当前公里数'
      });
      return
    }
    for (var i = 0; i < $scope.oilList.length; i++) {
      if ($scope.oilList[i].selected) {
        $scope.formData.new_oil_id= $scope.oilList[i].oil_id;
        $scope.formData.new_oil_brand= $scope.oilList[i].brand_name;
      }
    }
    $ionicLoading.show({
      template: '提交中...'
    });
    var url = '/order/uploadPhotoAndStartService';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $ionicLoading.hide();
      if (res.success) {
        /*var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '跳转到检测报告页面',
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
            // $rootScope.goState('tab.order');
            $rootScope.goState('enterTestReport', {data: JSON.stringify({'orderId': $scope.orderId})});
          }
        });*/
        $ionicLoading.hide();
        $rootScope.goState('tab.order');
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
