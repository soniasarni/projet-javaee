<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gestion de stock</title>


</head>
<body>
<div class="container">
 
<form method ="post" action="<%=request.getContextPath()%>/servletstock">
<label for="reference">reference</label>
<input type="text" name="reference">
<label for="quantite">quantite</label>
<input type="number" name="quantite">
<button type="submit" id="btn_enregistrer">Enregistrer</button>
</form>
</div>


</body>
</html>