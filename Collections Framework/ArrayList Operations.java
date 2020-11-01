import java.util.*;
public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<>();
		loop: while(true) {
		    int selectedOption = sc.nextInt();
		    switch(selectedOption) {
		        case 1:
		            System.out.println("Enter the item to be inserted:");
		            al.add(sc.next());
		            System.out.println("Inserted Succesfully");
		            break;
		        case 2:
		            System.out.println("Enter the item to be searched");
		            int index = al.indexOf(sc.next());
		            if(index == -1) 
		             System.out.println("Not present") ;
		            else 
		             System.out.println("Present at " + index);
		            break;
		        case 3: 
		            System.out.println("Enter the item to be deleted:");
		            al.remove(new Integer(sc.next()));
		            System.out.println("Deleted Succesfully");
		            break;
		        case 4: 
		            System.out.println(al);
		            break;
		        case 5: break loop;
		    }
		}
	}
}