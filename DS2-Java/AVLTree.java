import java.util.*;  
class Node{
    String key;                 
    int bf;                     
    Node left,right,parent;    
    Node(String k){           
        key=k;
    }
}

public class AVLTree{
    Node root;                
    // Function to calculate height of a node
    int h(Node n){
        if(n==null) return 0;
        return 1+Math.max(h(n.left),h(n.right));
    }

    // Update balance factor of a node
    void update(Node n){
        if(n!=null)
            n.bf=h(n.left)-h(n.right);
    }

    // Right Rotation (used when tree becomes left heavy)
    Node rightRotate(Node y){

        Node x=y.left;         
        y.left=x.right;

        if(x.right!=null) x.right.parent=y;

        x.right=y;

        x.parent=y.parent;
        y.parent=x;

        update(y);            
        update(x);

        return x;
    }

    // Left Rotation (used when tree becomes right heavy)
    Node leftRotate(Node x){

        Node y=x.right;       
        x.right=y.left;

        if(y.left!=null) y.left.parent=x;

        y.left=x;

        y.parent=x.parent;
        x.parent=y;

        update(x);
        update(y);

        return y;
    }

    // Balance the tree if BF becomes >1 or <-1
    Node balance(Node n){

        update(n);

        if(n.bf>1){                 
            if(n.left.bf<0)         
                n.left=leftRotate(n.left);
            return rightRotate(n);  
        }

        if(n.bf<-1){               
            if(n.right.bf>0)       
                n.right=rightRotate(n.right);
            return leftRotate(n);  
        }

        return n;                  
    }

    // Insert operation (BST insertion + balancing)
    Node insert(Node n,String key,Node p){

        if(n==null){
            Node t=new Node(key);
            t.parent=p;
            return t;
        }

        if(key.compareTo(n.key)<0)
            n.left=insert(n.left,key,n);

        else if(key.compareTo(n.key)>0)
            n.right=insert(n.right,key,n);

        return balance(n);     
    }
    Node min(Node n){
        while(n.left!=null)
            n=n.left;
        return n;
    }
    Node delete(Node n,String key){

        if(n==null) return null;

        if(key.compareTo(n.key)<0)
            n.left=delete(n.left,key);

        else if(key.compareTo(n.key)>0)
            n.right=delete(n.right,key);

        else{

            // Node with one or no child
            if(n.left==null) return n.right;
            if(n.right==null) return n.left;

            // Node with two children
            Node t=min(n.right); 
            n.key=t.key;
            n.right=delete(n.right,t.key);
        }

        return balance(n);       
    }

   
    void inorder(Node r){
        if(r!=null){
            inorder(r.left);
            System.out.print(r.key+" ");
            inorder(r.right);
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        AVLTree t=new AVLTree();  
        int ch;
        String m;
        do{

            System.out.println("\n1.Insert Month\n2.Delete Month\n3.Display\n0.Exit");

            ch=sc.nextInt();
            sc.nextLine();

            switch(ch){

                case 1:                    
                    System.out.print("Enter month: ");
                    m=sc.nextLine();
                    t.root=t.insert(t.root,m,null);
                    break;

                case 2:                    
                    System.out.print("Enter month to delete: ");
                    m=sc.nextLine();
                    t.root=t.delete(t.root,m);
                    break;
                case 3:                   
                    System.out.print("Months: ");
                    t.inorder(t.root);
                    System.out.println();
            }
        }while(ch!=0);
        sc.close();    
    }
}