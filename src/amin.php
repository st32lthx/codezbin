<?php require_once("includes/namespace.php");?>

<body>
<span id="homepage-flag" style="display:none"></span>

<?php require_once("topnav.php") ?>


<?php
$db = new Database($conf->server(),$conf->username(),$conf->password());
$db->connect();
$db->select_db($conf->dbname());












?>

	<div id="centercontent" class="maincontent">
		
		
		<P>
		
		
		<?php
		
		//$user_query = "select * from users";
		//$user_results = $db->query_database($user_query);
		
		
		$snippet_query = "select snippet_content from snippets where snippet_id = 3";
		$snippet_results = $db->query_database($snippet_query);
		
		
		
		
		
		while ($row = mysql_fetch_array($snippet_results)) {
			echo $row['snippet_lang']." ".$row['snippet_content']."<br/> ";
		}
		
		?>
		
		
		
		<?php
		/*
		while ($row = mysql_fetch_array($user_results)) {
			echo $row['first_name']." ".$row['last_name']." ".$row['username']."<br />";
		}
		?>
		
		<?php
		while ($row = mysql_fetch_array($snippet_results)) {
			echo $row['snippet_lang']." ".$row['snippet_content']."<br/> ";
		}
		*/
		?>
		
		</P>
		
	
		
	
	</div><!--end centercontent-->
</div>

<?php
/*
$add_snippet = "insert into snippets(snippet_lang,snippet_content) 

values 

(\"c*\",

\"cout << yeah\")"; 

$db->query_database($add_snippet);
*/

/*
$add_snippet = "insert into snippet_posts(user_id,date_posted) 

values 

(\"3\", \"2012-10-12\")";




$db->query_database($add_snippet);
*/

/*
$add_snippet = "insert into snippet_posts_items(snippet_post_id,snippet_id) 

values 

(\"2\", \"3\")";
$db->query_database($add_snippet);
*/
?>
</div><!--end content-->
</body>
<script type="text/javascript">
//printDOMTree(document.getElementById('mainmain'));//
</script>
</html>




