<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<!-- <meta http-equiv="Cotnent-Type" content="text/html; charset=utf-8" /> -->
	<title>添加商品Add Product Form</title>
	<style type="text/css">@import url(/javaeeMVCBasic/css/main.css);</style>
</head>
<body>

<div id="global">
<form action="product_save.action" method="post">
	<fieldset>
		<legend>添加商品Add a product</legend>
			<p>
			    <label for="name">商品名称Product Name: </label>
				<input type="text" id="name" name="name" 
				    tabindex="1">
            </p>
            <p>
			    <label for="description">商品描述Description: </label>
				<input type="text" id="description" 
				    name="description" tabindex="2">
			</p>
            <p>
    			<label for="price">商品价格Price: </label>
				<input type="text" id="price" name="price" 
				    tabindex="3">
			</p>
			<p id="buttons">
				<input id="reset" type="reset" tabindex="4">
				<input id="submit" type="submit" tabindex="5" 
				    value="添加商品Add Product">
			</p>
	</fieldset>
</form>
</div>
</body>
</html>
