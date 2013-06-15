/**
 * Simple car prototype
 * Author: Amin Meyghani
 * Date: Jun 15, 2013
 * Version: 1.0  
 */
#ifndef CAR_H
#define CAR_H

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

#endif /* defined(CAR_H) */
