#-------------------------------#
require_relative 'require_all.rb'
#-------------------------------#
sport_car = Machine::SportsCar.new(20,40,500)
puts "gas: #{sport_car.gas}
mile: #{sport_car.mile}
speed: #{sport_car.speed}"
space_car = Space::SportsCar.new(20,40,500,20000)
puts "space car jet value is #{space_car.jet_power}"

