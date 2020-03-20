ionicApp.controller("appointmentResultController", function ($scope, $rootScope, $stateParams,
                                                             $ionicScrollDelegate, $http, httpService, requestContext,
                                                             $ionicLoading, $timeout) {

  var stateParams = $stateParams.data;
  if (stateParams) {
    var parsedData = JSON.parse(stateParams);
    if (parsedData.orderId) {
      $scope.orderId = parsedData.orderId;
    }
  }

  $scope.changeState = function (state) {
    $rootScope.goState(state, {data: JSON.stringify({'orderId': $scope.orderId})})
  };

  $(document).ready(function () {
    $ionicLoading.hide();
  });

});
