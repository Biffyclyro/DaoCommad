import java.sql.Connection;

public class UpdateCommand implements Command<String> {


    @Override
    public String execute(Connection c) {
        return "Update";
    }
}
