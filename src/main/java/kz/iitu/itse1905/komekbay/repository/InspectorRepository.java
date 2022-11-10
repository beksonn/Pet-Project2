package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.Consumer;
import kz.iitu.itse1905.komekbay.model.Inspector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InspectorRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Inspector> listAllInspectors() {
        return jdbcTemplate.query(
                "SELECT * FROM inspector",
                (rs, rowNum) -> new Inspector(rs.getInt("ID"), rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),rs.getString("REGION"), rs.getInt("COST_OF_SERVICE"), rs.getBoolean("FREE")));
    }
}
