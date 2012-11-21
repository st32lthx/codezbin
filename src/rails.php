<?php require_once("includes/namespace.php");?>


<body>
<?php require_once("topnav.php") ?>


<?php
$db = new Database($conf->server(),$conf->username(),$conf->password());
$db->connect();
$db->select_db($conf->dbname());
$results = $query = "select * form users";

?>
<div id="content" class="maincontent">
<div id="expand_collapse_container">

<?php require_once("page_controls.php") ?>
</div><!--end expand collapse-->


	
	<ul class="snippet_container">
	
			<li><a href="#" class="snippet-trigger">Create new rails project</a>
			<div class="snippet">
				<pre class="brush: ruby;">
				#"-d mysql" indicates to use mysql as the db.
				rails new flitti -d mysql</pre>

				</div><!--end snippet-->
			</li><!--end :) -->


	<li><a href="#" class="snippet-trigger">Generate controller and view</a>
			<div class="snippet">
				<pre class="brush: ruby;">
				# Go to the flitti folder to run the following:
				rails generate controller flit index
				# flit is the controller and index is the view.
				</pre>

				</div><!--end snippet-->
			</li><!--end :) -->

			
			</ul><!--end snippet container-->
			
			
		
		

	<div id="footer"></div><!--end footer-->
	
	
	


	





</div><!--end content-->
</body>
<?php $db->close_connection(); ?>
</html>
