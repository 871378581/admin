ionicApp.controller("contactUsController", function ($scope, $rootScope, $stateParams,
                                                     $ionicScrollDelegate, $http, httpService, requestContext, $ionicPopup, $ionicLoading) {

  // 获取数据
  $scope.getData = function () {
    var url = '/header/getContactInfo';
    httpService.getRequest(url, $rootScope.getParamsData({})).then(function (res) {
      if (res.success) {
        $scope.contactInfo = res.data;
      }
    });
  };
  $scope.getData();

  // 投诉
  $scope.formData = {
    'content': ''
  };
  $scope.doSuggest = function () {
    if (!validateFormField($scope.formData.content)) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入投诉内容'
      });
      return
    }
    var url = '/header/commitComplaintSuggest';
    httpService.postRequest(url, $rootScope.getParamsData($scope.formData)).then(function (res) {
      if (res.success) {
        var confirmPopup = $ionicPopup.confirm({
          title: 'EGE数联·生态',
          template: '提交成功',
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
