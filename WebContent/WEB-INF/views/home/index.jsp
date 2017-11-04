<%@include file="/WEB-INF/includes/header.jsp"%>
<form method="post" action="#" id="formSalle">
	<span>Choississez votre salle :</span>
	<select id="roomSelected" name="nomSalle" class="form-control">
		<c:forEach items="${model}" var="salle">
			<option value="${salle.idSalle }">${salle.nomSalle}</option>
		</c:forEach>
	</select>
	<input type="submit" id="selectRoomSubmit" value="valider"  class="btn btn-primary">
</form>
<%@include file="/WEB-INF/includes/footer.jsp"%>