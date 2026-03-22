#include <iostream>
using namespace std;

struct Node {
int coeff, pow;
Node* next;
Node(int c, int p) { coeff = c; pow = p; next = NULL; }
};

class CircularPolynomial {
Node* head;
public:
CircularPolynomial() { head = NULL; }

void insert(int c, int p) {
Node* n = new Node(c, p);
if (!head) { head = n; n->next = head; return; }
Node* temp = head;
while (temp->next != head) temp = temp->next;
temp->next = n;
n->next = head;
}

void display() {
if (!head) return;
Node* temp = head;
do {
cout << temp->coeff << "x^" << temp->pow;
temp = temp->next;
if (temp != head) cout << " + ";
} while (temp != head);
cout << endl;
}

static CircularPolynomial add(CircularPolynomial &p1, CircularPolynomial &p2) {
CircularPolynomial res;
Node* t1 = p1.head; Node* t2 = p2.head;
if (!t1) return p2;

if (!t2) return p1;

do {
Node* temp2 = t2;
bool added = false;
do {
if (t1->pow == temp2->pow) {
res.insert(t1->coeff + temp2->coeff, t1->pow);
added = true;
break;
}
temp2 = temp2->next;
} while (temp2 != t2);
if (!added) res.insert(t1->coeff, t1->pow);
t1 = t1->next;
} while (t1 != p1.head);

t2 = p2.head;
do {
Node* tempRes = res.head;
bool exists = false;
do {
if (tempRes->pow == t2->pow) { exists = true; break; }
tempRes = tempRes->next;
} while (tempRes != res.head);
if (!exists) res.insert(t2->coeff, t2->pow);
t2 = t2->next;
} while (t2 != p2.head);

return res;
}
};

int main() {
CircularPolynomial p1, p2, sum;
int n, c, po;

cout << "Enter number of terms for 1st polynomial: "; cin >> n;
for(int i=0;i<n;i++){ cout<<"Coeff and power: "; cin>>c>>po; p1.insert(c,po); }

cout << "Enter number of terms for 2nd polynomial: "; cin >> n;
for(int i=0;i<n;i++){ cout<<"Coeff and power: "; cin>>c>>po; p2.insert(c,po); }

cout << "First Polynomial: "; p1.display();
cout << "Second Polynomial: "; p2.display();

sum = CircularPolynomial::add(p1,p2);
cout << "Sum: "; sum.display();

return 0;
}