
import java.util.Arrays;

public class Demo {
  public static void main(String[] args) {
    /*
     * Integer class implements Comparable
     * Interface so we can use the sort method
     */
    int[] arr = {11,55,22,0,89};
    Arrays.sort(arr);
    System.out.print("Sorted Integer Array: ");
    System.out.println(Arrays.toString(arr));

    /*
     * String class implements Comparable
     * Interface so we can use the sort method
     */
    System.out.print("Sorted String Array: ");
    String[] names = {"Scott", "Aaron", "Kimbo"};
    Arrays.sort(names);
    System.out.println(Arrays.toString(names));

	/*
		Student class implements Comparable
		So we can use Arrays.sort
	*/

    Student[] students = new Student[5];

    students[0] = new Student("Sammy", "Davis", "CS", 1.2);
    students[1] = new Student("Frank", "Sinatra", "CIS", 2.3);
    students[2] = new Student("Dean", "Martin", "LA", 2.0);
    students[3] = new Student("Ansom", "Andrews", "BS", 3.7);
    students[4] = new Student("Francine", "Sinatra", "CIS", 2.9);

    System.out.println("Sorted Student Array: ");
    Arrays.sort(students);

	for(Student student : students)
		System.out.println(student);
  }
}
