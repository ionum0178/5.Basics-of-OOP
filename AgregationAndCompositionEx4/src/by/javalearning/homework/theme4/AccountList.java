package by.javalearning.homework.theme4;

import java.util.List;
import java.util.Objects;

public class AccountList {

    private List<Account> accounts;

    public AccountList(List<Account> accounts) {
	this.accounts = accounts;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public int hashCode() {
	return Objects.hash(accounts);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	AccountList other = (AccountList) obj;
	return Objects.equals(accounts, other.accounts);
    }
    
    
}
