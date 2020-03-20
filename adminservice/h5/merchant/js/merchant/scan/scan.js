ionicApp.controller("scanController", function ($scope, $rootScope, $stateParams,
                                                $ionicScrollDelegate, $http, httpService, requestContext,
                                                $ionicLoading, $ionicPopup) {

  if (location.hash.indexOf("?") >= 0) { // 二维码扫描进来
    var url = location.hash.substring(location.hash.indexOf("?") + 1, location.hash.length); // 获取url中"?"符后的字串
    getOrderId(url);
  } else { // 门店端切换来进行扫一扫
    wx.scanQRCode({
      needResult: 1, // 默认为0，扫描结果由微信处理，1则直接返回扫描结果，
      scanType: ["qrCode"], // 可以指定扫二维码还是一维码，默认二者都有
      success: function (res) {
        var data = JSON.stringify(res.resultStr); // 当needResult 为 1 时，扫码返回的结果
        var url = data.substring(data.indexOf("?") + 1, data.length).replace(/\"/g, ""); // 获取url中"?"符后的字串
        getOrderId(url);
      },
      error: function () {
        console.log('扫一扫打开失败')
      }
    });
  }

  // 获取订单id
  function getOrderId(url) {
    var items = url.length > 0 ? url.split('&') : [], item = null;
    var params = new Object, key = null, value = null;
    for (var i = 0; i < items.length; i++) {
      item = items[i].split('=');
      key = decodeURIComponent(item[0]);
      value = decodeURIComponent(item[1]);
      if (key.length) {
        params[key] = value;
      }
    }
    if (params.orderId) {
      checkOrderId(params.orderId)
    } else {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '订单号获取失败'
      });
    }
  }
  
  function checkOrderId(orderId) {
    var formData = {
      'order_id': orderId
    };
    var url = '/order/getShopOrderInfo';
    httpService.getRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      $scope.areaList = [];
      if (res.success) {
        var data = res.data;
        if(data.shop_id!==$rootScope.shop_id){
          $ionicPopup.alert({
            title: 'EGE数联·生态',
            template: '非本店订单，请顾客重新查看'
          });
          $rootScope.goState('tab.homepage');
          return;
        }
        if(data.order_status==='A' || data.child_status==='J'){ // 预约中或已经扫码过但未开始服务
          $rootScope.goState('startService', {data: JSON.stringify({'orderId': orderId})});
        } else if(data.child_status==='K'){ // 已经开始了服务
          $rootScope.goState('enterTestReport', {data: JSON.stringify({'orderId': orderId})});
        } else if(data.child_status==='N'){ // 检测有异常
          $rootScope.goState('enterChargingItem', {data: JSON.stringify({'orderId': orderId})});
        } else {
          $rootScope.goState('tab.order');
        }
      } else {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: '订单查询失败'
        });
      }
    });
  }

});
