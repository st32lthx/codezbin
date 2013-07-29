//
//  main.cpp
//  ds-array
//
//  Created by Amin Meyghani on 1/3/13.
//  Copyright (c) 2013 Amin Meyghani. All rights reserved.
//

#include <iostream>
#include <array>
#include <vector>
#include <type_traits>
//functino template

template <typename Type>
Type max(Type a, Type b) {
    return a > b ? a : b;
}

int main(int argc, const char * argv[])
{

    //define one-dim array of ints with ten elements
    int numbers[10];
    numbers[0] = 1;
    numbers[1] = 2;
    int muNumber = numbers[0];
    std::cout << muNumber<< std::endl;
    
    //define two-d array of strings (a 2x2 table)
    /*
     
     +----+----+
     | t1 | a1 |
     +----+----+
     | t2 | a2 |
     +----+----+
     
     */
    
    std::string myBooks[2][2];
    myBooks[0][0] = "t1";
    myBooks[0][1] = "a1";
    
    myBooks[1][0] = "t2";
    myBooks[1][1] = "a2";
    
    //TODO:
    //Figure out how to write the correct for loop
    //figure out how to work with arrays in C++11, C++

    
    for (int i=0; i<2;i++){
        std::cout << myBooks[0][i] << std::endl;
    }
    
    
    for (int i=0; i<2;i++){
        std::cout << myBooks[1][i] << std::endl;
    }
    
    
    
    
    /*      Alternative way of creating arrays.
            3x2 table
            
            +------+------+
            |  b1  | au1  |
            +------+------+
            |  b2  |  au2 |
            +------+------+
            |  b3  |  au3 |
            +------+------+

            3 row , 2 cols
 
     */

    
    std::array<std::array<std::string, 2>, 3> myNumbers;
    myNumbers[0][0] = "b1";
    myNumbers[0][1] = "au1";
    
    
    myNumbers[1][0] = "b2";
    myNumbers[1][1] = "au2";
    
    myNumbers[2][0] = "b3";
    myNumbers[2][1] = "au3";
    
    std::cout << myNumbers[0][0] << " " << myNumbers[0][1]<< std::endl;
    std::cout <<myNumbers[1][0] << " " << myNumbers[1][1] <<std::endl;
    std::cout << myNumbers[2][0] << " " << myNumbers[2][1] <<std::endl;
    
    
    /*
     using templates to define a template for defining two dim arrays
     
     */
    
    
    //TODO
    
    
    
    
    
    /*
     using templates to define a template for defining two dim arrays
     
     */
    std::vector<int> vec;
    
    vec.push_back( 10 );
    vec.push_back( 20 );
    
    for (int &i : vec )
    {
        std::cout << i;
    }
    


    return 0;
}

