package com.segama.ege.repository;

import com.segama.ege.entity.ShopAdminUserDetailInfo;
import com.segama.ege.entity.ShopAdminUserDetailInfoExample;
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

public interface ShopAdminUserDetailInfoMapper {
    @SelectProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="countByExample")
    int countByExample(ShopAdminUserDetailInfoExample example);

    @DeleteProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopAdminUserDetailInfoExample example);

    @Delete({
        "delete from `shop_admin_user_detail_info`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_admin_user_detail_info` (`account`, `age`, ",
        "`shop_id`, `phone`, `address`, ",
        "`gender`, `real_name`, ",
        "`birthday`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`, ",
        "`birth`, `job`, `city`, ",
        "`user_head`)",
        "values (#{account,jdbcType=VARCHAR}, #{age,jdbcType=BIGINT}, ",
        "#{shop_id,jdbcType=BIGINT}, #{phone,jdbcType=VARCHAR}, #{address,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=VARCHAR}, #{real_name,jdbcType=VARCHAR}, ",
        "#{birthday,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{birth,jdbcType=VARCHAR}, #{job,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR}, ",
        "#{user_head,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopAdminUserDetailInfo record);

    @InsertProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopAdminUserDetailInfo record);

    @SelectProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head", property="user_head", jdbcType=JdbcType.VARCHAR)
    })
    List<ShopAdminUserDetailInfo> selectByExample(ShopAdminUserDetailInfoExample example);

    @Select({
        "select",
        "`id`, `account`, `age`, `shop_id`, `phone`, `address`, `gender`, `real_name`, ",
        "`birthday`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`description`, `birth`, `job`, `city`, `user_head`",
        "from `shop_admin_user_detail_info`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="age", property="age", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="birth", property="birth", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_head", property="user_head", jdbcType=JdbcType.VARCHAR)
    })
    ShopAdminUserDetailInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopAdminUserDetailInfo record, @Param("example") ShopAdminUserDetailInfoExample example);

    @UpdateProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopAdminUserDetailInfo record, @Param("example") ShopAdminUserDetailInfoExample example);

    @UpdateProvider(type=ShopAdminUserDetailInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopAdminUserDetailInfo record);

    @Update({
        "update `shop_admin_user_detail_info`",
        "set `account` = #{account,jdbcType=VARCHAR},",
          "`age` = #{age,jdbcType=BIGINT},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`phone` = #{phone,jdbcType=VARCHAR},",
          "`address` = #{address,jdbcType=VARCHAR},",
          "`gender` = #{gender,jdbcType=VARCHAR},",
          "`real_name` = #{real_name,jdbcType=VARCHAR},",
          "`birthday` = #{birthday,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR},",
          "`birth` = #{birth,jdbcType=VARCHAR},",
          "`job` = #{job,jdbcType=VARCHAR},",
          "`city` = #{city,jdbcType=VARCHAR},",
          "`user_head` = #{user_head,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopAdminUserDetailInfo record);
}