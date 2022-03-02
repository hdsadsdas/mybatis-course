package org.example.utils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtils {

    private static  SqlSessionFactory factory = null;

    //静态块  只执行一次
    static {

        String config = "mybatis.xml";
        try {
            InputStream in = Resources.getResourceAsStream(config);

            //创建SqlSessionFactory对象  使用SqlSessionFactoryBuilder
            factory = new SqlSessionFactoryBuilder().build(in);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //获取sqlSession的方法
    public static SqlSession getSqlSession(){

        SqlSession sqlSession = null;

        if (factory != null){

            sqlSession = factory.openSession();//非自动提交事务

        }

        return sqlSession;

    }

}
