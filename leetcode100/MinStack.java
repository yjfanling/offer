package leetcode100;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    TreeNode head = new TreeNode(Integer.MIN_VALUE);

    TreeNode last = new TreeNode(Integer.MAX_VALUE);

    List<Integer> list = new ArrayList<>();

    public MinStack() {
        head.right = last;
        last.left = head;
    }

    public void push(int val) {
        list.add(val);
        TreeNode node = new TreeNode(val);
        TreeNode tmp = head.right;
        while (tmp.right != null ) {
            if (val > tmp.val) {
                tmp = tmp.right;
            } else {
                addToNode(node, tmp);
                return;
            }
        }
        addToNode(node, tmp);
    }

    private static void addToNode(TreeNode node, TreeNode next) {
        TreeNode pre = next.left;
        pre.right = node;
        node.right = next;
        next.left = node;
        node.left = pre;
    }

    public void pop() {
        int val = list.remove(list.size()-1);
        TreeNode tmp = head.right;
        while (tmp.right != null ) {
            if (val != tmp.val) {
                tmp = tmp.right;
            } else {
                tmp.left.right = tmp.right;
                tmp.right.left = tmp.left;
                return;
            }
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return  head.right.val;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
/*
不使用辅助栈的做法
class MinStack:
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []
        self.min_value = -1

    def push(self, x: int) -> None:
        if not self.stack:
            self.stack.append(0)
            self.min_value = x
        else:
            diff = x-self.min_value
            self.stack.append(diff)
            self.min_value = self.min_value if diff > 0 else x

    def pop(self) -> None:
        if self.stack:
            diff = self.stack.pop()
            if diff < 0:
                top = self.min_value
                self.min_value = top - diff
            else:
                top = self.min_value + diff
            return top

    def top(self) -> int:
        return self.min_value if self.stack[-1] < 0 else self.stack[-1] + self.min_value

    def getMin(self) -> int:
        return self.min_value if self.stack else -1
 */
