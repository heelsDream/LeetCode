package BinaryTreeLevelOrderTraversal_II;
import java.util.*;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		this.val = x;
	}	
}

// this version is the fastest
public class BT_traverse_II {
	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root){
		// 'result' will hold the node values in reverse order
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>> ();
		
		if(root == null){return result;}
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		// list of list 'list' to hold the node values in order
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		
		// initialize the 'queue' by adding the root node
		queue.add(root);
		
		// process the binary tree layer-by-layer and store the node values in 'list'
		while (!queue.isEmpty()){
			ArrayList<TreeNode> tempNodes = new ArrayList<TreeNode>();
			ArrayList<Integer> tempValues = new ArrayList<Integer>();
			
			// remove the same-layer nodes from the current 'queue' and store the value of each node into the 'tempValues'
			while(!queue.isEmpty()){
				TreeNode node = queue.remove();
				tempNodes.add(node);
				tempValues.add(node.val);				
			}
			list.add(tempValues);
			
			// refill the 'queue' with next level/layer nodes
			for (TreeNode node : tempNodes){
				if(node.left != null){
					queue.add(node.left);
				}
				if(node.right != null){
					queue.add(node.right);					
				}				
			}
				
		}
		
		// reverse the 'list' and store into 'result'
		for(int i=list.size()-1; i>=0; i--){
			result.add(list.get(i));			
		}		
		return result;
	}	
}
