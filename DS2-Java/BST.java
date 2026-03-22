import java.util.Scanner;  
class Node {

int data;          
Node left, right;  
// Constructor to initialize node with data
Node(int data) {
this.data = data;
left = right = null;  
}
}

public class BST {
Node root;   
void insert(int data) {
Node newNode = new Node(data);  
// If tree is empty, new node becomes root
if (root == null) {
root = newNode;
return;
}

Node current = root, parent = null;  // Start traversal from root

// Traverse tree to find correct position
while (current != null) {

parent = current;

// If value smaller → go left
if (data < current.data)
current = current.left;

// If value greater → go right
else if (data > current.data)
current = current.right;
else
return;
}

// Attach new node at correct position
if (data < parent.data)
parent.left = newNode;
else
parent.right = newNode;
}

// ---------------- SEARCH OPERATION ----------------
// Searches an element in the BST
void search(int key) {

Node current = root;  
// Traverse until element found or tree ends
while (current != null) {

if (key == current.data) {   // If element matches
System.out.println("Element found");
return;
}

// Decide direction based on BST property
current = (key < current.data) ? current.left : current.right;
}

// If loop ends → element not present
System.out.println("Element not found");
}

// ---------------- FIND MINIMUM ----------------
// Finds smallest element (leftmost node)
void findMin() {

if (root == null) {   // Check if tree empty
System.out.println("Tree is empty");
return;
}

Node current = root;

// Move continuously to left child
while (current.left != null)
current = current.left;

System.out.println("Minimum element: " + current.data);
}

// ---------------- FIND MAXIMUM ----------------
// Finds largest element (rightmost node)
void findMax() {

if (root == null) {
System.out.println("Tree is empty");
return;
}

Node current = root;

// Move continuously to right child
while (current.right != null)
current = current.right;

System.out.println("Maximum element: " + current.data);
}

// ---------------- DELETE OPERATION ----------------
// Deletes a node from BST
void delete(int key) {
Node current = root, parent = null;
// First locate the node to delete
while (current != null && current.data != key) {
parent = current;
current = (key < current.data) ? current.left : current.right;
}
if (current == null) {
System.out.println("Element not found");
return;
}

// Case 1 & 2: Node has 0 or 1 child
if (current.left == null || current.right == null) {

Node child = (current.left != null) ? current.left : current.right;

// If deleting root node
if (current == root)
root = child;

// Connect parent with child
else if (parent.left == current)
parent.left = child;
else
parent.right = child;
}

// Case 3: Node has two children
else {

Node successorParent = current;
Node successor = current.right;

// Find inorder successor (smallest in right subtree)
while (successor.left != null) {
successorParent = successor;
successor = successor.left;
}

// Replace current node value with successor value
current.data = successor.data;

// Remove successor node
if (successorParent.left == successor)
successorParent.left = successor.right;
else
successorParent.right = successor.right;
}

System.out.println("Element deleted");
}

// ---------------- DISPLAY BST ----------------
// Displays BST elements using inorder traversal (non-recursive)
void display() {

if (root == null) {
System.out.println("Tree is empty");
return;
}

// Manual stack for traversal
Node stack[] = new Node[50];
int top = -1;

Node current = root;

System.out.print("BST elements: ");

// Inorder traversal using stack
while (current != null || top != -1) {

while (current != null) {
stack[++top] = current;   // Push node
current = current.left;   // Move to left subtree
}

current = stack[top--];   // Pop node
System.out.print(current.data + " ");

current = current.right;  // Move to right subtree
}

System.out.println();
}

// ---------------- MAIN METHOD ----------------
// Menu-driven program
public static void main(String[] args) {

BST bst = new BST();            // Create BST object
Scanner sc = new Scanner(System.in);  
int choice, value;
do {
System.out.println("\n1.Insert\n2.Delete\n3.Search\n4.Find Minimum\n5.Find Maximum\n6.Display\n7.Exit");
System.out.print("Enter choice: ");
choice = sc.nextInt();
switch (choice) {
case 1:
System.out.print("Enter value: ");
value = sc.nextInt();
bst.insert(value);
break;
case 2:
System.out.print("Enter value to delete: ");
value = sc.nextInt();
bst.delete(value);
break;
case 3:
System.out.print("Enter value to search: ");
value = sc.nextInt();
bst.search(value);
break;
case 4:
bst.findMin();
break;
case 5:
bst.findMax();
break;
case 6:
bst.display();
break;
case 7:
System.out.println("Program terminated");
break;
default:
System.out.println("Invalid choice");
}
} while (choice != 7);  
sc.close();  
}
}