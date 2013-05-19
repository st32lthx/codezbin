require_relative 'Car'

car = Car.new(20,50)
puts "gas: #{car.get_gas} mile: #{car.get_mile}"
puts "\n"
car.set_gas = 22
car.set_mile = 55
puts "Now.. gas: #{car.get_gas} mile: #{car.get_mile}"
