class GradeProcessor


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


end