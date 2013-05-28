

# 2. Provide a file with a block of instructions
File.open('file1.txt', 'r') do |file|
  while line = file.gets
    puts "** " + line.chomp.reverse + " **"
  end
end




# second argument is the 'mode': r, w, a, r+, w+, a+



## call the program with ruby Main.rb amin.txt
# reads the file and prints each line

# file = File.new(ARGV[0])
# lines = file.read.split("\n")
# lines.each do |line|

# 	puts line
# end