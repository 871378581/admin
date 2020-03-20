var setupWx = function (data, shareData) {
  var wxData = shareData.wxData;
  wx.config({
    debug: true,
    appId: data.appId,
    timestamp: data.timestamp,
    nonceStr: data.nonceStr,
    signature: data.signature,
    jsApiList: [
      'checkJsApi',
      'onMenuShareAppMessage',
      'onMenuShareTimeline',
      'startRecord',
      'stopRecord',
      'onVoiceRecordEnd',
      'playVoice',
      'pauseVoice',
      'stopVoice',
      'onVoicePlayEnd',
      'uploadVoice',
      'downloadVoice',"getLocation","openLocation"
    ]
  });


  wx.error(function (res) {
    //alert(JSON.stringify(res));
  });


  wx.ready(function () {
    // 分享给朋友
    wx.onMenuShareAppMessage({
      title: wxData.title, // 分享标题
      desc: wxData.desc, // 分享描述
      link: wxData.link, // 分享链接
      imgUrl: wxData.imgUrl, // 分享图标
      type: '', // 分享类型,music、video或link，不填默认为link
      dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
      success: function () {
      },
      cancel: function () {
        // 用户取消分享后执行的回调函数
      }
    });

    // 分享到朋友圈
    wx.onMenuShareTimeline({
      title: wxData.desc, // 分享标题
      link: wxData.link, // 分享链接
      imgUrl: wxData.imgUrl, // 分享图标
      success: function () {

      },
      cancel: function () {
        // 用户取消分享后执行的回调函数
      }
    });
  });
};

var token;

window.wxShareSetup = function (shareData) {
  var url = encodeURI(location.href.split('#')[0]);
  $.ajax({
    url: '/ege/api/wechat/js/share/post',
    type: 'POST',
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify({'url': url}),
    success: function (respond) {
      console.log(respond);
      token = respond;
      setupWx(token, shareData);
    },
    error: function (jqXHR, textStatus, errorThrown) {
      console.log('网路错误，请稍后再试！');
    }
  });
};
