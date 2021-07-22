/* 	Javascript:
	- tipizzazione NON forte
	- linguaggio di scripting (uso di tutti i metodi e variabli come se fossero static e public)
 */

/*
	Javascript permette di sfruttare le piene potenzialità del browser
	Verrà usato per costruire messaggi http personalizzati
	ciò ci permetterà di superare le limitazioni imposte dai FORM (no PUT, no DELETE)
*/

/*
	Sebbene javascript sia sufficiente per l'invio di richieste HTTP 
	Esiste un'altra tecnologia che rende il processo più semplice
	è una libreria javascript chiamata jQuery
*/

/*
	Il principio su cui si fonda il pattern che vedremo è semplice:
	Compilo una richiesta HTTP
	Chiedo al browser di mandarla al server (senza fare il refresh)
	tale richiesta si dirà asincrona
	il server risponderà.
	La risposta del server farà partire un trigger che permetterà l'aggiornamento della pagina
 */

var baseUrl = "http//:localhost:4202";
var apiUrl = baserUrl + "/productApis";

var apis;
var operationType =  [];

function getApis(){
	$.ajax({
		url: apiUrl,
		method: 'GET',
		error: function() {
			alert("Error :(")
		},
		success: function(data) {
			apis = data;
			showApisView();
		}
	});
}

function inList(operationList, operationElement) {
	for(let el of operationList){
		if(el.number == operationElement.number && el.text ==  operationElement.text)
			return true;
	}
	return false;
}

function showApisView() {
	let s = '';
	for(let api of operationTypes ){
		s+='<h4>' + opType + '</h4>';
		for(let api of api.productOperation[opType]) {
			if(opType == 'Sort')
			s+='<button>+api.description('+api.url+')+</button>';
			//alert(api.url);
		}
		
	}
	$("#operations").html(s);

}

function getProductApi(){
	
}

var products;

function getProducts(){
	//request http
	$.ajax({
		url: 'http://localhost:4202/products',
		method: 'GET',
		error: function() {
			alert("Error :(")
		},
		success: function(data) {
			products = data;
			showProducts();
		}
	});
}

function postProduct() {
	var pName = $('#name').val();
	var pBrand = $('#brand').val();
	var pCategory = $('#category').val();
	var pPrice = $('#price').val();
	var pAvailable = $('#available').is(":checked");
	var prod = new Product(0, pName, pBrand, pCategory, pPrice, pAvailable);
	$.ajax({
		method: 'POST',
		url: 'http://localhost:4202/product',
		data: JSON.stringify(prod),
		contentType: 'application/json',
		success: function() {getProducts()},
		error: function() {alert('Error :(')}
	});
}

function updateProduct(id) {
	var pId = $('#id_' + id).val();
	var pName = $('#name_' + id).val();
	var pBrand = $('#brand_' + id).val();
	var pCategory = $('#category_' + id).val();
	var pPrice = $('#price_' + id).val();
	var pAvailable = $('#available_' + id).is(":checked");
	var prod = new Product(pId, pName, pBrand, pCategory, pPrice, pAvailable);
	$.ajax({
		method: 'PUT',
		url: 'http://localhost:4202/product',
		data: JSON.stringify(prod),
		contentType: 'application/json',
		success: function() {getProducts()},
		error: function() {alert('Error :(')}
	});
}

function deleteProduct(id) {
	$.ajax({
		url: 'http://localhost:4202/product/' + id,
		method: 'DELETE',
		success: function() {getProducts()},
		error: function() {alert('Error :(')}
	});
}

function showProducts(){
	var htmlTableRows = '';
	for(let p of products){
		let available = (p.available) ? 'Yes' : 'No';
		let checked = (p.available) ? 'checked' : '';
		htmlTableRows += '<tr id="values_'+p.id+'" ><td>'+p.id+'</td><td>'+p.name+'</td><td>'+p.brand+'</td><td>'+p.category+'</td><td>€'+p.price+'</td><td>'+ available +'</td><td><button onclick="deleteProduct('+p.id+')" class="del">Delete</button></td><td><button onclick="showFields('+p.id+')" class="upd">Update</button></td></tr>'
		htmlTableRows += '<tr id="fields_'+p.id+'" style="display: none">' + 
        		'<td>'+p.id+'<input id="id_'+p.id+'" value="'+p.id+'" type="hidden"></td><td><input id="name_'+p.id+'" type="text" value="'+p.name+'"></td>' +
        		'<td><input id="brand_'+p.id+'" type="text" value="'+p.brand+'"></td>' +
        		'<td><input id="category_'+p.id+'" type="text" value="'+p.category+'"></td>' +
        		'<td><input id="price_'+p.id+'" type="number" value="'+p.price+'"></td>' +
        		'<td>available <input type="checkbox" id="available_'+p.id+'" '+checked+'></td>' +
        		'<td><button onclick="updateProduct('+p.id+')" class="save">Save</button></td>' +
        		'<td><button onclick="showValues('+p.id+')" class="clear">Cancel</button></td>' +
        	'</tr>';
	}
	$('#product-records').html(htmlTableRows);
}

class Product {
	constructor(id, name, brand, category, price, available) {
		this.id = id;
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.available = available;
	}
}

class OperationType{

}
function clearFields() {
	$('#name').val('');
	$('#brand').val('');
	$('#category').val('');
	$('#price').val('');
	$('#available').prop("checked", false);
}

function showFields(id) {
	$('#values_'+id).hide();
	$('#fields_'+id).show();
}

function showValues(id) {
	$('#values_'+id).show();
	$('#fields_'+id).hide();
}

getApis();
getProducts();

