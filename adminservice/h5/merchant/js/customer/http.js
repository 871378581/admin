ionicApp.service("httpService", function ($http, $rootScope, $q, $ionicLoading, requestContext) {
  var sendRequest = function (config) {
    var deferred = $q.defer();//$q一种内置服务，它可以使你异步地执行函数，并且当函数执行完成时它允许你使用函数的返回值（或异常）。
    //$q.defer()  可以创建一个deferred实例（延迟对象实例）。
    $http(config).then(function (response) {
      var result = response.data;
      if (result.resultCode != undefined && result.resultCode != 0 && result.resultCode != 1) {
        $ionicLoading.show({
          template: result.resultDesc,
          noBackdrop: true,
          duration: 2000
        });
      }
      deferred.resolve(response.data);
    }, function (error) {
      deferred.reject(error);
    });
    return deferred.promise; //通过deferred延迟对象，可以得到一个承诺promise，而promise会返回当前任务的完成结果
  };
  //所有GET请求
  this.getRequest = function (url, params) {
    var config = {
      // 'headers':{'Content-Type': 'application/x-www-form-urlencoded'},
      // 'transformRequest': function(obj) {
      //   var str = [];
      //   for(var p in obj){
      //     str.push(encodeURIComponent(p) + "=" + encodeURIComponent(obj[p]));
      //   }
      //   return str.join("&");
      // },
      method: "GET",
      url: requestContext + url,
      params: params ? params : []
    };
    return sendRequest(config);
  };
  //所有POST请求
  this.postRequest = function (url, data) {
    var config = {
      method: "POST",
      url: requestContext + url,
      data: data
    };
    return sendRequest(config);
  };
});

/*ionicApp.config(function($httpProvider) {
  $httpProvider.defaults.headers.put['Content-Type'] = 'application/x-www-form-urlencoded';
  $httpProvider.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
  $httpProvider.defaults.transformRequest = [function(data) {
    var param = function(obj) {
      var query = '';
      var name, value, fullSubName, subName, subValue, innerObj, i;
      for (name in obj) {
        value = obj[name];
        if (value instanceof Array) {
          for (i = 0; i < value.length; ++i) {
            subValue = value[i];
            fullSubName = name + '[' + i + ']';
            innerObj = {};
            innerObj[fullSubName] = subValue;
            query += param(innerObj) + '&';
          }
        } else if (value instanceof Object) {
          for (subName in value) {
            subValue = value[subName];
            fullSubName = name + '[' + subName + ']';
            innerObj = {};
            innerObj[fullSubName] = subValue;
            query += param(innerObj) + '&';
          }
        } else if (value !== undefined && value !== null) {
          query += encodeURIComponent(name) + '='
            + encodeURIComponent(value) + '&';
        }
      }
      return query.length ? query.substr(0, query.length - 1) : query;
    };
    return angular.isObject(data) && String(data) !== '[object File]' ? param(data) : data;
  }];
});*/
