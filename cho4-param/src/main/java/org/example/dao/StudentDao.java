package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.Student;
import org.example.vo.QueryParam;

import java.util.List;


public interface StudentDao {

    /*
    * 一个简单类型的参数
    * 简单类型 ： mybatis把Java中基本数据类型和String都叫简单类型。
    *
    * 在mapper文件获取简单类型的一个参数的值，使用#{任意字符}
    *
    * */

    Student selectStudentById(Integer id);

    /*
    * 多个参数：命名参数，在形参定义的前面加入@Param("自定义参数名称")
    * */

    List<Student> selectMultiParam(@Param("myname") String name,@Param("myage") Integer age);


    List<Student> selectMultiObject(QueryParam param);


    /*第一种模糊查询 ， 在java代码中指定 like的内容*/

    List<Student> selectLikeOne(String name);

    /*第二中模糊查询  在mapper文件中拼接 like内容*/
    List<Student> selectLikeTwo(String name);

}
