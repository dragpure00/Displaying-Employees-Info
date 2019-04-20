//Ayaz Araf
//HW4 CS212, Extrenal Source: https://www.geeksforgeeks.org/
import java.time.LocalDate;

public class D23197568 {
// Main Driver/Demo
	 public static void main(String args[]) {
		 D23197568 r= new D23197568();
		 
	     SalariedEmployee sal = r.new SalariedEmployee("Hans", "345679", 
	    		 3,17 , 2017, 2999.00);
	     
	     FulltimeEmployee ft= r.new FulltimeEmployee("Bill", "821647", 
	    		 30, 49, 24, 12, 2018);
	      
	     ParttimeEmployee pt = r.new ParttimeEmployee("Jane", "033715", 
	    		 17, 20, 4, 7, 2019);
	     System.out.println(sal);
	     System.out.println("---------------------------"
	     		+ "--------------------------------------");
	     System.out.println(ft);
	     System.out.println("------------------------------"
	     		+ "-----------------------------------");
	     System.out.println(pt);
	     System.out.println("-----------------------------------"
	     		+ "------------------------------");
	     sal.raiseTheSalary();
	     System.out.println("After 7% increase: "+"\n" +  sal);
	   }
	public abstract class Employee {//SuperClass
		   private String name;
		   private String id;
		   private LocalDate hireDate;

		 
		   public Employee() {
		       name = null;
		       id = null;
		       hireDate = null;
		   }

	
		   public Employee(String name, String id, int day, int month, int year) {
		       this.name = name;
		       this.id = id;
		       hireDate = LocalDate.of(year, month, day);
		   }

		   public String getName() {
		       return name;
		   }

		   public void setName(String name) {
		       this.name = name;
		   }

		   public String getId() {
		       return id;
		   }

		   public void setId(String id) {
		       this.id = id;
		   }

		   public LocalDate getHireDate() {
		       return hireDate;
		   }

		   public void setHireDate(LocalDate hireDate) {
		       this.hireDate = hireDate;
		   }

		   @Override
		   public String toString() {
			   return "Employee: "+ name +"\n"  + "id: " 
		   + id + "\n" + "Hired on: " + hireDate +"\n";
		   }

		  
		   protected abstract double pay();

		}

//subclass
		public class SalariedEmployee extends Employee {
		   
		   private double salary;
		   
		   private static final double increase = 0.07;
		   private String status;
		   
		   public SalariedEmployee() {
		       
		       this.salary = 0;
		   }

		 
		   public SalariedEmployee(String name, 
				   String id, int day, int month, int year, double salary) {
		       super(name, id, month,day , year);
		       this.salary = salary;
		       status = "Salaried";
		   }

		   
		   @Override
		   protected double pay() {
		       return this.salary;
		   }

		  
		   public void raiseTheSalary() {
		       this.salary = (this.salary * increase) + this.salary;
		   }

		   public double getSalary() {
		       return salary;
		   }

		   public String getStatus() {
		       return status;
		   }

		   public String getName() {
		       return super.getName();
		   }

		   public void setName(String name) {
		       super.setName(name);
		   }

		   public String getId() {
		       return super.getId();
		   }

		   public LocalDate getHireDate() {
		       return super.getHireDate();
		   }

		 
		   @Override
		   public String toString() {
		       return super.toString() + "Work Status: " + status + "\n" + "Salary:$ " 
		   + salary + "\n";
		   }

		}

//subclass	
		public class FulltimeEmployee extends Employee {

		   private double payRate;
		   private int hoursWorked;
		   private String status;

		   public FulltimeEmployee() {
		       
		       this.payRate = 0;
		       this.hoursWorked = 0;
		   }

		
		   public FulltimeEmployee(String name, 
				   String id, double payRate, int hoursWorked, int day, int month, 
				   int year) {
		       super(name, id, day, month, year);
		       setStatus("FT");
		       setHoursWorked(hoursWorked);
		       setPayRate(payRate);
		   }

		   
		   private int overTime() {
		       if (this.hoursWorked > 40) {
		           return hoursWorked - 40;
		       }
		       return 0;
		   }

		
		  
		   protected double pay() {
		       double pay = payRate * hoursWorked;
		       if (hoursWorked > 40) {
		           int overtime = overTime();
		           pay += overtime * (1.5 * hoursWorked);
		       }

		       return pay;
		   }

		   public String getStatus() {
		       return status;
		   }

		   public String getName() {
		       return super.getName();
		   }

		   public void setName(String name) {
		       super.setName(name);
		   }

		   public String getId() {
		       return super.getId();
		   }

		   public LocalDate getHireDate() {
		       return super.getHireDate();
		   }

		   public double getPayRate() {
		       return payRate;
		   }

		   public void setPayRate(double payRate) {
		       this.payRate = payRate;
		   }

		   public int getHoursWorked() {
		       return hoursWorked;
		   }

		   public void setHoursWorked(int hoursWorked) {
		       this.hoursWorked = hoursWorked;
		   }

		   public void setStatus(String status) {
		       this.status = status;
		   }

		  
		  
		   public String toString() {
		       return super.toString() + "Work Status: " + status + "\n" + "Pay Rate:$ " 
		   + payRate + "\n" + "Total Hours Worked: " + hoursWorked + "\n";
		   }

		}

		
//subclass
	
		public class ParttimeEmployee extends Employee {
		   private double payRate;
		   private int hoursWorked;
		   private String status;

		   public ParttimeEmployee() {
		       
		       this.payRate = 0;
		       this.hoursWorked = 0;
		   }

		   public ParttimeEmployee(String name, String id, double payRate, 
				   int hoursWorked, int day, int month, int year) {
		       super(name, id,month ,day , year);
		       setStatus("PT");
		       setHoursWorked(hoursWorked);
		       setPayRate(payRate);
		   }

	
		   @Override
		   protected double pay() {
		       return payRate * hoursWorked;
		   }

		   public String getStatus() {
		       return status;
		   }

		   public String getName() {
		       return super.getName();
		   }

		   public void setName(String name) {
		       super.setName(name);
		   }

		   public String getId() {
		       return super.getId();
		   }

		   public LocalDate getHireDate() {
		       return super.getHireDate();
		   }

		   public double getPayRate() {
		       return payRate;
		   }

		   public void setPayRate(double payRate) {
		       this.payRate = payRate;
		   }

		   public int getHoursWorked() {
		       return hoursWorked;
		   }

		   public void setHoursWorked(int hoursWorked) {
		       this.hoursWorked = hoursWorked;
		   }

		   public void setStatus(String status) {
		       this.status = status;
		   }

		   @Override
		   public String toString() {
		       return super.toString() + "Work Status: " + status + "\n" + 
		   "Pay Rate:$ " + payRate + "\n" + "Total Hours Worked: " + hoursWorked + "\n";
		   }
		}
			   
}
