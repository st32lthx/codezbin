module Burns
	class Alex < Person
		attr_accessor :height
		def initialize (args)
			super(args)
			@height = args["height"]
		end
	end
end