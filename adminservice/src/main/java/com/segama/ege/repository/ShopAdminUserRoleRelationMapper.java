package com.segama.ege.repository;

import com.segama.ege.entity.ShopAdminUserRoleRelation;
import com.segama.ege.entity.ShopAdminUserRoleRelationExample;
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

public interface ShopAdminUserRoleRelationMapper {
    @SelectProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="countByExample")
    int countByExample(ShopAdminUserRoleRelationExample example);

    @DeleteProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopAdminUserRoleRelationExample example);

    @Delete({
        "delete from `shop_admin_user_role_relation`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_admin_user_role_relation` (`shop_id`, `user_id`, ",
        "`role_id`, `account`, ",
        "`role_name`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`, ",
        "`version`)",
        "values (#{shop_id,jdbcType=BIGINT}, #{user_id,jdbcType=BIGINT}, ",
        "#{role_id,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{role_name,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopAdminUserRoleRelation record);

    @InsertProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopAdminUserRoleRelation record);

    @SelectProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="role_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<ShopAdminUserRoleRelation> selectByExample(ShopAdminUserRoleRelationExample example);

    @Select({
        "select",
        "`id`, `shop_id`, `user_id`, `role_id`, `account`, `role_name`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, `modifier_account`, `description`, `version`",
        "from `shop_admin_user_role_relation`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.BIGINT),
        @Result(column="role_id", property="role_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="role_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    ShopAdminUserRoleRelation selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopAdminUserRoleRelation record, @Param("example") ShopAdminUserRoleRelationExample example);

    @UpdateProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopAdminUserRoleRelation record, @Param("example") ShopAdminUserRoleRelationExample example);

    @UpdateProvider(type=ShopAdminUserRoleRelationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopAdminUserRoleRelation record);

    @Update({
        "update `shop_admin_user_role_relation`",
        "set `shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`user_id` = #{user_id,jdbcType=BIGINT},",
          "`role_id` = #{role_id,jdbcType=BIGINT},",
          "`account` = #{account,jdbcType=VARCHAR},",
          "`role_name` = #{role_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopAdminUserRoleRelation record);
}