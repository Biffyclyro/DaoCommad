import java.sql.Connection;

public interface Command<T> {
    T execute(Connection c);
}
