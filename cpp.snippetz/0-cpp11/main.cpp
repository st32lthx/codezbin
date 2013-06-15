//Hello World C++ 11
//=====================
#include <iostream>
#include <sstream>
#include <vector>
using namespace std;

int main( int argc, char ** argv ) {
	stringstream version;
	version << "GCC version: "
    << __GNUC__ << "." << __GNUC_MINOR__ << "." << __GNUC_PATCHLEVEL__
    << "\nVersion string: " << __VERSION__;
    
	cout << version.str() << endl;
    
	vector<string> v = { "one", "two", "three" };

	for( string s : v ) {	
		cout << s << endl;
	}
    
	return 0;
}

