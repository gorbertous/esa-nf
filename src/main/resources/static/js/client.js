(function($) {
	"use strict";

	// set active class on clicked element
	$("#layoutSidenav_nav .nav .nav-link").on("click", function(e) {

		var somehash = e.target.hash;

		var url = e.target.href;

		var chapterId = url.substring(
			url.lastIndexOf("view/") + 5,
			url.lastIndexOf("/")
		);

		window.sessionStorage.setItem("chapter_id", chapterId);

		if (somehash !== void (0)) {

			var hash_id = somehash.substring(2);
			$(".nav").find(".active").removeClass("active");
			if (this.id === hash_id) {

				window.sessionStorage.setItem("anchor_id", this.id);
				$(this).addClass("active");
			}
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

	// expand chapter elements based on clicked chapter id
	var id = window.sessionStorage.getItem("chapter_id");
	$("#ch" + id + "collapsePages").addClass("show");

})(jQuery);

