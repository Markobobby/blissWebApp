$(function(){
	$(".container").on("click", ".icon-cancel-squared", function(){
		$(".container .load").fadeOut();
	});
	$("#selectRoomSubmit").on("click", function(e){
		e.preventDefault();
		var url = "/blissWebApp/ajaxRequest/monitoringmachine", 
			idSalle = $("#roomSelected option:selected").val(),
			param = {idSalle : idSalle};
		if($(".load").length == 0)
			$("form").after("<div class='load'></div>");
		
		
		$.post(url, param, function(data){
			var isVisible = $(".load").is(":visible");
			$(".load").html(data);
			if(!isVisible) $(".load").slideDown();
		}).fail(function(jqXhr, txtStatut){
			console.log("Ajax fail");
			console.log(jqXhr);
			$(".load").html(jqXhr.responseText);
		});
	});
});