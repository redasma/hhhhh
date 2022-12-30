package UserProfileExtraction;

import java.util.LinkedList;
import java.util.List;

import com.example.tp3.Product;
import com.example.tp3.User;

public class UserProfile {
	private User user;
	private List<String> readingOperations;
	private List<String> writingOperations;
	private List<Product> mostExpensiveProductsSearched;
	
	public UserProfile(User user) {
		super();
		this.user = user;
		readingOperations = new LinkedList<String>();
		writingOperations = new LinkedList<String>();
		mostExpensiveProductsSearched = new LinkedList<Product>();



}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<String> getReadingOperations() {
		return readingOperations;
	}

	public void setReadingOperations(List<String> readingOperations) {
		this.readingOperations = readingOperations;
	}

	public List<String> getWritingOperations() {
		return writingOperations;
	}

	public void setWritingOperations(List<String> writingOperations) {
		this.writingOperations = writingOperations;
	}

	public List<Product> getMostExpensiveProductsSearched() {
		return mostExpensiveProductsSearched;
	}

	public void setMostExpensiveProductsSearched(List<Product> mostExpensiveProductsSearched) {
		this.mostExpensiveProductsSearched = mostExpensiveProductsSearched;
	}
}
