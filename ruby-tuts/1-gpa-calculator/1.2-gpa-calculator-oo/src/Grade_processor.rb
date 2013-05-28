class Grade_processor
	attr_accessor :letter_grade, :number_grade
	def initialize ()
		@letter_grade = ""
		@number_grade = 0
	end


##
# Converts a given letter grade to the equivalent 
# number grade. 
# Example: given the string "A", it will return the float 4.0
# letter: the letter grade string
# @return grade: the number grade float

##
	def convert_letterGrade_to_number(letter_grade)
		@number_grade = 0;
		case letter_grade
		when "A"
			@number_grade =  4.0
		when "A-"
			@number_grade =  3.7
		when "B+"
			@number_grade =  3.3
		when "B"
			@number_grade =  3.0
		when "B-"
			@number_grade =  2.7
		when "C+"
			@number_grade =  2.3
		when "C"
			@number_grade =  2.0
		when "C-"
			@number_grade =  1.7
		when "D"
			@number_grade =  1.0
		when "F"
			@number_grade = 0.0
		else
			puts " "

		end

		@number_grade

	end

	##
	# Converts a given number grade, converts to the 
	# corresponding letter grade range.
	# For example given 3.6 float, it will look at the range
	# of values and identifies that 3.6 is between 3.3 and 3.7
	# and outputs A-
	# @param number_grade: float, the number grade passed in
	# @return letter_grade: string, the letter grade equivalent
	def convert_numberGrade_to_letterGrade number_grade
	# 3.7 < x <= 4.0 : A
	# 3.3 < x <= 3.7 : A-
	# 3.0 < x <= 3.3 : B+
	# 2.7 < x <= 3.0 : B
	# 2.3 < x <= 2.7 : B-
	# 2.0 < x <= 2.3 : C+
	# 1.7 < x <= 2.0 : C
	# 1.0 < x <= 1.7 : C-
	# 1.0 : D
	# x<1.0 : F
	letter_grade = "";


	if (number_grade > 3.7 && number_grade <= 4.0)
		@letter_grade =  "A"
	elsif (number_grade > 3.3 && number_grade <= 3.7)
		@letter_grade =  "A-"
	elsif (number_grade > 3.0 && number_grade <= 3.3)
		@letter_grade =  "B+"
	elsif (number_grade > 2.7 && number_grade <= 3.0)
		@letter_grade =  "B"
	elsif (number_grade > 2.3 && number_grade <= 2.7)
		@letter_grade =  "B-"
	elsif (number_grade > 2.0 && number_grade <= 2.3)
		@letter_grade =  "C+"
	elsif (number_grade > 1.7 && number_grade <= 2.0)
		@letter_grade =  "C"
	elsif (number_grade > 1.0 && number_grade <= 1.7)
		@letter_grade =  "C-"
	elsif number_grade == 1.0
		@letter_grade =  "D"
	elsif number_grade < 1.0
		@letter_grade = "F"
	else
		puts " "

	end

	@letter_grade

end

end
