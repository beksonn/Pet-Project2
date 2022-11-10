package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Repository")
public class ConsumerRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Consumer> listAllConsumers() {
        return jdbcTemplate.query(
                "SELECT * FROM consumer",
                (rs, rowNum) -> new Consumer(rs.getInt("PERSONAL_ACCOUNT"), rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"), rs.getString("ADDRESS"), rs.getFloat("LAST_METER_READING"),rs.getString("REGION")));
    }

    public String createConsumer(Consumer newConsumer){
        jdbcTemplate.update("insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( ?,?,?,?,? )",newConsumer.getFirstName(),newConsumer.getLastName(),newConsumer.getAddress(),newConsumer.getLastMeterReading(),newConsumer.getRegion());
        String ownerFullName = newConsumer.getFirstName() + newConsumer.getLastName();
        jdbcTemplate.update("insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( ?,?,?,? )",ownerFullName,newConsumer.getPersonalAccount(),0.0,false);
        return "Consumer added to Region successfully";
    }

    public String updateConsumerById(Consumer updConsumer, int personalAccount){
        jdbcTemplate.update("update consumer set last_meter_reading = ?, first_name=?, last_name=?, address = ?, region = ? where personal_account = ?",
                updConsumer.getLastMeterReading(), updConsumer.getFirstName(), updConsumer.getLastName(),updConsumer.getAddress(),updConsumer.getRegion(),personalAccount);
        return "Consumer updated successfully";
    }

    public String deleteConsumerByPersonalAccount(int personalAccount){
        jdbcTemplate.update("delete from consumer where personal_account=?",personalAccount);
        return "Consumer with personal account: " + personalAccount + " has been deleted";
    }

    public void changeLastMeterAfterBill(int personalAccount, float newLastMeter){
        jdbcTemplate.update("update consumer set last_meter_reading = ? where personal_account = ?",
                newLastMeter, personalAccount);
    }
}