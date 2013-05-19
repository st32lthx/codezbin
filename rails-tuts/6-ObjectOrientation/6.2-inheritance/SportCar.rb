class SportsCar < Car
	attr_accessor :speed

	def initialize (gas, mile,speed)
		super(gas,mile) #accessing the super class Car
		# do what parent would do
		@speed = speed

	end
end