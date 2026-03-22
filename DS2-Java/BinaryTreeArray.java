import java.util.*; 

public class BinaryTreeArray {

    int tree[];
    int size = 0;

    BinaryTreeArray(int n){
        tree = new int[n];
    }

    // Insert node in array representation
    void insert(int val){
        if(size == tree.length){
            System.out.println("Tree Full");
            return;
        }
        tree[size++] = val;
    }

    // -------- Inorder Recursive --------
    void inorderRec(int i){
        if(i >= size) return;

        inorderRec(2*i+1);
        System.out.print(tree[i] + " ");
        inorderRec(2*i+2);
    }

    // -------- Inorder Non-Recursive --------
    void inorderNonRec(){

        Stack<Integer> st = new Stack<>();
        int i = 0;

        while(i < size || !st.isEmpty()){

            while(i < size){
                st.push(i);
                i = 2*i+1;
            }

            i = st.pop();
            System.out.print(tree[i] + " ");
            i = 2*i+2;
        }
    }

    // -------- Preorder Recursive --------
    void preorderRec(int i){

        if(i >= size) return;

        System.out.print(tree[i] + " ");
        preorderRec(2*i+1);
        preorderRec(2*i+2);
    }

    // -------- Preorder Non-Recursive --------
    void preorderNonRec(){

        Stack<Integer> st = new Stack<>();
        st.push(0);

        while(!st.isEmpty()){

            int i = st.pop();

            if(i >= size) continue;

            System.out.print(tree[i] + " ");

            st.push(2*i+2);
            st.push(2*i+1);
        }
    }

    // -------- Postorder Recursive --------
    void postorderRec(int i){

        if(i >= size) return;

        postorderRec(2*i+1);
        postorderRec(2*i+2);
        System.out.print(tree[i] + " ");
    }

    // -------- Postorder Non-Recursive --------
    void postorderNonRec(){

        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        s1.push(0);

        while(!s1.isEmpty()){

            int i = s1.pop();

            if(i >= size) continue;

            s2.push(i);

            s1.push(2*i+1);
            s1.push(2*i+2);
        }

        while(!s2.isEmpty())
            System.out.print(tree[s2.pop()] + " ");
    }

    // -------- Count Terminal (Leaf) Nodes --------
    int countLeafNodes(){

        int count = 0;

        for(int i=0;i<size;i++){
            if(2*i+1 >= size && 2*i+2 >= size)
                count++;
        }

        return count;
    }

    // -------- Main Menu Driven Program --------
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter max nodes: ");
        BinaryTreeArray bt = new BinaryTreeArray(sc.nextInt());

        int choice;

        do{

            System.out.println("\n1.Create");
            System.out.println("2.Inorder");
            System.out.println("3.Preorder");
            System.out.println("4.Postorder");
            System.out.println("5.Count Leaf");
            System.out.println("0.Exit");

            choice = sc.nextInt();

            switch(choice){

                case 1:

                    System.out.print("Enter number of nodes: ");
                    int n = sc.nextInt();

                    System.out.println("Enter node values:");

                    for(int i=0;i<n;i++)
                        bt.insert(sc.nextInt());

                    break;

                case 2:

                    System.out.print("Inorder Rec: ");
                    bt.inorderRec(0);

                    System.out.print("\nInorder NonRec: ");
                    bt.inorderNonRec();

                    break;

                case 3:

                    System.out.print("Preorder Rec: ");
                    bt.preorderRec(0);

                    System.out.print("\nPreorder NonRec: ");
                    bt.preorderNonRec();

                    break;

                case 4:

                    System.out.print("Postorder Rec: ");
                    bt.postorderRec(0);

                    System.out.print("\nPostorder NonRec: ");
                    bt.postorderNonRec();

                    break;

                case 5:

                    System.out.println("Leaf Nodes = " + bt.countLeafNodes());

                    break;
            }

        }while(choice != 0);

        sc.close();  
    }
}