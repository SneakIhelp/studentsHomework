import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentTable studentTable = new StudentTable("StudentTable");
        studentTable.create(Map.of("id", "INT", "fio", "VARCHAR(255)", "sex", "ENUM('male', 'female')", "id_group", "INT"));

        GroupTable groupTable = new GroupTable("GroupTable");
        groupTable.create(Map.of("id", "INT", "name", "VARCHAR(255)", "id_curator", "INT"));

        CuratorTable curatorTable = new CuratorTable("CuratorTable");
        curatorTable.create(Map.of("id", "INT", "fio", "VARCHAR(255)"));

        curatorTable.insert(1, "Ivan Ivanov");
        curatorTable.insert(2, "Maria Petrova");
        curatorTable.insert(3, "Sergey Smirnov");
        curatorTable.insert(4, "Elena Sidorova");

        groupTable.insert(1, "CS101", 1);
        groupTable.insert(2, "CS102", 2);
        groupTable.insert(3, "CS103", 3);

        studentTable.insert(1, "Alexey Pupkin", "male", 1);
        studentTable.insert(2, "Anna Orlova", "female", 1);
        studentTable.insert(3, "Vladimir Kozlov", "male", 1);
        studentTable.insert(4, "Natalia Sokolova", "female", 1);
        studentTable.insert(5, "Petr Vasilev", "male", 2);
        studentTable.insert(6, "Olga Zaitseva", "female", 2);
        studentTable.insert(7, "Igor Morozov", "male", 2);
        studentTable.insert(8, "Tatiana Nikolaeva", "female", 2);
        studentTable.insert(9, "Dmitry Kuznetsov", "male", 3);
        studentTable.insert(10, "Ekaterina Popova", "female", 3);
        studentTable.insert(11, "Maxim Makarov", "male", 3);
        studentTable.insert(12, "Daria Kovalenko", "female", 3);
        studentTable.insert(13, "Anton Zakharov", "male", 1);
        studentTable.insert(14, "Yulia Baranova", "female", 2);
        studentTable.insert(15, "Leonid Polakov", "male", 3);


        System.out.println("Information about all students:");
        studentTable.selectAllWithGroupAndCurator();

        int studentCount = studentTable.getCount();
        System.out.println("Number of students: " + studentCount);

        System.out.println("Female students:");
        studentTable.selectFemaleStudents();

        groupTable.update(1, "CS101", 4);

        System.out.println("List of groups with curators:");
        groupTable.selectAllWithCurator();

        System.out.println("Students from CS102:");
        studentTable.selectStudentsByGroupName("CS102");
    }
}