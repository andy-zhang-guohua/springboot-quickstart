<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>自定义错误展示页面</title>
    <style type="text/css">
        h1 {
            color: red
        }

        p {
            color: blue
        }
    </style>
</head>
<body>
<h1>自定义错误展示页面(Freemarker视图)</h1>
<div id="content">
    <p>遇到异常:${exception!}</p>
    <p>看到此页面时，也请注意当前响应的状态字</p>
</div>
</body>
<script type="text/javascript">

</script>
</html>
