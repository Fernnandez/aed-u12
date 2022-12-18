package BinaryTree;

public class Person {
  private String name;
  private String email;
  private String phone;
  private String address;
  private String socialMedia;

  public Person(String name, String email, String phone, String address, String socialMedia) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.address = address;
    this.socialMedia = socialMedia;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getSocialMedia() {
    return socialMedia;
  }

  public void setSocialMedia(String socialMedia) {
    this.socialMedia = socialMedia;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address + ", socialMedia="
        + socialMedia + "]";
  }

}
