package by.itacademy.mikhalevich.icourse.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Account extends AbstractEntity<Long> implements CurrentAccount {
	private String name;
	private String email;
	private String password;

	@Override
	public String getDescription() {
		return name + "("+email+")";
	}

	@Override
	public String toString() {
		return String.format("Account [id=%s, name=%s, email=%s]", getId(), name, email);
	}
}
