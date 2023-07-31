package tables;

import java.util.HashMap;
import java.util.Map;

public class StudentTable extends AbsTable{
    public StudentTable(String tableName) {
        super(tableName);
        columns = new HashMap<>(Map.of("id", "INT", "fio", "VARCHAR(255)", "sex", "ENUM('male', 'female')", "id_group", "INT"));
    }

    public void insert(int id, String fio, String sex, int id_group) {
        String sqlRequest = String.format("INSERT INTO %s (id, fio, sex, id_group) VALUES (%d, '%s', '%s', %d)", tableName, id, fio, sex, id_group);
        db.executeRequest(sqlRequest);
    }

    public void update(int id, String fio, String sex, int id_group) {
        String sqlRequest = String.format("UPDATE %s SET fio='%s', sex='%s', id_group=%d WHERE id=%d", tableName, fio, sex, id_group, id);
        db.executeRequest(sqlRequest);
    }

    public void delete(int id) {
        String sqlRequest = String.format("DELETE FROM %s WHERE id=%d", tableName, id);
        db.executeRequest(sqlRequest);
    }
}
