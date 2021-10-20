package com.asl.intern.login.mapper;

import com.asl.intern.login.entity.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {
    @Select("select * from user where account=#{account}")
    public User findByAccount(String account);
    
    @Update("update user set error_count=error_count+1 where account=#{account}")
    public int increaseUserErrorCount(String account);
    
    @Update("update user set error_count=0 where account=#{account}")
    public boolean cleanUserErrorCount(String account);
}
