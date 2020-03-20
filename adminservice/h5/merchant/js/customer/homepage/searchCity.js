ionicApp.controller("searchCityController", function ($scope, $rootScope, $stateParams,
                                                      $ionicScrollDelegate, $http, httpService, requestContext, $ionicLoading) {
  $scope.formData = {
    'keyword': ''
  };

  // 获取数据
  $scope.getData = function () {
    var url = '/header/getProvinceCityList';
    httpService.getRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $scope.areaList = [];
      if (res.success) {
        $scope.showProvinceList = true;
        $scope.showCityList = false;
        if (res.data.infos.length > 0) {
          $scope.areaList = res.data.infos;
        }
      }
    });
  };

  $scope.$watch('formData.keyword', function (newValue, oldValue) {
    $scope.getData();
  });

  $scope.changeShow = function (type) {
    if (type === 1) {
      $scope.showProvinceList = true;
      $scope.showCityList = false;
      $scope.showDistrictList = false;
      $scope.selectedCityIndex = -1;
      $scope.selectedCity = null;
      $scope.showConfirmBtn = false;
    } else if (type === 2) {
      $scope.showProvinceList = false;
      $scope.showCityList = true;
      $scope.showDistrictList = false;
      $scope.showConfirmBtn = true;
    } else if (type === 3) {
      $scope.showProvinceList = false;
      $scope.showCityList = false;
      $scope.showDistrictList = true;
      $scope.showConfirmBtn = true;
    }
  };
  $scope.changeShow(1);


  $scope.selectProvince = function (index, item) {
    $scope.selectedProvinceIndex = index;
    $scope.selectedProvince = item;
    $scope.changeShow(2);
  };

  $scope.selectCity = function (index, item) {
    $scope.selectedCityIndex = index;
    $scope.selectedCity = item;
    $scope.changeShow(3);
  };

  $scope.selectDistrict = function (index, item) {
    $scope.selectedDistrictIndex = index;
    $scope.selectedDistrict = item;
  };

  $scope.confirmArea = function () {

    if($scope.selectedDistrict){
      $rootScope.position.province = $scope.selectedProvince.province;
      $rootScope.position.city = $scope.selectedCity.city;
      $rootScope.position.district = $scope.selectedDistrict;
      $rootScope.showAreaName = $rootScope.position.district;
    } else if($scope.selectedCity){
      $rootScope.position.province = $scope.selectedProvince.province;
      $rootScope.position.city = $scope.selectedCity.city;
      $rootScope.showAreaName = $rootScope.position.city;
    } else if($scope.selectedProvince){
      $rootScope.position.province = $scope.selectedProvince.province;
      $rootScope.showAreaName = $rootScope.position.province;
    }
    $scope.changeShow(1);
    $rootScope.back();
  };

  $(document).ready(function(){
    $ionicLoading.hide();
  });

});
