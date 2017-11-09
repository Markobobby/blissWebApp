<%@include file="/WEB-INF/includes/header.jsp"%>
<h1>Changer une machine de salle</h1>
<div class="ui-widget ui-helper-clearfix" >
	<div id="listSalleout">
		<ul id="gallery" class="gallery ui-helper-reset ui-helper-clearfix">
			<c:forEach items="${model.machines}" var="m">
				<li class="ui-widget-content ui-corner-tr" id="${m.idMachine}">
					<h5 class="ui-widget-header">"${m.nomMachine}"</h5>
					<img src="" alt="${m.urlMachine}" width="96" height="72">
					<a href="" title="Détail" class="ui-icon ui-icon-zoomin">Détail</a>
					<a href="link/to/trash/script/when/we/have/js/off" title="Ajouter à la salle" class="ui-icon ui-icon-plus">Ajouter</a>
				</li>
			</c:forEach> 
		</ul>
	</div>
	<div id="trash" class="ui-widget-content ui-state-default">
		<select id="nomSalle" name="nom" size="1" onChange="chargerBase();">
			<c:forEach items="${model.salles}" var="m1">
		 		<option id="${m1.idSalle}">${m1.nomSalle}</option>
		 	</c:forEach>
		</select>
		<input type="button" value="Enregistrer la Salle" onclick="enregistrerSalle()">
		<div id="divSalle">
			<ul id="salleList" class="gallery ui-helper-reset"></ul>
		</div>
	</div> 
</div>
<script src="/blissWebApp/static/js/draganddrop.js" defer></script>
<%@include file="/WEB-INF/includes/footer.jsp"%>