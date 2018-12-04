package dbService.executor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by dkotenko on 11/21/18.
 */
public interface ResultHandler<T> {
    T handle(ResultSet resultSet) throws SQLException;
}
