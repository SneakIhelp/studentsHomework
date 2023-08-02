package tables;

import db.MySQLConnector;

import java.util.HashMap;
import java.util.Map;

public class CuratorTable extends AbsTable {
    public CuratorTable(String tableName) {
        super(tableName);
    }

    public void insert(int id, String fio) {
        String sqlRequest = String.format("INSERT INTO %s (id, fio) VALUES (%d, '%s')", tableName, id, fio);
        db.executeRequest(sqlRequest);
    }
}