/*
* @Author: name
* @Date:   2019-04-11 12:38:15
* @Last Modified by:   name
* @Last Modified time: 2019-04-22 20:38:58
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
        $('#tb_rooms').bootstrapTable({
            //http://134.175.54.180:8080/
            url: 'http://localhost:8080/dorm/room/getRoomsWithSearch',            //请求后台的URL（*）
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
            uniqueId: "room_id",                     //每一行的唯一标识，一般为主键列
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
                field: 'room_id',
                title: '宿舍号',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'name',
                title: '宿舍名',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'electric',
                title: '电费余额',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'water',
                title: '水费余额',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'size',
                title: '宿舍容量',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'used',
                title: '已住人数',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'last',
                title: '可住人数',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'academy',
                title: '所属学院',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'school',
                title: '所属专业',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },
            // {
            //     field: 'condition',
            //     title: '卫生评分',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // },{
            //     field: 'attendance',
            //     title: '考勤评分',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // },
            {
                field: 'assets',
                title: '固定资产情况',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case true:
                            return '正常';
                            break;
                        case false:
                            return '异常';
                            break;
                        default :
                            return '未知';
                    }
                }
            },{
                field: 'build',
                title: '宿舍楼栋',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'floor',
                title: '宿舍楼层',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
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
                    var vans = "";
                    {
                        vans+="<a href='#' class='btn btn-primary btn-xs role='button'><i class='fa fa-pencil-square-o'></i>查看</a>";
                        vans+="<a href='#' class='btn btn-primary btn-xs' role='button'><i class='fa fa-pencil-square-o'></i>编辑</a>";
                        vans+="<a href='#' class='btn btn-primary btn-xs' role='button'><i class='fa fa-pencil-square-o'></i>删除</a>";
                    }
                    return vans;
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
            roomIdOrName: $("#txt_search_RoomIdOrName").val(),
            academy: $("#opreate_select_academy").val(),
            build: $("#opreate_select_build").val(),
            school: $("#opreate_select_school").val(),
            floor: $("#opreate_select_floor").val(),
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
        $("#btn_query_RoomIdOrName").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_academy").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_school").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_build").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_floor").bind('click', function() {
            searchBtn ();
        });
    };
    debugger;
    $("button[name='refresh']").text("刷新");
    $("button[name='toggle']").text("切换");
    $("button[aria-label='Columns']").css('height','34px');
    return oInit;
};


function searchBtn (){
    $('#tb_rooms').bootstrapTable('refresh');
    console.log("selectStr: " + $("#txt_search_nameOrUserId").val());
}