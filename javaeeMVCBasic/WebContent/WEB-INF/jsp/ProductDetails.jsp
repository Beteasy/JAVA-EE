<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML> <!-- 以后尽量写满足H5要求的页面 -->
<html>
<head>
	<title>保存商品</title>
	<style type="text/css">@import url(/javaeeMVCBasic/css/main.css);</style>
</head>
<body>
<div id="global">
    <h4>商品保存</h4>
    <p>
        <h5>详情:</h5>
        商品名称: ${product.name}<br/>
        商品描述: ${product.description}<br/>
        商品价格: $${product.price}
    </p>
</div>
</body>
</html>