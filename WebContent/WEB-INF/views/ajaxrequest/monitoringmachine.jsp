<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<span class="icon-cancel-squared" title="Fermer"></span>
<h3>Salle ${model[0].idSalle} :</h3>
<div class="contentAgent">
	<c:forEach items="${model}" var="machine" varStatus="status">
		<div class="agent" data-id-machine="${ machine.idMachine }">
			<span>${machine.nomMachine}</span>
			<div class="icon-desktop"></div>
			<c:if test="${machine.etat == '0'}">
				<div class="alert alert-success">
					<i class="icon-check"></i>
					<span>Ok</span>	
				</div>
			</c:if>
			<c:if test="${machine.etat > '0'}">
				<div class="alert alert-warning">
					<i class="icon-attention-alt"></i>
					<span>Warning</span>	
				</div>
			</c:if>
		</div>
	</c:forEach>	
</div>