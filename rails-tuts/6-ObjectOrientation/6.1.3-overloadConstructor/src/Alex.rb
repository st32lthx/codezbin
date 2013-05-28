class Alex
	attr_accessor :first_name, :last_name, :height, :username, :owned_videos
	def initialize (args)
		@first_name = args["first_name"]
		@last_name = args["last_name"]
		@height = args["height"]
		@username = args["username"]
		@owned_videos = args["owned_videos"]
	end

end
