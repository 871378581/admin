package com.segama.ege.repository;

import com.segama.ege.entity.ShopPhotoResource;
import com.segama.ege.entity.ShopPhotoResourceExample;
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

public interface ShopPhotoResourceMapper {
    @SelectProvider(type=ShopPhotoResourceSqlProvider.class, method="countByExample")
    int countByExample(ShopPhotoResourceExample example);

    @DeleteProvider(type=ShopPhotoResourceSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopPhotoResourceExample example);

    @Delete({
        "delete from `shop_photo_resource`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_photo_resource` (`photo_url`, `shop_id`, ",
        "`order_id`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `version`, ",
        "`verify_status`)",
        "values (#{photo_url,jdbcType=VARCHAR}, #{shop_id,jdbcType=BIGINT}, ",
        "#{order_id,jdbcType=INTEGER}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{version,jdbcType=INTEGER}, ",
        "#{verify_status,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopPhotoResource record);

    @InsertProvider(type=ShopPhotoResourceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopPhotoResource record);

    @SelectProvider(type=ShopPhotoResourceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_status", property="verify_status", jdbcType=JdbcType.BIT)
    })
    List<ShopPhotoResource> selectByExample(ShopPhotoResourceExample example);

    @Select({
        "select",
        "`id`, `photo_url`, `shop_id`, `order_id`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `version`, `verify_status`",
        "from `shop_photo_resource`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.INTEGER),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER),
        @Result(column="verify_status", property="verify_status", jdbcType=JdbcType.BIT)
    })
    ShopPhotoResource selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopPhotoResourceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopPhotoResource record, @Param("example") ShopPhotoResourceExample example);

    @UpdateProvider(type=ShopPhotoResourceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopPhotoResource record, @Param("example") ShopPhotoResourceExample example);

    @UpdateProvider(type=ShopPhotoResourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopPhotoResource record);

    @Update({
        "update `shop_photo_resource`",
        "set `photo_url` = #{photo_url,jdbcType=VARCHAR},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`order_id` = #{order_id,jdbcType=INTEGER},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER},",
          "`verify_status` = #{verify_status,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopPhotoResource record);
}