<%@include file="/WEB-INF/includes/header.jsp"%>
<div id="connexion">
	<form id="connexionForm" method="post" action="#">
	
		<div class="col-sm-4">
				<label class="col-sm-2 col-form-label">Login:</label>			
				<input type="text" name="mail" class="form-control">
		
				<label class="col-sm-2 col-form-label">password:</label></td>
				<input type="password" name="pwd" class="form-control">
	
		<input type="submit" id="connectionButtonValider"class="btn btn-primary" value="valider">
		</div>
	</form>	
</div>
<div id="messageCo">

</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>