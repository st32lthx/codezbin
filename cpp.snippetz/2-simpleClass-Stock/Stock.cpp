//  Stock.cpp
//  CppStock
//
//  Created by Amin Meyghani on 12/24/12.
//  Copyright (c) 2012 Amin Meyghani. All rights reserved.
//
#include "Stock.h"
#include <iostream>
#include <cstring>  // --or string.h--for strncpy()

void Stock::acquire(const char * co, int n, double pr){
    
    strncpy(company, co, 29); // truncate co to fit if needed
    company[29] = '\0';
    
    if (n < 0){
        std::cerr << "Number of shares can't be negative; "
        << "shares set to 0.\n";
        shares = 0;
    }else{
        
        shares = n;
        share_val = pr;
        set_tot();
    }
}

void Stock::buy(int num, double price){
    
    if (num < 0){
        std::cerr << "Number of shares purchased can't be negative. "
        << "Transaction is aborted.\n";
        
    }else{
        
        shares += num;
        share_val = price;
        set_tot();
    }
}

void Stock::sell(int num, double price){
    
    if (num < 0){
        
        std::cerr << "Number of shares sold can't be negative. "
        << "Transaction is aborted.\n";
        
    }else if (num > shares){
        
        std::cerr << "You can't sell more than you have! "
        << "Transaction is aborted.\n";
        
    }else{
        shares -= num;
        share_val = price;
        set_tot();
    }
}



void Stock::update(double price){
    share_val = price;
    set_tot();
}



void Stock::show(){
    
    std::cout << "Company: " << company
    << "  Shares: " << shares << '\n'
    << "  Share Price: $" << share_val
    << "  Total Worth: $" << total_val << '\n';
}





