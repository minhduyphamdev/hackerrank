// 11/09
//problem: https://www.hackerrank.com/challenges/java-priority-queue/problem?isFullScreen=true

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

class Student {
  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getID() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCGPA() {
    return cgpa;
  }
}

class StudentComparator implements Comparator<Student> {

  @Override
  public int compare(Student o1, Student o2) {
    if (o1.getCGPA() != o2.getCGPA()) {
      return Double.compare(o2.getCGPA(), o1.getCGPA());
    } else if (!o1.getName().equals(o2.getName())) {
      return o1.getName().compareTo(o2.getName());
    }
    return Integer.compare(o1.getID(), o2.getID());
  }

}

class Priorities {
  public List<Student> getStudents(List<String> events) {
    int len = events.size();
    PriorityQueue<Student> pq = new PriorityQueue<Student>(len, new StudentComparator());
    for (int i = 0; i < len; i++) {
      String[] line = events.get(i).split("\\s+");
      if (line[0].equals("ENTER")) {
        Student student = new Student(Integer.parseInt(line[3]), line[1], Double.parseDouble(line[2]));
        pq.add(student);
      } else if (line[0].equals("SERVED") && !pq.isEmpty()) {
        pq.poll();
      }
    }

    return pq.stream().collect(Collectors.toList());
  }
}

public class ServeStudentPriorityQueue {
  private final static Scanner scan = new Scanner(System.in);
  private final static Priorities priorities = new Priorities();

  public static void main(String[] args) {
    int totalEvents = Integer.parseInt(scan.nextLine());
    List<String> events = new ArrayList<>();

    while (totalEvents-- != 0) {
      String event = scan.nextLine();
      events.add(event);
    }

    List<Student> students = priorities.getStudents(events);

    if (students.isEmpty()) {
      System.out.println("EMPTY");
    } else {
      for (Student st : students) {
        System.out.println(st.getName());
      }
    }
  }
}
