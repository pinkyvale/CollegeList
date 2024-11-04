import java.util.*;
import java.text.NumberFormat;

class Person {
    private String name;
    private String contactNum;

    Person(String name, String contactNum){
        setName(name);
        setContactNum(contactNum);
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setContactNum(String c){
        this.contactNum = c;
    }

    public String getContactNum(){
        return contactNum;
    }

    public String toString(){
        return "\n-----------------------------------------\n" +
               "Name: " + getName() + "\nContact Number: " + getContactNum();
    }
}

class Employee extends Person {
    private double salary;
    private String department;
    private static final NumberFormat myFormat = NumberFormat.getInstance();

    Employee(String name, String contactNum, double salary, String department){
        super(name, contactNum);
        setSalary(salary);
        setDepartment(department);
    }

    public void setSalary(double s){
        this.salary = s;
    }

    public double getSalary(){
        return salary;
    }

    public void setDepartment(String d){
        this.department = d;
    }

    public String getDepartment(){
        return department;
    }

    public String toString(){
        return super.toString() +
               "\nSalary: " + myFormat.format(getSalary()) +
               "\nDepartment: " + getDepartment(); 
    }
}

class Faculty extends Employee {
    private boolean status;

    Faculty(String name, String contactNum, double salary, String department, boolean status){
        super(name, contactNum, salary, department);
        setStatus(status);
    }

    public boolean isRegular(){
        return status;
    }

    public void setStatus(boolean status){
        this.status = status;
    }

    public String toString(){
        String statusInfo = (this.status) ? "Regular" : "Temporary";
        return super.toString() + "\nStatus: " + statusInfo;
    }
}

class Student extends Person {
    private String program;
    private int yearLevel;

    Student(String name, String contactNum, String program, int yearLevel){
        super(name, contactNum);
        setProgram(program);
        setYearLevel(yearLevel);
    }

    public void setProgram(String p) {
        this.program = p;
    }

    public String getProgram() {
        return program;
    }

    public void setYearLevel(int y) {
        this.yearLevel = y;
    }

    public int getYearLevel(){
        return yearLevel;
    }

    public String toString(){
        return super.toString() +
               "\nProgram: " + getProgram() +
               "\nYear Level: " + getYearLevel();
    }
}

public class CollegeList {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, contactNum, department, program;
        double salary;
        int yearLevel;
        boolean status = false;

        System.out.print("Press E for Employee, F for Faculty, S for Student: ");
        String choice = sc.nextLine();

        if(choice.equalsIgnoreCase("E")){
            System.out.println("Type employee's name, contact number, salary, and department.");
            System.out.println("Press Enter after every input.");
            name = sc.nextLine();
            contactNum = sc.nextLine();
            salary = sc.nextDouble();
            sc.nextLine();  
            department = sc.nextLine();

            Employee emp = new Employee(name, contactNum, salary, department);
            System.out.println(emp.toString());

        } else if(choice.equalsIgnoreCase("F")){
            System.out.println("Type faculty's name, contact number, salary, department, and status (Y for Regular, N for Temporary): ");
            System.out.println("Press Enter after every input.");
            name = sc.nextLine();
            contactNum = sc.nextLine();
            salary = sc.nextDouble();
            sc.nextLine();  
            department = sc.nextLine();
            String statusInput = sc.nextLine();

            status = statusInput.equalsIgnoreCase("Y");

            Faculty fac = new Faculty(name, contactNum, salary, department, status);
            System.out.println(fac.toString());

        } else if(choice.equalsIgnoreCase("S")){
            System.out.println("Type student's name, contact number, program, and year level: ");
            System.out.println("Press Enter after every input.");
            name = sc.nextLine();
            contactNum = sc.nextLine();
            program = sc.nextLine();
            yearLevel = sc.nextInt();

            Student stu = new Student(name, contactNum, program, yearLevel);
            System.out.println(stu.toString());

        } else {
            System.out.println("Invalid selection.");
        }

        sc.close();
    }
}