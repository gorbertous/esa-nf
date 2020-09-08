(function($) {
	"use strict";
	
//	$('#layoutSidenav_nav').collapse({
//  toggle: false
//})

	// set active class on clicked element
	$("#layoutSidenav_nav .nav .nav-link").on("click", function() {

//		$('.nav-item').not(this).each(function(a, b){
//    $(b).find('div.collapse.show').each(function(x, y) {
//        $(this).removeClass('show');
//    });
//  });
		var somehash = event.target.hash;

		if (somehash === void (0)) {
			var hash_id = 100;
		} else {
			var hash_id = somehash.substring(2);
		}


		$(".nav").find(".active").removeClass("active");
		if (this.id === hash_id) {

			window.sessionStorage.setItem("anchor_id", this.id);
			$(this).addClass("active");
		}

	});

	// Toggle the side navigation
	$("#sidebarToggle").on("click", function(e) {
		e.preventDefault();
		$("body").toggleClass("sb-sidenav-toggled");
	});

	// code for popups on terms, footnotes
	$('[data-toggle="popover"]').popover({
		html: true
	});

	// add active to sidebar navigation link
	var selected_link = window.sessionStorage.getItem("anchor_id");
	$("#" + selected_link).addClass("active");

})(jQuery);

