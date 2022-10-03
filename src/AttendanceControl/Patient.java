package AttendanceControl;

public class Patient {
  private String name;
  private String cpf;
  private String address;
  private boolean hasHealthPlan;

  public Patient(String name, String cpf, String address, boolean hasHealthPlan) {
    this.name = name;
    this.cpf = cpf;
    this.address = address;
    this.hasHealthPlan = hasHealthPlan;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public boolean isHasHealthPlan() {
    return hasHealthPlan;
  }

  public void setHasHealthPlan(boolean hasHealthPlan) {
    this.hasHealthPlan = hasHealthPlan;
  }

}
