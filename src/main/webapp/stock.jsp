<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gestion de stock</title>
<link href="<%=request.getContextPath()+"/style.css"%>"rel="stylesheet">

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
 

<table border="1">
<tr>
<th>Reference</th>
<th>Quantite</th>
<th>DateApprovisionnement</th>
</tr>
<c:forEach var="variable1" items="${listearticle}">
 
 <tr>
   <td><c:out value="${variable1.reference}"></c:out></td>
   <td> <c:out value="${variable1.quantite}"/></td>
   <td> <c:out value="${variable1.dateApprovisionnement}"/></td>
  </tr>
  
 </c:forEach>

</table>
<!-- Chercher une reference si elle existe et voir sa quantite  -->
<form method ="post" action="<%=request.getContextPath()%>/listerStockServlet" class="tab_rech">
<input type="text" name="reference"required>
<input type="submit" value="ok">
</form>

<table border="1" class="tab_rech">
<tr>
<th>Reference</th>
<th>Quantite</th>
</tr>
<c:forEach var="art" items="${articles}">
<tr>
   <td><c:out value="${art.reference}"></c:out></td>
   <td> <c:out value="${art.quantite}"/></td>
  
  </tr>
  </c:forEach>
</table>
</body>
</html>