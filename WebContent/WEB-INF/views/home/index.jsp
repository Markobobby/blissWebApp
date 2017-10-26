<span>Choississez votre salle :</span>



	<form method="post" action="#">
		<select name="nomSalle">
			<c:forEach items="${model.salle}" var="salle">
			<option value="${salle.idSalle }">${salle.nomSalle}</option>
			</c:forEach>
		</select>
		<input type="submit" value="valider">
	</form>
				<c:forEach items="${model.machine}" var="machine">
			<option value="${machine.idMachine }">${machine.nomMachine}</option>
			</c:forEach>
	
