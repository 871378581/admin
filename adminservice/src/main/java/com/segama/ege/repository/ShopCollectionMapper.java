package com.segama.ege.repository;

import com.segama.ege.entity.ShopCollection;
import com.segama.ege.entity.ShopCollectionExample;
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

public interface ShopCollectionMapper {
    @SelectProvider(type=ShopCollectionSqlProvider.class, method="countByExample")
    int countByExample(ShopCollectionExample example);

    @DeleteProvider(type=ShopCollectionSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopCollectionExample example);

    @Delete({
        "delete from `shop_collection`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_collection` (`user_id`, `shop_id`, ",
        "`gmt_collect`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `version`, ",
        "`status`)",
        "values (#{user_id,jdbcType=VARCHAR}, #{shop_id,jdbcType=BIGINT}, ",
        "#{gmt_collect,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{status,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopCollection record);

    @InsertProvider(type=ShopCollectionSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopCollection record);

    @SelectProvider(type=ShopCollectionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_collect", property="gmt_collect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<ShopCollection> selectByExample(ShopCollectionExample example);

    @Select({
        "select",
        "`id`, `user_id`, `shop_id`, `gmt_collect`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `version`, `status`",
        "from `shop_collection`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_collect", property="gmt_collect", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    ShopCollection selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopCollectionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopCollection record, @Param("example") ShopCollectionExample example);

    @UpdateProvider(type=ShopCollectionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopCollection record, @Param("example") ShopCollectionExample example);

    @UpdateProvider(type=ShopCollectionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopCollection record);

    @Update({
        "update `shop_collection`",
        "set `user_id` = #{user_id,jdbcType=VARCHAR},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`gmt_collect` = #{gmt_collect,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`status` = #{status,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopCollection record);
}