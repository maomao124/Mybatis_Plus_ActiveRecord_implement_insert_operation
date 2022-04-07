package mapper;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import data.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Project name(项目名称)：Mybatis_Plus_ActiveRecord实现插入操作
 * Package(包名): mapper
 * Class(测试类名): StudentMapperTest
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2022/4/7
 * Time(创建时间)： 17:08
 * Version(版本): 1.0
 * Description(描述)： 测试类
 */

class StudentMapperTest
{
    @Test
    public void insert() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student student = new Student();
        student.setName("李四");
        student.setId_card("123456");
        student.setSex("男");
        student.setBirthday("2003");
        student.setClass_no(1001L);

        boolean insert = student.insert();

        System.out.println(insert);
        System.out.println(student);
    }

    @Test
    public void query() throws IOException
    {
        String resource = "mybatis-config.xml";
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream(resource);
        //根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new MybatisSqlSessionFactoryBuilder().build(config);
        //通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Student student = new Student();

        QueryWrapper<Student> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id_card", "123456");

        List<Student> list = student.selectList(queryWrapper);

        for (Student student1 : list)
        {
            System.out.print(student1);
        }
    }
}