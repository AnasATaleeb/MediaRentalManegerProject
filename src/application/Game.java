package application;


public class Game extends Media{
	// define attributes 
	private double weight;
	
	// Default constructor
	public Game() {
		super();
	}
	//non default constructor
	public Game(String code,String title, int numOfCopies, double weight) {
		super(code,title, numOfCopies);
		this.weight = weight;
	}
	// getter for weight
	public double getWeight() {
		return weight;
	}
	//setter for weight
	public void setWeight(double d) {
		this.weight = d;
	}
	// to string to return data of object in string
	@Override
	public String toString() {
		return " Game [ "+ super.toString() +" Weight = " + weight +" ]";
	}
	
}
