package cn.bdqn.test;

import cn.bdqn.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class StuTest {
    public static void main(String[] args) {
        String resources ="mybatis-config.xml";
        Reader reader =null;
        try {
            reader=Resources.getResourceAsReader(resources);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession= sqlSessionFactory.openSession();
         List<Student> studentList= sqlSession.selectList("getStuList");
        for (Student stu: studentList) {
            System.out.println("姓名："+stu.getStuname()+",年龄："+stu.getAge()+",地址："+stu.getAddress());
        }
    }
}
