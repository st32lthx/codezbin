#include <iostream>
#include "src/Car.h"


int main(int argc, const char * argv[])
{

    Car car;
    int gas = car.get_gas();
    printf("gas is %d \n",gas);
    Car car2(500);
    int gas2 = car2.get_gas();
    printf("The new car has %d amount of gas \n", gas2);
    car2.set_gas(1000);
    printf("Now the new amount of gas for the second car is %d \n", car2.get_gas());
    return 0;
}

