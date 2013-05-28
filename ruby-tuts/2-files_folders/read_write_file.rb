
# file = File.new('file1.txt', 'w')
# file.puts "Ruby"
# file.print "programming\n"
# file.write "is "
# file << "fun"
# file.close

# # 2. Provide a file with a block of instructions
# File.open('file1.txt', 'r') do |file|
#   while line = file.gets
#     puts "** " + line.chomp.reverse + " **"
#   end
# end
# 
# 

$file = File.new('file2.txt', 'w') # w mode will only write (and replace the content)
# if you know you want to read every line, 
# each_line will be easier
File.open('aminresume.csv', 'r') do |file| # r mode will only read
	file.each_line { |line|
		$file.puts line.upcase
	}
end
$file.close





# second argument is the 'mode': r, w, a, r+, w+, a+