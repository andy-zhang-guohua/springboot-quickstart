<html>
<body>
<h1>这是一个自定义的409错误演示页面</h1>
<div id='timestamp'>异常时间 : ${timestamp?string('yyyy.MM.dd HH:mm:ss')!}</div>
<div id='error'>错误 : ${error!}</div>
<div id='status'>状态字 : ${status!}</div>
<div id='message'>消息 : ${message!}</div>
<div id='trace'>trace : ${trace!}</div>
</body>
</html>