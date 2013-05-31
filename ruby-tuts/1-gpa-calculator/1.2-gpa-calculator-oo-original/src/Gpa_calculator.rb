class Gpa_calculator
	attr_accessor :number_of_grades, :grade_sum, :gpa, :letter_grade
	def initialize ()
		@number_of_grades = 0
		@grade_sum = 0.0
		@gpa = 0
		@letter_grade = ""
	end



	def does_user_say_no question
		question == "stop" || question == "no" || question == "end" || question == "x" 
	end


	def get_user_grade_and_add_all

		user_input = ""
		grade_counter = 0


		until does_user_say_no user_input

			user_input = gets.chomp
			print " next grade or type stop: \n"
			grade_processor = Grade_processor.new()
			@grade_sum += grade_processor.convert_letterGrade_to_number(user_input)
			grade_counter+=1


		end
		@number_of_grades = grade_counter - 1

		@grade_sum

	end


	def calculate_gpa
		gpa = ""
		@gpa = get_user_grade_and_add_all / @number_of_grades
		grade_processor = Grade_processor.new();
		@letter_grade = grade_processor.convert_numberGrade_to_letterGrade @gpa
		gpa+= "Your GPA is #{@gpa} which is within #{@letter_grade} range"
	end

	private :does_user_say_no, :get_user_grade_and_add_all
end