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
    <style type="text/css">
        #contain-box{
            width: 1000px;
        }

        #nav-content{
            margin-top: 40px;
        }

        #form-box{
            width: 600px;
        }

    </style>
</head>
<body>
        <div id="contain-box" class="center-block">
            <div class="clearfix">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">账户列表</a></li>
                    <li><a href="#">账户新增</a></li>
                </ul>
            </div>

            <div id="nav-content">
                <div id="form-box" class="center-block">
                    <form role="form" action="${request.contextPath}/index/add/handle">
                        <div class="form-group">
                            <label for="exampleInputEmail1">账户编码</label>
                            <input type="text" name="num" class="form-control" id="exampleInputEmail1" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">账户名称</label>
                            <input type="text" name="name" class="form-control" id="exampleInputEmail1" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">账户备注</label>
                            <input type="text" name="remark" class="form-control" id="exampleInputEmail1" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">账户密码</label>
                            <input type="password" name="password" class="form-control" id="exampleInputEmail1" placeholder="">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">账户状态</label>
                            <select name="status" class="form-control">
                                <option value="0">冻结状态</option>
                                <option value="1">激活状态</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">账号类型</label>
                            <select name="role" class="form-control">
                                <option value="0">普通会员</option>
                                <option value="1">VIP</option>
                                <option value="2">SVIP</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">注册时间</label>
                            <input type="text" class="form-control" name="createtime" value="1984-10-23 21:09" />
                        </div>

                        <input type="hidden" name="token" value="${token}">
                        <button type="submit" class="btn btn-default center-block">新增</button>
                    </form>
                </div>
            </div>
        </div>



        <script type="text/javascript">
            $(function() {

                $('input[name="createtime"]').daterangepicker({
                    "singleDatePicker": true,
                    "showDropdowns": true,
                    "timePicker": true,
                    "timePickerIncrement": 60,
                    "timePicker24Hour": true,
                    "autoApply": true,
                    "locale": {
                        "format": "YYYY-MM-DD HH:mm",
                        "applyLabel": "确定",
                        "cancelLabel": "取消",
                        "daysOfWeek": [
                            "周日",
                            "周一",
                            "周二",
                            "周三",
                            "周四",
                            "周五",
                            "周六"
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
                    "startDate": moment().format("YYYY-MM-DD HH:mm"),
                    "maxDate": moment().format("YYYY-MM-DD HH:mm"),
                    "opens": "center"
                }, function(start, end, label) {
                    console.log("New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')");
                });

            });
        </script>

</body>
</html>