#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int a;
    cin >> a;

    if(a<0){
        cout << a << '\n';
        cout << "minus";
    }
    else{
        cout << a;
    }
    return 0;
}