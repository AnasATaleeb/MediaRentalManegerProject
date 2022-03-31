package application;

import java.util.ArrayList;
import java.util.Collections;

public class MediaRentalManeger implements MediaRentalInt { // implement class from mediaRentalInt interface

	// define attributes 
	private int count = 0,Limitedvalue=2;
	private ArrayList<Media> media= new ArrayList<>();
	private ArrayList<Customer> customer = new ArrayList<>();

	// Default constructor
	public MediaRentalManeger() {

	}
	//non default contractor
	public MediaRentalManeger(ArrayList<Media> media, ArrayList<Customer> customer) {
		this.setMedia(media);
		this.setCustomer(customer);
	}
	//getter for customer array list
	public ArrayList<Customer> getCustomer() {
		return customer;
	}
	//setter for customer array list
	public void setCustomer(ArrayList<Customer> customer) {
		this.customer = customer;
	}
	//getter for media array list
	public ArrayList<Media> getMedia() {
		return media;
	}
	//setter for media array list
	public void setMedia(ArrayList<Media> media) {
		this.media = media;
	} 
	//method to add a customer in data base
	@Override
	public void addCustomer(String id, String name, String address, String mobile, String plan){
		boolean isContain = true;
		Customer checkCustomer = new Customer(id,name,address,mobile,plan);
		for (int i = 0; i < customer.size(); i++) {
			if(customer.get(i).equals(checkCustomer)) {
				isContain = false;
				break;
			}
		}
		if(isContain) {
			if (plan.equalsIgnoreCase("LIMITED")) {
				customer.add(new Customer(id,name,address,mobile,plan));
				customer.get(customer.size() - 1).setValue(Limitedvalue);
			}
			else if (plan.equalsIgnoreCase("UNLIMITED")) {
				customer.add(new Customer(id,name,address,mobile,plan));
				customer.get(customer.size() - 1).setValue(-1);
			} else
				throw new IllegalArgumentException(" Error!! --> the coustomer doesn't add becase the plan isn't define. ");
		}
		else
			throw new IllegalArgumentException(" Error!! --> the coustomer available in data. ");
	}
	//method to add a movie in data base
	@Override
	public void addMovie(String code,String title, int copiesAvailable, String rating) {
		boolean isContain = true;
		Movie checkMovie = new Movie(code, title, copiesAvailable, rating);
		for (int i = 0; i < media.size(); i++) {
			if(media.get(i).equals(checkMovie)) {
				isContain = false;
				break;
			}
		}
		if(isContain) {			
			if (rating.equals("HR") || rating.equals("DR") || rating.equals("AC")) {
				media.add(new Movie(code, title, copiesAvailable, rating));
			} else
				throw new IllegalArgumentException(" Error!! --> the rate isn't define. ");
		}
		else
			throw new IllegalArgumentException(" Error!! --> the movie available in data. ");
	}
	//method to add a game in data base
	@Override
	public void addGame(String code,String title, int copiesAvailable, double weight) {
		boolean isContain = true;
		Game checkGame = new Game(code,title, copiesAvailable, weight);
		for (int i = 0; i < media.size(); i++) {
			if(media.get(i).equals(checkGame)) {
				isContain = false;
				break;
			}
		}
		if(isContain) {	
			media.add(new Game(code,title, copiesAvailable, weight));
		}
		else
			throw new IllegalArgumentException(" Error!! --> the game available in data. ");
	}
	//method to add a album in data base
	@Override
	public void addAlbum(String code,String title, int copiesAvailable, String artist, String songs) {
		boolean isContain = true;
		Album checkAlbum = new Album(code,title, copiesAvailable, artist, songs);
		for (int i = 0; i < media.size(); i++) {
			if(media.get(i).equals(checkAlbum)) {
				isContain = false;
				break;
			}
		}
		if(isContain) {	
			media.add(new Album(code,title, copiesAvailable, artist, songs));
		}
		else
			throw new IllegalArgumentException(" Error!! --> the album available in data. ");
	}
	//method to  set limited plan value in data base
	@Override
	public void setLimitedPlanLimit(int value) {
		if(value > 0 ) {			
			Limitedvalue = value;
			for (int i = 0; i < customer.size(); i++) {
				if(customer.get(i).getPlan().equalsIgnoreCase("LIMITED"))
					customer.get(i).setValue(value);
			}
		}
		else
			throw new IllegalArgumentException(" the number should be positive. ");
	}
	//method to return all customers info in data base
	@Override
	public String getAllCustomersInfo(){
		Collections.sort(customer);
		String cutomersInfo = "";
		for (int i = 0; i < customer.size(); i++) {
			cutomersInfo+=customer.get(i).toString()+"\n";
		}
		return cutomersInfo;
	}
	//method to return all media info in data base
	@Override
	public String getAllMediaInfo() {
		Collections.sort(media);
		String mediaInfo = "";
		for (int i = 0; i < media.size(); i++) {
			mediaInfo+=media.get(i).toString()+"\n";
		}
		return mediaInfo;
	}
	//method to add a media in array list cart 
	@Override
	public boolean addToCart(String customerName, String mediaTitle) {
		ArrayList<String> cart = new ArrayList<>();

		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getName().equals(customerName)) {
				for (int j = 0; j < media.size(); j++) {
					if (media.get(j).getTitle().equals(mediaTitle)) {
						if (media.get(j).getNumOfCopies() > 0) {
							if(customer.get(i).getCart() != null) {								
								if (customer.get(i).getCart().contains(mediaTitle)) {
									throw new IllegalArgumentException(" Error!! --> the media is already add in the cart. ");
								}
							} 
							cart = customer.get(i).getCart();
							cart.add(mediaTitle);
							customer.get(i).setCart(cart);					
							return true;
						} else {
							throw new IllegalArgumentException(" Error!! --> the number of copies is 0. ");
						}
					}
				}
				throw new IllegalArgumentException(" Error!! --> the media name doesn't fount in data base. ");
			}
		}
		throw new IllegalArgumentException(" Error!! --> the coustomer name doesn't found. ");
	}
	//method to remove a media in array list cart 
	@Override
	public boolean removeFromCart(String customerName, String mediaTitle) {
		for (int i = 0; i < customer.size(); i++) {
			if( customerName.equals(customer.get(i).getName())) {
				ArrayList<String> cart = new ArrayList<String>();
				cart = customer.get(i).getCart();
				for (int j = 0; j < cart.size(); j++) {
					if(mediaTitle.equals(cart.get(j))) {
						cart.remove(j);
						return true;							
					}
				}
			}
			
		}
		return false;
	}
	//method to Conversion a media from array list cart to array list rented and decrease number of copies 1
	@Override
	public String processRequests() {
		Collections.sort(customer);
		String ret = "| ";
		String errors = "";
		String reslut = "";
		for (int i = 0; i < customer.size(); i++) {
			ret += "Sending [";
			count = customer.get(i).getRented().size();
			for (int j = 0; j < customer.get(i).getCart().size() ; j++) {
				if(customer.get(i).getValue() == -1 || count < customer.get(i).getValue()) {
					if((customer.get(i).getRented().contains(customer.get(i).getCart().get(j)))){
						errors += "|\n| The media " + customer.get(i).getCart().get(j) +" is in already reseved to "+ customer.get(i).getName();
						continue;
					} 
					else {			
						for (int k = 0; k < media.size(); k++) {
							if( media.get(k).getTitle().equals(customer.get(i).getCart().get(j).trim())) {
								if(media.get(k).getNumOfCopies() > 0) {
									customer.get(i).getRented().add(customer.get(i).getCart().get(j));
									media.get(k).setNumOfCopies(media.get(k).getNumOfCopies() - 1);		
									ret += " [ " + customer.get(i).getCart().get(j) + " ] ";
									if(removeFromCart(customer.get(i).getName(), customer.get(i).getCart().get(j)))
										j--;
									count++;
									if(customer.get(i).getCart().size() == 0 ) {										
										j = customer.get(i).getCart().size();
									}
									break;
								}
								else {
									errors += "|\n| The number of copies in media " + customer.get(i).getCart().get(j) +" is equal 0 .";
									k = media.size();
								}
							}
						}
					}
				}
				else
					errors += "value = " + customer.get(i).getValue();
				if((customer.get(i).getValue() <= count ) && (customer.get(i).getValue() != -1) ) {
					errors += "|\n| The coustomer "+customer.get(i).getName()+" plan is limited he cant reseved larger than "+customer.get(i).getValue()+" media .";
					break;
				}
			}
			ret += " ] to [ " + customer.get(i).getName() + " ] \n| ";
		}
		
		
		reslut = ret + "\n" + errors;
		return reslut; 
	}
	// method to return media from array list rented to data base and increase number of copies 1
	@Override
	public boolean returnMedia(String customerName, String mediaTitle) {
		for (int i = 0; i < customer.size(); i++) {
			if (customer.get(i).getName().equals(customerName)) {
				if (customer.get(i).getRented().contains(mediaTitle)) {
					ArrayList<String> cart = new ArrayList<>();
					cart = customer.get(i).getRented();
					cart.remove(mediaTitle);
					customer.get(i).setRented(cart);
					for (int j = 0; j < media.size(); j++) {
						if (media.get(j).getTitle().equals(mediaTitle)) {
							media.get(j).setNumOfCopies(media.get(j).getNumOfCopies() + 1);
							return true;
						}
					}
				} else 
					return false;
			}
		}
		return false;
	}
	//to return all media that has a Attributes of the same attributes that were entered
	@Override
	public ArrayList<String> searchMedia(String title, String rating, String artist, String songs) {
		ArrayList<String> serch = new ArrayList<>();
		if (title.equals("") && rating.equals("") && artist.equals("") && songs.equals("")) {
			for (int i = 0; i < media.size(); i++) {
				serch.add(media.get(i).toString());
			}
			Collections.sort(serch);
			return serch; 
		}
		else if ( !title.equals("") && rating.equals("") && artist.equals("") && songs.equals("")) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i).getTitle().equals(title)) {
					if(media.get(i) instanceof Album ) {
						serch.add(media.get(i).toString());
					}
					else if(media.get(i) instanceof Movie ) {
						serch.add(media.get(i).toString());
					}
					else if(media.get(i) instanceof Game ) {
						serch.add(media.get(i).toString());
					}

				}
			}
			Collections.sort(serch);
			return serch;
		}
		else if ( !title.equals("") && !rating.equals("") && artist.equals("") && songs.equals("")) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i).getTitle().equals(title)) {
					if(media.get(i) instanceof Movie ) {
						if(media.get(i).toString().contains(rating)) {
							serch.add(media.get(i).toString());
						}
					}
				}
			}
			Collections.sort(serch);
			return serch;
		}
		else if ( !title.equals("") && rating.equals("") && !artist.equals("") && songs.equals("")) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i).getTitle().equals(title)) {
					if(media.get(i) instanceof Album ) {
						if(media.get(i).toString().contains(artist)) {
							serch.add(media.get(i).toString());	
						}
					}
				}
			}
			Collections.sort(serch);
			return serch; 
		}
		else if ( !title.equals("") && rating.equals("") && artist.equals("") && !songs.equals("") ) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i).getTitle().equals(title)) {
					if(media.get(i) instanceof Album ) {
						if(media.get(i).toString().contains(songs)) {
							serch.add(media.get(i).toString());
						}
					}
				}
			}
			Collections.sort(serch);
			return serch; 
		}
		else if ( title.equals("") && rating.equals("") && artist.equals("") && !songs.equals("") ) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i) instanceof Album ) {
					if(media.get(i).toString().contains(songs)) {
						serch.add(media.get(i).toString());
					}
				}
			}
			Collections.sort(serch);
			return serch; 
		}
		else if ( title.equals("") && rating.equals("") && !artist.equals("") && songs.equals("") ) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i) instanceof Album ) {
					if(media.get(i).toString().contains(artist)) {
						serch.add(media.get(i).toString());
					}
				}
			}
			Collections.sort(serch);
			return serch; 
		}
		else if ( title.equals("") && !rating.equals("") && artist.equals("") && songs.equals("") ) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i) instanceof Movie ) {
					if(media.get(i).toString().contains(rating)) {
						serch.add(media.get(i).toString());
					}
				}
			}
			Collections.sort(serch);
			return serch; 
		}
		else if ( !title.equals("") && rating.equals("") && !artist.equals("") && !songs.equals("") ) {
			for (int i = 0; i < media.size(); i++) {
				if(media.get(i).getTitle().equals(title)) {
					if(media.get(i) instanceof Album ) {
						if(media.get(i).toString().contains(rating)) {
							if(media.get(i).toString().contains(songs)) {
								serch.add(media.get(i).toString());
							}
						}
					}
				}
			}
			Collections.sort(serch);
			return serch;
		}
		else
			throw new IllegalArgumentException();		
	}
}

