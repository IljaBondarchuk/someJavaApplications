package codewars;



import java.util.ArrayList;
import java.util.Stack;

public class LoopInspector {
    public static void main(String[] args) {

    }


    public int loopSize(Node node){
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(node);
        while (true) {
            node = node.getNext();
            if (nodeStack.search(node) == -1) {
                nodeStack.push(node);
            } else {
                return nodeStack.search(node);
            }
        }
    }
     static class Node{

        // data fields (reference variables)
        // data stores an
        // next points to the next node
        private Node next;

        public Node( Node next2) {
            next = next2;
        }


        /**
         * This Is An "Accessor" Method - Used To Get A Data Field.
         *
         * @return the data
         */

        /**
         * This Is An "Accessor" Method - Used To Get A Data Field.
         *
         * @return the address to the next node
         */
        public Node getNext() {
            return next;
        }
    }
}
