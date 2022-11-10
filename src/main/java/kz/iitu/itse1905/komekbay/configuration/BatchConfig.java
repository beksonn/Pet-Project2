package kz.iitu.itse1905.komekbay.configuration;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.BatchSqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class BatchConfig extends BatchSqlUpdate {
    private static String SQL_MOVIE = "insert into Consumer(name, type,price)" +
            "values( :name, :type, :price)";


    private static int BatchSize = 10;

    public BatchConfig(DataSource dataSource){
        super(dataSource, SQL_MOVIE);

        declareParameter(new SqlParameter("name", Types.VARCHAR));
        declareParameter(new SqlParameter("type", Types.VARCHAR));
        declareParameter(new SqlParameter("price", Types.INTEGER));

        setBatchSize(BatchSize);
    }
}
