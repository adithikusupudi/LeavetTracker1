<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!Doctype HTML>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600;700&display=swap')
	;

body {
	margin: 0px;
	padding: 0px;
	background-color: #21618c;
	overflow: hidden;
	font-family: system-ui;
}

.sidenav {
	height: 100%;
	width: 270px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #154360;
	overflow: hidden;
	transition: 0.5s;
	padding-top: 30px;
}

.sidenav a {
	padding: 15px 8px 15px 32px;
	text-decoration: none;
	font-size: 20px;
	color: #5DADE2;
	display: block;
	transition: 0.3s;
}

.sidenav a:hover {
	color: #f1f1f1;
	background-color: #21618c;
}

.sidenav {
	position: absolute;
	top: 0;
	right: 25px;
	font-size: 36px;
}

.dashboard {
	margin: 0px;
	margin-left: 28px;
	font-name: 'Aleo light';
	font-size: 40px;
	color: #F4F6F7;
	margin-bottom: 30px;
}

.menu li {
	margin: 0px;
	margin-left: -10px;
	font-name: 'Aleo light';
	font-size: 20px;
	color: #99A3A4;
	margin-bottom: 30px;
}

.sub-menu li {
	margin: 0px;
	margin-left: -50px;
	font-name: 'Aleo light';
	font-size: 20px;
	color: #5DADE2;
}

.main h1 {
	position: absolute;
	top: 50%;
	color: #fbfcfc;
	left: 60%;
	transform: translate(-50%, -50%);
	font-size: 30px;
}

.horizontal-line {
	display: block;
	margin-top: 30px;
	margin-left: auto;
	margin-right: 20px;
	border-style: inset;
	border-width: 1px;
}
</style>

<body>
	<div class="wrap">
		<div id="mySidenav" class="sidenav">
			<p class="dashboard">Dashboard</p>
			<ul class="menu">
				<li type=none>Employee</li>
				<ul class="sub-menu">
					<li type=none><a href="#">User View</a></li>
					<li type=none><a href="#">Add Leave</a></li>
				</ul>
				<hr color="#85C1E9" class="horizontal-line"></hr>
				<li type=none>Manager</li>
				<ul class="sub-menu">
					
					<li type=none><a href="login.html">Employee Details</a></li>
				</ul>
				<hr color="#85C1E9" class="horizontal-line"></hr>
			</ul>

		</div>
		<section class="main">
			<h1>BSCS LEGACY LEAVE TRACKER</h1>
			</center>
		</section>
	</div>
	
<script>
function openCity(evt, Name) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}
</script>
</body>


</html>