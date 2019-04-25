/*
* @Author: name
* @Date:   2019-04-11 12:38:15
* @Last Modified by:   name
* @Last Modified time: 2019-04-25 10:23:25
*/
$(function () {

    //1.初始化Table
    var oTable = new TableInit();
    oTable.Init();

    //2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();

});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#tb_users').bootstrapTable({
            url: 'http://localhost:8080/dorm/user/selectUser',            //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded;charset=utf-8",//post请求的话就加上这个句话
            //contentType: "application/json;charset=utf-8",
            dataType:"json",
            crossDomain: true,
            //async : false,
            //jsonp: "callback",
            //jsonpCallback:"showData",
            //rows : jsonpCallback.data.rows,
            //$('#tb_users').bootstrapTable('load', data.data),
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParamsType: "limit",
            queryParams: oTableInit.queryParams,//传递参数（*）
            // queryParams : function (params) {
            //         //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            //         var temp = {
            //             //callback:"result",
            //             limit: params.limit,                         //页面大小
            //             offset: (params.offset / params.limit),   //页码
            //             sort: params.sort,      //排序列名
            //             sortOrder: params.order, //排位命令（desc，asc）
            //             selectStr: $("#txt_search_nameOrUserId").val()
            //         };
            //         return temp;
            //     },
            responseHandler:function(result){
                if (result){
                    var  data = {"total":result.data.total,"rows":result.data.rows};
                    return data;
                }
                return result.data;
            },
            //dateType: "json",
            totalRows: 0,
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber:1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: true,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: false,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "user_id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            // ajax:function(params) {
            //     $.ajax({
            //         url:"http://localhost:8080/dorm/user/getAllUser",
            //         contentType: "application/json;charset=utf-8",
            //         type:"GET",
            //         dataType:"jsonp",
            //         //limit: params.limit,   //页面大小
            //         //offset: params.offset,  //页码
            //         //limit: params.data.limit, offset: params.data.offset
            //         data:{},
            //         async : false,//此处需要注意的是要想获取ajax返回的值这个async属性必须设置成同步的，否则获取不到返回值
            //         jsonp: "callback",//传递给请求处理程序或页面的，用以获得jsonp回调函数名的参数名(一般默认为:callback)
            //         //jsonpCallback:"showData",//自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名，也可以写"?"，jQuery会自动为你处理数据
            //         success:function(data){
            //             console.log(data);
            //             params.success({
            //                 rows : data.data.rows
            //             });
            //             $('#tb_users').bootstrapTable('load', data.data);
            //         },
            //         error:function(data){
            //             console.log(data);
            //         }
            //         })
            // },
            columns: [{
                checkbox: true
            }, {
                field: 'user_id',
                title: '用户账号',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'name',
                title: '用户名',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'operate',
                title: '权限级别',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case 1:
                            return '系统管理员';
                            break;
                        case 2:
                            return '宿舍管理员';
                            break;
                        case 3:
                            return '财务管理员';
                            break;
                        case 4:
                            return '维修管理员';
                            break;
                        case 5:
                            return '教师';
                            break;
                        case 6:
                            return '学生';
                            break;
                        case 7:
                            return '访客';
                            break;
                        default :
                            return '--';
                    }
                }
            }
            // , {
            //     field: 'spare01',
            //     title: '备用字段01',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // }, {
            //     field: 'spare02',
            //     title: '备用字段02',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // },{
            //     field: 'spare03',
            //     title: '备用字段03',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // },{
            //     field: 'spare04',
            //     title: '备用字段04',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // }
            ,{
                //field: 'operate',
                title: '操作',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    // var vans = "";
                    // vans+="<a href='#' class='btn btn-primary btn-xs role='button'><i class='fa fa-pencil-square-o'></i>查看</a>";
                    // vans+="<a href='#' class='btn btn-primary btn-xs' role='button'><i class='fa fa-pencil-square-o'></i>编辑</a>";
                    // vans+="<a href='#' class='btn btn-primary btn-xs' role='button'><i class='fa fa-pencil-square-o'></i>删除</a>";
                    // return vans;
                    var userId = row.user_id;
                    var result = "";
                    result += "<a href='javascript:;' class='btn btn-primary btn-xs green' role='button' onclick=\"lookViewById('" + userId + "', view='userView')\" title='查看'><i class='fa fa-pencil-square-o'>查看</i></a>";
                    result += "<a href='javascript:;' class='btn btn-primary btn-xs blue' onclick=\"EditViewById('" + userId + "', view='userEdit')\" title='编辑'><i class='fa fa-pencil-square-o'>编辑</i></a>";
                    result += "<a href='javascript:;' class='btn btn-primary btn-xs red' onclick=\"DeleteByIdsLayer('" + userId + "')\" title='删除'><i class='fa fa-pencil-square-o'>删除</i></a>";
                    return result;
                }
            }]
        });
    };

    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,                         //页面大小
            offset: (params.offset / params.limit),   //页码
            sort: params.sort,      //排序列名
            sortOrder: params.order, //排位命令（desc，asc）
            selectStr: $("#txt_search_nameOrUserId").val()
        };
        return temp;
    };
    return oTableInit;


};


var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};

    oInit.Init = function () {
        //初始化页面上面的按钮事件
        $("#btn_query").bind('click', function() {
            searchBtn ();
        });
        $("#btn_add").bind('click', function() {
            addUserButtonSubmit ();
        });
        //btn_delete
        $("#btn_delete").bind('click', function() {
            deleteBtn ();
        });
    };
    $("button[name='refresh']").text("刷新");
    $("button[name='toggle']").text("切换");
    $("button[aria-label='Columns']").css('height','34px');
    return oInit;
};


function searchBtn (){
    $('#tb_users').bootstrapTable('refresh');
    console.log("selectStr: " + $("#txt_search_nameOrUserId").val());
}
function deleteBtn (){
    layer.open({
        title:"提示",
        area:['325px'],
        content:"确定删除选中？",
        btn:['确定','取消'],
        yes:function(){
            layer.closeAll();
            var userList = [];
            userList = $('#tb_users').bootstrapTable('getSelections');
            var userIdList = [];
            if (userList.length>=1){
                for (var i = 0;i<userList.length;i++)
                {
                    userIdList.push(userList[i].user_id);
                    deleteByUserIdAJAX (userList[i].user_id);
                }
            }else{
                layer.msg("请选中一行");
            }
        },
        btn2:function(){
            layer.closeAll(); //关闭当前窗口
        }
    });
    console.log("userIdList: " + userIdList);
}
function addUserButtonSubmit (){
    window.location.href = "file:///D:/Study/Eclipse/eclipseJeePhoton/Works/dorm/src/main/webapp/WEB-INF/user/html/addUser.html";
}
function lookViewById (userId, view){
    window.location.href = "file:///D:/Study/Eclipse/eclipseJeePhoton/Works/dorm/src/main/webapp/WEB-INF/user/html/" + view + ".html?userId=" + userId;
}
function EditViewById (userId, view){
    window.location.href = "file:///D:/Study/Eclipse/eclipseJeePhoton/Works/dorm/src/main/webapp/WEB-INF/user/html/" + view + ".html?userId=" + userId;
}
function DeleteByIdsLayer (userId){
    layer.open({
        title:"提示",
        area:['325px'],
        content:"确定删除？",
        btn:['确定','取消'],
        yes:function(){
            layer.closeAll();
            deleteByUserIdAJAX (userId);
        },
        btn2:function(){
        layer.closeAll(); //关闭当前窗口
    }
    });
}
function deleteByUserIdAJAX (userId){
    $.ajax({
            url: 'http://localhost:8080/dorm/user/deleteUser',
            type: 'POST',
            dataType: 'json',
            data: {userId: userId},
            })
            .done(function() {
                $('#tb_users').bootstrapTable('refresh');
                setTimeout(function (){
                    layer.msg("删除成功")
                },1000);
            })
            .fail(function() {
                console.log("error");
            })
            .always(function() {
                console.log("complete");
            });
}