import org.postgresql.ds.PGSimpleDataSource;

public class ExDAO {
    public static void main(String[] args) {
        final var ds = new PGSimpleDataSource();
        ds.setUser("");
        ds.setDatabaseName("");
        ds.setPassword("");

        final var dao = new InvokerDAO(ds);

        dao.addCommand(new InsertCommand(), System.out::println);
        dao.addCommand(new DeleteCommand(), System.out::println);
        dao.addCommand(new SelectCommad(), System.out::println);
        dao.addCommand(new UpdateCommand(), System.out::println);

        dao.executeAll();

    }
}
