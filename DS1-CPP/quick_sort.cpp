#include <iostream>
using namespace std;
int partition(int a[], int low, int high) {
int pivot = a[high], i = low - 1;
for (int j = low; j < high; j++) {
if (a[j] <= pivot) {
i++;
int t = a[i]; a[i] = a[j]; a[j] = t;
}
}
int t = a[i + 1]; a[i + 1] = a[high]; a[high] = t;
return i + 1;
}
void quickSort(int a[], int low, int high) {
if (low < high) {
int pi = partition(a, low, high);
quickSort(a, low, pi - 1);
quickSort(a, pi + 1, high);
}
}
int main() {
int n, ch;
cout << "Enter number of elements: ";
cin >> n;
int a[50];
cout << "Enter elements: ";
for (int i = 0; i < n; i++) cin >> a[i];
cout << "\nOriginal array: ";
for (int i = 0; i < n; i++) cout << a[i] << " ";
cout << "\n\n1. Quick Sort\nEnter choice: ";
cin >> ch;
switch (ch) {
case 1:
quickSort(a, 0, n - 1);
cout << "\nSorted array: ";
for (int i = 0; i < n; i++) cout << a[i] << " ";
break;
default:
cout << "Invalid choice!";
}
}