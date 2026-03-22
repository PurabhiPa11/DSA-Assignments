#include <iostream>
#include <stack>
using namespace std;
int main() {
string prefix;
cout<<"Enter Prefix Expression: "; cin>>prefix;
stack<string> s;
for(int i=prefix.length()-1; i>=0; i--){
char c = prefix[i];
if(isalnum(c)) s.push(string(1,c));
else{
string a=s.top(); s.pop();
string b=s.top(); s.pop();
s.push("("+a+c+b+")");
}
}
cout<<"Infix: "<<s.top();
}