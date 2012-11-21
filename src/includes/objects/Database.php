<?php
/**
*@author: Amin Meyghani
*@date: Oct.20.2012
*@version: 1.0
 *Database class.
 * Operations typical of a database.
 *More robust: 
 *http://docs.oracle.com/cd/E17781_01/appdev.112/e18555/ch_three_db_access_class.htm
 *Results:
 * http://php.net/manual/en/function.mysql-fetch-assoc.php
 */
class Database{
    /**
     *username
     *password
     *server
     * @var username: string: username to the database
     * @var username: string: username to the database
     * @var server: server: eg: localhost (most of the time)
     */
    private $username;
    private $password;    
    private $server;    
    private $connection;    
    /**
     *non-default constructor.
     * @param $server: name of the server
     * @param $username: username of MYSQL
	 * @param $password: password to MYSQL
     */
     

    function __construct($server, $username, $password) {
        $this->server=$server;
        $this->username=$username;
        $this->password=$password;                
    }
    /**
     *Connects to database
     */
    function connect(){

     $this->connection = mysql_connect($this->server,$this->username, $this->password);
if (!$this->connection) {
    echo "Cannot connect to database.".mysql_error();
    exit;
}

   
    }
    
	function select_db($database){
		mysql_select_db($database,$this->connection);
	}
	
	function query_database($query){
		
		$results = mysql_query($query, $this->connection);
		
		if (!$results) {
            echo("Some error has occurred. No results were returned.");
            exit();
        }
        return $results;
	}
	
	function close_connection($dbConnection){
	mysql_close($this->connection);
	}
	


 }
    
