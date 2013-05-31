class GpaCalculator


	def initialize

		@grade_sum = 0.0
		@number_of_grades = 0
		$gpa = 0.0

	end


	def does_user_say_no question

		question == "stop"

	end

	def get_user_grade_and_add_all

		user_input = ""
		grade_counter = 0


		until does_user_say_no user_input

			user_input = gets.chomp
			grade_processor = GradeProcessor.new
			@grade_sum += grade_processor.convert_letterGrade_to_number user_input
			grade_counter +=1

		end

		@number_of_grades = grade_counter - 1
		@grade_sum


	end


	def calculate_gpa

		@gpa =  get_user_grade_and_add_all / @number_of_grades
		@gpa

	end


	private :does_user_say_no

end