ionicApp.controller("storeAppointmentController", function ($scope, $rootScope, $stateParams,
                                                            $ionicScrollDelegate, $http, httpService, requestContext,
                                                            $ionicLoading, $ionicPopup, $timeout) {

  $scope.carList = [];
  $scope.oilList = [];

  // 获取门店详情
  function getStoreDetailData() {
    if(!localStorage.appointmentmentShopId){
      return;
    }
    var url = '/shop/getShopInfoByID?id=' + localStorage.appointmentmentShopId;
    httpService.getRequest(url, $rootScope.getParamsData({})).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
        if($scope.detail.oils.length>0){
          $scope.oilList = $scope.detail.oils;
        } else {
          $scope.oilList = [];
        }
        var score = parseFloat($scope.detail.score);
        $scope.detail.score = score > 5 ? 5 : score.toFixed(1);
        $scope.detail.starNum = Math.floor(score);
        $scope.detail.door_imgs = $scope.detail.door_img_url.split('|');
      }
    });
  }

  // 获取个人车辆列表数据
  var swiper;
  $scope.showCarList = false;
  function getCarListData() {
    var url = '/car/getOrderCarsInfo';
    var formData = {
      currentPage: 1,
      showCount: 100
    };
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        var data = res.data;
        $scope.carList = data.cars;
        for(var i=0; i<$scope.carList.length; i++){
          if($scope.carList[i].is_default){
            $scope.carList[i].selected = true;
          }
          switch ($scope.carList[i].car_status) {
            case '0':
              $scope.carList[i].car_status_name = '未激活';
              break;
            case '1':
              $scope.carList[i].car_status_name = '使用中';
              break;
            case '2':
              $scope.carList[i].car_status_name = '已过期';
              break;
          }
          switch ($scope.carList[i].card_level) {
            case '1':
              $scope.carList[i].card_level_name = '银卡会员';
              break;
            case '2':
              $scope.carList[i].card_level_name = '金卡会员';
              break;
            case '3':
              $scope.carList[i].card_level_name = '黑卡会员';
              break;
            default:
              $scope.carList[i].card_level_name = '普通会员';
              break;
          }
        }
        swiper = new Swiper('.swiper-container', {
          initialSlide: 0,
          slidesPerView: 'auto',
          observer: true,//修改swiper自己或子元素时，自动初始化swiper
          observeParents: true//修改swiper的父元素时，自动初始化swiper
        });
        setTimeout(function () {
          document.getElementsByClassName('swiper-wrapper')[0].style.transform = 'translate3d(0px, 0px, 0px)'
        }, 500)
      }
    });
  }

  var stateParams = $stateParams.data;
  if (stateParams) {
    var parsedData = JSON.parse(stateParams);
    if (parsedData.shop_id) {
      localStorage.appointmentmentShopId = parsedData.shop_id;
    }
    getStoreDetailData();
    getCarListData();
  }

  $scope.formData = {
    "user_id": $rootScope.userInfo.user_id,
    "user_name": $rootScope.userInfo.nick_name,
    "shop_id": localStorage.appointmentmentShopId,
    "car_id": null,
    "oil_id": null,
    "service_item": "",
    // "gmt_service_date": "2019-11-23",
    // "gmt_service_begin_time": "09:30",
    "gmt_service_date": "",
    "gmt_service_begin_time": "",
    "gmt_service_end_time": "" //允许为空
  };

  // 选择服务车辆
  $scope.changeShow = function () {
    $scope.showCarList = true;
  };
  $scope.selectCar = function(car, index){
    $scope.showCarList = false;
    for(var i=0; i<$scope.carList.length; i++){
      $scope.carList[i].selected = false;
    }
    car.selected = !car.selected;
    swiper.slideTo(index, 100, false);
  };

  // 选择机油
  $scope.selectOil = function (oil) {
    for (var i = 0; i < $scope.oilList.length; i++) {
      $scope.oilList[i].selected = false;
    }
    oil.selected = !oil.selected;
  };

  /*var targetDate = [];
  for (var i = new Date().getFullYear(); i <= new Date().getFullYear() + 1; i++) {
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
    targetDate.push({
      'id': i,
      'value': i + '年',
      'childs': childs
    })
  }
  var targetTime = [];
  for (var i = 0; i < 24; i++) {
    var childs = [
      {'id': '00', 'value': '00分'},
      {'id': '30', 'value': '30分'}
    ];
    targetTime.push({
      'id': i,
      'value': i + '时',
      'childs': childs
    })
  }*/


  var nowDate = new Date();
  var currYear = nowDate.getFullYear();
  var currMonth = nowDate.getMonth() + 1;
  var currDay = nowDate.getDate();
  var currDate = currYear + '-' + (currMonth < 10 ? '0' +currMonth : currMonth) + '-' + (currDay < 10 ? '0' + currDay : currDay);
  var currHour = nowDate.getHours();
  function getDateMobileSelect() {var targetDate = [];
    for (var i = currYear; i <= currYear + 1; i++) {
      var childs = [];
      var startMonth = currYear===i ? currMonth : 1;
      for (var j = startMonth; j <= 12; j++) {
        var childsLast = [];
        var days = getMonthDays(i, j);
        var startDay = (currYear===i && currMonth===startMonth) ? currDay : 1;
        for (var k = startDay; k <= days; k++) {
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
      targetDate.push({
        'id': i,
        'value': i + '年',
        'childs': childs
      })
    }
    new MobileSelect({
      trigger: '#startDate',
      title: '日期选择',
      wheels: [
        {data: targetDate}
      ],
      position: [0, 0, 0],
      transitionEnd: function (indexArr, data) {
      },
      callback: function (indexArr, data) {
        $scope.formData.gmt_service_date = data[0].id + '-' + (data[1].id < 10 ? '0' + data[1].id : data[1].id) + '-' + (data[2].id < 10 ? '0' + data[2].id : data[2].id);
        getHourMobileSelect();
      }
    });
  }
  function getHourMobileSelect() {
    var targetTime = [];
    var startHour = $scope.formData.gmt_service_date=== currDate ? currHour + 1 : 0;
    for (var i = startHour; i < 24; i++) {
      var childs = [
        {'id': '00', 'value': '00分'},
        {'id': '30', 'value': '30分'}
      ];
      targetTime.push({
        'id': i,
        'value': i + '时',
        'childs': childs
      })
    }
    new MobileSelect({
      trigger: '#startTime',
      title: '时间选择',
      wheels: [
        {data: targetTime}
      ],
      position: [0, 0],
      transitionEnd: function (indexArr, data) {
      },
      callback: function (indexArr, data) {
        $scope.formData.gmt_service_begin_time = data[0].id + ':' + data[1].id;
      }
    });
  }
  getDateMobileSelect();

  // 执行预约
  $scope.saveData = function () {
    for(var i=0; i<$scope.carList.length; i++){
      if($scope.carList[i].selected){
        $scope.formData.car_id = $scope.carList[i].id;
      }
    }
    if (!validateFormField($scope.formData.car_id)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请选择进行保养的车辆'
      });
      return
    }
    for(var i=0; i<$scope.oilList.length; i++){
      if($scope.oilList[i].selected){
        $scope.formData.oil_id = $scope.oilList[i].oil_id;
      }
    }
    /*if (!validateFormField($scope.formData.oil_id)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请选择保养用的机油'
      });
      return
    }*/
    if (!validateFormField($scope.formData.gmt_service_date)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请选择保养日期'
      });
      return
    }
    if (!validateFormField($scope.formData.gmt_service_begin_time)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请选择保养时间'
      });
      return
    }
    $ionicLoading.show({
      template: '提交中...'
    });
    var url = '/order/submitOrder';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      $ionicLoading.hide();
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '预约成功',
          buttons: [{
            text: '确认',
            type: 'button-positive',
            onTap: function (e) {
              return true;
            }
          }]
        });
        confirmPopup.then(function (r) {
          if (r) {
            $rootScope.goState('appointmentResult', {data: JSON.stringify({'orderId': res.data})});
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
