package by.itacademy.mikhalevich.icourse.repository;

import by.itacademy.mikhalevich.icourse.model.Account;
import java.util.HashMap;
import java.util.Map;

public class LoginPasswordSource {
    private Map<Long, Account> loginMap;

    public LoginPasswordSource() {
        this.loginMap = createLoginList();
    }

    private Map<Long, Account> createLoginList() {

        HashMap<Long, Account> account = new HashMap<>();

//        Account account1 = new Account((long) 1,"Yauheni", "admin@admin", "admin");
//        Account account2 = new Account((long) 2,"Kirill", "Kirill@gmail.ru", "1");
//        Account account3 = new Account((long) 3,"Yauheni", "Eva@mail.ru", "2");

//        account.put(account1.getId(), account1);
//        account.put(account2.getId(), account2);
//        account.put(account3.getId(), account3);
        return account;
    }

    public Map<Long, Account> getLoginMap() {
        return loginMap;
    }

    public Account getAccountById(Long id) {
        return loginMap.get(id);
    }

}
