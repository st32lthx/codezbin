/**
 * Simple car prototype
 * Author: Amin Meyghani
 * Date: Jun 15, 2013
 * Version: 1.0  
 */
#ifndef __CppClasses__Car__
#define __CppClasses__Car__

#include <iostream>

 class Car{
 private:
 	int _gas;
 public:
	/*
	Constructors
	 */
	Car();
	Car (int gas);
	/*
	Setters and getters
	 */
	int get_gas();
	void set_gas(int gas);

};

#endif /* defined(__CppClasses__Car__) */
