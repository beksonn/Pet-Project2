package kz.iitu.itse1905.komekbay.configuration;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.ParsedSql;

import javax.sql.DataSource;
import java.util.Deque;
import java.util.List;

class BatchConfigTest {
    @Mock
    Deque<Object> parameterQueue;
    @Mock
    List<Integer> rowsAffected;
    @Mock
    PreparedStatementCreatorFactory preparedStatementFactory;
    @Mock
    ParsedSql cachedSql;
    @Mock
    Object parsedSqlMonitor;
    @Mock
    Log logger;
    @Mock
    JdbcTemplate jdbcTemplate;
    @Mock
    List<SqlParameter> declaredParameters;
    @InjectMocks
    BatchConfig batchConfig;
    private DataSource dataSource;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testBatchConfig(){
        BatchConfig batchConfig = new BatchConfig(dataSource);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme