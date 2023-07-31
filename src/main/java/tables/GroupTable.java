package tables;

import java.util.HashMap;
import java.util.Map;

public class GroupTable extends AbsTable{
    public GroupTable(String tableName) {
        super(tableName);
        columns = new HashMap<>(Map.of("id", "INT", "name", "VARCHAR(255)", "id_curator", "INT"));
    }

    public void insert(int id, String name, int id_curator) {
        String sqlRequest = String.format("INSERT INTO %s (id, name, id_curator) VALUES (%d, '%s', %d)", tableName, id, name, id_curator);
        db.executeRequest(sqlRequest);
    }

    public void update(int id, String name, int id_curator) {
        String sqlRequest = String.format("UPDATE %s SET name='%s', id_curator=%d WHERE id=%d", tableName, name, id_curator, id);
        db.executeRequest(sqlRequest);
    }
}
