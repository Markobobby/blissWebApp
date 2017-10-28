<%@include file="/WEB-INF/includes/header.jsp"%>
<form method="post" action="#">
	<span>Choississez votre salle :</span>
	<select id="roomSelected" name="nomSalle">
		<c:forEach items="${model}" var="salle">
			<option value="${salle.idSalle }">${salle.nomSalle}</option>
		</c:forEach>
	</select>
	<input type="submit" id="selectRoomSubmit" value="valider">
</form>
<%@include file="/WEB-INF/includes/footer.jsp"%>