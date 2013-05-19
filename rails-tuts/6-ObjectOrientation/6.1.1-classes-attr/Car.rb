class Car
	attr_accessor:gas, :mile


	@@car_counter = 0 #class variable


	def initialize (gas,mile)
		@gas = gas
		@mile = mile
		@@car_counter+=1  #the class variable is incremented  
							# to count the number of instances created.

	end

	def self.honk     # class method
		puts "honk..."
	end

	def self.count    # class method
		@@car_counter
	end



end

