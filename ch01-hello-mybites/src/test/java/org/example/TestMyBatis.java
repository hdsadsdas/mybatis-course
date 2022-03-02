package org.example;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.domain.Student;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {

    //测试方法，测试功能
    @Test
        public void textInert() throws IOException {

            //访问mybatis读取student数据
            //1.定义mybatis主配置文件的名称

            String config = "mybatis.xml";

            //2读取这个config表示的文件
            InputStream in = Resources.getResourceAsStream(config);

            //3创建SqlSessionFactoryBuilder类对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            //4创建SqlSessionFactory类对象
            SqlSessionFactory factory = builder.build(in);

            //5获取SqlSession对象，从SqlSessionFactory中获取SqlSession
            SqlSession sqlSession = factory.openSession();

            //6指定要执行的sql语句的标识。sql映射文件中的namespace + "." + 标签的id值
            String sqlId = "org.example.dao.StudentDao" + "." + "insertStudent";

            Student student = new Student();
            student.setId(1004);
            student.setName("啦啦啦");
            student.setEmail("xhhxzlch@aaa");
            student.setAge(20);

            //7执行sql语句，通过sqlId找到语句
            int nums = sqlSession.insert(sqlId,student);

            //mybatis默认不是自动提交事务，所有在执行sql语句后要手动提交事务
            sqlSession.commit();

            //8输出结果
            System.out.println("执行插入结果为"+nums);

            //9关闭SqlSession对象
            sqlSession.close();

        }

    }


