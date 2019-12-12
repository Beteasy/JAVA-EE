<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<title>商品添加成功</title>
	</head>
	<body>
	<div id="global">
	    <h4>商品添加成功</h4>
	    <p>
	        <h5>商品详情</h5>
	        商品名称: ${product.name}<br/>
	        商品描述: ${product.description}<br/>
	        商品价格: $${product.price}
	    </p>
	</div>
	</body>
</html>