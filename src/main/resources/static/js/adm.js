(function($) {
	"use strict";

	// set active class on clicked element
//	$("#layoutSidenav_nav .nav .nav-link").on("click", function() {
//		$(".nav").find(".active").removeClass("active");
//		$(this).addClass("active");
//
//	});
	
	var current = location.pathname;
    $('#layoutSidenav_nav .nav .nav-link').each(function(){
        var $this = $(this);
        // if the current path is like this link, make it active
        if($this.attr('href').indexOf(current) !== -1){
            $this.addClass('active');
        }
    })

	// Toggle the side navigation
	$("#sidebarToggle").on("click", function(e) {
		e.preventDefault();
		$("body").toggleClass("sb-sidenav-toggled");
	});


})(jQuery);



