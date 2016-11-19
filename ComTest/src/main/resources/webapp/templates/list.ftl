<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript" src="${request.contextPath}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${request.contextPath}/js/moment.min.js"></script>

    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/bootstrap.min.css">
    <script type="text/javascript" src="${request.contextPath}/js/daterangepicker.js"></script>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/daterangepicker.css" />
    <script type="text/javascript" src="${request.contextPath}/js/jquery.dataTables.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/jquery.dataTables.min.css" />
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/select2.min.css" />
    <script type="text/javascript" src="${request.contextPath}/js/select2.min.js"></script>
    <style type="text/css">
        #contain-box{
            width: 1000px;
        }

        #nav-content{
            margin-top: 40px;
            padding: 10px 0 80px;
        }

        #filter{
            padding: 10px 0;
            margin-bottom: 20px;
            border-top: solid 1px #cccccc;
            border-bottom: solid 1px #cccccc;
        }

        #filter ul{
            margin-bottom: 0;
            list-style: none;
        }

        #filter ul li{
            margin-right: 20px;
        }

        #filter input,#filter select{
            height: 30px;
            text-align: center;
        }

        #status{
            width: 320px;
        }

    </style>
</head>
<body>
        <div id="contain-box" class="center-block">
            <div class="clearfix">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="${request.contextPath}/index/list">账户列表</a></li>
                    <li><a href="${request.contextPath}/index/add">账户新增</a></li>

                </ul>
            </div>

            <div id="nav-content">
                <div id="filter" class="clearfix">
                    <ul class="clearfix">
                        <li class="pull-left"><input id="status" type="text" readonly></li>
                        <li class="pull-left">
                            <select>
                                <option value="-1" selected>全部类型</option>
                                <option value="0">普通会员</option>
                                <option value="1">VIP</option>
                                <option value="2">SVIP</option>
                            </select>
                        </li>
                        <li class="pull-left"><input type="text" placeholder="搜索编码"></li>
                        <li class="pull-left"><input type="text" placeholder="搜索名字"></li>
                    </ul>


                </div>
                <table id="example" class="display" cellspacing="0" width="100%">
                    <thead>
                        <tr>
                            <th>编码</th>
                            <th>名称</th>
                            <th>备注</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>登录时间</th>
                            <th>账号类型</th>
                            <th>操作</th>
                        </tr>
                    </thead>

                    <tfoot>
                        <tr>
                            <th>编码</th>
                            <th>名称</th>
                            <th>备注</th>
                            <th>状态</th>
                            <th>创建时间</th>
                            <th>登录时间</th>
                            <th>账号类型</th>
                            <th>操作</th>
                        </tr>
                    </tfoot>

                    <tbody>
                        <tr>
                            <td>编码</td>
                            <td>名称</td>
                            <td>备注</td>
                            <td>状态</td>
                            <td>创建时间</td>
                            <td>登录时间</td>
                            <td>账号类型</td>
                            <td>操作</td>
                        </tr>
                        <tr>
                            <td>编码</td>
                            <td>名称</td>
                            <td>备注</td>
                            <td>状态</td>
                            <td>创建时间</td>
                            <td>登录时间</td>
                            <td>账号类型</td>
                            <td>操作</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>


        <button id="test">OK</button>

<script type="text/javascript">
    $(document).ready(function() {

        $('#status').daterangepicker({
            "singleDatePicker": false,
            "showDropdowns": true,
            "drops": "down",
            "timePicker": true,
            "timePicker24Hour": true,
            "locale": {
                "format": "YYYY-MM-DD HH:mm",
                "applyLabel": "确定",
                "cancelLabel": "取消",
                "daysOfWeek": [
                    "日",
                    "一",
                    "二",
                    "三",
                    "四",
                    "五",
                    "六"
                ],
                "monthNames": [
                    "一月",
                    "二月",
                    "三月",
                    "四月",
                    "五月",
                    "六月",
                    "七月",
                    "八月",
                    "九月",
                    "十月",
                    "十一月",
                    "十二月"
                ],
                "firstDay": 1
            },
            "alwaysShowCalendars": true,
            "linkedCalendars": true,
            "startDate": moment().subtract(1, "weeks").format("YYYY-MM-DD HH:mm"),
            "endDate": moment().format("YYYY-MM-DD HH:mm"),
            "minDate": moment().subtract(10, "years").format("YYYY-MM-DD HH:mm"),
            "maxDate": moment().format("YYYY-MM-DD HH:mm"),
            "opens": "right"
        }, function(start, end, label) {
            table.ajax.reload();
            console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
        });



        var table = $('#example').DataTable({
            columns: [
                {"name": "num", "data": "num", "searchable": true},
                {"name": "name", "data": "name", "searchable": true},
                {"name": "remark", "data": "remark", "searchable": false},
                {"name": "status", "data": "status", "searchable": false, "render": function ( data, type, full, meta) {
                    var status = ["冻结", "正常"];
                    return status[full['status']];
                }},
                {"name": "create", "data": "create", "searchable": false},
                {"name": "login", "data": "login", "searchable": false},
                {"name": "role", "data": "role", "searchable": false, "render": function ( data, type, full, meta) {
                    var roles = ["普通会员", "VIP", "SVIP"];
                    return roles[full['role']];
                }},
                {"searchable": false, "render": function ( data, type, full, meta) {
                    var rowId = full['DT_RowId'];
                    rowId = rowId.replace("row_", "");
                    var statusURL = "${request.contextPath}/index/status?id=" + rowId;
                    var modifyURL = "${request.contextPath}/index/modify?id=" + rowId;
                    var deleteURL = "${request.contextPath}/index/delete?id=" + rowId;
                    var statusOp = ["解封", "冻结"];
                    var template = "<a class='status-a' href='" + statusURL +"'>" + statusOp[full['status']] + "</a>|<a href='" + modifyURL +"'>修改</a>|<a class='delete-a' href='" + deleteURL + "'>删除</a>";
                    return template;
                }}
            ],
            //开启服务器模式
            serverSide: true,
            //数据来源（包括处理分页，排序，过滤） ，即url，action，接口，等等
            ajax: {
                "url": '${request.contextPath}/index/ajax',
                "type": "POST",
                "data": function (d) {
                    d.date = $("#status").val();
                    d.role = $("select").val();
                }
            },
            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            }
        });


        $("#example").on("draw.dt", function () {
            $(".status-a").click(function (e) {
                e.preventDefault();
                var target = $(e.target);
                var href = $(e.target).attr("href");
                $.ajax({
                    url: href,
                    async:false,
                    dataType: "text",
                    success: function (result) {
                        if (result > 0)
                            table.ajax.reload();
                    }
                });
            });
            $(".delete-a").click(function (e) {
                e.preventDefault();
                var target = $(e.target);
                var href = $(e.target).attr("href");
                $.ajax({
                    url: href,
                    async:false,
                    dataType: "text",
                    success: function (result) {
                        if (result > 0)
                            table.ajax.reload();
                    }
                });
            })
        });




        $("select").select2();

        $("select").on("select2:select", function (e) {
            table.ajax.reload();
        });


        function reload() {
            table.ajax.reload();
        }

        $("#test").click(function () {
//            var node = $("tr>td:last>a:eq(0)");
            var node = $("td>a");

            node.last().click(function (e) {
                alert("aaa");
                e.preventDefault();
            });

            console.log(node);
            alert(node.html())
        });





    });
</script>

</body>
</html>