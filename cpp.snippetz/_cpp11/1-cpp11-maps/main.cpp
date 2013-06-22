#include <map>
#include <string>
#include <iostream>
using namespace std;
int main() {
    multimap<int,string> entryMap;
    
    entryMap = {
        {5,"fifth"},
        {2,"second"},
        {1,"first"},
        {4,"forth"},
        {6,"sixth"},
        {3,"third"}
    };
    
    
    
    /*
     const &elem: read only passed reference
     auto: interface type good practice
     */
    for (const auto &elem : entryMap) {
        cout << elem.first << " " << elem.second << " ";
    }
    cout << endl;
    
}