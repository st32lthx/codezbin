#-------------------------------#
require_relative 'require_all.rb'
#-------------------------------#

calculator = Gpa_calculator.new
puts "This is the range of grades and their corresponding letter grade"
puts "3.7 < x <= 4.0 : A \n
3.3 < x <= 3.7 : A- \n
3.0 < x <= 3.3 : B+ \n
2.7 < x <= 3.0 : B \n
2.3 < x <= 2.7 : B- \n
2.0 < x <= 2.3 : C+ \n 
1.7 < x <= 2.0 : C \n
1.0 < x <= 1.7 : C- \n
1.0 : D \n
x<1.0 : F \n" 
puts "Input your grades like A-, B+, C and then when you are done type stop and hit enter"
puts calculator.calculate_gpa
