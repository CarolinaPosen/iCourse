package by.itacademy.mikhalevich.icourse.model;


public class Account extends AbstractEntity<Long> implements CurrentAccount {
	private String name;
	private String email;
	private String password;

	public Account() {
		super();
	}

	public Account(Long id) {
		super(id);
	}

	public Account(Long id, String name, String email, String password) {
		super(id);
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Override
	public String getDescription() {
		return name + "("+email+")";
	}

	@Override
	public String toString() {
		return String.format("Account [id=%s, name=%s, email=%s]", getId(), name, email);
	}
}
