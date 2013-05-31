#Grade   	    QP         Grade     QP        Grade      QP        Grade       QP        Grade        QP            
#A             4.0         B+       3.3         B-        2.7         C         2.0         D         1.0
#A-            3.7         B         3.0         C+       2.3         C-        1.7         F          0.0
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

$number_of_grades = 0
$grade_sum = 0.0
$gpa = 0

#------------------------------#

def does_user_say_no question
	question == "stop"
end


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
		letter_grade =  "A"
	elsif (number_grade > 3.3 && number_grade <= 3.7)
		letter_grade =  "A-"
	elsif (number_grade > 3.0 && number_grade <= 3.3)
		letter_grade =  "B+"
	elsif (number_grade > 2.7 && number_grade <= 3.0)
		letter_grade =  "B"
	elsif (number_grade > 2.3 && number_grade <= 2.7)
		letter_grade =  "B-"
	elsif (number_grade > 2.0 && number_grade <= 2.3)
		letter_grade =  "C+"
	elsif (number_grade > 1.7 && number_grade <= 2.0)
		letter_grade =  "C"
	elsif (number_grade > 1.0 && number_grade <= 1.7)
		letter_grade =  "C-"
	elsif number_grade == 1.0
		letter_grade =  "D"
	elsif number_grade < 1.0
		letter_grade = "F"
	else
		puts " "

	end

	letter_grade

end

def get_user_grade_and_add_all

	user_input = ""
	grade_counter = 0


	until does_user_say_no user_input

		user_input = gets.chomp
		$grade_sum += convert_letterGrade_to_number(user_input)
		grade_counter+=1
	end

	$number_of_grades = grade_counter - 1
	$grade_sum

end


def calculate_gpa
	$gpa = get_user_grade_and_add_all / $number_of_grades
	$gpa
end

gpa = calculate_gpa
puts gpa
puts convert_numberGrade_to_letterGrade gpa




