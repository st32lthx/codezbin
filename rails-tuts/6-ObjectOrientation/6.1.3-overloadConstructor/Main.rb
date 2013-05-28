#-------------------------------#
require_relative 'require_all.rb'
#-------------------------------#

alex = Alex.new(
	"first_name" => "Alex",
	"last_name" =>"Anderson")

alex2 = Alex.new(
	"first_name" => "Alex",
	"last_name" =>"Anderson",
	"owned_videos"=>"55")

puts "First name: #{alex.first_name}, last name: #{alex.last_name}"
puts "First name: #{alex2.first_name}, last name: #{alex2.last_name}, number of videos: #{alex2.owned_videos}"


