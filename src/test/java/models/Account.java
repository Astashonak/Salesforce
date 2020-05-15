package models;

public class Account {
    String accountName;
    String phone;
    String description;

    public Account(String accountName, String phone, String description) {
        this.accountName = accountName;
        this.phone = phone;
        this.description = description;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
