<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>商品</title>
		<style type="text/css">@import url(css/main.css);</style>
	</head>
	<body>
		<div id="global">
    		<h4>商品保存</h4>
		    <p>
		        <h5>商品详情:</h5>
		        商品名称: ${product.name}<br/>
		        商品描述: ${product.description}<br/>
		        商品价格: $${product.price}
		    </p>
	</body>
</html>