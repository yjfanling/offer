package leetcode100;

public class CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node copyNode = head;
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node result = head.next;
        for (Node node = head; node != null ; node = node.next) {
            Node newNode = node.next;
            node.next = node.next.next;
            newNode.next = newNode.next!=null ? newNode.next.next : null;
        }
        return  result;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}