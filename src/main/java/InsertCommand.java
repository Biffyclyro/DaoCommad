import java.sql.Connection;

public class InsertCommand implements Command<String> {

    @Override
    public String execute(Connection c) {
        return "Insert";
    }
}
