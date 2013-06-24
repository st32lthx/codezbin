#include <iostream>
using std::cout;using std::endl;
/*
Passing by pointer, the value is manipulated directly. - method (1)
*/
void manipulate ( int *input){

    input[0] +=1;
}

/*
Passing by reference, the value is manipulated directly. - method (2)
*/

void manipulate2 ( int &input){

    input +=1;
}



int main() {

    cout << "POINTERS" << endl;
    printf("------------------ \n");
/**************************/
    int quantity   =   2 ;

/* pointer (not *pointer) gets the address where quantity lives */
    int *pointer =  &quantity;

    cout << quantity << " : Prints the value in the variable quantity " << endl;
    cout << pointer << " : Prints the address of pointee " << endl;
/*  dereference the pointer by * operator. */
    cout << *pointer << " : Prints the value pointed by the pointer" << endl;


/* Setting the value using the pointer */

*pointer    =   3;  /* equivalent to    quantity = 3    */

/*  dereference the pointer by * operator. */
    cout << *pointer << " : Prints the value pointed by the pointer" << endl;


    printf("-------Functions and Pointers (1)----------- \n");
    int *input = (int *)malloc(sizeof(int));

    cout << input[0] << ": value before being manipulated" << endl;
/*   manipulate needs the address of varaible */
    manipulate(input);
    cout << input[0] << ": value AFTER being manipulated" << endl;
    free(input);

    printf("-------Functions and Pointers (2)----------- \n");
    int input2 = 20;
    cout << input2 << ": value before being manipulated" << endl;
/*   manipulate2 needs the address implicity */
    manipulate2(input2);
    cout << input2 << ": value AFTER being manipulated" << endl;

    


    printf("-------Dynamic Memory Allocation----------- \n");
    int *grades = new int;

    grades[0] = 4;
    grades[1] = 3;
    grades[2] = 2;

    for (int i = 0; i < 3; ++i)
    {
        cout << grades[i] << ": value at index " << i << endl;
    }

    delete grades;
    grades = NULL;

    printf("-------Pointers and Arrays----------- \n");

    int points[ 10 ];
    int *_points = points;

    /* fill up the array */

    for (int i = 0; i < 10; ++i)
    {
        _points [ i ] = i;
    }

    for (int i = 0; i < 10; ++i)        
    {
        cout << _points [ i ] << ": value at the index: " << i << endl;

    }

    printf("-------2D arrays with pointers----------- \n");

    int size = 2;
    int **matrix = new int*[size];
    for (int i = 0; i < size; ++i){

        matrix [ i ] = new int[size];
    }

    /* the commented for loop can populate the matrix */

    // for (int i = 0; i<size ;++i ){

    //     for (int j = 0; j < size; ++j){

    //         matrix[i][j] = 4;
    //     }
    // }

    matrix[0][0] = 1;
    matrix[0][1] = 2;
    matrix[0][2] = 3;
    matrix[0][3] = 4;

    matrix[1][0] = 5;
    matrix[1][1] = 6;
    matrix[1][2] = 7;
    matrix[1][3] = 8;

    cout << matrix[0][0] << "(0,0)" << endl;
    cout << matrix[0][1] << "(0,1)" << endl;
    cout << matrix[0][2] << "(0,2)" << endl;
    cout << matrix[0][3] << "(0,3)" << endl;
    cout << matrix[1][0] << "(1,0)" << endl;
    cout << matrix[1][1] << "(1,1)" << endl;
    cout << matrix[1][2] << "(1,2)" << endl;
    cout << matrix[1][3] << "(1,3)" << endl;


    /* To free memory, free rows first, then the pointers to the rows. */

    for (int i = 0; i < size; ++i){

        delete [] matrix[i];
    }

    delete [] matrix;



    return 0;
}