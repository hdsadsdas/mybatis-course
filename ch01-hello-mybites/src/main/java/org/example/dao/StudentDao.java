package org.example.dao;

import org.example.domain.Student;

import java.util.List;

//接口
public interface StudentDao {

    //查询所有数据
    public List<Student> selectStudents();

    //插入方法
    //Student 表示要插入到数据库的数据
    //返回值是执行影响的行数
    public int insertStudent(Student student);

}
