module Space
	class SportsCar < Car
		attr_accessor :speed, :jet_power
		def initialize (gas, mile,speed,jet_power)
		super(gas,mile)
		@speed = speed
		@jet_power = jet_power
	end
end
end