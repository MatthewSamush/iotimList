

var $ = require('jQuery');



	$(document).ready(function() {
		if($(".statusText").innerHtml() == "Done"){
			$(".statusBlock").css("background-color","green");
		}
	});
