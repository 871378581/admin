ionicApp.controller("orderEvaluateController", function ($scope, $rootScope, $stateParams,
                                                         $ionicScrollDelegate, $http, httpService, requestContext,
                                                         $ionicPopup, $ionicLoading) {

  if (location.hash.indexOf("?") >= 0) {
    var params = getRequest2();
    if (params.orderId) {
      var detail = {'orderId': params.orderId};
      $rootScope.goState('orderDetail', {data: JSON.stringify(detail)});
    }
  }

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

  $scope.tagInfoList = [
    {'tag':'环境好','selected':false},
    {'tag':'态度好','selected':false},
    {'tag':'技术专业','selected':false},
    {'tag':'价格合理','selected':false},
    {'tag':'工作高效','selected':false}
  ];
  $scope.selectTag = function (item) {
    item.selected = !item.selected
  };
  $scope.formData = {
    "user_id": $rootScope.userInfo.user_id,
    "order_id": $scope.orderId,
    "evaluate_content": "",
    "evaluate_score": null
  };

  // 初始化评分星级
  function initDetailStar() {
    var ratingOptions = {
      selectors: {
        starsSelector: '.rating-stars',
        starSelector: '.rating-star',
        starActiveClass: 'is--active',
        starHoverClass: 'is--hover',
        starNoHoverClass: 'is--no-hover',
        targetFormElementSelector: '.rating-value'
      }
    };
    $(".rating-stars").ratingStars(ratingOptions);
    $(".rating-stars").on("ratingChanged", function (ev, data) {
      $scope.formData.evaluate_score = data.ratingValue;
    });
  }

  // 获取数据
  function getData() {
    var url = '/order/getOrderInfo';
    var paramsData = {
      id: $scope.orderId
    };
    httpService.getRequest(url, $rootScope.getParamsData(paramsData)).then(function (res) {
      if (res.success) {
        $scope.detail = res.data;
        switch ($scope.detail.order_status) {
          case 'A':
            $scope.detail.order_status_name = '预约中';
            $scope.detail.order_tips = '待门店确认预约';
            break;
          case 'B':
            $scope.detail.order_status_name = '服务中';
            $scope.detail.order_tips = '服务中';
            break;
          case 'C':
            $scope.detail.order_status_name = '待付款';
            $scope.detail.order_tips = '待付款';
            break;
          case 'E':
            $scope.detail.order_status_name = '已完成';
            $scope.detail.order_tips = '已完成';
            break;
          case 'I':
            $scope.detail.order_status_name = '已取消';
            $scope.detail.order_tips = '已取消';
            break;
          case 'U':
            $scope.detail.order_status_name = '待评价';
            $scope.detail.order_tips = '待评价';
            break;
          case 'W':
            $scope.detail.order_status_name = '支付完成待确认';
            $scope.detail.order_tips = '支付完成待确认';
            break;
        }
        initDetailStar();
      }
    });
  }

  // 评价
  $scope.saveData = function () {
    if (!validateFormField($scope.formData.evaluate_content)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请填写评价内容'
      });
      return
    }
    if (!validateFormField($scope.formData.evaluate_score)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请对本次服务进行评分'
      });
      return
    }
    var selectedTag = [];
    for(var i=0; i<$scope.tagInfoList.length; i++){
      if($scope.tagInfoList[i].selected){
        selectedTag.push($scope.tagInfoList[i].tag);
      }
    }
    $scope.formData.evaluate_tags = selectedTag.length>0 ? selectedTag.join(',') : '';
    var url = '/order/submitEvaluate';
    httpService.postRequest(url, $rootScope.getStringifyData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '评价成功',
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
