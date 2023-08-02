package tables;

import db.IDBConnector;
import db.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbsTable {
    public String tableName;
    public Map<String, String> columns;
    IDBConnector db;

    public AbsTable(String tableName) {
        this.tableName = tableName;
        db = new MySQLConnector();
    }


    public int getCount() {
        final String sqlRequest = String.format("SELECT COUNT(*) FROM %s", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        int count = 0;
        try {
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return count;
    }

    public void create(Map<String, String> columns) {
        this.columns = columns;
        String sqlRequest = String.format("CREATE TABLE %s (%s)", this.tableName, convertMapColumnsToString());
        db.executeRequest(sqlRequest);
    }

    private String convertMapColumnsToString() {
        final String result = columns.entrySet().stream()
                .map((Map.Entry entry) -> String.format("%s %s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
        return result;
    }
}
