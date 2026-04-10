import java.util.Scanner;

class HashTable {
    int size;
    int table[];

    HashTable(int size) {
        this.size = size;
        table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
    }

    void insert(int key) {
        int index = key % size;
        int start = index;

        while (table[index] != -1) {
            index = (index + 1) % size;

            if (index == start) {
                System.out.println("Hash Table is Full");
                return;
            }
        }

        table[index] = key;
        System.out.println("Key inserted successfully");
    }

    void search(int key) {
        int index = key % size;
        int start = index;

        while (table[index] != -1) {
            if (table[index] == key) {
                System.out.println("Key found at index " + index);
                return;
            }
            index = (index + 1) % size;

            if (index == start)
                break;
        }

        System.out.println("Key not found");
    }

    void delete(int key) {
        int index = key % size;
        int start = index;

        while (table[index] != -1) {
            if (table[index] == key) {
                table[index] = -1;
                System.out.println("Key deleted successfully");
                return;
            }
            index = (index + 1) % size;

            if (index == start)
                break;
        }

        System.out.println("Key not found");
    }

    void display() {
        System.out.println("Hash Table:");
        for (int i = 0; i < size; i++) {
            System.out.println(i + " -> " + table[i]);
        }
    }
}

public class HashTableLinearProbing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of hash table: ");
        int size = sc.nextInt();

        HashTable ht = new HashTable(size);

        while (true) {
            System.out.println("\n1.Insert");
            System.out.println("2.Search");
            System.out.println("3.Delete");
            System.out.println("4.Display");
            System.out.println("5.Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter key to insert: ");
                    int key1 = sc.nextInt();
                    ht.insert(key1);
                    break;

                case 2:
                    System.out.print("Enter key to search: ");
                    int key2 = sc.nextInt();
                    ht.search(key2);
                    break;

                case 3:
                    System.out.print("Enter key to delete: ");
                    int key3 = sc.nextInt();
                    ht.delete(key3);
                    break;

                case 4:
                    ht.display();
                    break;

                case 5:
                    System.exit(0);

                default:
                    System.out.println("Invalid choice");
                    sc.close();
            }
        }
    }
}