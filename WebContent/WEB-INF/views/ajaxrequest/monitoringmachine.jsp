<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="monitoringMachine">
	<h1>Monitoring</h1>
	<c:forEach items="${model}" var="machine">
		<div>${machine.nomMachine}</div>
	</c:forEach>
</div>