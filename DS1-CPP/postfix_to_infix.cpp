#include <iostream>
#include <stack>
using namespace std;
int main() {
string postfix;
cout<<"Enter Postfix Expression: "; cin>>postfix;
stack<string> s;
for(int i=0; i<postfix.length(); i++){
char c = postfix[i];
if(isalnum(c)) s.push(string(1,c));
else{
string b=s.top(); s.pop();
string a=s.top(); s.pop();
s.push("("+a+c+b+")");
}
}
cout<<"Infix: "<<s.top();
}