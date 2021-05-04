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
<!-- approvisionner le stock -->
<div class="container">
 <h3>improvisionner le stock</h3>
<form method ="post" action="<%=request.getContextPath()%>/servletstock">
<label for="reference">reference</label>
test
${ref }
<input type="text" name="reference" required >
<label for="quantite">quantite</label>
<input type="number" name="quantite" required >
<button type="submit" id="btn_enregistrer">Enregistrer</button>

 </form>
 
</div>
 <br><hr><br>

      
<!-- Chercher une reference si elle existe et voir sa quantite  -->

<form method ="post" action="<%=request.getContextPath()%>/listerStockServlet" class="tab_rech">
<h3>Chercher un produit dans le stock</h3>
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
       <input type="text" name="reference"required>
       <input type="submit" value="recherche" name="action">
  
</form>
    <br><hr><br>
   <!--AFFICHER LA LISTE DU STOCK  -->
<h3>liste des produits dans le stock</h3>
<table border="1">
   <tr>
      <th>Reference</th>
      <th>Quantite</th>
      <th>DateApprovisionnement</th>
      <th>supprimer</th>
      <th>modifier</th>
    </tr>

  <c:forEach var="variable1" items="${requestScope.listearticle}">
    <tr>
       <td><c:out value="${variable1.reference}"></c:out></td>
       <td><c:out value="${variable1.quantite}"/></td>
       <td><c:out value="${variable1.dateApprovisionnement}"/></td>
      <!--  <td><a href="<%=request.getContextPath()%>/SuppStock_servlet?action=supprimer&reference= ${variable1.reference}">supprimer</a></td>
       <td><a href="SuppStock_servlet?action=Update&reference=${variable1.reference}">modifier</a></td> -->
       
     </tr>
   </c:forEach>
</table>
      <br><hr><br>
   
<!--   <!--supprimer les articles du stock 
<div class="container">

<form method ="post" action="<%=request.getContextPath()%>/SuppStock_servlet">
 <h3>supprimer les articles </h3>
 <table border="1">
   <tr>
      <th>Reference</th>
      <th>Quantite</th>
      <th>DateApprovisionnement</th>
   </tr>
 <c:forEach var="variable2" items="${listearticle}">
<tr>
<td><input type="text" name="reference"required  value="${variable2.reference}"></td>
<td><input type="number" name="quantite"required value="${variable2.quantite}"></td>
<td><input type="date" name="dateApprovisionnement"required value="${variable2.dateApprovisionnement}"></td>
<td><input type="submit" value="supprimer" ></td>

</tr>
</c:forEach>
 </table>
 </form>
</div>  -->
   <!--modifier les articles du stock -->

<!-- <form method ="post" action="<%=request.getContextPath()%>/modifStock_servlet">
 <h3>modifier le stock </h3>
 <table border="1">
   <tr>
      <th>Reference</th>
      <th>Quantite</th>
      <th>DateApprovisionnement</th>
   </tr>
 <c:forEach var="variable2" items="${listearticle}">
<tr>
<td><input type="text" name="reference"required  value="${variable2.reference}"></td>
<td><input type="number" name="quantite"required value="${variable2.quantite}"></td>
<td><input type="date" name="dateApprovisionnement"required value="${variable2.dateApprovisionnement}"></td>
<td><input type="submit" value="modifier"></td>
</tr>
</c:forEach>
 </table>
</form>  -->
 <div class="container">
<h3>modifier /Supprimer les articles</h3>
 <table border="1">
   <tr>
      <th>Reference</th>
      <th>Quantite</th>
      <th>DateApprovisionnement</th>
      <th>modifier</th>
      <th>supprimer</th>
   </tr>
 <c:forEach var="variable2" items="${listearticle}">
    <tr>
                  <td>${variable2.reference}</td>
                  <td>${variable2.quantite}</td>
                  <td>${variable2.dateApprovisionnement}</td>
                  <td>
                      <a href="<%=request.getContextPath()%>/SuppStock_servlet?action=modifier&id=${variable2.id}&reference=${variable2.reference}&quantite=${variable2.quantite}"> 
                         modifier
                      </a>
                   </td>
                  <td>
                      <a href="<%= request.getContextPath()%>/SuppStock_servlet?action=supprimer&id=${variable2.id}">
                           supprimer
                      </a>
                   </td>
   </tr>
</c:forEach>
 </table>
 </div>
 
 <!-- saisir les modififcation-->
<div class="container">
 <h3>saisir les modififcations</h3>
<form method ="post" action="<%=request.getContextPath()%>/SuppStock_servlet">
<label for="reference">reference</label>

<input type="text" name="reference" required value="${ref}">
<label for="quantite">quantite</label>
<input type="number" name="quantite" required value="${qte}">
<button type="submit" id="btn_enregistrer">Enregistrer</button>

 </form>
 
</div>
   </body>
   </html>