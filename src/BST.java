public class BST {
    BST root;
    BST left;
    BST right;
    int data;
    public BST(){

    }
    public  BST(int data){
        this.data = data;
    }

    public void insert(int data){
        if(root==null){
            BST node = new BST(data);
            root = node;
        }
        BST temp = root;
        BST prev = null;
        while(temp != null){
            prev = temp;
            if(data > temp.data)
                temp=temp.right;
            else if(data < temp.data)
                temp = temp.left;
            else
                return;
        }
        BST node = new BST(data);
        if(data > prev.data)
            prev.right = node;
        else{
            prev.left = node;
        }
    }

    public BST delete(BST n ,int data){
        if(n==null)
            return n;
        if(data < n.data)
            n.left = delete(n.left, data);
        else if(data > n.data)
            n.right = delete(n.right, data);
        // whoooho got you bitch
        else if(n.left ==null && n.right ==null){
            n = null;

        }else if (n.left== null){
            BST temp = n;
            n=n.right;
            return n;
        }else if(n.right==null){
            BST temp = n;
            n=n.left;
        }else{
            BST temp = findMin(n.right);
            n.data = temp.data;
            n.right = delete(n.right,temp.data);
        }

        return n;
    }

    public BST findMin(BST n){
        while(n.left!=null){
            n=n.left;
        }
        return n;
    }

    public void inorder(BST n){
        if(n != null){
            inorder(n.left);
            System.out.println(n.data);
            inorder(n.right);
        }
    }
    public int findHeight(BST root){
        if(root==null)
            return -1;
        int left=findHeight(root.left);
        int right=findHeight(root.right);
        return max(left,right)+1;
    }
    public int max(int left, int right){
        if(left>right)
            return left;
        return right;
    }

    public int sum(BST temp){
        if(temp==null)
            return 0;
        return temp.data+sum(temp.left)+sum(temp.right);
    }


    public boolean isBSTUtil(BST n, BST prev)
    {// traverse the tree in inorder fashion and // keep track of prev node
        if (n!=null)
        {
            if (!isBSTUtil(n.left, prev))
                return false;
            // Allows only distinct valued nodes
            if (prev != null && n.data <= prev.data)
                return false;
            prev = n;
            return isBSTUtil(n.right, prev);
        }

        return true;
    }
    public boolean isFullTree (BST n)
    {// If empty tree
        if (n == null)
            return true;
        // If leaf node
        if (n.left == null && n.right == null)
            return true;
        // If both left and right are not NULL, and left & right subtrees
        // are full
        if (n.left!=null && n.right!=null)
            return (isFullTree(n.left) && isFullTree(n.right));
        // We reach here when none of the above if conditions work
        return false;
    }

    public BST getRoot(){
        return root;
    }
}
