package kz.iitu.itse1905.komekbay.repository;

import kz.iitu.itse1905.komekbay.model.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Doc> listAllDocs() {
        return jdbcTemplate.query(
                "SELECT * FROM doc",
                (rs, rowNum) -> new Doc(rs.getInt("ID"), rs.getString("DOC_NAME"),
                        rs.getString("DOC_TYPE") ,rs.getBytes("DATA")));
    }

    public void saveFile(Doc newDoc){
        jdbcTemplate.update("insert into doc(DOC_NAME, DOC_TYPE, DATA) values ( ?,?,? )",newDoc.getDocName(),newDoc.getDocType(),newDoc.getData());
    }

}
