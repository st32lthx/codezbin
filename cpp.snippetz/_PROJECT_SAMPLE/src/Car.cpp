#include "../headers/Car.h"
Car::Car(){
	_gas = 0;
}

Car::Car(int gas) : _gas(gas){}

int Car::getGas(){
	return _gas;
}
