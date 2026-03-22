#include <iostream>
using namespace std;

struct Node {
int data;
Node *prev, *next;
Node(int val) { data = val; prev = next = NULL; }
};

class DList {
Node* head;
public:
DList() { head = NULL; }

void create(int n) {
for (int i = 0, val; i < n; i++) {
cout << "Enter value: "; cin >> val;
insert(val);
}
}

void insert(int val) {
Node* n = new Node(val);
if (!head) head = n;
else {
Node* temp = head;

while (temp->next) temp = temp->next;
temp->next = n;
n->prev = temp;
}
}

void display() {
for (Node* t = head; t; t = t->next)
cout << t->data << " ";
cout << endl;
}

void del(int val) {
Node* t = head;
while (t && t->data != val) t = t->next;
if (!t) return;
if (t->prev) t->prev->next = t->next;
else head = t->next;
if (t->next) t->next->prev = t->prev;
delete t;
}

void search(int val) {
Node* t = head; int pos = 1;
while (t) {
if (t->data == val) { cout << "Found at position " << pos << endl; return; }
t = t->next; pos++;
}
cout << "Not found\n";

}

void sortList() {
for (Node* i = head; i; i = i->next)
for (Node* j = i->next; j; j = j->next)
if (i->data > j->data) swap(i->data, j->data);
}
};

int main() {
DList d;
int ch, n, val;
do {
cout << "\n1.Create 2.Display 3.Insert 4.Delete 5.Search 6.Sort 0.Exit\n";
cin >> ch;
switch (ch) {
case 1: cout << "Enter number of nodes: "; cin >> n; d.create(n); break;
case 2: d.display(); break;
case 3: cout << "Enter value to insert: "; cin >> val; d.insert(val); break;
case 4: cout << "Enter value to delete: "; cin >> val; d.del(val); break;
case 5: cout << "Enter value to search: "; cin >> val; d.search(val); break;
case 6: d.sortList(); cout << "List sorted.\n"; break;
}
} while (ch != 0);
return 0;
}