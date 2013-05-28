# ask user for grades one by one
## A [enter], A [enter], A[enter], x[enter] to end.
# print the GPA and the range that the user in A range, B range, etc.

#the other way is: A,A,A,A,B,B+,C+,D,A,F,E,A-
# the program processes it and splits by "," and outputs the result.

## psudo code ##

# ask user for grades until they say no.
# add up all the grades 
# divide the sum by the number of grades.
# print the result
# 
# Working with arrays
numbers = []
sum = 0
(1..5).each do |x|
	numbers << x
	sum+=x
end
puts "the array elements:"
puts numbers
puts "the sum is: #{sum}"
puts "there are #{numbers.length} elements in the array"
puts "the first elements"