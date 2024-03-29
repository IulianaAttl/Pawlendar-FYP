package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "select o from User o")
})
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String password;
	private String location;
	private String bio;
	private int timesLoggedIn;
	
	//a user can have many pets
	@OneToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Pet> pets = new ArrayList<Pet>();
	
	//a user can have many tasks live
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Task> liveTasks = new ArrayList<Task>();
	
	//a user has a list of badges
	@ManyToMany
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Badge> badges = new ArrayList<Badge>();
		
	public User() {
		
	}
	
	public User(String firstName, String lastName, String username, String email, String password, String location, String bio, int timesLoggedIn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.password = password;
		this.location = location;
		this.bio = bio;
		this.timesLoggedIn = timesLoggedIn;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public int getTimesLoggedIn() {
		return timesLoggedIn;
	}

	public void setTimesLoggedIn(int timesLoggedIn) {
		this.timesLoggedIn = timesLoggedIn;
	}
	
	public List<Task> getLiveTasks() {
		return liveTasks;
	}

	public void setLiveTasks(List<Task> liveTasks) {
		this.liveTasks = liveTasks;
	}

	public List<Badge> getBadges() {
		return badges;
	}

	public void setBadges(List<Badge> badges) {
		this.badges = badges;
	}
}