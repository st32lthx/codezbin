
#include "Car.h"

/*
Constructor with no args.
 */
Car::Car(){
	_gas = 200;
}
/*
Constructor with args.
 */
Car::Car(int gas){
	_gas = gas;
}

/*
Getter for the gas.
Returns int.
 */
int Car::get_gas(){
	return _gas;
}
/**
 * Setters for the gas
 * param: int: amount of gas
 * returns void
 */

void Car::set_gas(int gas){
	_gas = gas;
}
