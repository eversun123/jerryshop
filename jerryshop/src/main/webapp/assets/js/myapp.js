$(function() {

	// solving the active menu problem
	switch (menu) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if (menu == 'Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_' + menu).addClass('active');
		break;
	}
});

var jsonUrl = '';
if (window.categoryId == '') {
	jsonUrl = window.contextRoot + '/json/data/all/products';
} else {
	jsonUrl = window.contextRoot + '/json/data/' + window.categoryId
			+ '/product';
}

var $table = $('#productListTable');
function formatNumber(n) {
    return n.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

if ($table.length) {

	console.log('Inside the table');

	$table.DataTable({
		lengthMenu : [ [ 3, 5, 10, -1 ],
				[ '3 records', '5 records', '10 records', 'All' ] ],
		pageLength : 5,
		ajax : {

			url : jsonUrl,
			dataSrc : ''
		},
		columns : [ {
			data : 'name'
		}, {
			data : 'brand'
		}, {
			data : 'unitPrice',
			mRender : function(data, type, row) {
				return '&#65509;' + data;
			}
		}, {
			data : 'quantity'
		} ]
	});
}
