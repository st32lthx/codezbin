require_relative 'Car.rb'
require_relative 'SportCar.rb'

sport_car = SportsCar.new(20,40,500)
puts "gas: #{sport_car.gas}
mile: #{sport_car.mile}
speed: #{sport_car.speed}"
