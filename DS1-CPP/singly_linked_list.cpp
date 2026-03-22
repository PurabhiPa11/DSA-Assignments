#include <iostream>
#include <list>
#include <algorithm>

using namespace std;

int main() {
list<int> l;
int choice, val;

do {
cout << "\n1.Insert 2.Delete 3.Display 4.Search 5.Reverse 6.Sort 7.Merge 0.Exit\n";
cin >> choice;

if (choice == 1) {
cout << "Enter value: "; cin >> val;
l.push_back(val);
}
else if (choice == 2) {
cout << "Enter value to delete: "; cin >> val;
l.remove(val);
}
else if (choice == 3) {
cout << "List: ";
for (list<int>::iterator it = l.begin(); it != l.end(); ++it)
cout << *it << " ";
cout << endl;
}
else if (choice == 4) {
cout << "Enter value to search: "; cin >> val;
cout << (find(l.begin(), l.end(), val) != l.end() ? "Found\n" : "Not Found\n");
}
else if (choice == 5) {

l.reverse(); cout << "List reversed.\n";
}
else if (choice == 6) {
l.sort(); cout << "List sorted.\n";
}
else if (choice == 7) {
list<int> l2; int n, v;
cout << "Enter number of elements in 2nd list: "; cin >> n;
for (int i = 0; i < n; i++) { cin >> v; l2.push_back(v); }
l.merge(l2); cout << "Lists merged.\n";
}

} while (choice != 0);

return 0;
}