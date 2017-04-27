
package domain.db;

import java.sql.SQLException;

public class DbException extends RuntimeException {

    public DbException() {
        super();
    }
    
    public DbException(String message) {
        super(message);
    }
    
}
