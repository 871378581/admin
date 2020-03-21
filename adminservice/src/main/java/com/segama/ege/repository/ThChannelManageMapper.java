package com.segama.ege.repository;

import com.segama.ege.entity.ThChannelManage;
import com.segama.ege.entity.ThChannelManageExample;
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

public interface ThChannelManageMapper {
    @SelectProvider(type=ThChannelManageSqlProvider.class, method="countByExample")
    int countByExample(ThChannelManageExample example);

    @DeleteProvider(type=ThChannelManageSqlProvider.class, method="deleteByExample")
    int deleteByExample(ThChannelManageExample example);

    @Delete({
        "delete from `th_channel_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `th_channel_manage` (`channel_code`, `channel_name`, ",
        "`main_body`, `contacter`, ",
        "`contacter_phone`, `status`, ",
        "`jieru_way`, `meiti_type`, ",
        "`meiti_pwd`, `meiti_account`, ",
        "`account_id`, `bank_card`, ",
        "`open_bank_area`, `real_name`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`description`)",
        "values (#{channel_code,jdbcType=VARCHAR}, #{channel_name,jdbcType=VARCHAR}, ",
        "#{main_body,jdbcType=VARCHAR}, #{contacter,jdbcType=VARCHAR}, ",
        "#{contacter_phone,jdbcType=VARCHAR}, #{status,jdbcType=INTEGER}, ",
        "#{jieru_way,jdbcType=VARCHAR}, #{meiti_type,jdbcType=VARCHAR}, ",
        "#{meiti_pwd,jdbcType=VARCHAR}, #{meiti_account,jdbcType=VARCHAR}, ",
        "#{account_id,jdbcType=VARCHAR}, #{bank_card,jdbcType=VARCHAR}, ",
        "#{open_bank_area,jdbcType=VARCHAR}, #{real_name,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ThChannelManage record);

    @InsertProvider(type=ThChannelManageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ThChannelManage record);

    @SelectProvider(type=ThChannelManageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_name", property="channel_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_body", property="main_body", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter", property="contacter", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter_phone", property="contacter_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="jieru_way", property="jieru_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_type", property="meiti_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_pwd", property="meiti_pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_account", property="meiti_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="account_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card", property="bank_card", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_bank_area", property="open_bank_area", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    List<ThChannelManage> selectByExample(ThChannelManageExample example);

    @Select({
        "select",
        "`id`, `channel_code`, `channel_name`, `main_body`, `contacter`, `contacter_phone`, ",
        "`status`, `jieru_way`, `meiti_type`, `meiti_pwd`, `meiti_account`, `account_id`, ",
        "`bank_card`, `open_bank_area`, `real_name`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `description`",
        "from `th_channel_manage`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="channel_code", property="channel_code", jdbcType=JdbcType.VARCHAR),
        @Result(column="channel_name", property="channel_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="main_body", property="main_body", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter", property="contacter", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter_phone", property="contacter_phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="jieru_way", property="jieru_way", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_type", property="meiti_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_pwd", property="meiti_pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="meiti_account", property="meiti_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="account_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card", property="bank_card", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_bank_area", property="open_bank_area", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="real_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    ThChannelManage selectByPrimaryKey(Long id);

    @UpdateProvider(type=ThChannelManageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ThChannelManage record, @Param("example") ThChannelManageExample example);

    @UpdateProvider(type=ThChannelManageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ThChannelManage record, @Param("example") ThChannelManageExample example);

    @UpdateProvider(type=ThChannelManageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ThChannelManage record);

    @Update({
        "update `th_channel_manage`",
        "set `channel_code` = #{channel_code,jdbcType=VARCHAR},",
          "`channel_name` = #{channel_name,jdbcType=VARCHAR},",
          "`main_body` = #{main_body,jdbcType=VARCHAR},",
          "`contacter` = #{contacter,jdbcType=VARCHAR},",
          "`contacter_phone` = #{contacter_phone,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=INTEGER},",
          "`jieru_way` = #{jieru_way,jdbcType=VARCHAR},",
          "`meiti_type` = #{meiti_type,jdbcType=VARCHAR},",
          "`meiti_pwd` = #{meiti_pwd,jdbcType=VARCHAR},",
          "`meiti_account` = #{meiti_account,jdbcType=VARCHAR},",
          "`account_id` = #{account_id,jdbcType=VARCHAR},",
          "`bank_card` = #{bank_card,jdbcType=VARCHAR},",
          "`open_bank_area` = #{open_bank_area,jdbcType=VARCHAR},",
          "`real_name` = #{real_name,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`description` = #{description,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ThChannelManage record);
}