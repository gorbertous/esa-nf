$(function() {

	//chapter tables
	let tables = ["11", "21", "22", "23", "24", "25", "26", "31", "32", "33", "34", "51", "52", "53", "54", "70", "71", "72", "73", "74",
		"81", "82", "83", "84", "851", "852", "86", "87", "88", "89", "810", "811", "812", "813", "8140", "8141", "8142", "8150", "8151", "8152", "8161", "8162", "8163",
		"8164", "817", "818", "91", "92", "93","94","95", "96","971","972","981","982"];
	for (let i = 0; i < tables.length; i++) {

		$("#export" + tables[i]).click(function(e) {
			e.preventDefault();
			var table_id = tables[i].substring(0, 1) + "." + tables[i].substring(1);
			var table_title = "Chapter " + "Table " + table_id;
			var file_name = "Table-" + table_id + "-" + new Date().toISOString().replace(/[\-\:\.]/g, "") + ".xls";
			var table = $("#table" + tables[i]);
			if (table && table.length) {
				$(table).table2excel({
					exclude: ".noExl",
					name: table_title,
					filename: file_name,
					fileext: ".xls",
					exclude_img: true,
					exclude_links: true,
					exclude_inputs: true,
					preserveColors: false
				});
			}
		});
	}

});