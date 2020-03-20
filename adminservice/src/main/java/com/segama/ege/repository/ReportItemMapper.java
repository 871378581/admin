package com.segama.ege.repository;

import com.segama.ege.entity.ReportItem;
import com.segama.ege.entity.ReportItemExample;
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

public interface ReportItemMapper {
    @SelectProvider(type=ReportItemSqlProvider.class, method="countByExample")
    int countByExample(ReportItemExample example);

    @DeleteProvider(type=ReportItemSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReportItemExample example);

    @Delete({
        "delete from `report_item`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `report_item` (`each_item`, `each_value`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`father_item_id`)",
        "values (#{each_item,jdbcType=VARCHAR}, #{each_value,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{father_item_id,jdbcType=BIGINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ReportItem record);

    @InsertProvider(type=ReportItemSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ReportItem record);

    @SelectProvider(type=ReportItemSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="each_item", property="each_item", jdbcType=JdbcType.VARCHAR),
        @Result(column="each_value", property="each_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="father_item_id", property="father_item_id", jdbcType=JdbcType.BIGINT)
    })
    List<ReportItem> selectByExample(ReportItemExample example);

    @Select({
        "select",
        "`id`, `each_item`, `each_value`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `father_item_id`",
        "from `report_item`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="each_item", property="each_item", jdbcType=JdbcType.VARCHAR),
        @Result(column="each_value", property="each_value", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="father_item_id", property="father_item_id", jdbcType=JdbcType.BIGINT)
    })
    ReportItem selectByPrimaryKey(Long id);

    @UpdateProvider(type=ReportItemSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ReportItem record, @Param("example") ReportItemExample example);

    @UpdateProvider(type=ReportItemSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ReportItem record, @Param("example") ReportItemExample example);

    @UpdateProvider(type=ReportItemSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ReportItem record);

    @Update({
        "update `report_item`",
        "set `each_item` = #{each_item,jdbcType=VARCHAR},",
          "`each_value` = #{each_value,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`father_item_id` = #{father_item_id,jdbcType=BIGINT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ReportItem record);
}