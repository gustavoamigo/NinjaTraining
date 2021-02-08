package fb;

public class InsertIntoSortedCircularLinkedList {

    class Node {
        public int val;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    };

    public Node insert(Node head, int insertVal) {
        Node root = head;
        int i = 0;
        if(head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }
        while(true) {
            int valHead = head.val;
            int valNext = head.next.val;
            // insert between
            if(valHead<valNext && valHead<=insertVal && insertVal<valNext) {
                Node newNode = new Node(insertVal, head.next);
                head.next = newNode;
                return root;
            } else if(valHead>valNext && (valHead<=insertVal || insertVal<=valNext)) {
                Node newNode = new Node(insertVal, head.next);
                head.next = newNode;
                return root;
            } else if(head == head.next) {
                Node newNode = new Node(insertVal, head.next);
                head.next = newNode;
                return root;
            } else if(head.next == root && i>0) {
                Node newNode = new Node(insertVal, head.next);
                head.next = newNode;
                return root;
            }
            i++;
            head = head.next;
        }
    }
}
