//
//  main.cpp
//  cppclasstr2
//
//  Created by Amin Meyghani on 12/24/12.
//  Copyright (c) 2012 Amin Meyghani. All rights reserved.
//

#include <iostream>
#import "Stock.h"
int main(int argc, const char * argv[])
{
    
    Stock stock1;
    stock1.acquire("NanoSmart", 20, 12.50);
    std::cout.setf(std::ios_base::fixed);        // #.## format
    std::cout.precision(2);                 // #.## format
    std::cout.setf(std::ios_base::showpoint);    // #.## format
    stock1.show();
    stock1.buy(15, 18.25);
    stock1.show();
    stock1.sell(400, 20.00);
    stock1.show();
    return 0;
}



