package concepts.oops;

/**
 * process of wrapping code(method) and data(variables) together into a single unit is called encapsulation.
 * often called as data hiding. The main goal of encapsulation is to protect the data from unauthorized or invalid access
 * We achieve this by
 * -declaring variables as private.
 * -to access to those private variables you create public getter and setter methods.
 * <p>
 * control and validation are advantages of encapsulation
 * In Java, the Outer Class (EncapsulationLesson) has full access to the private members of its Inner Classes (SecuredBankAccount). The "privacy" boundary is the top-level class file
 *
 */

public class EncapsulationLesson
{

    class BadBankAccount {
        public double balance;// this is free to use
    }

    public void demonstrateBadPractice() {
        BadBankAccount account = new BadBankAccount();
        account.balance = -100000;
        System.out.println("The Bad balance is " + account.balance);
    }

    class SecuredBankAccount
    {
        private double sBalance; //locked this data

        public SecuredBankAccount(double initialBalance) {
            this.sBalance = initialBalance;
        }

        //Getter
        public double getBalance() {
            return sBalance;
        }

        //Setter
        public void deposit(double amount) {
            if (amount > 0) {
                sBalance = sBalance + amount;
                System.out.println("Deposited amount is $" + amount);
            } else {
                System.out.println("Invalid amount, amount must be positive");
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= sBalance) {
                sBalance = sBalance - amount;
                System.out.println("Withdrawn amount is $" + amount);
            } else {
                System.out.println("Insufficient funds or invalid amount");
            }
        }
    }

    public void demonstrateGoodPractice() {
        SecuredBankAccount account = new SecuredBankAccount(1000);
        System.out.println("The good current balance is " + account.getBalance());
        account.deposit(500);
        System.out.println("The good current balance is " + account.getBalance());
        account.withdraw(200);
        System.out.println("The good balance is " + account.getBalance());
    }

    /* Problem statement - Employee Management System
      Sceanrio - Design an HR System
      Rules - 1) Employee Id cannot be changed once set/generated(Immutable field)
              2) Salary cannot be negative
              3) Only HR can view the salary
     */

    /* Final - restrict the user - variable, method, class
    - if we make any variable as final we cannot change the value of final variable
    - if you make any class as final then you cannot extend it
    - final method is inherited, but you cannot override it
    - A final variable that is not initialized at the time of declaration is known as blank final variable
    - It can be initialized only in constructor/ can we set the final variable value from getter and setter ?(No)
     */

    class Employee{
        private final int id;
        private String name;
        private double salary;


        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary=salary;
            System.out.println("The id is "+id+ " name is "+name+" salary is "+salary);
        }
        public int getId() {
            System.out.println("The employee Id is "+id);
            return id;
        }
        public String getName() {
            return name;
        }

        public void setSalary(double salary) {
            if(salary>=0){
                this.salary = salary;
            }
            else{
                System.out.println("Invalid Salary, salary cannot be negative");
            }

        }

        public double getSalary(boolean isAdmin){
            if(isAdmin){
                System.out.println("The salary is "+salary);
                return salary;
            }
            else{
                System.out.println("Access Denied");
                return 0.0;
            }

        }
    }

    public int generateRandomInt(){
        int j;
        int r=0;
        for(j=100;j>=0;j--){
            r=r+(int)(Math.random()*j);
        }
        System.out.println("Random value is " +r);
        return r;
    }

    public void problemSolvingScenario(){
        int idToBePaased = generateRandomInt();
        Employee emp = new Employee(idToBePaased,"SachG",50000);
        emp.setSalary(60000);
        emp.getSalary(false);
        emp.getSalary(true);
        emp.getId();
        System.out.println(emp.getName());
    }

    public static void main(String[] args) {
        EncapsulationLesson encapsulationLesson = new EncapsulationLesson();
        encapsulationLesson.demonstrateBadPractice();
        encapsulationLesson.demonstrateGoodPractice();
        encapsulationLesson.problemSolvingScenario();
    }
}