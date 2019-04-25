/*
* @Author: name
* @Date:   2019-04-18 21:01:14
* @Last Modified by:   name
* @Last Modified time: 2019-04-25 09:39:25
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
        $('#tb_students').bootstrapTable({
            url: 'http://localhost:8080/dorm/student/getStudentsWithSearch',            //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded;charset=utf-8",//post请求的话就加上这个句话
            //contentType: "application/json;charset=utf-8",
            dataType:"json",
            crossDomain: true,
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: true,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParamsType: "limit",
            queryParams: oTableInit.queryParams,//传递参数（*）
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
            uniqueId: "student_id",                     //每一行的唯一标识，一般为主键列
            showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [{
                checkbox: true
            }, {
                field: 'student_id',
                title: '学号',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
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
                title: '学生姓名',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'sex',
                title: '性别',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case 0:
                            return '男生';
                            break;
                        case 1:
                            return '女生';
                            break;
                        // case 2:
                        //     return '未知';
                        //     break;
                        default:
                            return '未知';

                    }
                }
            },{
                field: 'tel',
                title: '联系电话',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'mail',
                title: '邮箱',
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
                title: '专业年纪',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            },{
                field: 'status',
                title: '在宿状态',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case 1:
                            return '在宿舍';
                            break;
                        case 2:
                            return '请假';
                            break;
                        case 3:
                             return '退宿';
                             break;
                        case 4:
                             return '放假';
                             break;
                        case 6:
                             return '待入宿';
                             break;
                        default:
                            return '未知';

                    }
                }
            },
            {
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
            delMark: $("#opreate_select_del_mark").val(),
            StudentId: $("#txt_search_studentId").val(),
            name: $("#txt_search_name").val(),
            roomId: $("#txt_search_roomId").val(),
            academy: $("#opreate_select_academy").val(),
            school: $("#opreate_select_school").val(),
            status: $("#opreate_select_status").val(),
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
        $("#btn_query_studentId").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_roomId").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_name").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_academy").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_school").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_status").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_del_mark").bind('click', function() {
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
    $('#tb_students').bootstrapTable('refresh');
}