import java.util.*;

class Box {
    double length;
    double width;
    double height;
    
    public Box(double l ,double w , double h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }
    public double getVolume() {
        return this.length * this.width * this.height;
    }
    @Override
    public String toString() {
        return "Length : " + this.length  +" Width: "+ this.width + " Height : " + this.height + "\n"; 
    }
    @Override
    public int hashCode() {
        Double ob  = this.getVolume();
        return ob.hashCode();
    }
}
public class Main
{
	public static void main(String[] args) {
		HashSet<Box> set = new HashSet<>();
		Box b1 = new Box(3,2,1);
		Box b2 = new Box(2,3,4);
		Box b3 = new Box(3,4,5);
		Box b4 = new Box(5,4,3);
		Box b5 = new Box(1,2,3);
		set.add(b1);
		set.add(b2);
		set.add(b3);
		set.add(b4);
		set.add(b5);
		System.out.println(set);
	}
}
