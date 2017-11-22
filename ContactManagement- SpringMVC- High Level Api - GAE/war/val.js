$(document).ready(function(){
	
	$("#Add").click(function(){
		
		var fname1 = $("#fname").val();
		var lname1 = $("#lname").val();
		var gender1 = $("#gender").val();
		var pno1 = $("#pno").val();
		var email1 = $("#email").val();
		var address1 = $("#address").val();
		
		
		var addData = {Fname:fname1, Lname:lname1, Gender:gender1, Phone:pno1, Mail:email1, Address:address1};
		
		var getData = JSON.stringify(addData);
		
		if(fname1==''||lname1==''||gender1==''||pno1==''||email1==''||address1=='')
		{
		alert("Please Fill All Fields");
		}
		else
		{
		$.ajax({
		type: "POST",
		url: "/Add.ds",
		dataType:'json',
		data:'data='+getData,
		success: function(data){
		alert("Contacts added successfully");
		}
		});
		}
		return false;
		});
	
$("#sea").click(function(){
		
		var search1 = $("#search").val();

		var addData1 = {Search:search1};
		
		var getData1 = JSON.stringify(addData1);
		
		if(search1=='')
		{
		alert("Please Fill Fields");
		}
		else
		{
		$.ajax({
		type: "POST",
		url: "/Search.ds",
		dataType:'json',
		data:'data='+getData1,
		success: function(data){
		alert("Contacts added successfully");
		}
		});
		}
		return false;
		});

$("#update").click(function(){
	
	var fname2 = $("#fname").val();
	var lname2 = $("#lname").val();
	var gender2 = $("#gender").val();
	var pno2 = $("#pno").val();
	var email2 = $("#email").val();
	var address2 = $("#address").val();
	
	
	var addData2 = {Fname:fname2, Lname:lname2, Gender:gender2, Phone:pno2, Mail:email2, Address:address2};
	
	var getData2 = JSON.stringify(addData2);
	
	if(fname2==''||lname2==''||gender2==''||pno2==''||email2==''||address2=='')
	{
	alert("Please Fill All Fields");
	}
	else
	{
	$.ajax({
	type: "POST",
	url: "/Update.ds",
	dataType:'json',
	data:'data='+getData2,
	success: function(data){
	alert("Contacts updated successfully");
	}
	});
	}
	return false;
	});

$("#del").click(function(){
	
	var del1 = $("#delete").val();

	var addData4 = {Delete:del1};
	
	var getData4 = JSON.stringify(addData4);
	
	if(del1=='')
	{
	alert("Please Fill Fields");
	}
	else
	{
	$.ajax({
	type: "POST",
	url: "/delete.ds",
	dataType:'json',
	data:'data='+getData4,
	success: function(data){
	alert("Delete successfully");
	}
	});
	}
	return false;
	});


});