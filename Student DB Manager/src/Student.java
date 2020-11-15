class Student {
	private int rollNumber;
	private String name;
	private double marks;
	
	Student(int rn, String n, double m) {
		this.rollNumber = rn;
		this.name = n;
		this.marks = m;
	}
	
	public int getRollNumber() {
		return this.rollNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getMarks() {
		return this.marks;
	}
	
	public String toString() {
		return "{" + " Roll Number : " + this.rollNumber +", Name : " + this.name + ", Marks : " +  this.marks + " }";
	}
}
