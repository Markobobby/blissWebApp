$(function(){
	$("#selectRoomSubmit").on("click", function(e){
		e.preventDefault();
		var url = "/blissWebApp/ajaxRequest/monitoringmachine", 
			idSalle = $("#roomSelected option:selected").val(),
			param = {idSalle : idSalle};
		if($(".load").length) $(".load").remove();
		$("form").after("<div class='load'></div>");
		
		$.post(url, param, function(data){
			console.log("ajax");
			console.log(data);
			$(".load").html(data);
		}).fail(function(jqXhr, txtStatut){
			console.log("Ajax fail");
			console.log(jqXhr);
			$(".load").html(jqXhr.responseText);
		});
	});
});