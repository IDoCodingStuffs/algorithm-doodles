import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import trees.Tree;

public class TreeTest {
  @Test
  public void testGetLeftSubTree() {
    Tree tree = new Tree(2);
    tree.setTreeArray(new int[]{Integer.MIN_VALUE,1,2,3});

    assertEquals(2, tree.returnLeftSubTree().getTreeArray()[1]);
    assertEquals(2, tree.returnLeftSubTree().getTreeArray().length);

    tree = new Tree(3);
    tree.setTreeArray(new int[]{Integer.MIN_VALUE,1,2,3,4,5,6,7});

    assertEquals(2, tree.returnLeftSubTree().getTreeArray()[1]);
    assertEquals(4, tree.returnLeftSubTree().getTreeArray()[2]);
    assertEquals(5, tree.returnLeftSubTree().getTreeArray()[3]);
    assertEquals(4, tree.returnLeftSubTree().getTreeArray().length);
  }

  @Test
  public void testGetRightSubTree() {
    Tree tree = new Tree(2);
    tree.setTreeArray(new int[]{Integer.MIN_VALUE,1,2,3});

    assertEquals(3, tree.returnRightSubTree().getTreeArray()[1]);
    assertEquals(2, tree.returnRightSubTree().getTreeArray().length);

    tree = new Tree(3);
    tree.setTreeArray(new int[]{Integer.MIN_VALUE,1,2,3,4,5,6,7});

    assertEquals(3, tree.returnRightSubTree().getTreeArray()[1]);
    assertEquals(6, tree.returnRightSubTree().getTreeArray()[2]);
    assertEquals(7, tree.returnRightSubTree().getTreeArray()[3]);
    assertEquals(4, tree.returnRightSubTree().getTreeArray().length);
  }

  @Test
  public void testSetLeftSubTree() {
    Tree tree = new Tree(1);
    tree.getTreeArray()[1] = 1;

    Tree leftSub = new Tree(1);
    leftSub.getTreeArray()[1] = 2;

    tree.setLeftSubTree(leftSub);

    assertEquals(2, tree.getTreeArray()[2]);
    assertEquals(4, tree.getTreeArray().length);
  }

  @Test
  public void testSetRightSubTree() {
    Tree tree = new Tree(1);
    tree.getTreeArray()[1] = 1;

    Tree rightSub = new Tree(1);
    rightSub.getTreeArray()[1] = 3;

    tree.setRightSubTree(rightSub);

    assertEquals(3, tree.getTreeArray()[3]);
    assertEquals(4, tree.getTreeArray().length);
  }
}
