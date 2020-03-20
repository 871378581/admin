package com.segama.ege.repository;

import com.segama.ege.entity.ShopAdminUser;
import com.segama.ege.entity.ShopAdminUserExample;
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

public interface ShopAdminUserMapper {
    @SelectProvider(type=ShopAdminUserSqlProvider.class, method="countByExample")
    int countByExample(ShopAdminUserExample example);

    @DeleteProvider(type=ShopAdminUserSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopAdminUserExample example);

    @Delete({
        "delete from `shop_admin_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_admin_user` (`shop_id`, `account`, ",
        "`password`, `role_type`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`version`, `token`, ",
        "`expire_time`, `shop_name`)",
        "values (#{shop_id,jdbcType=BIGINT}, #{account,jdbcType=VARCHAR}, ",
        "#{password,jdbcType=VARCHAR}, #{role_type,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER}, #{token,jdbcType=VARCHAR}, ",
        "#{expire_time,jdbcType=TIMESTAMP}, #{shop_name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopAdminUser record);

    @InsertProvider(type=ShopAdminUserSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopAdminUser record);

    @SelectProvider(type=ShopAdminUserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_type", property="role_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR)
    })
    List<ShopAdminUser> selectByExample(ShopAdminUserExample example);

    @Select({
        "select",
        "`id`, `shop_id`, `account`, `password`, `role_type`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, `version`, `token`, `expire_time`, `shop_name`",
        "from `shop_admin_user`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_type", property="role_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="token", property="token", jdbcType=JdbcType.VARCHAR),
        @Result(column="expire_time", property="expire_time", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR)
    })
    ShopAdminUser selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopAdminUserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopAdminUser record, @Param("example") ShopAdminUserExample example);

    @UpdateProvider(type=ShopAdminUserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopAdminUser record, @Param("example") ShopAdminUserExample example);

    @UpdateProvider(type=ShopAdminUserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopAdminUser record);

    @Update({
        "update `shop_admin_user`",
        "set `shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`account` = #{account,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "`role_type` = #{role_type,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`token` = #{token,jdbcType=VARCHAR},",
          "`expire_time` = #{expire_time,jdbcType=TIMESTAMP},",
          "`shop_name` = #{shop_name,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopAdminUser record);
}