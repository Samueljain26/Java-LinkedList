// Node class
class Student {
    int rollNumber;
    String name;
    int age;
    char grade;
    Student next;

    public Student(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Linked List class 
class StudentLinkedList {
    private Student head;

    // Add student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        newStudent.next = head;
        head = newStudent;
    }

    // Add student at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (head == null) {
            head = newStudent;
            return;
        }
        Student temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newStudent;
    }

    // Add student at a specific position 
    public void addAtPosition(int rollNumber, String name, int age, char grade, int position) {
        if (position <= 1) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }
        Student newStudent = new Student(rollNumber, name, age, grade);
        Student temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of range. Adding at the end.");
            return;
        }
        newStudent.next = temp.next;
        temp.next = newStudent;
    }

    // Delete student by Roll Number
    public void deleteStudent(int rollNumber) {
        if (head == null) return;
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }
        Student temp = head;
        while (temp.next != null && temp.next.rollNumber != rollNumber) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    // Search student by Roll Number
    public Student searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Update grade by Roll Number
    public void updateGrade(int rollNumber, char newGrade) {
        Student student = searchStudent(rollNumber);
        if (student != null) {
            student.grade = newGrade;
        } else {
            System.out.println("Student not found.");
        }
    }

    // Display all student records
    public void displayStudents() {
        if (head == null) {
            System.out.println("No student records found.");
            return;
        }
        Student temp = head;
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }
}

// Main class
public class StudentManagement {
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        // Adding students
        studentList.addAtEnd(101, "Alice", 20, 'A');
        studentList.addAtBeginning(102, "Bob", 21, 'B');
        studentList.addAtPosition(103, "Charlie", 22, 'C', 2);

        // Display all students
        System.out.println("Student Records:");
        studentList.displayStudents();

        // Searching for a student
        System.out.println("\nSearching for Roll Number 102:");
        Student foundStudent = studentList.searchStudent(102);
        if (foundStudent != null) {
            System.out.println("Found: Roll No: " + foundStudent.rollNumber + ", Name: " + foundStudent.name);
        } else {
            System.out.println("Student not found.");
        }

        // Updating grade
        System.out.println("\nUpdating grade for Roll Number 103:");
        studentList.updateGrade(103, 'A');
        studentList.displayStudents();

        // Deleting a student
        System.out.println("\nDeleting Roll Number 102:");
        studentList.deleteStudent(102);
        studentList.displayStudents();
    }
}
