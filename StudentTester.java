/*Write the CSEStudent and CSE111Student classes derived from Student class so that the following code generates the output below: */

public class StudentTester { // Driver code
    public static void printShout(Student s) {
        System.out.println("------------------");
        System.out.println(s.msg);
        System.out.println(s.shout());
    }

    public static void main(String[] args) {
        Student s = new Student();
        CSEStudent cs = new CSEStudent();
        CSE111Student cs111 = new CSE111Student();
        System.out.println(s.msg);
        System.out.println(cs.msg);
        System.out.println(cs111.msg);
        printShout(s);
        printShout(cs);
        printShout(cs111);
    }
}

// Class starts here

class Student { // Parent class
    public String msg = "I love BU";

    public String shout() {
        return msg;
    }
}

class CSEStudent extends Student {
    public String msg = "I want to transfer to CSE";

    public String shout() {
        return this.msg;
    }
}

class CSE111Student extends Student {
    public String msg = "I love Java Programming";

    public String shout() {
        return this.msg;
    }
}