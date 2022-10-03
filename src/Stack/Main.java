package Stack;

public class Main {
  public static void main(String[] args) {
    Stack stack = new Stack();

    stack.add("E");
    stack.add("A");
    stack.add("C");

    System.out.println("Top of the stack: " + stack.getNext());
  }
}
