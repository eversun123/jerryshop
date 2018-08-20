$(function(){
	
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
		if(menu=='Home')
			break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
});

var products =[
	
	['1','ABC'],
	['2','AaC'],
	['3','fBC'],
	['4','hBC'],
	['5','ABHC'],
	['6','ATC'],
	['7','AYC'],
]

var $table = $('#productListTable');

if($table.length){
	
	console.log('Inside the table');
	
	$table.DataTable({
		lengthMenu:[ [3,5,10,-1],['3 records','5 records','10 records','All']],
		pageLength:5,
		data: products
	});
}



