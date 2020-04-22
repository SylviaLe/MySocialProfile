class TNode {
	public int key;
	public TNode left;
	public TNode right;
	public TNode parent;
	
	public TNode(int k, TNode L, TNode r, TNode p){
		key = k;
		left = L;
		right = r;
		parent = p;
	}
	
	public void displayNode(){
		System.out.println("{" + key + "}");
	}
}