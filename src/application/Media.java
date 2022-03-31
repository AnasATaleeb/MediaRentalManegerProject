package application;


public abstract class Media implements Comparable<Media> {
	// define attributes protected to inherent variable to sub class 
	protected String code;
	protected String title;
	protected int numOfCopies;
	// Default constructor
	public Media() {
		
	}
	
	// non default constructor
	public Media(String code,String title, int numOfCopies) {
		this.code = code;
		this.title = title;
		this.numOfCopies = numOfCopies;
	}
	//getter for code
	public String getCode() {
		return code;
	}
	//setter for code
	public void setCode(String code) {
		this.code = code;
	}
	//getter for title
	public String getTitle() {
		return title;
	}
	//setter for title
	public void setTitle(String title) {
		this.title = title;
	}
	//getter for number of copies
	public int getNumOfCopies() {
		return numOfCopies;
	}
	//setter for number of copies 
	public void setNumOfCopies(int numOfCopies) {
		this.numOfCopies = numOfCopies;
	}
	//equal method to return true if object we need add equal this object 
	public boolean equals(Media o){
        if (this.getTitle().equals(o.getTitle()))
            return true;
        else
            return false;
    }
	/*
	 * The comparison is based on the encode value of each character in the strings.
	 * The method returns 0 if the string is equal to the other string. A value less
	 * than 0 is returned if the string is less than the other string (less characters) and a value greater than 0 if the string is greater than the other string (more characters). 
	 */
	@Override
	public int compareTo(Media o) {
		if(title.compareTo(o.getTitle()) > 0 )
			return 1;
		else if ( title.compareTo(o.getTitle()) < 0 )
			return -1;
		else
			return 0; 
		}
	// to string to return data of object in string
	@Override
	public String toString() {
		return "Code = " + code + ", Title = " + title + ", Number Of Copies = " + numOfCopies + " ,";
	}
	
	
}
