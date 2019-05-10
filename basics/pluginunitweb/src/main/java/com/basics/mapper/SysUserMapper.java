package com.basics.mapper;

import com.basics.entity.SysRole;
import com.basics.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xueshiqi
 * @since 2019/3/29
 * 用户信息表的dao
 */
@Mapper
public interface SysUserMapper {

    /**
     * 查询全部的用户数据
     * @return
     */
    @Select("select * from sys_user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.basics.mapper.SysRoleMapper.getAllByUserId"))
    })
    List<SysUser> getAll();

    /**
     * 根据角色id查询出对应角色的用户
     * @param roleId
     * @return
     */
    @Select("select u.* from sys_user u inner join sys_role_user ru on u.id = ru.sys_user_id where ru.sys_role_id = #{roleId}")
    List<SysUser> getAllByRoleId(@Param("roleId") Integer roleId);

    /**
     * 根据用户id进行查询对应的用户信息
     * @param id
     * @return
     */
    @Select("select * from sys_user where id =#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.basics.mapper.SysRoleMapper.getAllByUserId"))
    })
    SysUser getSysUserById(int id);

    /**
     * 根据用户名称进行查询
     * @param username
     * @return
     */
//    一对一使用如下
//    @Result(property = "address",column = "address_id",one = @One(select = "com.ay.mybatis.dao.AddressMapper.findAddressById"))
    @Select("select * from sys_user where username =#{username}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "roles",column = "id",many = @Many(select = "com.basics.mapper.SysRoleMapper.getAllByUserId"))
    })
    SysUser getSysUserByUserName(@Param("username") String username);
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
