<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<span class="icon-cancel-squared" title="Fermer"></span>
<div class="contentAgent">
	<c:if test="${empty model}"><span>Il n'y a pas de poste pour cette salle</span></c:if>
	
	<c:forEach items="${model}" var="machine" varStatus="status">
		<div class="agent" data-id-machine="${ machine.idMachine }">
			<span>${machine.nomMachine}</span>
			<div class="icon-desktop"></div>
			<div class="urlMachine">
				<span>IP :</span>
				<span>${machine.urlMachine}</span>
			</div>
			<div class="ramMachine">
				<span>RAM :</span>
				<span>${machine.ram}</span>
			</div>
			<div class="disqueMachine">
				<span>Disque :</span>
				<span>${machine.disque}</span>
			</div>
			<c:if test="${machine.dateDernierRecut < 60}">
				<c:if test="${machine.etat > '0'}">
					<div class="alert alert-success">
						<i class="icon-check"></i>
						<span>${machine.message}</span>	
					</div>
				</c:if>
				<c:if test="${machine.etat == '0'}">
					<div class="alert alert-warning">
						<i class="icon-attention-alt"></i>
						<span>${machine.message}</span>
					</div>
				</c:if>
			</c:if>
			<c:if test="${machine.dateDernierRecut > 60}">
				<div class="alert alert-warning">
					<i class="icon-attention"></i>
					<span>Machine Down !</span>
				</div>
			</c:if>
		</div>
	</c:forEach>	
</div>