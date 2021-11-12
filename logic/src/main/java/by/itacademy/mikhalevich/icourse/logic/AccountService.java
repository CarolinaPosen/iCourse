package by.itacademy.mikhalevich.icourse.logic;

import by.itacademy.mikhalevich.icourse.model.CurrentAccount;

public interface AccountService {

	CurrentAccount authentificate(String login, String password);

}
