<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="Cache-Control" content="no-store">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="/favicon.png">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script src="/webjars/jquery/jquery.min.js"></script>

<link href="https://webfontworld.github.io/gmarket/GmarketSans.css" rel="stylesheet">

<title></title>
<style>
* {
	margin: 0;
	padding:0;
	font-family: 'GmarketSans';
	font-size: 26px;
}	

a {
	text-decoration: none;
}

h1 {
	text-align: center;
	background-color: #242424;
	color:#78b862;
}

#create {
	background-color: #242424;
}

</style>

</head>
<script>
// Check javascript has loaded
$(document).ready(function(){

  // Click event of the showPassword button
  $('#showPassword').on('click', function(){

    // Get the password field
    var passwordField = $('#password');

    // Get the current type of the password field will be password or text
    var passwordFieldType = passwordField.attr('type');

    // Check to see if the type is a password field
    if(passwordFieldType == 'password')
    {
        // Change the password field to text
        passwordField.attr('type', 'text');

        // Change the Text on the show password button to Hide
        $(this).val('Hide');
    } else {
        // If the password field type is not a password field then set it to password
        passwordField.attr('type', 'password');

        // Change the value of the show password button to Show
        $(this).val('Show');
    }
  });
});
</script>
<body>
<div id="create" class="container-fluid p-5  text-white text-center">
<h1>USER 회원가입</h1>
</div>
<a href="/">Home</a>
<hr>
<section class="container">
	<form action="/user/create" method="post">
		<div class="mb-3">
			<label class="form-lable mb-2" for="id">id<span>*</span></label>
			<input class="form-control"    id="id" name="id" placeholder="id를 입력하세요." value="${user.id}"/>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="password">password<span>*</span></label>
			<input class="form-control"  type="password"      id="password"  name="password"  placeholder="비밀번호를 입력하세요." value="${user.password}"/>
			<input type="button"  id="showPassword" value="show" class="mt-1 btn" style="border: solid gray 2px; background-color:  #78b862;" /></p>
		</div>
		<div class="mb-3">
			<label class="form-lable mb-2" for="role">이메일</label>
			<input class="form-control"    id="role"	   name="role"    placeholder="메일주소를 입력해주세요." value=""/>
		</div>
		<button type="submit" class="btn " style="background: #78b862; ">Submit</button>
	</form>	
</section>
<hr>
<c:if test="${binding.hasErrors()}">
<h2>Error Massage</h2>
<hr>
<c:forEach var="g" items="${binding.globalErrors}">
	<div>${g.code} ${g.defaultMessage}</div>
</c:forEach>
<hr>
<c:forEach var="f" items="${binding.fieldErrors}">
	<div>${f.field} ${f.defaultMessage}</div>
</c:forEach>

</c:if>

</body>
</html>