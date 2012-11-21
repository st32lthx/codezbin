<?php require_once("includes/namespace.php");?>
<body>
<?php require_once("topnav.php") ?>

<div id="content" class="maincontent">
<div id="expand_collapse_container">
<?php require_once("page_controls.php") ?>
</div><!--end expand collapse-->

	<ul class="snippet_container">

		<li><a href="#" class="snippet-trigger">Run Ruby - On Mac</a>
		<div class="snippet">
			<pre class="brush: ruby;">
			##OPEN TERMINAL
			#go to Desktop
			cd /Users/aminmeyghani/Desktop
			#Make a folder and name it whatever
			mkdir myfolder
			#go to this folder you made
			cd myFolder
			#Make a ruby file
			vi main.rb
			#now you are in vim editor. The following
			#are vi related.
			[HIT i on keyboard]
			[TYPE] puts "blah" 
			[HIT esc  on keyboard]
			[TYPE] :wq [HIT ENTER] #this will quit and save
			#now you can run the program:
			ruby main.rb
			#outputs:
			blah</pre>

			</div><!--end snippet-->
		</li><!--end :) -->
		<li><a href="#" class="snippet-trigger">Add two numbers - Simple Function</a>
		<div class="snippet">
			<pre class="brush: ruby;">
			##
			#define functions first and then them.
			#Add two numbers
			#
			
			#Define Function
			def add(x,y)
				return x+y
			end
			
			#Call function
			puts add(2,3)
			
			
			</pre>
			</div><!--end snippet-->
		</li><!--end :) -->
		
		
		
		

		
		</ul><!--end snippet container-->
	
	<div id="footer"></div><!--end footer-->

</div><!--end content-->
</body>
</html>
