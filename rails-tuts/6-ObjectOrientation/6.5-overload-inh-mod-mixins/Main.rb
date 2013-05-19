#-------------------------------#
require_relative 'require_all.rb'
#-------------------------------#

persona = Anderson::Alex.new("first_name" => "Alex", "last_name" => "Anderson")
personb = Burns::Alex.new("first_name"=>"Alex","last_name"=>"Burns", "height"=>"58")

puts "Person 1: #{persona.first_name}, #{persona.last_name}"
puts "Person 2: #{personb.first_name}, #{personb.last_name}, height is #{personb.height}"