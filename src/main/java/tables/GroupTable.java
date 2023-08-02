package tables;

import db.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GroupTable extends AbsTable{
    public GroupTable(String tableName) {
        super(tableName);
    }

    public void selectAllWithCurator() {
        final String sqlRequest = String.format("SELECT g.*, c.fio AS curator_name " +
                "FROM %s g " +
                "JOIN CuratorTable c ON g.id_curator = c.id", tableName);
        ResultSet rs = db.executeRequestWithAnswer(sqlRequest);
        try {
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columns; i++) {
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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