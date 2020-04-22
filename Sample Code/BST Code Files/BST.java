import java.util.*;               // for Stack class

class BST {
	private TNode root;
	
	public BST(){
		root = null;
	}
	
	public TNode getMin(TNode v){
		if (v.left==null)
			return v;
		else
			return getMin(v.left);
	}
		
	//replaces node u with node w in the tree
	//assumes node u is non-null
	private void replace(TNode u, TNode w){
		if (u.parent.left == u)
			u.parent.left = w;
		else
			u.parent.right = w;
	}
	
	//deletes node with key k from tree and returns it.
	//returns null if not found.
	public TNode delete(int k){
		//first find node to be deleted
		TNode v = find(k);
		if (v == null)
			return null;
		else { //v is non-null
			if (v.right == null && v.left == null) {
				//v is a leaf node
				replace(v, null);
			}
			else if (v.right != null && v.left != null) {
				//both children are present
				TNode s = getMin(v.right); //get successor of v
				v.key = s.key; //cheat by replacing contents of v
				//then deleting s instead of v
				replace(s,s.right); //note: s has no left child
			}
			else {//v has exactly one child
				if (v.left != null)
					replace(v,v.left);
				else
					replace(v,v.right);
			}
			return v;
		} //end big if 
	}
	
	public void recInsert(int k, TNode v){
		if (k > v.key){
			if (v.right == null) {
				v.right = new TNode(k,null,null,v);
			} else {
				recInsert(k, v.right);
			}
		} else if (k <= v.key) {
			if (v.left == null) {
				v.left = new TNode(k, null, null, v);
				v.left.parent = v;
			}
			else {
				recInsert(k, v.left);
			}
		}
	}
	
	public void insert(int k) {
		if (root == null) {
			root = new TNode(k, null, null, null);
		} else {
			recInsert(k, root);
		}
	}
	
	public TNode recFind(int k, TNode v){
		if (v == null){ //if recursively reached child of leaf node
			return null;
		} else if (k > v.key){
			return recFind(k, v.right);
		} else if (k < v.key) {
			return recFind(k, v.left);
		} else {
			return v;
		}
	}
	
	public TNode find(int k){
		return recFind(k, root);
	}
	
	public void traverse(char traverseType)
	{
		switch(traverseType)
		{
			case 'p': System.out.print("\nPreorder traversal: ");
				preOrder(root);
				break;
			case 'i': System.out.print("\nInorder traversal:  ");
				inOrder(root);
				break;
			case 't': System.out.print("\nPostorder traversal: ");
				postOrder(root);
				break;
		}
		System.out.println();
	}
	
	private void preOrder(TNode localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.key + " ");
			preOrder(localRoot.left);
			preOrder(localRoot.right);
		}
	}
	// -------------------------------------------------------------
	private void inOrder(TNode localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.left);
			System.out.print(localRoot.key + " ");
			inOrder(localRoot.right);
		}
	}
	// -------------------------------------------------------------
	private void postOrder(TNode localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.left);
			postOrder(localRoot.right);
			System.out.print(localRoot.key + " ");
		}
	}
	// -------------------------------------------------------------
	
	public void displayTree()
	{
		Stack<TNode> globalStack = new Stack<TNode>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
		"......................................................");
		while(isRowEmpty==false)
		{
			Stack<TNode> localStack = new Stack<TNode>();
			isRowEmpty = true;

			for(int j=0; j<nBlanks; j++)
			System.out.print(' ');

			while(globalStack.isEmpty()==false)
			{
				TNode temp = (TNode)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.key);
					localStack.push(temp.left);
					localStack.push(temp.right);

					if(temp.left != null ||
							temp.right != null)
					isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
				System.out.print(' ');
			}  // end while
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
			globalStack.push( localStack.pop() );
		}  // end while isRowEmpty is false
		System.out.println(
		"......................................................");
	}  // end displayTree()
}
	