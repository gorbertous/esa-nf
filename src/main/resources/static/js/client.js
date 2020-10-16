(function($) {
	"use strict";

	// This will capture hash changes while on the page
	$(window).on("hashchange", function() {
		offsetAnchor();
	});


	// The function actually applying the offset
	function offsetAnchor() {
		if (location.hash.length !== 0) {
			sessionStorage.setItem("currenturl_hash_change", window.location.href);
			window.scrollTo(window.scrollX, window.scrollY - 100);
//			alert(sessionStorage.getItem("currenturl_hash_change"));
		}
	}

	// Set the offset when entering page with hash present in the url
	window.setTimeout(offsetAnchor, 0);

	// set active class on clicked element
	$("#layoutSidenav_nav .nav .nav-link").on("click", function(e) {

		var somehash = e.target.hash;

		var url = e.target.href;

		if (url !== void (0)) {

			var chapterId = url.substring(
				url.lastIndexOf("view/") + 5,
				url.lastIndexOf("/")
			);

			sessionStorage.setItem("chapter_id", chapterId);
			sessionStorage.setItem("currenturl_hash_change", url);
			
			
			//set timeout for collapse elements
			if (this.classList.contains('collapsed')) {
			    
				var tID = setTimeout(function () {
		            location.href = url;
		            clearTimeout(tID);		// clear time out.
		        }, 500);
			}

		}

		if (somehash !== void (0)) {

			var hash_id = somehash.substring(2);
			$(".nav").find(".active").removeClass("active");

			if (this.id === hash_id) {

				sessionStorage.setItem("anchor_id", this.id);
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
	var selected_link = 0
	if (sessionStorage.getItem("anchor_id") !== void (0)) {
		
		selected_link = sessionStorage.getItem("anchor_id");
		if(selected_link > 0){
			$("#" + selected_link).addClass("active");
		}

	}

	// expand chapter elements based on clicked chapter id
	var expand_id = 0
	if (sessionStorage.getItem("chapter_id") !== void (0)) {
		expand_id = sessionStorage.getItem("chapter_id");
		if(expand_id > 0){
			$("#ch" + expand_id + "collapsePages").addClass("show");
		}
	}
	

})(jQuery);



