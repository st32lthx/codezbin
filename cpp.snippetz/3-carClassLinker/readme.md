## Compiling with the linker ##
Make sure that the folder structure is followed and the indlues are set correctly. Once everything is set run:

	g++ -std=c++0x -o hello Main.cpp src/*.cpp src/*.h

And then you can run the executeable:

	./hello
	
More detailed, more verbose:

	g++ -O3 -march=native -W -Wall  -Wextra -pedantic -std=c++0x -o hello Main.cpp src/*.cpp src/*.h
	
For information on make files look at the following:

[Stackoverflow](http://stackoverflow.com/questions/14884474/how-to-link-object-files-and-libraries-without-using-makefile)

`.cpp file`

	// special libraries to include
	#include "acado.h"  
	#include "auxiliary_functions.c" 
	/* -------------------------- */
	// Create objects for special classes 
	   ACADOvariables acadoVariables; 
	   ACADOworkspace acadoWorkspace;
	
	int main(){
	    // perform task A_1
	    // perform task A_2 
	    // Tasks A_1 and A_2 depend on the specially included headers
	    return 0;
	}
	

`make file`

	LDLIBS = -lm 
	CXXFLAGS = -O3 -finline-functions -I. -I./qpoases/INCLUDE -I./qpoases/SRC
	CFLAGS = -O3
	CC     = g++
	
	OBJECTS = \
	    ./qpoases/SRC/QProblemB.o       \
	    ./qpoases/SRC/Bounds.o          \
	    ./qpoases/SRC/Constraints.o     \
	    ./qpoases/SRC/SubjectTo.o       \
	    ./qpoases/SRC/Indexlist.o       \
	    ./qpoases/SRC/CyclingManager.o  \
	    ./qpoases/SRC/Utils.o           \
	    ./qpoases/SRC/MessageHandling.o \
	    ./qpoases/solver.o              \
	    integrator.o                    \
	    condensing.o                    \
	    gauss_newton_method.o 
	
	.PHONY: all
	all: test libacado_exported_rti.a
	
	test: ${OBJECTS} test.o
	
	./qpoases/solver.o    : ./qpoases/solver.hpp
	integrator.o          : acado.h
	condensing.o          : acado.h
	gauss_newton_method.o : acado.h   ./qpoases/solver.hpp
	test.o                : acado.h   ./qpoases/solver.hpp
	
	libacado_exported_rti.a: ${OBJECTS}
	    ar r $@ $?
	
	${OBJECTS} : ./qpoases/solver.hpp
	
	.PHONY : clean
	clean :
	    -rm -f *.o *.a ./qpoases/SRC/*.o ./qpoases/SRC/*.a test

The alternative as proposed in the answer is:

	 g++ test.cpp -O3 -finline-functions -I. -I./qpoases/INCLUDE -I./qpoases/SRC -lm -o test ./qpoases/SRC/QProblemB.o ./qpoases/SRC/Bounds.o ./qpoases/SRC/Constraints.o ./qpoases/SRC/SubjectTo.o ./qpoases/SRC/Indexlist.o ./qpoases/SRC/CyclingManager.o ./qpoases/SRC/Utils.o ./qpoases/SRC/MessageHandling.o ./qpoases/solver.o integrator.o condensing.o gauss_newton_method.o
