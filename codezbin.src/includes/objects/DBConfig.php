<?php

//DB object model.
//Author: Amin Meyghani



class DBConfig{

    private $username = "";
    private $password = "";    
    private $server = "";  
    private $dbname = "";
      
    private $connection;    
    
function username(){
	return $this->username;
}

function password(){
	return $this->password;
}
function server(){
	return $this->server;
}

function dbname(){
	return $this->dbname;
}

 }
