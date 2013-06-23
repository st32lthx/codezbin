# Compiling the c++11 program #

**on Windows the compiler will be installed when Visual Studio 2012 is installed.**

**on Mac, PORT can be used to install the compiler or the latest version of XCODE.**

### Installing GCC 4.7 on MAC ###

Install macports first

	sudo port selfupdate
	sudo port install gcc47
	
New installation locations:

	/opt/local/bin/gcc-mp-4.7
	/opt/local/bin/g++-mp-4.7
	
Select Compiler:

	port select --list gcc
	
Example output:

		Available versions for gcc:
		gcc42
		llvm-gcc42
		mp-gcc47
		none (active)
		
To select GCC 4.7, run the command

	sudo port select --set gcc mp-gcc47
	Password:
	Selecting 'mp-gcc47' for 'gcc' succeeded. 'mp-gcc47' is now active.


## To compile the program do: ##

	g++ -std=c++0x -o SomeName main.cpp

Then you can invoke the name of the compiled file:

	./SomeName

And it will run the program and show you the result.