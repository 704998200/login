package com.asl.intern.login.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.asl.intern.login.entity.User;
import com.asl.intern.login.mapper.UserMapper;

public class SqlSessionFactoryUtil {
	public SqlSessionFactoryUtil() {
		
	}
	public static SqlSessionFactory sqlSessionFactory=null;
	public static SqlSessionFactory getSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			return sqlSessionFactory;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
