package tables;

import db.MySQLConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class StudentTable extends AbsTable{
    public StudentTable(String tableName) {
        super(tableName);
    }

    public void selectAllWithGroupAndCurator() {
        final String sqlRequest = String.format("SELECT s.*, g.name AS group_name, c.fio AS curator_name " +
                "FROM %s s " +
                "JOIN `GroupTable` g ON s.id_group = g.id " +
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

    public void selectFemaleStudents() {
        final String sqlRequest = String.format("SELECT * FROM %s WHERE sex = 'female'", tableName);
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

    public void selectStudentsByGroupName(String groupName) {
        final String sqlRequest = String.format("SELECT s.*, g.name AS group_name, c.fio AS curator_name " +
                "FROM %s s " +
                "JOIN `GroupTable` g ON s.id_group = g.id " +
                "JOIN CuratorTable c ON g.id_curator = c.id " +
                "WHERE g.name = '%s'", tableName, groupName);
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

    public void insert(int id, String fio, String sex, int id_group) {
        String sqlRequest = String.format("INSERT INTO %s (id, fio, sex, id_group) VALUES (%d, '%s', '%s', %d)", tableName, id, fio, sex, id_group);
        db.executeRequest(sqlRequest);
    }
}