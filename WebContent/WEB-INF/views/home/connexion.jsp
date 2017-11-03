<%@include file="/WEB-INF/includes/header.jsp"%>
<div id="connexion">
	<form id="connexionForm" method="post" action="#">
		<table>
			<tr>
				<td><label>Login :</label></td>
				<td><input type="text" name="mail"></td>
			</tr>
			<tr>
				<td><label>password :</label></td>
				<td><input type="password" name="pwd"> </td>
			</tr>
		</table>		
		<input type="submit" value="valider">
	</form>	
</div>
<div id="messageCo">

</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>