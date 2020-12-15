package dao;

/**
 * INFO310
 * DAOException.java
 * Forwards DAO exception/Run Time exceptions to console
 * when errors occur during database access.
 * @author Hugo Baird
 */
public class DAOException extends RuntimeException {
    public DAOException(String reason) {
        super(reason);
    }
    
    public DAOException(String reason, Throwable cause) {
        super(reason, cause);
    }
}