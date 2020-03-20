ionicApp.controller("carAddController", function ($scope, $rootScope, $stateParams,
                                                  $ionicScrollDelegate, $http, httpService, requestContext, $ionicPopup, $ionicLoading) {

  var stateParams = $stateParams.data;
  if (stateParams) {
    var formData = JSON.parse(stateParams);
    $scope.formData = {
      'id': formData.id,
      'plate': formData.plate,
      'color': formData.color,
      'vin': formData.vin,
      'type': formData.car_type_name,
      'is_default': formData.is_default,
      'user_name': formData.user_name,
      'phone': formData.phone
    };
    $scope.car_status = formData.car_status;
  } else {
    $scope.formData = {
      'id': 0,
      'is_default': false
    };
    $scope.car_status = null;
  }

  // 获取品牌列表
  $scope.keyword = '';
  $scope.getData = function () {
    var url = '/car/getCarTypeInfo?keyword=' + $scope.keyword;
    httpService.getRequest(url, {}).then(function (res) {
      if (res.success) {
        $scope.brandList = res.data.infos;
        for (var i = 0; i < $scope.brandList.length; i++) {
          if ($scope.brandList[i].children && $scope.brandList[i].children.length > 0) {
            $scope.selOuterIndex = i;
            $scope.selInnerIndex = 0;
            $scope.selBrand(i, 0, $scope.brandList[i].children[0]);
            break;
          }
        }
      }
    });
  };
  $scope.getData();

  $scope.$watch('keyword', function (newValue, oldValue) {
    if (newValue || oldValue) {
      $scope.getData();
      $scope.selctedBrand = null;
    }
  });

  // 弹出模态框
  $scope.showModal = false;
  $scope.toShowModal = function () {
    if ($scope.car_status != null && $scope.car_status != 0 && $scope.car_status != 3) {
      return;
    }
    $scope.showModal = true;
  };
  // 选择品牌
  $scope.selBrand = function (outerIndex, innerIndex, brand) {
    $scope.selOuterIndex = outerIndex;
    $scope.selInnerIndex = innerIndex;
    $scope.selctedBrand = brand;
    $scope.formData.brand_code = brand.brand_code; // 品牌编码
  };
  // 选择型号
  $scope.selModel = function (model) {
    $scope.formData.type = $scope.selctedBrand.name + ' ' + model;
    $scope.formData.car_logo_url = $scope.selctedBrand.brandImg;
    for(var i=0; i<$scope.selctedBrand.childrenType.length; i++){
      if($scope.selctedBrand.childrenType[i].typeName===model){
        $scope.formData.type_code = $scope.selctedBrand.childrenType[i].typeCode; // 型号编码
      }
    }
    $scope.showModal = false;
  };

  // 更改弹框显示
  $scope.changeModalShow = function () {
    // $scope.showModal = !$scope.showModal;
  };
  // 更改选择状态
  $scope.changeChecked = function () {
    $scope.checked = !$scope.checked;
  };
  // 保存新增车辆信息
  $scope.saveData = function () {
    if (!validateFormField($scope.formData.plate)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入车牌'
      });
      return
    }
    if (!validateFormField($scope.formData.type)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入型号'
      });
      return
    }
    $ionicLoading.show({
      template: '提交中...'
    });
    var url = '/car/saveCarInfo';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $ionicLoading.hide();
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '保存成功',
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

  // 删除车辆
  $scope.toDelCar = function () {
    var confirmPopup = $ionicPopup.confirm({
      title: 'EGE数联·生态',
      template: '确认删除？',
      buttons: [{
        text: '取消',
        type: 'button-default',
        onTap: function (e) {
        }
      }, {
        text: '确认',
        type: 'button-positive',
        onTap: function (e) {
          return true;
        }
      }]
    });
    confirmPopup.then(function (res) {
      if (res) {
        var formData = {
          'id': $scope.formData.id
        };
        var url = '/car/deleteCarById';
        httpService.postRequest(url, $rootScope.getStringifyData(formData)).then(function (res) {
          if (res.success) {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: '删除成功'
            });
            $rootScope.goState('carList');
          } else {
            $ionicPopup.alert({
              title: 'EGE数联·生态',
              template: res.errorMessage
            });
          }
        });
      } else {
        console.log('pressed Cancel');
      }
    });
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
