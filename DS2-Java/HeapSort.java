import java.util.Scanner;  
public class HeapSort{
    static int heap[] = new int[100];
    static int size = 0;              

    // Swap two elements in the heap
    static void swap(int i,int j){
        int t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    // Heapify function to maintain max heap property
    static void heapify(int i){

        int largest = i;

        int left = 2*i+1;  
        int right = 2*i+2; 

    
        if(left<size && heap[left] > heap[largest])
            largest = left;

        if(right<size && heap[right] > heap[largest])
            largest = right;

        // If largest is not root, swap and continue heapify
        if(largest!=i){
            swap(i,largest);
            heapify(largest);
        }
    }

    // Create heap from user input
    static void create(Scanner sc){

        System.out.print("Enter number of elements: ");
        size = sc.nextInt();

        System.out.println("Enter elements:");

        // Store elements in array
        for(int i=0;i<size;i++)
            heap[i] = sc.nextInt();

        // Convert array into heap
        for(int i=size/2-1;i>=0;i--)
            heapify(i);
    }

    // Heap Sort algorithm
    static void sort(){

        int temp = size;

        // Move largest element to end repeatedly
        for(int i=size-1;i>0;i--){

            swap(0,i);  
            size--;

            heapify(0);  
        }

        size = temp;

        
        System.out.println("Sorted:");

        for(int i=0;i<size;i++)
            System.out.print(heap[i]+" ");
    }

       public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int ch;
        do{
            System.out.println("\n1.Create\n2.Sort\n0.Exit");
            ch = sc.nextInt();
            switch(ch){
                case 1:         
                    create(sc);
                    break;
                case 2:          
                    sort();
                    break;
            }
        }while(ch!=0);
        sc.close();  
    }
}