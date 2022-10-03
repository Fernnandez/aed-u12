package Stack;

import List.MyLinkedList;

public class Stack {
  private MyLinkedList<String> list;

  public Stack() {
    this.list = new MyLinkedList<String>();
  }

  public void add(String newValue) {
    this.list.pushFirst(newValue);
  }

  public void remove() {
    this.list.remove(getNext());
  }

  public void removeBySize(int size) {
    // System.out.println(size);
    for (int i = 0; i < size; i++) {
      if (getNext() != null) {
        this.list.remove(getNext());
      } else {
        break;
      }
    }
  }

  public String getNext() {
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
