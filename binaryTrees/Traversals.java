package traversals;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Your implementation of the pre-order, in-order, and post-order
 * traversals of a tree.
 */
public class Traversals<T extends Comparable<? super T>> {

    /**
     * DO NOT ADD ANY GLOBAL VARIABLES!
     */

    /**
     * Given the root of a binary search tree, generate a
     * pre-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the pre-order traversal of the tree.
     */
    public List<T> preorder(TreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (root == null) {
        	return result;
        }
        preorderHelper(root, result);
        return result;
    }
    
    private void preorderHelper(TreeNode<T> node, List<T> result) {
    	if (node == null) {
    		return;
    	}
    	result.add(node.getData());
    	preorderHelper(node.getLeft(), result);
    	preorderHelper(node.getRight(), result);
    }
    
    /**
     * Given the root of a binary search tree, generate an
     * in-order traversal of the tree. The original tree
     * should not be modified in any way.
     *
     * This must be done recursively.
     *
     * Must be O(n).
     *
     * @param <T> Generic type.
     * @param root The root of a BST.
     * @return List containing the in-order traversal of the tree.
     */
    public List<T> inorder(TreeNode<T> root) {
    	List<T> result = new ArrayList<>();
    	if (root == null) {
    		return result;
    	}
    	inorderHelper(root, result);
		return result; 
    }
    
    private void inorderHelper(TreeNode<T> node, List<T> result) {
    	if (node == null) {
    		return;
    	}
    	inorderHelper(node.getLeft(), result);
    	result.add(node.getData());
    	inorderHelper(node.getRight() ,result);
    }
    
    public List<T> postorder(TreeNode<T> root){
    	List<T> result = new ArrayList<>();
    	if (root == null) {
    		return result;
    	}
    	postorderHelper(root, result);
    	return result;
    }
    
    private void postorderHelper(TreeNode<T> node, List<T> result) {
    	if (node == null) {
    		return;
    	}
    	postorderHelper(node.getLeft(), result);
    	postorderHelper(node.getRight(), result);
    	result.add(node.getData());
    }
}
    