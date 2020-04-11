package com.segama.ege.repository;

import com.segama.ege.entity.ThTemplateManage;
import com.segama.ege.entity.ThTemplateManageExample;
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

public interface ThTemplateManageMapper {
    @SelectProvider(type=ThTemplateManageSqlProvider.class, method="countByExample")
    int countByExample(ThTemplateManageExample example);

    @DeleteProvider(type=ThTemplateManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThTemplateManageExample example);

    @Delete({
        "delete from `th_template_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_template_manage` (`template_name`, `template_code`, ",
        "`banner1`, `banner2`, ",
        "`sub_product`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`)",
        "values (#{template_name,jdbcType=VARCHAR}, #{template_code,jdbcType=VARCHAR}, ",
        "#{banner1,jdbcType=VARCHAR}, #{banner2,jdbcType=VARCHAR}, ",
        "#{sub_product,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThTemplateManage record);

    @InsertProvider(type=ThTemplateManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThTemplateManage record);

    @SelectProvider(type=ThTemplateManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="template_name", property="template_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="template_code", property="template_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner1", property="banner1", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner2", property="banner2", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_product", property="sub_product", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<ThTemplateManage> selectByExample(ThTemplateManageExample example);

    @Select({
        "select",
        "`id`, `template_name`, `template_code`, `banner1`, `banner2`, `sub_product`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `description`",
        "from `th_template_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="template_name", property="template_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="template_code", property="template_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner1", property="banner1", jdbcType=JdbcType.VARCHAR),
        @Result(column="banner2", property="banner2", jdbcType=JdbcType.VARCHAR),
        @Result(column="sub_product", property="sub_product", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ThTemplateManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThTemplateManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThTemplateManage record, @Param("example") ThTemplateManageExample example);

    @UpdateProvider(type=ThTemplateManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThTemplateManage record, @Param("example") ThTemplateManageExample example);

    @UpdateProvider(type=ThTemplateManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThTemplateManage record);

    @Update({
        "update `th_template_manage`",
        "set `template_name` = #{template_name,jdbcType=VARCHAR},",
          "`template_code` = #{template_code,jdbcType=VARCHAR},",
          "`banner1` = #{banner1,jdbcType=VARCHAR},",
          "`banner2` = #{banner2,jdbcType=VARCHAR},",
          "`sub_product` = #{sub_product,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThTemplateManage record);
}