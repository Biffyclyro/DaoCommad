import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class InvokerDAO {
    private final List<Consumer<Connection>> commandList = new ArrayList<>();
    private final DataSource ds;

    public InvokerDAO(DataSource ds) {
        this.ds = ds;
    }


    public <T> void addCommand(Command<T> c, Consumer<T> callback){
        this.commandList.add(conn -> callback.accept(c.execute(conn)));
    }

    public <T> void executeAll(){
       try (final var conn = ds.getConnection()) {

           this.commandList.parallelStream().forEach( command ->{
               command.accept(conn);
           });
       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }
    }


}
