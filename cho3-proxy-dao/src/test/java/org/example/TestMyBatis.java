package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudent(){

        /*
        * 使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
        * getMapper能获取dao接口对应的实现类对象。
        * */

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        //调用dao的方法，执行数据库的操作
        List<Student> students = dao.selectStudents();

        for (Student stu : students){

            System.out.println("学生="+stu);

        }


    }

    @Test
    public void testInsertStudent(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setEmail("dasda");
        student.setName("拉了拉");
        student.setId(1006);
        student.setAge(30);

        int nums = dao.insertStudent(student);

        sqlSession.commit();

        if (nums != 0){
            System.out.println("成功");
        }else {
            System.out.println("失败");
        }

    }


}
