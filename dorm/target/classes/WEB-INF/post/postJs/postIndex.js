/*
* @Author: name
* @Date:   2019-04-20 13:54:38
* @Last Modified by:   name
* @Last Modified time: 2019-04-20 15:28:19
*/


$(function () {

    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd',//显示格式
        todayHighlight: 1,//今天高亮
        minView: "month",//设置只显示到月份
        startView:2,
        forceParse: 0,
        showMeridian: 1,
        autoclose: 1,//选择后自动关闭
        locale: moment.locale('zh-cn')
    });
    $('#datetimepicker2').datetimepicker({
        format: 'YYYY-MM-DD hh:mm',
        locale: moment.locale('zh-cn')
    });

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
        $('#tb_posts').bootstrapTable({
            url: 'http://localhost:8080/dorm/post/getPostsWithSearch',            //请求后台的URL（*）
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
                field: 'post_id',
                title: '公告号',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'title',
                title: '标题',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }
            // , {
            //     field: 'content',
            //     title: '内容',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // }
            // , {
            //     field: 'remark',
            //     title: '备注',
            //     align: 'center',
            //     valign: 'middle',
            //     formatter: (value, row, index) => {
            //         return value;
            //     }
            // }
            , {
                field: 'create_id',
                title: '创建人',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'create_time',
                title: '创建时间',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'release_id',
                title: '发布人',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'release_time',
                title: '发布时间',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'start_time',
                title: '开始时间',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }, {
                field: 'end_time',
                title: '结束时间',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    return value;
                }
            }
            ,{
                field: 'del_mark',
                title: '删除标记',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case 0:
                            return '未删除';
                            break;
                        case 1:
                            return '已删除';
                            break;
                        // case 2:
                        //     return '未知';
                        //     break;
                        default:
                            return '未知';

                    }
                }
            },{
                field: 'type',
                title: '公告类型',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case 1:
                            return '宿舍通知公告';
                            break;
                        case 2:
                            return '宿舍维修公告';
                            break;
                        case 3:
                            return '宿舍财务公告';
                            break;
                        default:
                            return '未知';

                    }
                }
            },{
                field: 'status',
                title: '公告状态',
                align: 'center',
                valign: 'middle',
                formatter: (value, row, index) => {
                    switch (value){
                        case 1:
                            return '新建';
                            break;
                        case 2:
                            return '待审核';
                            break;
                        case 3:
                             return '已发布';
                             break;
                        case 4:
                             return '已关闭';
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
            postId: $("#txt_search_postId").val(),
            title: $("#txt_search_title").val(),
            createId: $("#txt_search_createId").val(),
            createTime: $("#datetimepicker_createTime").val(),
            releaseId: $("#txt_search_releaseId").val(),
            releaseTime: $("#datetimepicker_releaseTime").val(),
            startTime: $("#datetimepicker_startTime").val(),
            endTime: $("#datetimepicker_endTime").val(),
            type: $("#opreate_select_type").val(),
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
        $("#btn_query_postId").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_title").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_createId").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_createTime").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_releaseId").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_releaseTime").bind('click', function() {
            searchBtn ();
        });
        $("#btn_query_startAndEndTime").bind('click', function() {
            //startTime: $("#datetimepicker_startTime").val(),
            //endTime: $("#datetimepicker_endTime").val(),
            var satrtTimeStr = $("#datetimepicker_startTime").val();
            var endTimeStr = $("#datetimepicker_endTime").val();
            if (satrtTimeStr>endTimeStr){
                layer.msg("结束时间不能小于开始时间");
            }else{
                searchBtn ();
            }
        });
        $("#btn_query_type").bind('click', function() {
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
    $('#tb_posts').bootstrapTable('refresh');
}