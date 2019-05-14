package com.Jsoup;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Desc
 * @Author 刘慧斌
 * @CreateTime 2019-04-28 11:43
 **/
public class MysqlTest {
    public static void main(String[] args) {
        String resource = "mybatis-config.xml";
        int count = 0;
        SqlSession sqlSession = null;
        try {
            //1 获取mybatis-config.xml的输入流
            InputStream is = Resources.getResourceAsStream(resource);
            //2 创建SqlSessionFactory对象，完成对配置文件的读取
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //3 创建sqlSession
            sqlSession = factory.openSession();
            //4 调用mapper文件来对数据进行操作，必须先把mapper文件引入到mybatis-config.xml中
            count = sqlSession.selectOne("resources/BankFinancialProductsDao");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            sqlSession.close();
        }
    }
}
