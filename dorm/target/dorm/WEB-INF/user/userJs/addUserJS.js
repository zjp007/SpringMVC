/*
* @Author: name
* @Date:   2019-04-17 18:34:34
* @Last Modified by:   name
* @Last Modified time: 2019-04-18 15:53:19
*/

function addUserButtonSubmit (){
    var id = '';
    var user_id = '';
    var name = '';
    var password = '';
    var passwordAgain = '';
    var operate = '';
    var spare01 = '';
    var spare02 = '';
    var spare03 = '';
    var spare04 = '';
    id = $("#txt_id").val();
    user_id = $("#txt_userId").val();
    name = $("#txt_name").val();
    password = $("#txt_password").val();
    operate = $("#opreate_select_operate").val();
    passwordAgain = $("#txt_password_again").val();
    if (id == "" || id == '' || id == undefined){
        layer.msg("请输入序号");
    }else{
        if (user_id == "" || user_id == '' || user_id == undefined){
            //window.alert("请输入用户账号！");
            layer.msg("请输入用户账号！");
        }else{
            if (name == "" || name == '' || name == undefined){
                layer.msg("请输入姓名！");
            }else{
                if (password == "" || password == '' || password == undefined){
                    layer.msg("请输入密码！");
                }else{
                    if (passwordAgain == "" || passwordAgain == '' || passwordAgain == undefined){
                        layer.msg("请再次输入密码！");
                    }else{
                        if (password!=passwordAgain&&password!=''&&passwordAgain!=''&&user_id!=''&&name!=''){
                        layer.msg("密码输入不正确！");
                        //window.alert("密码输入不正确！");
                        }else{
                            var params = "{'id': '" + id + "','user_id': '" + user_id + "','name': '" + name + "','password': '" + password + "','operate': " + operate + ",'spare01': '" + spare01 + "','spare02': '" + spare02 + "','spare03': '" + spare03 + "','spare04': '" + spare04 + "'}";
                            var userBaseOrder = "\"userBaseOrder\": " + params;
                            console.log("params : " + params);
                            console.log("userBaseOrder : " + userBaseOrder);
                            $.ajax({
                            url: 'http://localhost:8080/dorm/user/insertUser?userBaseOrder=' + params,
                            type: 'POST',
                            dataType: 'json',
                            //data: params,
                            })
                            .done(function() {
                                // setTimeout(function (){
                                //     layer.msg("添加成功")
                                // },1000);
                                setTimeout(function (){
                                     window.location.href = "file:///D:/Study/Eclipse/eclipseJeePhoton/Works/dorm/src/main/webapp/WEB-INF/user/html/userList.html"
                                 },1000);
                                layer.msg("添加成功");
                                console.log("success");
                            })
                            .fail(function() {
                                console.log("error");
                            })
                            .always(function() {
                                console.log("complete");
                            });
                        }
                    }
                }
            }
        }
}
}

function button_back (){
    //layer.msg("mmmmmm");
    window.location.href = "file:///D:/Study/Eclipse/eclipseJeePhoton/Works/dorm/src/main/webapp/WEB-INF/user/html/userList.html";
}