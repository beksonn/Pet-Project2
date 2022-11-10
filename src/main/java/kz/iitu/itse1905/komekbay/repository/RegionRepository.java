package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
@Lazy
public class RegionRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Region> listAllRegion(){
        return jdbcTemplate.query(
                "SELECT * FROM region",
                (rs, rowNum) -> new Region(rs.getInt("ID"), rs.getString("NAME"),
                        rs.getFloat("FIRST_LVL_PAYMENT"), rs.getFloat("SECOND_LVL_PAYMENT"), rs.getFloat("THIRD_LVL_PAYMENT")));
    }

    public String createRegion(Region newRegion){
        jdbcTemplate.update("insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( ?,?,?,? )",newRegion.getName(),newRegion.getFirstLvlPayment(),newRegion.getSecondLvlPayment(),newRegion.getThirdLvlPayment());
        return "Region added successfully";
    }

    public Page<Region> findAllWithPagination(Pageable page) {
        List<Region> regions1 = listAllRegion();
        List<Region> regions = jdbcTemplate.query("select * from region LIMIT " + page.getPageNumber() + " OFFSET " + (page.getPageSize()-1),
                (rs, rowNum) -> new Region(rs.getInt("ID"), rs.getString("NAME"),
                        rs.getFloat("FIRST_LVL_PAYMENT"), rs.getFloat("SECOND_LVL_PAYMENT"), rs.getFloat("THIRD_LVL_PAYMENT")));
        return new PageImpl<Region>(regions, page, count());
    }

    public int count() {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM region", Integer.class);
    }
}