#include <iostream>
using namespace std;
#define SIZE 5
class TakeAwayQueue {
string orders[SIZE];
int front, rear;
public:
TakeAwayQueue() {
front = rear = -1;
}
void placeOrder(string order) {
if (rear == SIZE - 1) {
cout << "Order Queue Full! Please wait.\n";
return;
}
if (front == -1) front = 0;
orders[++rear] = order;
cout << "Order placed: " << order << endl;
}
void serveOrder() {
if (front == -1 || front > rear) {
cout << "No pending orders!\n";
return;
}
cout << "Order served: " << orders[front++] << endl;
if (front > rear) front = rear = -1;
}
void displayOrders() {
if (front == -1) {
cout << "No pending orders.\n";
return;
}
cout << "Pending Orders: ";
for (int i = front; i <= rear; i++) {
cout << orders[i];
if (i < rear) cout << " -> ";
}
cout << endl;
}
};
int main() {
TakeAwayQueue tq;
int choice;
string order;
cout << "\n--- Hotel Take-Away System ---";
cout << "\n1. Place Order";
cout << "\n2. Serve Order";
cout << "\n3. Show Pending Orders";
cout << "\n4. Exit";
do {
cout << "\n\nEnter your choice: ";
cin >> choice;
cin.ignore();
switch (choice) {
case 1:
cout << "Enter order name: ";
getline(cin, order);
tq.placeOrder(order);
break;
case 2:
tq.serveOrder();
break;
case 3:
tq.displayOrders();
break;
case 4:
cout << "Exiting system. Thank you!\n";
break;
default:
cout << "Invalid choice! Try again.\n";
}
} while (choice != 4);
return 0;
}