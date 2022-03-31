package application;
import java.util.*;

public interface MediaRentalInt {
	void addCustomer(String id, String name, String address, String mobile, String plan);

	void addMovie(String code,String title, int copiesAvailable, String rating);

	void addGame(String code,String title, int copiesAvailable, double weight);

	void addAlbum(String code,String title, int copiesAvailable, String artist, String songs);

	void setLimitedPlanLimit(int value);

	String getAllCustomersInfo();

	String getAllMediaInfo();

	boolean addToCart(String customerName, String mediaTitle);

	boolean removeFromCart(String customerName, String mediaTitle);

	String processRequests();

	boolean returnMedia(String customerName, String mediaTitle);

	ArrayList<String> searchMedia(String title, String rating, String artist, String songs);

}
