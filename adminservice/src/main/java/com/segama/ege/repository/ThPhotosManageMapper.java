package com.segama.ege.repository;

import com.segama.ege.entity.ThPhotosManage;
import com.segama.ege.entity.ThPhotosManageExample;
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

public interface ThPhotosManageMapper {
    @SelectProvider(type=ThPhotosManageSqlProvider.class, method="countByExample")
    int countByExample(ThPhotosManageExample example);

    @DeleteProvider(type=ThPhotosManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThPhotosManageExample example);

    @Delete({
        "delete from `th_photos_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_photos_manage` (`photo_name`, `photo_code`, ",
        "`url`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`)",
        "values (#{photo_name,jdbcType=VARCHAR}, #{photo_code,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThPhotosManage record);

    @InsertProvider(type=ThPhotosManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThPhotosManage record);

    @SelectProvider(type=ThPhotosManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_name", property="photo_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo_code", property="photo_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<ThPhotosManage> selectByExample(ThPhotosManageExample example);

    @Select({
        "select",
        "`id`, `photo_name`, `photo_code`, `url`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`",
        "from `th_photos_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="photo_name", property="photo_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="photo_code", property="photo_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    ThPhotosManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThPhotosManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThPhotosManage record, @Param("example") ThPhotosManageExample example);

    @UpdateProvider(type=ThPhotosManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThPhotosManage record, @Param("example") ThPhotosManageExample example);

    @UpdateProvider(type=ThPhotosManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThPhotosManage record);

    @Update({
        "update `th_photos_manage`",
        "set `photo_name` = #{photo_name,jdbcType=VARCHAR},",
          "`photo_code` = #{photo_code,jdbcType=VARCHAR},",
          "`url` = #{url,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThPhotosManage record);
}