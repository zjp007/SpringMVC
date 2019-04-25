/*
* @Author: name
* @Date:   2019-04-18 14:25:35
* @Last Modified by:   name
* @Last Modified time: 2019-04-18 15:14:42
*/
var userId = GetRequest ();
$.ajax({
    //getUser
    url: 'http://localhost:8080/dorm/user/getUser',
    type: 'POST',
    dataType: 'json',
    data: userId,
})
.done(function(data) {
    $("#txt_id").val(data.id);
    $('#txt_id').attr("readonly",true);
    $("#txt_userId").val(data.user_id);
    $('#txt_userId').attr("readonly",true);
    $("#txt_name").val(data.name);
    $('#txt_name').attr("readonly",true);
    $("#opreate_select_operate").val(data.operate);
    //disabled="disabled"
    $('#opreate_select_operate').attr("disabled","disabled");
    console.log("success");
})
.fail(function() {
    console.log("error");
})
.always(function() {
    console.log("complete");
});

function GetRequest() {
   var url = location.search; //获取url中"?"符后的字串
   var theRequest = new Object();
   if (url.indexOf("?") != -1) {
      var str = url.substr(1);
      strs = str.split("&");
      for(var i = 0; i < strs.length; i ++) {
         theRequest[strs[i].split("=")[0]]=unescape(strs[i].split("=")[1]);
      }
   }
   return theRequest;
}