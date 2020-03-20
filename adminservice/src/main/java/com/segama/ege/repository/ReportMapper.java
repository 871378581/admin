package com.segama.ege.repository;

import com.segama.ege.entity.Report;
import com.segama.ege.entity.ReportExample;
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

public interface ReportMapper {
    @SelectProvider(type=ReportSqlProvider.class, method="countByExample")
    int countByExample(ReportExample example);

    @DeleteProvider(type=ReportSqlProvider.class, method="deleteByExample")
    int deleteByExample(ReportExample example);

    @Delete({
        "delete from `report`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `report` (`order_id`, `order_string_id`, ",
        "`gmt_report_date`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `report_have_exception`, ",
        "`report_items`)",
        "values (#{order_id,jdbcType=BIGINT}, #{order_string_id,jdbcType=VARCHAR}, ",
        "#{gmt_report_date,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{report_have_exception,jdbcType=BIT}, ",
        "#{report_items,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(Report record);

    @InsertProvider(type=ReportSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(Report record);

    @SelectProvider(type=ReportSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_report_date", property="gmt_report_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="report_have_exception", property="report_have_exception", jdbcType=JdbcType.BIT),
        @Result(column="report_items", property="report_items", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Report> selectByExampleWithBLOBs(ReportExample example);

    @SelectProvider(type=ReportSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_report_date", property="gmt_report_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="report_have_exception", property="report_have_exception", jdbcType=JdbcType.BIT)
    })
    List<Report> selectByExample(ReportExample example);

    @Select({
        "select",
        "`id`, `order_id`, `order_string_id`, `gmt_report_date`, `gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, `report_have_exception`, `report_items`",
        "from `report`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_report_date", property="gmt_report_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="report_have_exception", property="report_have_exception", jdbcType=JdbcType.BIT),
        @Result(column="report_items", property="report_items", jdbcType=JdbcType.LONGVARCHAR)
    })
    Report selectByPrimaryKey(Long id);

    @UpdateProvider(type=ReportSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Report record, @Param("example") ReportExample example);

    @UpdateProvider(type=ReportSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") Report record, @Param("example") ReportExample example);

    @UpdateProvider(type=ReportSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    @UpdateProvider(type=ReportSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Report record);

    @Update({
        "update `report`",
        "set `order_id` = #{order_id,jdbcType=BIGINT},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`gmt_report_date` = #{gmt_report_date,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`report_have_exception` = #{report_have_exception,jdbcType=BIT},",
          "`report_items` = #{report_items,jdbcType=LONGVARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(Report record);

    @Update({
        "update `report`",
        "set `order_id` = #{order_id,jdbcType=BIGINT},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`gmt_report_date` = #{gmt_report_date,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`report_have_exception` = #{report_have_exception,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Report record);
}