package pdfGenerator.model;

public class User {
	private long id;
	private String username;
	private int age;
	public int getAge() {
		return age;
	}
	public long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
