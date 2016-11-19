<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${request.contextPath}/css/bootstrap.min.css">
    <style>
        #login-box{
            width: 400px;
            padding: 50px 80px;
            margin-top: 80px;
            border: solid 1px #cccccc;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <div id="login-box" class="center-block">
        <form role="form" action="${request.contextPath}/login/handle">
            <div class="form-group">
                <label for="exampleInputEmail1">用户编码</label>
                <input type="text" name="num" class="form-control" id="exampleInputEmail1" placeholder="">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">密码</label>
                <input type="password" name="pwd" class="form-control" id="exampleInputPassword1" placeholder="">
            </div>
            <button type="submit" class="btn btn-default center-block">登陆</button>
        </form>
    </div>


</body>
</html>