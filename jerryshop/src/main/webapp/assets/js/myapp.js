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
	jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId
			+ '/products';
}

var $table = $('#productListTable');

if ($table.length) {

	console.log('Inside the table');

	$table
			.DataTable({
				lengthMenu : [ [ 3, 5, 10, -1 ],
						[ '3 records', '5 records', '10 records', 'All' ] ],
				pageLength : 5,
				ajax : {

					url : jsonUrl,
					dataSrc : ''
				},
				columns : [
						{
							data : 'code',
							mRender : function(data, type, row) {
								return '<img src="' + window.contextRoot
										+ '/resources/images/' + data
										+ '.jpg" class = "dataTableImg"/>';
							}
						},
						{
							data : 'name'
						},
						{
							data : 'brand'
						},
						{
							data : 'unitPrice',
							mRender : function(data, type, row) {
								return '&#65509;' + data;
							}
						},
						{
							data : 'quantity',
							mRender : function(data, type, row) {
								if (data < 1)
									return '<span style="color:red">Out of Stock!</span>';
								return data;
							}
						},
						{
							data : 'id',
							bSortable : false,
							mRender : function(data, type, row) {

								var str = '';
								// str+='<a
								// href="'+window.contextRoot+'/show/'+data+'product">View</a>';
								// str+='<a
								// href="'+window.contextRoot+'/cart/add/'+data+'product">Add
								// to cart</a>';
								str += '<a href="'
										+ window.contextRoot
										+ '/show/'
										+ data
										+ '/product" class="btn btn-primary"><span class = "glyphicon glyphicon-eye-open"></span>View</a> &#160;';
								if (row.quantity < 1) {
									str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></span></a>';

								} else {
									str += '<a href="'
											+ window.contextRoot
											+ '/cart/add/'
											+ data
											+ '/product" class ="btn btn-success"><span class = "glyphicon glyphicon-shopping-cart"></span></a>';

								}

								return str;
							}
						}

				]
			});
}
