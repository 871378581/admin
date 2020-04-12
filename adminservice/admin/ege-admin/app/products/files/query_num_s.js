           function IdentityCodeValid(code) {
            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
            var tip = "";
            var pass= true;
             var  reg = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
            if(!code || !reg.test(code)){
                tip = "身份证号格式错误";
                pass = false;
            }

           else if(!city[code.substr(0,2)]){
                tip = "地址编码错误";
                pass = false;
            }
            else{
                //18位身份证需要验证最后一位校验位
                if(code.length == 18){
                    code = code.split('');
                    //∑(ai×Wi)(mod 11)
                    //加权因子
                    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                    //校验位
                    var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                    var sum = 0;
                    var ai = 0;
                    var wi = 0;
                    for (var i = 0; i < 17; i++)
                    {
                        ai = code[i];
                        wi = factor[i];
                        sum += ai * wi;
                    }
                    var last = parity[sum % 11];
                    if(parity[sum % 11] != code[17]){
                        tip = "身份证号格式错误";
                        pass =false;
                    }
                }
            }
            if(!pass) {


                alert(tip);
                return true;

            }
        }
           function checkName(str) {
               var reg = /^[\u4e00-\u9fa5]{2,4}$/i;
               if (!reg.test(str)) {
                   return true
               }
           }

        function summit_form() {
            var union = $('#union').val();
            var user_name = $('#certName').val();
            var id_card = $('#certNo').val();
            var mobile = $('#mobilePhone').val();
            var sel_city = $('#city').val();
            var addr_detail = $('#address').val();
            var addr = sel_city + addr_detail;
            var pt = /^0?1[3|4|5|6|7|8|9][0-9]\d{8}$/;
            var otherGoods = $('input[name="otherGoods"]:checked').val();
            var qq = $('#qq').val();


            if (!pt.test(mobile)) {

                alert('请输入正确的联系号码');
                return false;

            }
            // else if (addr.length>=50 ||!addr) {
            //
            //     alert('请正确输入地址');
            //     return false;
            //
            // }
            // else if(/^[0-9]+$/.test(addr_detail)){
            //     alert('详细地址填写有误');
            //     return false;
            // }
            // else if(!sel_city){
            //
            //      alert('请点击选取省市区县');
            //     return false;
            //
            // }

            // else if (addr_detail.length>=50 ||!addr_detail || addr_detail.length<6) {
            //
            //     alert('请输入正确的详细地址');
            //     return false;
            //
            // }
            else if(checkName(user_name)){

               alert("姓名必须至少包含两个汉字");
                return false;

            }
            // else if(IdentityCodeValid(id_card)){
            //
            //     return false;
            //
            // }

            else if (typeof(otherGoods) == "undefined") {
                alert("请选择一张王卡");
                return false;
            }

            postData = {
                "union": union,
                "certName": user_name,
                "contractPhone": mobile,
                "certId": id_card,
                //"addr": addr,
                "otherGoods": otherGoods,
                "qq": qq
            };


            $("#summit_btn").hide();
            $.showLoading('请稍后');
            $.ajax({
                type: "POST",
                url: "/channel/sendInfo",
                data: postData,
                success: function (msg) {

                    $("#summit_btn").show();
                    $.hideLoading();

                    if(msg.code === 1){
                        //alert('下单成功，我们将尽快为您配送，请留意陌生号码的短信或者来电哦~');
                        location.href=msg.data
                    }else{
                        alert(msg.msg);
                    }

                }
                }
            )
        }


  function summit_form_front(){


    var number = '';
    $('input:checkbox[name=checkboox]:checked').each(function(k){
    if(k == 0){
        number = $(this).val();
    }else{
        number += ','+$(this).val();
    }
    })

    if(number == '1'){

        summit_form();

    }else{

        alert('请您阅读入网协议');

    }



}
