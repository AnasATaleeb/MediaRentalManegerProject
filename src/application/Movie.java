package application;

public class Movie extends Media{
	// define attributes 
	private String rate;
	
	// Default constructor
	public Movie(){
		super();
	}
	// non default constructor 
	public Movie(String code,String title, int numOfCopies, String rate) {
		super(code,title, numOfCopies);
		this.rate = rate;
	}
	//getter for rate
	public String getRate() {
		return rate;
	}
	//setter for rate
	public void setRate(String rate) {
		this.rate = rate;
	}
	// to string to return data of object in string
	@Override
	public String toString() {
		return " Movie [ "+ super.toString() +" Rate = " + rate + "]";
	}
	
	

}
