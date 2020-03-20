package com.segama.ege.repository;

import com.segama.ege.entity.HotRecommend;
import com.segama.ege.entity.HotRecommendExample;
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

public interface HotRecommendMapper {
    @SelectProvider(type=HotRecommendSqlProvider.class, method="countByExample")
    int countByExample(HotRecommendExample example);

    @DeleteProvider(type=HotRecommendSqlProvider.class, method="deleteByExample")
    int deleteByExample(HotRecommendExample example);

    @Delete({
        "delete from `hot_recommend`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `hot_recommend` (`photo_url`, `url`, ",
        "`sort`, `is_disable`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`)",
        "values (#{photo_url,jdbcType=VARCHAR}, #{url,jdbcType=VARCHAR}, ",
        "#{sort,jdbcType=BIGINT}, #{is_disable,jdbcType=BIT}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(HotRecommend record);

    @InsertProvider(type=HotRecommendSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(HotRecommend record);

    @SelectProvider(type=HotRecommendSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.BIGINT),
        @Result(column="is_disable", property="is_disable", jdbcType=JdbcType.BIT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<HotRecommend> selectByExample(HotRecommendExample example);

    @Select({
        "select",
        "`id`, `photo_url`, `url`, `sort`, `is_disable`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, `description`",
        "from `hot_recommend`",
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
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    HotRecommend selectByPrimaryKey(Long id);

    @UpdateProvider(type=HotRecommendSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HotRecommend record, @Param("example") HotRecommendExample example);

    @UpdateProvider(type=HotRecommendSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HotRecommend record, @Param("example") HotRecommendExample example);

    @UpdateProvider(type=HotRecommendSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HotRecommend record);

    @Update({
        "update `hot_recommend`",
        "set `photo_url` = #{photo_url,jdbcType=VARCHAR},",
          "`url` = #{url,jdbcType=VARCHAR},",
          "`sort` = #{sort,jdbcType=BIGINT},",
          "`is_disable` = #{is_disable,jdbcType=BIT},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(HotRecommend record);
}