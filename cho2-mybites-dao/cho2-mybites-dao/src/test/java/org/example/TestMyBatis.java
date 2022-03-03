package org.example;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudent(){

        StudentDao dao = new StudentDaoImpl();
        List<Student> studentList = dao.selectStudents();

        for (Student stu : studentList){

            System.out.println(stu);

        }

    }

    @Test
    public void testInsertStudent(){

        StudentDao dao = new StudentDaoImpl();

        Student student = new Student();

        student.setId(1005);
        student.setAge(20);
        student.setName("战火");
        student.setEmail("dasdasd@dasd");

        int nums = dao.insertStudent(student);

        System.out.println("添加对象的数量："+ nums);

    }


}
