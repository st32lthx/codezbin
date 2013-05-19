require_relative 'Car.rb'
Car.honk

car = Car.new(20,50)
puts "gas: #{car.gas} mile: #{car.mile}"
car.gas = 22
car.mile= 55
puts "Now.. gas: #{car.gas} mile: #{car.mile}"

puts Car.count ##calling the class method
