package com.basics.mapper;

import com.basics.entity.SysRole;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author xueshiqi
 * @since 2019/3/29
 * 用户信息表的dao
 */
@Mapper
public interface SysRoleMapper {

    @Select("select r.* from sys_role r inner join sys_role_user ru on r.id =ru.sys_role_id")
    @Results({
            @Result(property = "permissions",column = "id",many = @Many(select = "com.basics.mapper.SysPermissionMapper.getAllByRoleId"))
    })
    List<SysRole> findAll();

    /**
     * 根据userid查询角色信息
     * @param userId
     * @return
     */
    @Select("select r.* from sys_role r inner join sys_role_user ru on r.id =ru.sys_role_id where ru.sys_user_id = #{userId}")
    @Results({
            @Result(property = "permissions",column = "id",many = @Many(select = "com.basics.mapper.SysPermissionMapper.getAllByRoleId"))
    })
    List<SysRole> getAllByUserId(@Param("userId")Integer userId);

    /**
     * 根据角色id进行查询
     * @param id
     * @return
     */
    @Select("select * from sys_role where id =#{id}")
    @Results({
            @Result(property = "permissions",column = "id",many = @Many(select = "com.basics.mapper.SysPermissionMapper.getAllByRoleId"))
    })
    SysRole getSysRoleById(int id);

    /**
     * 根据角色名称进行查询
     * @param name
     * @return
     */
    @Select("select * from sys_role where name =#{name}")
    @Results({
            @Result(property = "permissions",column = "id",many = @Many(select = "com.basics.mapper.SysPermissionMapper.getAllByRoleId"))
    })
    SysRole getSysRoleByName(@Param("name") String name);

    /**
     * 添加角色
     * @param sysRole
     * @return
     */
    @Insert("insert into sys_role (name) values (#{name})")
    int addSysRole(SysRole sysRole);

    /**
     * 批量删除角色
     * @param list
     * @return
     */
    @Delete({"<script>delete from sys_role where id in " +
            "<foreach collection=\"list\" item=\"id\" open=\"(\" close=\")\" separator=\",\">#{id}</foreach>" +
            "</script>"})
    int deleteSysRoleByIds(List<Integer> list);


}
