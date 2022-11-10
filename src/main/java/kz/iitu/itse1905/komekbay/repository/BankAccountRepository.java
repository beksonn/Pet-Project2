package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BankAccountRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<BankAccount> listAllBankAccount() {
        return jdbcTemplate.query(
                "SELECT * FROM bank_account",
                (rs, rowNum) -> new BankAccount(rs.getInt("ID"), rs.getString("OWNER_FULL_NAME"),
                        rs.getInt("OWNER_PERSONAL_ACCOUNT"), rs.getFloat("MONEY"), rs.getBoolean("PAYMENT_FOR_THIS_MONTH")));
    }

    public void changeOwnerPersonalAccount(BankAccount bankAccount) {
        jdbcTemplate.update("update bank_account set OWNER_PERSONAL_ACCOUNT = ? where OWNER_FULL_NAME = ?",bankAccount.getOwnerPersonalAccount(), bankAccount.getOwnerFullName());
    }

    public String fillUpAccount(BankAccount bankAccount, float fillingMoney) {
        Float finalMoney = bankAccount.getMoney() + fillingMoney;
        jdbcTemplate.update("update bank_account set MONEY = ? where OWNER_PERSONAL_ACCOUNT = ?",finalMoney, bankAccount.getOwnerPersonalAccount());
        return "Bank account filled up";
    }

    public String fillDownAfterPayment(BankAccount bankAccount, float forPayment, boolean inspectorOrMonthPay) {
        Float finalMoney = bankAccount.getMoney() - forPayment;
        if(inspectorOrMonthPay) {
            jdbcTemplate.update("update bank_account set MONEY = ?, PAYMENT_FOR_THIS_MONTH = ? where OWNER_PERSONAL_ACCOUNT = ?", finalMoney, true, bankAccount.getOwnerPersonalAccount());
        }else{
            jdbcTemplate.update("update bank_account set MONEY = ? where OWNER_PERSONAL_ACCOUNT = ?", finalMoney, bankAccount.getOwnerPersonalAccount());
        }
        return "You paid for this month";
    }
}
