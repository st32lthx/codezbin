$grade_sum = 0.0
$number_of_grades = 0
$gpa = 0.0


def convert_letterGrade_to_number(letter_grade)
	grade = 0;
	case letter_grade
	when "A"
		grade =  4.0
	when "A-"
		grade =  3.7
	when "B+"
		grade =  3.3
	when "B"
		grade =  3.0
	when "B-"
		grade =  2.7
	when "C+"
		grade =  2.3
	when "C"
		grade =  2.0
	when "C-"
		grade =  1.7
	when "D"
		grade =  1.0
	when "F"
		grade = 0.0
	else
		puts " "

	end

	grade

end

def does_user_say_no question

	question == "stop"

end

def get_user_grade_and_add_all

	user_input = ""
	grade_counter = 0


	until does_user_say_no user_input

		user_input = gets.chomp
		$grade_sum += convert_letterGrade_to_number user_input
		grade_counter +=1

	end

	$number_of_grades = grade_counter - 1
	$grade_sum


end


def calcluate_gpa

	$gpa =  get_user_grade_and_add_all / $number_of_grades
	$gpa

end

my_grade = calcluate_gpa
puts my_grade





