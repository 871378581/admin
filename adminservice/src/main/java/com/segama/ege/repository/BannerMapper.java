package com.segama.ege.repository;

import com.segama.ege.entity.Banner;
import com.segama.ege.entity.BannerExample;
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

public interface BannerMapper {
    @SelectProvider(type=BannerSqlProvider.class, method="countByExample")
    int countByExample(BannerExample example);

    @DeleteProvider(type=BannerSqlProvider.class, method="deleteByExample")
    int deleteByExample(BannerExample example);

    @Delete({
        "delete from `banner`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `banner` (`photo_url`, `url`, ",
        "`sort`, `is_disable`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`)",
        "values (#{photo_url,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=BIGINT}, #{is_disable,jdbcType=BIT}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Banner record);

    @InsertProvider(type=BannerSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Banner record);

    @SelectProvider(type=BannerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<Banner> selectByExample(BannerExample example);

    @Select({
        "select",
        "`id`, `photo_url`, `url`, `sort`, `is_disable`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`",
        "from `banner`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    Banner selectByPrimaryKey(Long id);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Banner record, @Param("example") BannerExample example);

    @UpdateProvider(type=BannerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Banner record);

    @Update({
        "update `banner`",
        "set `photo_url` = #{photo_url,jdbcType=VARCHAR},",
          "`url` = #{url,jdbcType=VARCHAR},",
          "`sort` = #{sort,jdbcType=BIGINT},",
          "`is_disable` = #{is_disable,jdbcType=BIT},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Banner record);
}