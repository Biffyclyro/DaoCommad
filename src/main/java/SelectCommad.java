import java.sql.Connection;

public class SelectCommad implements Command<String>{

    @Override
    public String execute(Connection c) {
        return "Select";
    }
}
