package List;

public class MyLinkedList<Type> {
  private Knot<Type> first;
  private Knot<Type> last;
  private int size;

  public MyLinkedList() {
    this.size = 0;
  }

  public Knot<Type> getFirst() {
    return first;
  }

  public void setFirst(Knot<Type> first) {
    this.first = first;
  }

  public Knot<Type> getLast() {
    return last;
  }

  public void setLast(Knot<Type> last) {
    this.last = last;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public void pushLast(Type newValue) {
    Knot<Type> newElement = new Knot<Type>(newValue);
    if (this.first == null && this.last == null) {
      this.first = newElement;
      this.last = newElement;
    } else {
      this.last.setNext(newElement);
      this.last = newElement;
    }
    this.size++;
  }

  public void pushFirst(Type newValue) {
    Knot<Type> newElement = new Knot<Type>(newValue);
    if (this.first == null && this.last == null) {
      this.first = newElement;
      this.last = newElement;
    } else {
      newElement.setNext(this.first);
      this.first = newElement;
    }
    this.size++;
  }

  public void remove(Type wantedValue) {
    Knot<Type> previous = null;
    Knot<Type> current = this.first;
    for (int i = 0; i < this.getSize(); i++) {
      if (current.getValue().equals(wantedValue)) {
        if (this.size == 1) {
          this.first = null;
          this.last = null;
        } else if (current == first) {
          this.first = current.getNext();
          current.setNext(null);
        } else if (current == last) {
          this.last = previous;
          previous.setNext(null);
        } else {
          previous.setNext(current.getNext());
          current = null;
        }
        this.size--;
        break;
      }
      previous = current;
      current = current.getNext();
    }
  }

  public Knot<Type> get(int position) {
    Knot<Type> current = this.first;
    for (int i = 0; i < position; i++) {
      if (current.getNext() != null) {
        current = current.getNext();
      }
    }
    return current;
  }
}