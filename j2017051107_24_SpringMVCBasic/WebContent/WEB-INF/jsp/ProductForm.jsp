<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>添加商品</title>
	</head>
	<body>
	<div id="global">
		<form action="product_save.action" method="post">
		    <fieldset>
		        <legend>添加一个商品</legend>
		            <p>
		                <label for="name">商品名称: </label>
		                <input type="text" id="name" name="name" 
		                    tabindex="1">
		            </p>
		            <p>
		                <label for="description">商品描述: </label>
		                <input type="text" id="description" 
		                    name="description" tabindex="2">
		            </p>
		            <p>
		                <label for="price">商品价格: </label>
		                <input type="text" id="price" name="price" 
		                    tabindex="3">
		            </p>
		            <p id="buttons">
		                <input id="reset" type="reset" tabindex="4">
		                <input id="submit" type="submit" tabindex="5" 
		                    value="添加商品">
		            </p>
		    </fieldset>
		</form>
	</div>
	</body>
</html>