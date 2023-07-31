package tables;

import java.util.HashMap;
import java.util.Map;

public class CuratorTable extends AbsTable {
    public CuratorTable(String tableName) {
        super(tableName);
        columns = new HashMap<>(Map.of("id", "INT", "fio", "VARCHAR(255)"));
    }

    public void insert(int id, String fio) {
        String sqlRequest = String.format("INSERT INTO %s (id, fio) VALUES (%d, '%s')", tableName, id, fio);
        db.executeRequest(sqlRequest);
    }

    public void update(int id, String fio) {
        String sqlRequest = String.format("UPDATE %s SET fio='%s' WHERE id=%d", tableName, fio, id);
        db.executeRequest(sqlRequest);
    }
}
