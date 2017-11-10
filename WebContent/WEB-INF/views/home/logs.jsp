<%@include file="/WEB-INF/includes/header.jsp"%>
<h3>Historique des erreurs :</h3>
<ul>
	<c:forEach items="${model}" var="m" >
		<li>Erreur sur la machine ${m.nomMachine} le ${m.date} : ${m.message}</li>
	</c:forEach>
</ul>
<%@include file="/WEB-INF/includes/footer.jsp"%>