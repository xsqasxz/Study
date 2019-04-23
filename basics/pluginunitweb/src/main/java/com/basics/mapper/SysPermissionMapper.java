package com.basics.mapper;

import com.basics.entity.SysPermission;
import com.basics.entity.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xueshiqi
 * @since 2019/4/3
 * 用户权限表
 */
@Mapper
public interface SysPermissionMapper {

    @Select("select * from sys_permission")
    @Results({
            @Result(property = "roles",column = "id",many = @Many(select = "com.basics.mapper.SysRoleMapper.getAllByUserId"))
    })
    List<SysUser> getAll();

    /**
     * 根据角色id查询用户权限
     * @param roleId
     * @return
     */
    @Select("select p.* from sys_permission p inner join sys_permission_role pr on p.id =pr.sys_permission_id where ru.sys_role_id = #{roleId}")
    List<SysPermission> getAllByRoleId(@Param("roleId")Integer roleId);

    /**
     * 根据权限id进行查询
     * @param id
     * @return
     */
    @Select("select * from sys_permission where id =#{id}")
    SysPermission getSysPermissionById(int id);

    /**
     * 根据权限名称进行查询
     * @param name
     * @return
     */
    @Select("select * from sys_permission where name =#{name}")
    SysPermission getSysPermissionByName(@Param("name") String name);

    /**
     * 添加权限
     * @param sysRole
     * @return
     */
    @Insert("insert into sys_permission (name,descritpion,url,pid) values (#{name},#{descritpion},#{url},#{pid})")
    int addSysPermission(SysPermission sysRole);

    /**
     * 批量删除权限
     * @param list
     * @return
     */
    @Delete({"<script>delete from sys_permission where id in " +
            "<foreach collection=\"list\" item=\"id\" open=\"(\" close=\")\" separator=\",\">#{id}</foreach>" +
            "</script>"})
    int deleteSysPermissionByIds(List<Integer> list);

}
