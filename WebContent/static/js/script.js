$(function(){
	var timerIdentifier, jqXhrMonitoring ;
	
	$(".container").on("click", ".icon-cancel-squared", function(){
		$(".container .load").fadeOut();
		clearInterval(timerIdentifier);
		jqXhrMonitoring.abort();
	});
	$("#selectRoomSubmit").on("click", function(e){
		e.preventDefault();
		var url = "/blissWebApp/ajaxRequest/monitoringmachine", 
			idSalle = $("#roomSelected option:selected").val(),
			param = {idSalle : idSalle};
		if($(".load").length == 0)
			$("form").after("<div class='load'></div>");
		
		var i = 1;
		jqXhrMonitoring = $.post(url, param, function(data){
			var isVisible = $(".load").is(":visible");
			$(".load").html(data);
			if(!isVisible) $(".load").slideDown();
			i++;
		}).fail(function(jqXhr, txtStatut){
			console.log("Ajax fail");
			console.log(jqXhr);
			$(".load").html(jqXhr.responseText);
		});
		
		if(timerIdentifier != null){
			clearInterval(timerIdentifier);
		}
		timerIdentifier = setInterval(() => {
			console.log(i);
			$.post(url, param, function(data){
				var isVisible = $(".load").is(":visible");
				$(".load").html(data);
				if(!isVisible) $(".load").slideDown();
				i++;
			}).fail(function(jqXhr, txtStatut){
				console.log("Ajax fail");
				console.log(jqXhr);
				$(".load").html(jqXhr.responseText);
			});
		}, 300000);
		console.log("timeIdentifier");
		console.log(timerIdentifier);
	});
});