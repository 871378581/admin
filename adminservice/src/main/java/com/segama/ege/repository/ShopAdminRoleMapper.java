package com.segama.ege.repository;

import com.segama.ege.entity.ShopAdminRole;
import com.segama.ege.entity.ShopAdminRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ShopAdminRoleMapper {
    @SelectProvider(type=ShopAdminRoleSqlProvider.class, method="countByExample")
    int countByExample(ShopAdminRoleExample example);

    @DeleteProvider(type=ShopAdminRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopAdminRoleExample example);

    @Delete({
        "delete from `shop_admin_role`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_admin_role` (`shop_id`, `role_name`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`, `version`)",
        "values (#{shop_id,jdbcType=BIGINT}, #{role_name,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopAdminRole record);

    @InsertProvider(type=ShopAdminRoleSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopAdminRole record);

    @SelectProvider(type=ShopAdminRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<ShopAdminRole> selectByExample(ShopAdminRoleExample example);

    @Select({
        "select",
        "`id`, `shop_id`, `role_name`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`, `version`",
        "from `shop_admin_role`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    ShopAdminRole selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopAdminRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopAdminRole record, @Param("example") ShopAdminRoleExample example);

    @UpdateProvider(type=ShopAdminRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopAdminRole record, @Param("example") ShopAdminRoleExample example);

    @UpdateProvider(type=ShopAdminRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopAdminRole record);

    @Update({
        "update `shop_admin_role`",
        "set `shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`role_name` = #{role_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopAdminRole record);
}