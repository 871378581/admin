ionicApp.controller("informationSettingController", function ($scope, $rootScope, $stateParams,
                                                              $ionicScrollDelegate, $http, httpService, requestContext,
                                                              $ionicPopup, $ionicLoading) {

  // 选择性别
  var sexMobileSelect = new MobileSelect({
    trigger: '#sex',
    title: '请选择性别',
    wheels: [
      {data: ['男', '女']}
    ],
    position: [0],
    transitionEnd: function (indexArr, data) {
      console.log(data);
    },
    callback: function (indexArr, data) {
      $scope.formData.sex = data[0];
    }
  });

  // 选择地区
  var dsy = $rootScope.dsy;
  for (var i = 0; i < dsy.length; i++) {
    for (var j = 0; j < dsy[i].childs.length; j++) {
      delete dsy[i].childs[j].childs;
    }
  }
  var dsyMobileSelect = new MobileSelect({
    trigger: '#dsy',
    title: '地区选择',
    wheels: [
      {data: dsy}
    ],
    transitionEnd: function (indexArr, data) {
      console.log(data);
    },
    callback: function (indexArr, data) {
      $scope.formData.place_city = data[0].value + data[1].value;
    }
  });

  var birth = [];
  for (var i = 1949; i <= new Date().getFullYear(); i++) {
    var childs = [];
    for (var j = 1; j < 13; j++) {
      var childsLast = [];
      var days = getMonthDays(i, j);
      for (var k = 1; k <= days; k++) {
        childsLast.push({
          'id': k,
          'value': k + '日'
        })
      }
      childs.push({
        'id': j,
        'value': j + '月',
        'childs': childsLast
      })
    }
    birth.push({
      'id': i,
      'value': i + '年',
      'childs': childs
    })
  }
  var birthMobileSelect = new MobileSelect({
    trigger: '#birth',
    title: '日期选择',
    wheels: [
      {data: birth}
    ],
    position: [31, 0, 0],
    transitionEnd: function (indexArr, data) {
    },
    callback: function (indexArr, data) {
      $scope.formData.birth = data[0].id + '-' + (data[1].id < 10 ? '0' + data[1].id : data[1].id) + '-' + (data[2].id < 10 ? '0' + data[2].id : data[2].id);
    }
  });

  if ($rootScope.userInfo) {
    $scope.formData = {
      'shop_user_account': $.getCookie(COOKIE_NAME_USERNAME),
      "shop_id": $rootScope.shop_id,
      "shop_user_id": $rootScope.shop_user_id,
      'user_head': $rootScope.userInfo.user_head,
      'user_name': $rootScope.userInfo.user_name,
      'sex': $rootScope.userInfo.sex,
      // 'age': $rootScope.userInfo.age,
      'place_city': $rootScope.userInfo.place_city,
      'job': $rootScope.userInfo.job,
      'birth': $rootScope.userInfo.birth
    };
  } else {
    $scope.formData = {};
  }

  $scope.saveData = function () {
    var url = '/user/saveShopUserInfo';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        $rootScope.userInfo = $scope.formData;
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
