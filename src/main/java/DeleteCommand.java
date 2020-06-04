import java.sql.Connection;

public class DeleteCommand implements Command<String>{

    @Override
    public String execute(Connection c) {
        return "Delete";
    }
}
