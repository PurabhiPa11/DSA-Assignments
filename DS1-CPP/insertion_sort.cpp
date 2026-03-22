#include <iostream>
using namespace std;
int main() {
int n, ch;
cout << "Enter number of elements: ";
cin >> n;
int a[50];
cout << "Enter elements: ";
for (int i = 0; i < n; i++) cin >> a[i];
cout << "\nOriginal array: ";
for (int i = 0; i < n; i++) cout << a[i] << " ";
cout << "\n\n1. Insertion Sort\nEnter choice: ";
cin >> ch;
switch (ch) {
case 1:
for (int i = 1; i < n; i++) {
int key = a[i], j = i - 1;
while (j >= 0 && a[j] > key) {
a[j + 1] = a[j];
j--;
}
a[j + 1] = key;
}
cout << "\nSorted array: ";
for (int i = 0; i < n; i++) cout << a[i] << " ";
break;
default:
cout << "Invalid choice!";
}
}