import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.function.Supplier;
import java.util.function.Consumer;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class HelloWorld {
    public static void main(String[] args) {
        //----------------CHECK-POSITIVE--------------------------

        Predicate<Integer> isPositive=(Validnumber)->(Validnumber>0);
        int Validnumber=3;
        System.out.println(isPositive.test(Validnumber));

        //------------------TO-UPPERCASE-------------------------

        Function<String,String> toUppercase=(str)->str.toUpperCase();
        String GivenString="sanjay";
        System.out.println(toUppercase.apply(GivenString));
        
        //------------------CONTAINS SUBSTRING--------------------------------

        Predicate<String> containsString=mainString->mainString.contains("substring");
        System.out.println(containsString.test("hello substring"));

        //-------------------CHECK-PRIME--------------------------------

        Predicate<Integer> isPrime =(number)->{
            if(number<=1){
                return false;
            }
            for(int i=2;i<=Math.sqrt(number);i++){
                if(number%i==0){
                    return false;
                }
            }
            return true;
        };
    
        int number =7;
        if(isPrime.test(number)){
        System.out.println("check prime:"+number+" is a prime number");
        }else{
             System.out.println("check prime:"+number+" is not a prime number");
        }

        //-------------------INCREASE SALARY BY 10%-------------------------------
       UnaryOperator<Double> increaseSalary=(salary)->salary*1.10;
       double currentSalary=5000;
       double newSalary=currentSalary+increaseSalary.apply(currentSalary);
       System.out.println("NewSalary:"+newSalary);
       //------------------CHECK SALARY GREATER THAN 10000------------------
       Predicate<Double> isSalaryGreaterThan10000=(salary)->salary>10000.0;
       double CurrentSalary=12000.0;
       if(isSalaryGreaterThan10000.test(CurrentSalary)){
           System.out.println(CurrentSalary+" is Greater than 10000");
       }else{
           System.out.println(CurrentSalary+" is not Greater than 10000");
       }
       //-------------------------GET COMPANY ADDRESS---------------

    Supplier<String> getCompanyAdress=()->"FORD GLOBAL SOLUTIONS,SHOLINGANALLUR-ELCOT,CHENNAI";
   String CompanyAddress=getCompanyAdress.get();
    System.out.println("Company Address: "+CompanyAddress);

      //----------------------PRINT EMPLOYEE-DETAILS--------------------------------
  Employee employee=new Employee("SANJAY",30,50000.0);
Consumer<Employee> printEmployeeDetails=emp->System.out.println(emp.toString());
printEmployeeDetails.accept(employee);

     //---------------DISPLAY EMPLOYEE DETAILS HAVING HIGHEST SALARY

Map<String,EmployeeSalary> employeeMap=new HashMap<>();
employeeMap.put("SANJAY",new EmployeeSalary("SANJAY",2000.0));
employeeMap.put("VIJAY",new EmployeeSalary("VIJAY",3000.0));
employeeMap.put("DEVA",new EmployeeSalary("DEVA",2000.0));
EmployeeSalary highestSalaryEmployee=null;
double maxSalary=Double.MIN_VALUE;
for(Map.Entry<String,EmployeeSalary> entry:employeeMap.entrySet()){
    EmployeeSalary currentEmployee=entry.getValue();
    if(currentEmployee.getSalary()>maxSalary){
        maxSalary=currentEmployee.getSalary();
         highestSalaryEmployee=currentEmployee;
    }
}
if(highestSalaryEmployee!=null){
    System.out.println("Employee with the highest salary: "+highestSalaryEmployee);
}else{
    System.out.println("No employees found");
}

     //-----------SORT EMPLOYEE LIST BASED ON ON NAME------
List<Employee> employeeList=new ArrayList<>();
employeeList.add(new Employee("Raja",21,5000.0));
employeeList.add(new Employee("Vijay",32,50000.0));
Collections.sort(employeeList,Comparator.comparing(Employee::getName));
System.out.print("\n-----------------------------\n");
System.out.println("Sorted Employee List based on Name:");
for(Employee emp:employeeList){
    System.out.println(emp);
}
        }
}
  class Employee{
        private String name;
        private int age;
        private double salary;
        public Employee(String name,int age,double salary){
            this.name=name;
            this.age=age;
            this.salary=salary;
            }
   public String getName(){
         return name;
     }
   @Override
     public String toString(){
         return "Employee{"+"name='"+name+'\''+", age="+age+", salary="+salary+'}';
     }
    }
    class EmployeeSalary{
         private String name;
         private double salary;
         public EmployeeSalary(String name,double salary){
            this.name=name;
            this.salary=salary;
         }
         public double getSalary(){
             return salary;
         }
         @Override
     public String toString(){
         return "Employee{"+"name='"+name+'\''+",salary="+salary+'}';
     }
    }