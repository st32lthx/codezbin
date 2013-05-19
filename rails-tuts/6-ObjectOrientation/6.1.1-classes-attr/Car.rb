class Car
	attr_accessor:gas, :mile


	@@car_counter = 0


	def initialize (gas,mile)
		@gas = gas
		@mile = mile
		@@car_counter+=1

	end

	def self.honk
		puts "honk..."
	end

	def self.count
		@@car_counter
	end



end

