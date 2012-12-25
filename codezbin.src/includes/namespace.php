<?php
/*@Author: Amin Meyghani
@Date: Nov.11.2012
Defines a global accessible path for the app. In addition to that, it prints all the necessary HTML.
*/

define("APP_PATH", realpath("."));
$paths = array(
APP_PATH.'/includes/', 
APP_PATH.'/includes/calendar', 
APP_PATH.'/includes/objects', 
APP_PATH.'/includes/objects', 
get_include_path()
);
set_include_path(implode(PATH_SEPARATOR, $paths)); 
?>
<?php require_once('html_head.php'); ?>
<?php require_once('Database.php');?>
<?php require_once('DBConfig.php');
$conf = new DBConfig();	?>







