//
//  main.cpp
//  ds-structs
//
//  Created by Amin Meyghani on 1/3/13.
//  Copyright (c) 2013 Amin Meyghani. All rights reserved.
//

#include <iostream>
#import <string>
int main(int argc, const char * argv[])
{

    struct Book{
        int year;
        std::string title;
        std::string author;
        float price;
    };
    
    //make an instance
    
    Book myBook;
    
    //assign value
    
    myBook.title = "The Inversions of Paradise";
    myBook.price = 25.5;
    myBook.author = "Amin Meyghani";
    
    //access
    
    std::string bookTtitle = myBook.title;
    
    std::cout << "The title of my book is:" << bookTtitle << std::endl;

    return 0;
}

