#include <iostream>
using namespace std;
struct Term {
int row, col, value;
};
int main() {
int rows, cols, n;
cout << "Enter number of rows, columns and non-zero elements: ";
cin >> rows >> cols >> n;
Term sparse[20], transpose[20];
cout << "Enter row, column and value of each non-zero element:\n";
for (int i = 0; i < n; i++) {
cin >> sparse[i].row >> sparse[i].col >> sparse[i].value;
}
int count[20] = {0};
for (int i = 0; i < n; i++) {
count[sparse[i].col]++;

}
int index[20];
index[0] = 0;
for (int i = 1; i < cols; i++) {
index[i] = index[i-1] + count[i-1];
}
for (int i = 0; i < n; i++) {
int colIndex = sparse[i].col;
int pos = index[colIndex];
transpose[pos].row = sparse[i].col;
transpose[pos].col = sparse[i].row;
transpose[pos].value = sparse[i].value;
index[colIndex]++;
}
cout << "\nFast Transpose of Sparse Matrix:\n";
cout << "Row Col Value\n";
for (int i = 0; i < n; i++) {
cout << transpose[i].row << " "
<< transpose[i].col << " "
<< transpose[i].value << endl;
}
return 0;
}