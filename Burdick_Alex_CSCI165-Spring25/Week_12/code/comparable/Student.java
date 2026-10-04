/*
	This class demonstrates implementing an interface.
	An interface is the ultimate abstract "class" and simply defines methods that must be implemented
	Interfaces allow us to group objects according to expected behaviors

	
	Like abstract classes, interfaces cannot be used to create objects 
	Interface methods do not have a body - the body is provided by the "implementing" class
	On implementation of an interface, you must override all of its methods
	Interface methods are by default abstract and public
	Interface attributes are by default public, static and final
	An interface cannot contain a constructor (as it cannot be used to create objects)
	An interface may be used as a reference type for a variable

*/

public class Student implements Comparable<Student> {

	private String firstName;
	private String lastName;
	private String major;
	private double gpa;

	/**
	 * Constructor
	 * @param first
	 * @param last
	 * @param major
	 * @param gpa
	 */
	Student(String first, String last, String major, double gpa){
		this.firstName  = first;
		this.lastName   = last;
		this.major      = major;
		this.setGPA(gpa);
	}

	/**
	 * Set the gpa
	 * 
	 * @param gpa the new gpa
	 */
	public void setGPA(double gpa){
		if(gpa >= 0 && gpa <= 4.0)
		this.gpa = gpa;
	}

	/*
		This method MUST be overridden because the class declares that it "implements Comparable"
		return negative number if "this" comes before "argument"
		return positive number if "this" comes after "argument"
		return 0 if they are equal
	*/
	@Override
	public int compareTo(Student stu){
		if(this.gpa > stu.gpa) return -1;
		if(this.gpa < stu.gpa) return 1;
		return 0;
	}

	@Override
	public boolean equals(Object other){
		if(this == other)						return true;
		if(other == null)						return false;  
		if(other.getClass() != this.getClass())	return false;

		Student temp = (Student)other;

		return(this.firstName.equals(temp.firstName)	&& 
			this.lastName.equals(temp.lastName) )		&&
			this.major.equals(temp.major);
	} 

	@Override
	public String toString(){
		return firstName + " " + lastName + " " + major + " " + gpa;
	}
}