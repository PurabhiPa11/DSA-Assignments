#include <iostream>
#include <stack>
using namespace std;
int precedence(char c) {
if(c=='+'||c=='-') return 1;
if(c=='*'||c=='/') return 2;
return 0;
}
int main() {
string infix, postfix="";
cout<<"Enter Infix Expression: "; cin>>infix;
stack<char> s;
for(int i=0; i<infix.length(); i++){
char c = infix[i];
if(isalnum(c)) postfix+=c;
else if(c=='(') s.push(c);
else if(c==')'){
while(!s.empty() && s.top()!='('){ postfix+=s.top(); s.pop(); }
s.pop();
}
else{
while(!s.empty() && precedence(s.top())>=precedence(c)){
postfix+=s.top(); s.pop();
}
s.push(c);
}
}
while(!s.empty()){ postfix+=s.top(); s.pop(); }
cout<<"Postfix: "<<postfix;
}