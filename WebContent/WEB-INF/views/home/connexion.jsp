<%@include file="/WEB-INF/includes/header.jsp"%>
<div id="connexion">
	<form id="connexionForm" method="post">
		<table>
			<tr>
				<td><label>Login :</label></td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td><label>password :</label></td>
				<td><input type="password" name="pwd"> </td>
			</tr>
		</table>		
		<input type="submit" value="valider">
	</form>	
</div>
<%@include file="/WEB-INF/includes/footer.jsp"%>