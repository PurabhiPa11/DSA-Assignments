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
cout << "\n\n1. Bubble Sort\nEnter choice: ";
cin >> ch;
switch (ch) {
case 1:
for (int i = 0; i < n - 1; i++) {
for (int j = 0; j < n - i - 1; j++) {
if (a[j] > a[j + 1]) {
int temp = a[j];
a[j] = a[j + 1];
a[j + 1] = temp;
}
}
}
cout << "\nSorted array: ";

for (int i = 0; i < n; i++) cout << a[i] << " ";
break;
default:
cout << "Invalid choice!";
}
}