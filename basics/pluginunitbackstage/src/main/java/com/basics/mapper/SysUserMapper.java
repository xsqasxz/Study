package com.basics.mapper;

import com.basics.entity.SysUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xueshiqi
 * @since 2019/3/29
 * 用户信息表的dao
 */
@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user")
//    @Results({
//            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
//            @Result(property = "nickName", column = "nick_name")
//    })
    List<SysUser> getAll();

    /**
     * 根据用户id进行查询对应的用户信息
     * @param id
     * @return
     */
    @Select("select * from sys_user where id =#{id}")
    SysUser getSysUserById(int id);

    /**
     * 根据用户名称进行查询
     * @param username
     * @return
     */
    @Select("select * from sys_user where username = #{username}")
    SysUser getSysUserByUserName(String username);
    /**
     * 添加用户数据
     * @param sysUser
     * @return
     */
    @Insert("insert into sys_user (nickname,username,password,enabled) values (#{nickname},#{username},#{password},#{enabled})")
    int addSysUser(SysUser sysUser);


    /**
     * 根据传入的id集合来进行删除
     * @param list
     * @return
     */
    @Delete({"<script>delete from sys_user where id in " +
            "<foreach collection=\"list\" item=\"id\" open=\"(\" close=\")\" separator=\",\">#{id}</foreach>" +
            "</script>"})
    int deleteSysUserByIds(List<Integer> list);

    /**
     * 根据传入的名称集合来进行删除
     * @param list
     * @return
     */
    @Delete({"<script>delete from sys_user where username in " +
            "<foreach collection=\"list\" item=\"username\" open=\"(\" close=\")\" separator=\",\">#{username}</foreach>" +
            "</script>"})
    int deleteSysUserByUserName(List<String> list);
}
