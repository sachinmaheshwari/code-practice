package fromaman;

public class TreeNode {

	private int data;
	private TreeNode leftChild;
	private TreeNode rightChild;
    //horizontal distance root 0 left child -1 right child +1 and so on
	private int hd;
	
	public TreeNode(int data, TreeNode leftChild, TreeNode rightChild) {
		super();
		this.data = data;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public TreeNode(int data) {
		super();
		this.data = data;
		this.leftChild = null;
		this.rightChild = null;
	}

    public int getHd() {
        return hd;
    }

    public void setHd(int hd) {
        this.hd = hd;
    }

    public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public TreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
}
