package com.segama.ege.repository;

import com.segama.ege.entity.ShopAdminRoleMenuRelation;
import com.segama.ege.entity.ShopAdminRoleMenuRelationExample;
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

public interface ShopAdminRoleMenuRelationMapper {
    @SelectProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="countByExample")
    int countByExample(ShopAdminRoleMenuRelationExample example);

    @DeleteProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopAdminRoleMenuRelationExample example);

    @Delete({
        "delete from `shop_admin_role_menu_relation`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_admin_role_menu_relation` (`shop_id`, `menu_id`, ",
        "`role_id`, `menu_name`, ",
        "`role_name`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`, ",
        "`version`)",
        "values (#{shop_id,jdbcType=BIGINT}, #{menu_id,jdbcType=BIGINT}, ",
        "#{role_id,jdbcType=BIGINT}, #{menu_name,jdbcType=VARCHAR}, ",
        "#{role_name,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopAdminRoleMenuRelation record);

    @InsertProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopAdminRoleMenuRelation record);

    @SelectProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_id", property="menu_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="role_id", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_name", property="menu_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<ShopAdminRoleMenuRelation> selectByExample(ShopAdminRoleMenuRelationExample example);

    @Select({
        "select",
        "`id`, `shop_id`, `menu_id`, `role_id`, `menu_name`, `role_name`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, `modifier_account`, `description`, `version`",
        "from `shop_admin_role_menu_relation`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_id", property="menu_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="role_id", jdbcType=JdbcType.BIGINT),
        @Result(column="menu_name", property="menu_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    ShopAdminRoleMenuRelation selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopAdminRoleMenuRelation record, @Param("example") ShopAdminRoleMenuRelationExample example);

    @UpdateProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopAdminRoleMenuRelation record, @Param("example") ShopAdminRoleMenuRelationExample example);

    @UpdateProvider(type=ShopAdminRoleMenuRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopAdminRoleMenuRelation record);

    @Update({
        "update `shop_admin_role_menu_relation`",
        "set `shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`menu_id` = #{menu_id,jdbcType=BIGINT},",
          "`role_id` = #{role_id,jdbcType=BIGINT},",
          "`menu_name` = #{menu_name,jdbcType=VARCHAR},",
          "`role_name` = #{role_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopAdminRoleMenuRelation record);
}