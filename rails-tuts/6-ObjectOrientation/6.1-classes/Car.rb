class Car

	
	def initialize (gas,mile)

		@gas = gas
		@mile = mile
	end

	def get_gas
		return @gas
	end

	def get_mile
		return @mile
	end

	def set_gas=(newgas)
		@gas = newgas
	end

	def set_mile=(newmile)
		@mile = newmile
	end

end

