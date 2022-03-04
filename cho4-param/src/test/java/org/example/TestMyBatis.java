package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.example.vo.QueryParam;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudentById(){

        /*
        * 使用mybatis的动态代理机制，使用sqlSession.getMapper(dao接口)
        * getMapper能获取dao接口对应的实现类对象。
        * */

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1002);

        System.out.println("student="+student);


        }

        @Test
    public void testSelectMultiParam(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("李四",20);

        for (Student stu : students){

            System.out.println("学生="+stu);

        }

        sqlSession.close();

        }


    @Test
    public void testSelectMultiObject(){

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam queryParam = new QueryParam();
        queryParam.setParamAge(20);
        queryParam.setParamName("张三");

        List<Student> students = dao.selectMultiObject(queryParam);

        for (Student stu : students){

            System.out.println("学生="+stu);

        }

        sqlSession.close();

    }

    @Test
    public void testSelectLikeOne(){



        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "%李%";

        List<Student> students = dao.selectLikeOne(name);

        for (Student stu : students){

            System.out.println("student="+stu);

        }
      sqlSession.close();


    }

    @Test
    public void testSelectLikeTwo(){



        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "李";

        List<Student> students = dao.selectLikeTwo(name);

        for (Student stu : students){

            System.out.println("student="+stu);

        }
        sqlSession.close();


    }

    }


