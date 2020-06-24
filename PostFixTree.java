import java.util.Stack;


public class PostfixTree {

    private Stack<Node> stack = new Stack<>();

    class Node {
        boolean isOperator;
        String op;
        Node left;
        Node right;
        double value;
        Stack<Node> s = new Stack<>();
        Stack<Node> p = new Stack<>();

        Node(double d) {
            value = d;
            isOperator = false;
        }

        Node(String operator, Node l, Node r) {
            op = operator;
            isOperator = true;
            left = l;
            right = r;
        }

        private Stack<Node> recursInOrder(Node node) {
            if (!node.isOperator) {
                return s;
            }
            recursInOrder(node.left);
            s.push(node);
            recursInOrder(node.right);

                return s;
        }

        private Stack<Node> recursPoOrder(Node node) {
            if (node == null) {
                return p;
            }
            p.push(node);
            recursPoOrder(node.left);
            recursPoOrder(node.right);

                return p;
        }

        private int recursHeight(Node node) {
            if (node == null)
                return 0;
            else {
                int lHeight = recursHeight(node.left);
                int rHeight = recursHeight(node.right);
                    if (lHeight > rHeight)
                        return (lHeight + 1);
                    else
                        return (rHeight + 1);
            }
        }
    }



    public void pushNumber(double d) {
    Node n = new Node(d);
    stack.push(n);
    }

    public void pushAdd() {
        Node n = new Node("+", stack.pop(),stack.pop());
        stack.push(n);

    }

    public void pushMultiply() {
        Node n = new Node("*", stack.pop(),stack.pop());
        stack.push(n);

    }

    public void pushSubtract() {
        Node n = new Node("-", stack.pop(),stack.pop());
        stack.push(n);

    }

    public void pushDivide() {
        Node n = new Node("/", stack.pop(),stack.pop());
        stack.push(n);
    }

    public double evaluate() {
        Node n = stack.peek();
        Stack<Node> x = n.recursPoOrder(n);
        Stack<Double> d = new Stack<Double>();

        while (x.size() > 0) {
            if (!x.peek().isOperator) {
                d.push(x.peek().value);
                x.pop();
            } else {
                double a = d.pop();
                double b = d.pop();
                String c = x.peek().op;
                x.pop();

                if (c.equals("+")) {
                    d.push(a + b);
                } else if (c.equals("-")) {
                    d.push(b - a);
                } else if (c.equals("*")) {
                    d.push(a * b);
                } else if (c.equals("/")) {
                    d.push(a / b);
                }
            }
        }
        return d.peek();
    }

    public String inorder()
        { Node n = stack.peek();
            Stack<Node> x = n.recursInOrder(n);
            String ret = "(";
            while (x.size() > 0){
            if (x.peek().left.isOperator && x.peek().right.isOperator){
                ret += " " + x.peek().op + " ";
                x.pop();
            }
            else if (x.peek().right.isOperator){
                    ret += " " + x.peek().op + " " + String.valueOf(x.peek().left.value);
                    x.pop();
            }
            else
            {
                ret += "(" + String.valueOf(x.peek().right.value) + " " + x.peek().op + " " + String.valueOf(x.peek().left.value) + ")";
                x.pop();
            } }
            return ret + ")";
        }


        public int height() {
        Node n = stack.peek();
        n.recursHeight(n);
        return n.recursHeight(n)-1;
    }
}
