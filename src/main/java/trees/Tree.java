package trees;

import org.apache.commons.lang3.ArrayUtils;

public class Tree {
  //Implicit representation for treeArray
  
  private int[] treeArray;
  private int depth;

  public Tree(int treeDepth) {
    this.depth = treeDepth;
    this.treeArray =  new int[(int) Math.pow(2, treeDepth)];
    treeArray[0] = Integer.MIN_VALUE;
  }

  public int returnRoot() {
    return treeArray[1];
  }

  public int[] getTreeArray() {
    return treeArray;
  }

  public int getDepth() {
    return depth;
  }

  public void setTreeArray(int[] treeArray) {
    this.treeArray = treeArray;
  }

  public Tree returnLeftSubTree() {
    if (depth == 0) return null;

    Tree ret = new Tree(depth - 1);
    for (int i  = 1; i < depth; i ++) {
      for (int j  = 0; j < depth - 1; j ++) {
        ret.getTreeArray()[(int) Math.pow(2, i - 1) + j]
            = treeArray[(int) Math.pow(2, i) + j];
      }
    }

    return ret;
  }

  public Tree returnRightSubTree() {
    if (depth == 0) return null;

    Tree ret = new Tree(depth - 1);
    for (int i  = 1; i < depth; i ++) {
      for (int j  = 0; j < depth - 1; j ++) {
        ret.getTreeArray()[(int) Math.pow(2, i - 1) + j]
            = treeArray[(int) (Math.pow(2, i) + Math.pow(2, i - 1)) + j];
      }
    }

    return ret;
  }

  public void setLeftSubTree(Tree leftSub) {
    if (leftSub.getDepth() >= depth) {
      this.treeArray = ArrayUtils.addAll(
          this.treeArray,
          new int[(int) (Math.pow(2, leftSub.getDepth() + 1) - Math.pow(2, depth))]);
      this.depth = leftSub.getDepth() + 1;
    }

    for (int i  = 1; i < depth; i ++) {
      for (int j  = 0; j < depth - 1; j ++) {
        treeArray[(int) Math.pow(2, i) + j] =
            leftSub.getTreeArray()[(int) Math.pow(2, i - 1) + j];
      }
    }
  }

  public void setRightSubTree(Tree rightSub) {
    if (rightSub.getDepth() >= depth) {
      this.treeArray = ArrayUtils.addAll(
          this.treeArray,
          new int[(int) (Math.pow(2, rightSub.getDepth() + 1) - Math.pow(2, depth))]);
      this.depth = rightSub.getDepth() + 1;
    }

    for (int i  = 1; i < depth; i ++) {
      for (int j  = 0; j < depth - 1; j ++) {
        treeArray[(int) (Math.pow(2, i) + Math.pow(2, i - 1)) + j]
            = rightSub.getTreeArray()[(int) Math.pow(2, i - 1) + j];
      }
    }
  }


}
