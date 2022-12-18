package BinaryTree;

public class Element<T> {
  private String key;
  private T value;
  private Element<T> left;
  private Element<T> right;

  public Element(String key, T value) {
    this.key = key;
    this.value = value;
    this.left = null;
    this.left = null;
  }

  @Override
  public String toString() {
    return value.toString();
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public Element<T> getLeft() {
    return left;
  }

  public void setLeft(Element<T> left) {
    this.left = left;
  }

  public Element<T> getRight() {
    return right;
  }

  public void setRight(Element<T> right) {
    this.right = right;
  }
}
