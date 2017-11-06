<%@include file="/WEB-INF/includes/header.jsp"%>
<!-- 
<div id="connexion">
	<form id="connexionForm" method="post" action="#">
	
		<div class="col-sm-4">
				<label class="col-sm-2 col-form-label">Login:</label>			
				<input type="text" class="form-control">
		
				<label class="col-sm-2 col-form-label">password:</label></td>
				<input type="password"  class="form-control">
	
		<input type="submit" id="connectionButtonValider"class="btn btn-primary" value="valider">
		</div>
	</form>	
</div>
<div id="messageCo">

</div>
-->
<form class="form-signin"  method="post">
  <h2 class="form-signin-heading">Please sign in</h2>
  <label for="inputEmail" class="sr-only">Email address</label>
  <input type="text"  name="mail" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
  <label for="inputPassword" class="sr-only">Password</label>
  <input type="password" name="pwd" id="inputPassword" class="form-control" placeholder="Password" required>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
</form>

<%@include file="/WEB-INF/includes/footer.jsp"%>