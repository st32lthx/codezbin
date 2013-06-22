#include "headers/Car.h"
#include <iostream>
int main(){


	Car car;
	int gas = car.getGas();

	std::cout << "gas :" << gas << std::endl;

	Car car2(200);
	int gas2 = car2.getGas();

	std::cout << "gas2 :" << gas2 << std::endl;
	return 0;
}
