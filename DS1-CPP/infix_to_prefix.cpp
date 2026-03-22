#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;
int precedence(char c) {
if(c=='+'||c=='-') return 1;
if(c=='*'||c=='/') return 2;
return 0;
}
string infixToPrefix(string infix){
reverse(infix.begin(), infix.end());
for(int i=0; i<infix.length(); i++){
if(infix[i]=='(') infix[i]=')';
else if(infix[i]==')') infix[i]='(';
}
stack<char> s; string prefix="";
for(int i=0; i<infix.length(); i++){
char c = infix[i];
if(isalnum(c)) prefix+=c;
else if(c=='(') s.push(c);
else if(c==')'){ while(!s.empty() && s.top()!='('){ prefix+=s.top(); s.pop(); } s.pop();}
else{
while(!s.empty() && precedence(s.top())>=precedence(c)){ prefix+=s.top(); s.pop(); }
s.push(c);
}
}
while(!s.empty()){ prefix+=s.top(); s.pop();}
reverse(prefix.begin(), prefix.end());
return prefix;
}
int main(){
string infix;
cout<<"Enter Infix Expression: "; cin>>infix;
cout<<"Prefix: "<<infixToPrefix(infix);
}