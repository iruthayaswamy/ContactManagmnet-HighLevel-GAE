<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Contact</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="val.js"></script>
<style>
input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}



input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>

<h3>UPDATE CONTACT</h3>

<div class="container">
 

    <label for="fname">First Name</label>
    <input type="text" id="fname" >

    <label for="lname">Last Name</label>
    <input type="text" id="lname" >

    <label for="gender">Gender</label>
    <select id="gender" name="gender">
      <option value="Male">Male</option>
      <option value="Female">Female</option>
      <option value="others">Others</option>
    </select>

    <label for="pno">Phone Number</label>
    <input type="text" id="pno" placeholder="Update Contact with Phone Number..">
    
    <label for="email">Email</label>
    <input type="text" id="email">
    
    
    <label for="address">Address</label>
    <textarea id="address" name="address"  style="height:150px"></textarea>

    <input type="submit" id="update" value="update">
    
 
  
</div>

</body>
</html>
