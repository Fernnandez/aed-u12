package Queue;

import List.MyLinkedList;

public class Queue<Type> {
  private MyLinkedList<Type> list;

  public Queue() {
    this.list = new MyLinkedList<Type>();
  }

  public void add(Type newValue) {
    this.list.pushLast(newValue);
  }

  public void remove() {
    this.list.remove(getNext());
  }

  public Type getNext() {
    if (this.list.getFirst() != null) {
      return this.list.getFirst().getValue();
    } else {
      return null;
    }
  }

  public int getSize() {
    return this.list.getSize();
  }
}
