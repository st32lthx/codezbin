## create the rails application ##

	rails new Game -d mysql

## go to the app folder ##

	cd Game

## Create Database

	rake db:create

## Make the model for Player

	rails g model Player name:string health:integer is_dead:boolean

### possible datatypes for ActiveReccord Rails 3

[Docs Reference](http://guides.rubyonrails.org/migrations.html#supported-types
)
	
	:primary_key  
	:string	:text    :integer	:float	:decimal	:datetime          	:timestamp	:time              	:date	:binary            
	:boolean

## Run the migration

	rake db:migrate
	
## Create controller and the index action ##

	rails g controller players index
	
## adding entry to database using the Query Interface ##

	# runs the rails console in development
	rails c
	# Create method makes a new object and saves it to the database.
	Player.create(name:"Jon", health:100, is_dead:0)
	
## looping through the entries in the array in the index view##

	<% @players.each do |player| %>
	
		<%= player.name %>
		<%= player.health %>
		<%= player.is_dead %>		
		
	<%end$>
	
