package BinaryTree;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    boolean loop = true;
    Scanner reader = new Scanner(System.in);
    PersonBinaryTree schedule = new PersonBinaryTree();

    System.out.println("Schedule!!!");
    System.out.println("=========================================================");

    while (loop) {
      System.out.println("What do you want to do ?");
      System.out.println("=========================================================");
      System.out.println("1- Add new People");
      System.out.println("2- Remove People");
      System.out.println("3- Find someone in the schedule");
      System.out.println("4- List all records");
      System.out.println("5- Exit");
      System.out.println("=========================================================");
      int option = reader.nextInt();

      switch (option) {
        case 1:
          System.out.println("Name: ");
          System.out.println("=========================================================");
          String name = reader.next();

          System.out.println("Email: ");
          System.out.println("=========================================================");
          String email = reader.next();

          System.out.println("Phone Number: ");
          System.out.println("=========================================================");
          String number = reader.next();

          System.out.println("Address: ");
          System.out.println("=========================================================");
          String address = reader.next();

          System.out.println("Social Media: ");
          System.out.println("=========================================================");
          String media = reader.next();

          Person people = new Person(name, email, number, address, media);
          schedule.add(people);
          break;

        case 2:
          System.out.println("Name of people to remove: ");
          System.out.println("=========================================================");
          String nameToRemove = reader.next();
          schedule.remove(nameToRemove);
          break;

        case 3:
          System.out.println("Name of people to find: ");
          System.out.println("=========================================================");
          String nameToFind = reader.next();
          schedule.findElement(nameToFind);
          break;

        case 4:
          schedule.inOrder(schedule.getRoot());
          break;

        case 5:
          loop = false;
          break;
      }

    }
  }

}
