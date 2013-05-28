# A simple example of an Object Oriented program #

Program calculates GPA. 

## Usage ##
run:

	ruby Main.rb

Then input your letter grades one at a time and hit enter.

`example:`

	A [enter]
	B [enter]
	B+ [enter]
	.
	.
	.
	
And once you are done, type `stop` and hit `enter`. It will calculate the GPA and will print the results.

## The range used for the GPA range calculation ##

Below is the rules used to calculate the number grades.

	3.7 < x <= 4.0 : A
	3.3 < x <= 3.7 : A-
	3.0 < x <= 3.3 : B+
	2.7 < x <= 3.0 : B
	2.3 < x <= 2.7 : B-
	2.0 < x <= 2.3 : C+
	1.7 < x <= 2.0 : C
	1.0 < x <= 1.7 : C-
	1.0 : D
r	
## Classes ##
The classes used for this calculator are as follows:

### 1. Gpa_calculator.rb ###
#### 1.1 Methods ####
`1.1.1 calculate_gpa`

	The main method that runs the program.
	
#### 1.2 Instance Variables ####

	attr_accessor :number_of_grades, :grade_sum, :gpa, :letter_grade

### 2. Grade_processor ###

#### 2.1 Methods ####

`2.1.1 convert_letterGrade_to_number(letter_grade)`

	#
	
	Converts a given letter grade to the equivalent 
	number grade. 
	Example: given the string "A", it will return the float 4.0
	
	@param: letter: the letter grade string
	@return grade: the number grade float
	
	#

`2.1.2 convert_numberGrade_to_letterGrade(number_grade)`

 	
 	
	Converts a given number grade, converts to the corresponding letter grade range.	For example given 3.6 float, it will look at the range
	of values and identifies that 3.6 is between 3.3 and 3.7
	and outputs A-
	
	@param number_grade: float, the number grade passed in
	@return letter_grade: string, the letter grade equivalent

	#


#### 2.2 Instance Variables ####
	attr_accessor :letter_grade, :number_grade
	
##TODO##

Encapsulation … Need to make the methods in the classes private.

1. Gpa calculator: get_user_grade_and_add_all, does_user_say_no

2. Grade Processor: none. 
