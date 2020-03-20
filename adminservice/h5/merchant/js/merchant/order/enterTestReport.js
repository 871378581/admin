ionicApp.controller("enterTestReportController", function ($scope, $rootScope, $stateParams,
                                                           $ionicScrollDelegate, $http, httpService, requestContext,
                                                           $ionicLoading, $ionicPopup) {

  if (location.hash.indexOf("?") >= 0) {
    var params = getRequest2();
    if (params.orderId) {
      var detail = {'orderId': params.orderId};
      $rootScope.goState('enterTestReport', {data: JSON.stringify(detail)});
    }
  }

  var stateParams = $stateParams.data;
  if (stateParams) {
    var parsedData = JSON.parse(stateParams);
    if (parsedData.orderId) {
      $scope.orderId = parsedData.orderId;
      localStorage.orderId = $scope.orderId;
    }
    $scope.orderStatus = parsedData.orderStatus;
    $scope.childStatus = parsedData.childStatus;
    $scope.reportId = parsedData.reportId;
  } else {
    $scope.orderId = localStorage.orderId;
  }

  $scope.btnList = [
    {
      'img': 'img2/order/enterTestReport/btn-cd.png',
      'name': '灯光',
      'keyword': 'dengguang',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-jy.png',
      'name': '机油',
      'keyword': 'jiyou',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-jl.png',
      'name': '机滤',
      'keyword': 'jilv',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-hhs.png',
      'name': '火花塞',
      'keyword': 'huohuasai',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-fdy.png',
      'name': '防冻液',
      'keyword': 'fangdongye',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-jqm.png',
      'name': '节气门',
      'keyword': 'jieqimen',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-bsxy.png',
      'name': '变速箱油',
      'keyword': 'biansuxiangyou',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-scy.png',
      'name': '刹车油',
      'keyword': 'shacheyou',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-pd.png',
      'name': '皮带',
      'keyword': 'pidai',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-scp.png',
      'name': '刹车盘',
      'keyword': 'shachepan',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-lt.png',
      'name': '轮胎',
      'keyword': 'luntai',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-scp2.png',
      'name': '刹车片',
      'keyword': 'shachepian',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-dp.png',
      'name': '电瓶',
      'keyword': 'dianping',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-kt.png',
      'name': '空调',
      'keyword': 'kongtiao',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-dp2.png',
      'name': '底盘',
      'keyword': 'dipan',
      'result': null,
      'show': false
    },
    {
      'img': 'img2/order/enterTestReport/btn-byjy.png',
      'name': '保养建议',
      'keyword': 'baoyangjianyi',
      'result': null,
      'show': false
    }
  ];
  $scope.process = 0;// 检测输入进度
  $scope.showSelectResult = false;

  // 获取已提交的检测报告
  function getTestReportData() {
    var formData = {
      'order_id': $scope.orderId
    };
    var url = '/testItem/getTestItem';
    httpService.postRequest(url, $rootScope.getParamsData(formData)).then(function (res) {
      if (res.success) {
        var detail = res.data;
        if (detail && detail.report_items) {
          $scope.formData = detail.report_items;
            for (var i = 0; i < $scope.formData.length; i++) {
                if ($scope.formData[i].result !== null) {
                    $scope.process++;
                }
            }
        }else{
            setTestReportDataNull();
        }

      } else {
        $ionicPopup.alert({
          title: 'EGE数联·生态',
          template: res.errorMessage
        });
      }
    });
  }

  function setTestReportDataNull() {
    $scope.formData = [
      {
        "mainCategoryName": "dengguang",
        "mainCategoryDisplayName": "灯光",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "xingchedeng",
            "entryDisplayName": "行车灯",
            "entryValue": "正常",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "jinguangdeng",
            "entryDisplayName": "近光灯",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "yuanguangdeng",
            "entryDisplayName": "远光灯",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "bianguang",
            "entryDisplayName": "变光",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "zuoyouzhuanxiangdeng",
            "entryDisplayName": "左右转向灯",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "shanshuobaojingzhishideng",
            "entryDisplayName": "闪烁报警指示灯",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "qianwudeng",
            "entryDisplayName": "前雾灯",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "qianzhucheleida",
            "entryDisplayName": "前驻车雷达",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "yugua",
            "entryDisplayName": "雨刮",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "dadengqingxizhuagnzhi",
            "entryDisplayName": "大灯清洗装置",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "jiyou",
        "mainCategoryDisplayName": "机油",
        "result": null,
        "photos": "",
        "remark": "",
        "entryValue": "正常",
        "subCategoryList": [
          {
            "entryName": "fangyoulaing",
            "entryDisplayName": "放油量",
            "entryValue": "",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "jiajiyou",
            "entryDisplayName": "加机油",
            "entryValue": "",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "jilv",
        "mainCategoryDisplayName": "机滤",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "jiujianpinpai",
            "entryDisplayName": "旧件品牌",
            "entryValue": "",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "xinjianpinpai",
            "entryDisplayName": "新件品牌",
            "entryValue": "",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "huohuasai",
        "mainCategoryDisplayName": "火花塞",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "mushijiance",
            "entryDisplayName": "目视检测",
            "entryValue": "正常",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "dianhuoxianquan",
            "entryDisplayName": "点火线圈",
            "entryValue": "正常",
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "fangdongye",
        "mainCategoryDisplayName": "防冻液",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "phzhi",
            "entryDisplayName": "PH值",
            "entryValue": null,
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": "参考值7-9.5"
          },
          {
            "entryName": "bingdian",
            "entryDisplayName": "冰点",
            "entryValue": null,
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": "参考值-68摄氏度— -15摄氏度"
          },
          {
            "entryName": "feidian",
            "entryDisplayName": "沸点",
            "entryValue": null,
            "title": "",
            "result": true,
            "range": "",
            "standardRefer": "参考值>105摄氏度"
          }
        ]
      },
      {
        "mainCategoryName": "jieqimen",
        "mainCategoryDisplayName": "节气门",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "kaidujiancha",
            "entryDisplayName": "开度检查",
            "title": "",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": "参考范围1.6—5.0"
          }
        ]
      },
      {
        "mainCategoryName": "biansuxiangyou",
        "mainCategoryDisplayName": "变速箱油",
        "result": null,
        "photos": "",
        "remark": "",
        "entryValue": "正常",
        "subCategoryList": [
          {
            "entryName": "lengtai",
            "entryDisplayName": "冷态",
            "title": "油尺刻度位置",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "retai",
            "entryDisplayName": "热态",
            "title": "油尺刻度位置",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "shacheyou",
        "mainCategoryDisplayName": "刹车油",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "shuihanliang",
            "entryDisplayName": "水含量",
            "title": "",
            "entryValue": null,
            "result": false,
            "range": "",
            "standardRefer": "参考值0.5%—2.5%"
          },
          {
            "entryName": "ganfeidian",
            "entryDisplayName": "干沸点",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值205-207摄氏度"
          },
          {
            "entryName": "shifeidian",
            "entryDisplayName": "湿沸点",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值170-190摄氏度"
          }
        ]
      },
      {
        "mainCategoryName": "pidai",
        "mainCategoryDisplayName": "皮带",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "zhangjindu",
            "entryDisplayName": "张紧度",
            "title": "",
            "entryValue": "正常",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "shachepan",
        "mainCategoryDisplayName": "刹车盘",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "zuoqianlun",
            "entryDisplayName": "左前轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": ">=3毫米为强制更换"
          },
          {
            "entryName": "zuohoulun",
            "entryDisplayName": "左后轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": ">=3毫米为强制更换"
          },
          {
            "entryName": "youqianlun",
            "entryDisplayName": "右前轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": ">=3毫米为强制更换"
          },
          {
            "entryName": "youhoulun",
            "entryDisplayName": "右后轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": ">=3毫米为强制更换"
          }
        ]
      },
      {
        "mainCategoryName": "luntai",
        "mainCategoryDisplayName": "轮胎",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "zuoqianlun_neice",
            "entryDisplayName": "左前轮",
            "title": "内侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "zuoqianlun_waice",
            "entryDisplayName": "左前轮",
            "title": "外侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "zuohoulun_neice",
            "entryDisplayName": "左后轮",
            "title": "内侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "zuohoulun_waice",
            "entryDisplayName": "左后轮",
            "title": "外侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "youqianlun_neice",
            "entryDisplayName": "右前轮",
            "title": "内侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "youqianlun_waice",
            "entryDisplayName": "右前轮",
            "title": "外侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "youhoulun_neice",
            "entryDisplayName": "右后轮",
            "title": "内侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "youhoulun_waice",
            "entryDisplayName": "右后轮",
            "title": "外侧",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          },
          {
            "entryName": "zuoqianlun3",
            "entryDisplayName": "左前轮",
            "title": "胎压",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值：2.3-2.5之间"
          },
          {
            "entryName": "zuohoulun3",
            "entryDisplayName": "左后轮",
            "title": "胎压",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值：2.3-2.5之间"
          },
          {
            "entryName": "youqianlun3",
            "entryDisplayName": "右前轮",
            "title": "胎压",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值：2.3-2.5之间"
          },
          {
            "entryName": "youhoulun3",
            "entryDisplayName": "右后轮",
            "title": "胎压",
            "entryValue": null,
            "result": false,
            "range": "",
            "standardRefer": "参考值：2.3-2.5之间"
          }
        ]
      },
      {
        "mainCategoryName": "shachepian",
        "mainCategoryDisplayName": "刹车片",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "zuoqianlun2",
            "entryDisplayName": "左前轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "<=1.6毫米为强制更换"
          },
          {
            "entryName": "zuohoulun2",
            "entryDisplayName": "左后轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "<=1.6毫米为强制更换"
          },
          {
            "entryName": "youqianlun2",
            "entryDisplayName": "右前轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "<=1.6毫米为强制更换"
          },
          {
            "entryName": "youhoulun2",
            "entryDisplayName": "右后轮",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "<=1.6毫米为强制更换"
          }
        ]
      },
      {
        "mainCategoryName": "dianping",
        "mainCategoryDisplayName": "电瓶",
        "result": null,
        "photos": "",
        "remark": "",
        "entryValue": "正常",
        "subCategoryList": [
          {
            "entryName": "dianya",
            "entryDisplayName": "电压",
            "title": "",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "kongtiao",
        "mainCategoryDisplayName": "空调",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "gaoya",
            "entryDisplayName": "高压",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值1400-1600kpa"
          },
          {
            "entryName": "diya",
            "entryDisplayName": "低压",
            "title": "",
            "entryValue": null,
            "result": true,
            "range": "",
            "standardRefer": "参考值150-250kpa"
          }
        ]
      },
      {
        "mainCategoryName": "dipan",
        "mainCategoryDisplayName": "底盘",
        "result": null,
        "photos": "",
        "remark": "底盘的文字描述",
        "entryValue": "正常",
        "subCategoryList": [
          {
            "entryName": "dipan2",
            "entryDisplayName": "底盘",
            "title": "",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      },
      {
        "mainCategoryName": "baoyangjianyi",
        "mainCategoryDisplayName": "保养建议",
        "result": null,
        "photos": "",
        "remark": "",
        "subCategoryList": [
          {
            "entryName": "baoyangjianyi2",
            "entryDisplayName": "保养建议",
            "title": "",
            "entryValue": "",
            "result": true,
            "range": "",
            "standardRefer": ""
          }
        ]
      }
    ];
  }

  getTestReportData();
  // if ($scope.reportId) { // 已提交过检测报告
  //   getTestReportData();
  // } else if (localStorage['historyTestReport' + $scope.orderId]) { // 已输入过检测报告
  //   $scope.formData = JSON.parse(localStorage['historyTestReport' + $scope.orderId]);
  //   for (var i = 0; i < $scope.formData.length; i++) {
  //     if ($scope.formData[i].result !== null) {
  //       $scope.process++;
  //     }
  //   }
  // } else { // 输入检测报告
  //   setTestReportDataNull();
  // }

  $scope.selectedIndex = -1;
  $scope.showInputPage = false;
  // 更改输入页
  $scope.changeInputPage = function (index) {
    if (!$scope.formData) {
      setTestReportDataNull();
    }
    if (index !== null) {
      $scope.selectedIndex = index;
      $scope.btnList[index].show = true;
      if ($scope.formData[$scope.selectedIndex].photos.length > 0) {
        $scope.fileList = $scope.formData[$scope.selectedIndex].photos.split(",");
      } else {
        $scope.fileList = [];
      }
      if($scope.formData[$scope.selectedIndex].entryValue==='正常'){
        $scope.formData[$scope.selectedIndex].result = true;
      } else {
        $scope.formData[$scope.selectedIndex].result = false;
      }
      $scope.showInputPage = true;
    } else {
      switch ($scope.formData[$scope.selectedIndex].mainCategoryName) {
        case "dengguang":
        case "huohuasai":
        case "pidai":
          $scope.formData[$scope.selectedIndex].result = true;
          for (var i = 0; i < $scope.formData[$scope.selectedIndex].subCategoryList.length; i++) {
            if (!$scope.formData[$scope.selectedIndex].subCategoryList[i].result) {
              $scope.formData[$scope.selectedIndex].result = false;
              break;
            }
          }
          break;
        case "jiyou":
        case "biansuxiangyou":
        case "dianping":
        case "dipan":
          for (var i = 0; i < $scope.formData[$scope.selectedIndex].subCategoryList.length; i++) {
            var item = $scope.formData[$scope.selectedIndex].subCategoryList[i];
            if (!item.entryValue || item.entryValue === "") {
              $ionicPopup.alert({
                title: 'EGE数联·生态',
                template: '请输入所有检测项'
              });
              return;
            }
          }
          break;
        case "jilv":
        case "baoyangjianyi":
          $scope.formData[$scope.selectedIndex].result = true;
          for (var i = 0; i < $scope.formData[$scope.selectedIndex].subCategoryList.length; i++) {
            var item = $scope.formData[$scope.selectedIndex].subCategoryList[i];
            if (!item.entryValue || item.entryValue === "") {
              $ionicPopup.alert({
                title: 'EGE数联·生态',
                template: '请输入所有检测项'
              });
              return;
            }
          }
          break;
        case "fangdongye":
        case "jieqimen":
        case "shacheyou":
        case "shachepan":
        case "luntai":
        case "shachepian":
        case "kongtiao":
          $scope.formData[$scope.selectedIndex].result = true;
          for (var i = 0; i < $scope.formData[$scope.selectedIndex].subCategoryList.length; i++) {
            var item = $scope.formData[$scope.selectedIndex].subCategoryList[i];
            if (!item.entryValue || item.entryValue === "") {
              $ionicPopup.alert({
                title: 'EGE数联·生态',
                template: '请输入所有检测项'
              });
              return;
            }
            switch (item.entryName) {
              case "phzhi":
                setRangeResult(item, 7, 9.5);
                break;
              case "bingdian":
                setRangeResult(item, -68, -15);
                break;
              case "feidian":
                setRangeResult(item, 105, null);
                break;
              case "kaidujiancha":
                setRangeResult(item, 1.6, 5);
                break;
              case "shuihanliang":
                setRangeResult(item, 0.5, 2.5);
                break;
              case "ganfeidian":
                setRangeResult(item, 205, 207);
                break;
              case "shifeidian":
                setRangeResult(item, 170, 190);
                break;
              case "zuoqianlun":
              case "zuohoulun":
              case "youqianlun":
              case "youhoulun":
                setRangeResult2(item, 0, 3);
                break;
              case "zuoqianlun_neice":
              case "zuoqianlun_waice":
              case "zuohoulun_neice":
              case "zuohoulun_waice":
              case "youqianlun_neice":
              case "youqianlun_waice":
              case "youhoulun_neice":
              case "youhoulun_waice":
                setRangeResult2WithMultiVal(item, 1.6, null);
                break;
              case "zuoqianlun3":
              case "zuohoulun3":
              case "youqianlun3":
              case "youhoulun3":
                setRangeResult(item, 2.3, 2.5);
                break;
              case "zuoqianlun2":
              case "zuohoulun2":
              case "youqianlun2":
              case "youhoulun2":
                setRangeResult2(item, 1.6, null);
                break;
              case "gaoya":
                setRangeResult2(item, 1400, 1600);
                break;
              case "diya":
                setRangeResult2(item, 150, 250);
                break;
            }
          }
          break;
        default:
          break;
      }
      localStorage['historyTestReport' + $scope.orderId] = JSON.stringify($scope.formData);
      $scope.btnList[$scope.selectedIndex].show = false;
      $scope.showInputPage = false;
      // 设置检测进度
      $scope.process = 0;
      for (var i = 0; i < $scope.formData.length; i++) {
        if ($scope.formData[i].result !== null) {
          $scope.process++;
        }
      }
      $scope.saveData(null);
    }
  };

  // 不带边界
  function setRangeResult(item, minValue, maxValue) {
    if (minValue !== null && parseFloat(item.entryValue) < minValue) {
      item.result = false;
      item.range = "low";
      $scope.formData[$scope.selectedIndex].result = false;
    } else if (maxValue !== null && parseFloat(item.entryValue) > maxValue) {
      item.result = false;
      item.range = "high";
      $scope.formData[$scope.selectedIndex].result = false;
    } else {
      item.result = true;
    }
  }

  // 带边界
  function setRangeResult2(item, minValue, maxValue) {
    if (minValue !== null && parseFloat(item.entryValue) <= minValue) {
      item.result = false;
      item.range = "low";
      $scope.formData[$scope.selectedIndex].result = false;
    } else if (maxValue !== null && parseFloat(item.entryValue) >= maxValue) {
      item.result = false;
      item.range = "high";
      $scope.formData[$scope.selectedIndex].result = false;
    } else {
      item.result = true;
    }
  }

  // 带边界,多值，逗号分割，只要又一个不满足，就整体不满足
  function setRangeResult2WithMultiVal(item, minValue, maxValue) {
    if (item.entryValue) {
      var list = item.entryValue.split(",");
      for (var i = 0; i < 3; i++) {
        var entryVal = (list[i]);
        if (minValue !== null && entryVal <= minValue) {
          item.result = false;
          item.range = "low";
          $scope.formData[$scope.selectedIndex].result = false;
          return;
        } else if (maxValue !== null && entryVal >= maxValue) {
          item.result = false;
          item.range = "high";
          $scope.formData[$scope.selectedIndex].result = false;
          return;
        }
      }
    }
    item.result = true;
  }

  // 选择输入项
  $scope.selectedInputItem = null;
  $scope.fileList = [];
  $scope.toSelectResult = function (item, hasOwnValue) {
    $scope.selectedInputItem = item;
    $scope.hasOwnValue = hasOwnValue;
    $scope.showSelectResult = true;
  };
  // 选择输入项实况图片上传
  $scope.addFile = function () {
    $("#pictureFile").click();
  };
  $scope.removeFile = function (index) {
    $scope.fileList.remove(index);
    $scope.formData[$scope.selectedIndex].photos = $scope.fileList.join(",");
  };
  $scope.uploadFile = function () {
    var sendData = new FormData();
    var files = document.querySelector('#pictureFile').files;
    if (files && files.length > 0) {
      sendData.append('file', files[0]);
    }
    // 执行上传
    $ionicLoading.show({
      template: '图片上传中...'
    });
    $http({
      method: "POST",
      url: ROOT_URL + "/file/upload",
      data: sendData,
      headers: {'Content-Type': undefined},
      transformRequest: angular.identity
    }).then(function (res) {
      $ionicLoading.hide();
      var data = res.data;
      $scope.fileList.push(data.url);
      $scope.formData[$scope.selectedIndex].photos = $scope.fileList.join(",");
      $("#pictureFile").val("");
    }, function error() {
      $ionicLoading.hide();
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '图片上传失败'
      });
    });
  };

  $scope.result = null;
  // 选择检查结果
  $scope.selectResult = function (bo) {
    $scope.result = bo;
  };
  $scope.confirmResult = function (bo) {
    if (bo) {
      $scope.selectedInputItem.result = $scope.result;
      if (!$scope.hasOwnValue) {
        if ($scope.result) {
          $scope.selectedInputItem.entryValue = "正常";
        } else {
          $scope.selectedInputItem.entryValue = "不正常";
        }
      } else {
        if ($scope.result) {
          $scope.selectedInputItem.tempValue = "正常";
        } else {
          $scope.selectedInputItem.tempValue = "不正常";
        }
      }
    }
    $scope.result = null;
    $scope.hasOwnValue = false;
    $scope.showSelectResult = false;
  };

  $scope.saveData = function (index) {
    /*if ($scope.process !== 16) {
      $ionicPopup.alert({
        title: 'EGE数联·生态',
        template: '请输入全部的检测项'
      });
      return
    }*/
    var exception = false;
    for (var i = 0; i < $scope.formData.length; i++) {
      if ($scope.formData[i].result === false) {
        exception = true;
        break;
      }
    }
    var formData = {
      'report_have_exception': exception,
      'order_id': $scope.orderId,
      'report_items': JSON.stringify($scope.formData)
    };
    var url = '/testItem/submitTestItem';
    $ionicLoading.show({
      template: '提交中...'
    });
    httpService.postRequest(url, formData).then(function (res) {
      $ionicLoading.hide();
      if (res.success) {
        $ionicLoading.hide();
        if (index !== null) {
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
        }
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
