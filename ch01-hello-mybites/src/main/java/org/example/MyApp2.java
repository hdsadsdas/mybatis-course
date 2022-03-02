package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyApp2 {
    public static void main(String[] args) throws IOException {


        //5获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        //6指定要执行的sql语句的标识。sql映射文件中的namespace + "." + 标签的id值
        String sqlId = "org.example.dao.StudentDao" + "." + "selectStudents";

        //7执行sql语句，通过sqlId找到语句
        List<Student> studentList =  sqlSession.selectList(sqlId);

        //8输出结果
        studentList.forEach(stu -> System.out.println(stu));

        //9关闭SqlSession对象
        sqlSession.close();

    }
}
