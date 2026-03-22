#include <iostream>
#include <string>
using namespace std;
struct Book { int id; string title, author; };
int main() {
int n;
cout << "Enter number of books: ";
cin >> n;
cin.ignore();
Book books[50];
for(int i=0;i<n;i++){
cout << "Enter Book ID: "; cin >> books[i].id; cin.ignore();
cout << "Enter Title: "; getline(cin, books[i].title);
cout << "Enter Author: "; getline(cin, books[i].author);
}
string searchAuthor;
cout << "Enter Author to search: "; getline(cin, searchAuthor);
bool found=false;
for(int i=0;i<n;i++){
if(books[i].author==searchAuthor){
cout << "Found: " << books[i].id << " " << books[i].title << " " << books[i].author << endl;
found=true; break;
}
}
if(!found) cout << "Author not found!\n";
for(int i=0;i<n-1;i++)
for(int j=0;j<n-i-1;j++)
if(books[j].id>books[j+1].id)
swap(books[j],books[j+1]);
int searchID;
cout << "Enter Book ID to search: "; cin >> searchID;
int left=0, right=n-1, mid;
found=false;
while(left<=right){
mid=(left+right)/2;
if(books[mid].id==searchID){
cout << "Found: " << books[mid].id << " " << books[mid].title << " " << books[mid].author << endl;
found=true; break;
}
else if(books[mid].id<searchID) left=mid+1;
else right=mid-1;
}
if(!found) cout << "Book ID not found!\n";
return 0;
}