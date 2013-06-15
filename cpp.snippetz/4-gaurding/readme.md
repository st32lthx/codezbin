# Gaurding #
It is used to prevent classes being loaded more than once.

[Stackoverflow](http://stackoverflow.com/questions/3246803/why-use-ifndef-class-h-and-define-class-h-in-h-file-but-not-in-cpp)

Question:

I have always seen people write

	#ifndef CLASS_H
	#define CLASS_H
	
	//blah blah blah
	
	#endif
	
The question is why don't they also do that for the .cpp file that contain definitions for class functions?

Let's say I have a main.cpp, and main.cpp import class.h. class.h do not import anything, so how can the main.cpp know what is in the class.cpp?

`Answer:`

When you see this in .h file:

	#ifndef FILE_H
	#define FILE_H
	
	/* ... Declarations etc here ... */
	
	#endif


This is a preprocessor technique of preventing a header file from being included multiple times, which can be problematic for various reasons. During compilation of your project, each .cpp file (usually) is compiled. In simple terms, this means the compiler will take your .cpp file, open any files #included by it, concatenate them all into one massive text file, and then perform syntax analysis and finally it will convert it to some intermediate code, optimize/perform other tasks, and finally generate the assembly output for the target architecture. Because of this, if a file is #included multiple times under one .cpp file, the compiler will append its file contents twice, so if there are definitions within that file, you will get a compiler error telling you that you redefined a variable. When the file is processed by the preprocessor step in the compilation process, the first time its contents are reached the first two lines will check if FILE_H has been defined for the preprocessor. If not, it will define FILE_H and continue processing the code between it and the #endif directive. The next time that file's contents are seen by the preprocessor, the check against FILE_H will be false, so it will immediately scan down to the #endif and continue after it. This prevents redefinition errors.

And to address your second concern:

In C++ programming as a general practice we separate development into two file types. One is with an extension of .h and we call this a "header file." They usually provide a declaration of functions, classes, structs, global variables, typedefs, preprocessing macros and definitions, etc. Basically, they just provide you with information about your code. Then we have the .cpp extension which we call a "code file." This will provide definitions for those functions, class members, any struct members that need definitions, global variables, etc. So the .h file declares code, and the .cpp file implements that declaration. For this reason, we generally during compilation compile each .cpp file into an object and then link those objects (because you almost never see one .cpp file include another .cpp file).

How these externals are resolved is a job for the linker. When your compiler processes main.cpp, it gets declarations for the code in class.cpp by including class.h. It only needs to know what these functions or variables look like (which is what a declaration gives you). So it compiles your main.cpp file into some object file (call it main.obj). Similarly, class.cpp is compiled into a class.obj file. To produce the final executable, a linker is invoked to link those two object files together. For any unresolved external variables or functions, the compiler will place a stub where the access happens. The linker will then take this stub and look for the code or variable in another listed object file, and if it's found, it combines the code from the two object files into an output file and replaces the stub with the final location of the function or variable. This way, your code in main.cpp can call functions and use variables in class.cpp IF AND ONLY IF THEY ARE DECLARED IN class.h.

I hope this was helpful.