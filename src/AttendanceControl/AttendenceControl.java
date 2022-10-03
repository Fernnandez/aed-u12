package AttendanceControl;

import java.util.Random;
import java.util.Scanner;

import Queue.Queue;

import static java.lang.System.exit;

public class AttendenceControl {
  public static void main(String[] args) {

    String[] options = {
        "1- Urgecy",
        "2- Priority service",
        "3- Normal service",
        "4- Call Next patient",
        "5- Exit",
    };

    Scanner scanner = new Scanner(System.in);
    int option = 0;

    // Ticket queues
    Queue<Ticket> ticketUrgency = new Queue<Ticket>();
    Queue<Ticket> ticketPriority = new Queue<Ticket>();
    Queue<Ticket> ticketNormal = new Queue<Ticket>();

    Queue<Patient> doctorQueue = new Queue<Patient>();

    while (option != 5) {
      printMenu(options, ticketUrgency, ticketPriority, ticketNormal, doctorQueue);
      try {
        option = scanner.nextInt();
        switch (option) {
          case 1:
            addTicket(ticketUrgency, "urgency");
            break;
          case 2:
            addTicket(ticketPriority, "priority");
            break;
          case 3:
            addTicket(ticketNormal, "normal");
            break;
          case 4:
            callNextTicket(ticketUrgency, ticketPriority, ticketNormal, doctorQueue);
            break;
          case 5:
            exit(0);
        }
      } catch (Exception ex) {
        System.out.println("Please enter an integer value between 1 and " + options.length);
        scanner.next();
      }
    }
  }

  public static void printMenu(String[] options, Queue<Ticket> urgency, Queue<Ticket> priority, Queue<Ticket> normal,
      Queue<Patient> doctorQueue) {

    System.out.println("==========================");

    Ticket currentTicket = null;

    // Get the next ticket by priority
    if (urgency.getNext() != null) {
      currentTicket = urgency.getNext();
    } else if (priority.getNext() != null) {
      currentTicket = priority.getNext();
    } else {
      currentTicket = normal.getNext();
    }

    if (currentTicket != null) {
      System.out.println("Next ticket : " + currentTicket.getValue() + " - " + currentTicket.getType());
    } else {
      System.out.println("No one in queue");
    }

    System.out.println("==========================");

    if (doctorQueue.getNext() != null) {
      System.out.println("Patient in attendence : " + doctorQueue.getNext().getName());
    } else {
      System.out.println("No one in attendence");
    }

    System.out.println("==========================");
    System.out.println("Ticket queue");
    for (String option : options) {
      System.out.println(option);
    }
    System.out.print("Choose your option : ");
  }

  // Options
  private static void addTicket(Queue<Ticket> queue, String type) {
    Random random = new Random();
    Ticket ticket = new Ticket(type, random.nextInt(1000));
    queue.add(ticket);
  }

  private static void callNextTicket(Queue<Ticket> urgency, Queue<Ticket> priority, Queue<Ticket> normal,
      Queue<Patient> doctorQueue) {
    Scanner scanner = new Scanner(System.in);
    Ticket currentTicket = null;

    // Get the next ticket by priority
    if (urgency.getNext() != null) {
      currentTicket = urgency.getNext();
      urgency.remove();
    } else if (priority.getNext() != null) {
      currentTicket = priority.getNext();
      priority.remove();
    } else {
      currentTicket = normal.getNext();
      normal.remove();
    }

    System.out
        .println("tikcet in attendance : " + currentTicket.getValue() + " - " + currentTicket.getType());
    System.out.println("patient's name ? ");
    String patientName = scanner.next();
    System.out.println("patient's cpf ? ");
    String patientCpf = scanner.next();

    Patient patient = new Patient(patientName, patientCpf, "any address", false);

    if (doctorQueue.getNext() != null) {
      doctorQueue.remove();
    }

    doctorQueue.add(patient);
  }

}