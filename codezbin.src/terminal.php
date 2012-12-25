<?php require_once("includes/namespace.php");?>
<body>
<?php require_once("topnav.php") ?>

<div id="content" class="maincontent">
<div id="expand_collapse_container">
<?php require_once("page_controls.php") ?>
</div><!--end expand collapse-->

	<ul class="snippet_container">

		<li><a href="#" class="snippet-trigger">Go to the beginning of line</a>
		<div class="snippet">
			<pre class="brush: shell;">
			[hold control and hit a on keyboard] ctrl+a</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		<li><a href="#" class="snippet-trigger">Go to the end of line</a>
		<div class="snippet">
			<pre class="brush: shell;">
			[hold control and hit e] ctrl+e</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		<li><a href="#" class="snippet-trigger">Clear screen</a>
		<div class="snippet">
			<pre class="brush: shell;">
			ctrl+L</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		
		<li><a href="#" class="snippet-trigger">Cut/Delete everything to the left of the cursor</a>
		<div class="snippet">
			<pre class="brush: shell;">
			ctrl+u</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		<li><a href="#" class="snippet-trigger">Cut/Delete everything to the right of the cursor</a>
		<div class="snippet">
			<pre class="brush: shell;">
			ctrl+k</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		<li><a href="#" class="snippet-trigger">Paste/Yank</a>
		<div class="snippet">
			<pre class="brush: shell;">
			ctrl+y</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		<li><a href="#" class="snippet-trigger">Show results in a manageable manner</a>
		<div class="snippet">
			<pre class="brush: shell;">
			# If you want to see the listing in a directory
			# and you have a lot of content that might not 
			# fit the screen, you can see the results one at a time
			# bit hitting space after your run the following:
			ls -l | more
			#or at any point you can hit esc to stop it.</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
	
		
		
		</ul><!--end snippet container-->
	
	
	<div id="footer"></div><!--end footer-->
	
</div><!--end content-->
</body>
</html>
