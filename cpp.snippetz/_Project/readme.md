## Compiling with the linker ##
Make sure that the folder structure is followed and the indlues are set correctly. Once everything is set run:

	g++ -std=c++0x -o run Main.cpp src/*.cpp src/*.h

And then you can run the executeable:

	./run
	
More detailed, more verbose:

	g++ -O3 -march=native -W -Wall  -Wextra -pedantic -std=c++0x -o run Main.cpp src/*.cpp src/*.h
	
And run the program:

	./run