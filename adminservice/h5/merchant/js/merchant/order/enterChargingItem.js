ionicApp.controller("enterChargingItemController", function ($scope, $rootScope, $stateParams,
                                                             $ionicScrollDelegate, $http, httpService, requestContext,
                                                             $ionicLoading, $ionicPopup) {
  if (location.hash.indexOf("?") >= 0) {
    var params = getRequest2();
    if (params.orderId) {
      var detail = {'orderId': params.orderId};
      $rootScope.goState('enterChargingItem', {data: JSON.stringify(detail)});
    }
  }

  var stateParams = $stateParams.data;
  if (stateParams) {
    var parsedData = JSON.parse(stateParams);
    if (parsedData.orderId) {
      $scope.orderId = parsedData.orderId;
      localStorage.orderId = $scope.orderId;
    }
  } else {
    $scope.orderId = localStorage.orderId;
  }

  $scope.formData = {
    "shop_user_id": $rootScope.shop_user_id,
    "order_id": $scope.orderId,
    "feeDetails": []
  };
  $scope.feeItem = {
    "each_item": "",
    "each_fee": null
  };
  $scope.showAddItem = false;

  // 获取已提交的增值项
  function getChargingItemData() {
    var formData = {
      'id': $scope.orderId
    };
    var url = '/order/getPayInfo';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        var data = res.data;
        if(data.feeDetailList){
          $scope.formData.feeDetails = data.feeDetailList;
        }
      } else {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: res.errorMessage
        });
      }
    });
  }
  getChargingItemData();

  // 编辑附加项目
  $scope.editItem = function (index) {
    $scope.showAddItem = true;
    if(index!=null && index!==undefined){
      $scope.selectedIndex = index;
      $scope.feeItem = $scope.feeItem = {
        "each_item": $scope.formData.feeDetails[index].each_item,
        "each_fee": $scope.formData.feeDetails[index].each_fee
      };
    } else {
      $scope.selectedIndex = null;
      $scope.feeItem = {
        "each_item": "",
        "each_fee": null
      };
    }
  };
  $scope.cancelEdit = function(){
    $scope.showAddItem = false;
  };

  // 保存附加项目
  $scope.saveItem = function(){
    if (!validateFormField($scope.feeItem.each_item)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入费用名称'
      });
      return
    }
    if (!validateFormField($scope.feeItem.each_fee)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入金额'
      });
      return
    }
    if($scope.selectedIndex === null){
      $scope.formData.feeDetails.push($scope.feeItem);
    } else {
      $scope.formData.feeDetails[$scope.selectedIndex] = $scope.feeItem;
    }
    $scope.showAddItem = false;
  };

  // 移除费用项
  $scope.removeItem = function (index) {
    $scope.formData.feeDetails.remove(index);
  };

  $scope.saveData = function () {
    if ($scope.formData.feeDetails.length===0) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入附加项目'
      });
      return
    }
    var url = '/order/submitPayFeeDetail';
    $ionicLoading.show({
      template: '提交中...'
    });
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $ionicLoading.hide();
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '录入成功',
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
            $rootScope.goState('tab.order');
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
