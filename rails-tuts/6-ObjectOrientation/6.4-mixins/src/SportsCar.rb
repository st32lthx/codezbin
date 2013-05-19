module Machine
	class SportsCar < Car
		attr_accessor :speed
		def initialize (gas, mile,speed)
		super(gas,mile)
		@speed = speed
	end
end
end