package List;

public class Knot<Type> {
  private Type value;
  private Knot<Type> next;

  public Knot(Type value) {
    this.value = value;
    this.next = null;
  }

  public Knot(Type value, Knot<Type> next) {
    this.value = value;
    this.next = next;
  }

  public Type getValue() {
    return value;
  }

  public void setValue(Type value) {
    this.value = value;
  }

  public Knot<Type> getNext() {
    return next;
  }

  public void setNext(Knot<Type> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return "Knot [value=" + value + ", next=" + next + "]";
  }

}
