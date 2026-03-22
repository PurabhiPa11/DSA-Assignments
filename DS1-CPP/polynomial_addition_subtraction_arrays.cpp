#include <iostream>
using namespace std;
struct Term {
int coeff;
int exp;
};
int main() {
int n1, n2;
cout << "Enter number of terms in first polynomial: ";
cin >> n1;
Term poly1[20];
cout << "Enter coefficient and exponent for each term:\n";
for (int i = 0; i < n1; i++) {
cin >> poly1[i].coeff >> poly1[i].exp;
}
cout << "Enter number of terms in second polynomial: ";
cin >> n2;
Term poly2[20];
cout << "Enter coefficient and exponent for each term:\n";
for (int i = 0; i < n2; i++) {
cin >> poly2[i].coeff >> poly2[i].exp;
}
cout << "\nResult of Addition: ";
int i = 0, j = 0;
while (i < n1 && j < n2) {
if (poly1[i].exp == poly2[j].exp) {
cout << poly1[i].coeff + poly2[j].coeff << "x^" << poly1[i].exp << " ";
i++; j++;
} else if (poly1[i].exp > poly2[j].exp) {
cout << poly1[i].coeff << "x^" << poly1[i].exp << " ";
i++;
} else {
cout << poly2[j].coeff << "x^" << poly2[j].exp << " ";
j++;
}
}
while (i < n1) cout << poly1[i].coeff << "x^" << poly1[i++].exp << " ";
while (j < n2) cout << poly2[j].coeff << "x^" << poly2[j++].exp << " ";
cout << "\nResult of Subtraction (P1 - P2): ";
i = 0; j = 0;
while (i < n1 && j < n2) {
if (poly1[i].exp == poly2[j].exp) {
cout << poly1[i].coeff - poly2[j].coeff << "x^" << poly1[i].exp << " ";
i++; j++;
} else if (poly1[i].exp > poly2[j].exp) {
cout << poly1[i].coeff << "x^" << poly1[i].exp << " ";
i++;
} else {

cout << -poly2[j].coeff << "x^" << poly2[j].exp << " ";
j++;
}
}
while (i < n1) cout << poly1[i].coeff << "x^" << poly1[i++].exp << " ";
while (j < n2) cout << -poly2[j].coeff << "x^" << poly2[j++].exp << " ";
return 0;
}