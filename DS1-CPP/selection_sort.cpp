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
cout << "\n\n1. Selection Sort\nEnter choice: ";
cin >> ch;
switch (ch) {
case 1:
for (int i = 0; i < n - 1; i++) {
int minIndex = i;
for (int j = i + 1; j < n; j++) {
if (a[j] < a[minIndex]) minIndex = j;
}
int temp = a[i];
a[i] = a[minIndex];
a[minIndex] = temp;
}
cout << "\nSorted array: ";
for (int i = 0; i < n; i++) cout << a[i] << " ";
break;
default:
cout << "Invalid choice!";
}
}