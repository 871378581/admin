package com.segama.ege.repository;

import com.segama.ege.entity.BusinessCooperateApply;
import com.segama.ege.entity.BusinessCooperateApplyExample;
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

public interface BusinessCooperateApplyMapper {
    @SelectProvider(type=BusinessCooperateApplySqlProvider.class, method="countByExample")
    int countByExample(BusinessCooperateApplyExample example);

    @DeleteProvider(type=BusinessCooperateApplySqlProvider.class, method="deleteByExample")
    int deleteByExample(BusinessCooperateApplyExample example);

    @Delete({
        "delete from `business_cooperate_apply`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `business_cooperate_apply` (`user_name`, `phone_num`, ",
        "`expect_contact_time`, `project_description`, ",
        "`contacter_status`, `remark`, ",
        "`operator`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `user_id`, ",
        "`shop_name`, `shop_area_size`, ",
        "`shop_address`, `merchant_type`)",
        "values (#{user_name,jdbcType=VARCHAR}, #{phone_num,jdbcType=VARCHAR}, ",
        "#{expect_contact_time,jdbcType=VARCHAR}, #{project_description,jdbcType=VARCHAR}, ",
        "#{contacter_status,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{operator,jdbcType=VARCHAR}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{user_id,jdbcType=VARCHAR}, ",
        "#{shop_name,jdbcType=VARCHAR}, #{shop_area_size,jdbcType=VARCHAR}, ",
        "#{shop_address,jdbcType=VARCHAR}, #{merchant_type,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(BusinessCooperateApply record);

    @InsertProvider(type=BusinessCooperateApplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(BusinessCooperateApply record);

    @SelectProvider(type=BusinessCooperateApplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_num", property="phone_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="expect_contact_time", property="expect_contact_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_description", property="project_description", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter_status", property="contacter_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_area_size", property="shop_area_size", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_address", property="shop_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_type", property="merchant_type", jdbcType=JdbcType.VARCHAR)
    })
    List<BusinessCooperateApply> selectByExample(BusinessCooperateApplyExample example);

    @Select({
        "select",
        "`id`, `user_name`, `phone_num`, `expect_contact_time`, `project_description`, ",
        "`contacter_status`, `remark`, `operator`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`, `user_id`, `shop_name`, `shop_area_size`, `shop_address`, ",
        "`merchant_type`",
        "from `business_cooperate_apply`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone_num", property="phone_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="expect_contact_time", property="expect_contact_time", jdbcType=JdbcType.VARCHAR),
        @Result(column="project_description", property="project_description", jdbcType=JdbcType.VARCHAR),
        @Result(column="contacter_status", property="contacter_status", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="operator", property="operator", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_area_size", property="shop_area_size", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_address", property="shop_address", jdbcType=JdbcType.VARCHAR),
        @Result(column="merchant_type", property="merchant_type", jdbcType=JdbcType.VARCHAR)
    })
    BusinessCooperateApply selectByPrimaryKey(Long id);

    @UpdateProvider(type=BusinessCooperateApplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") BusinessCooperateApply record, @Param("example") BusinessCooperateApplyExample example);

    @UpdateProvider(type=BusinessCooperateApplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") BusinessCooperateApply record, @Param("example") BusinessCooperateApplyExample example);

    @UpdateProvider(type=BusinessCooperateApplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(BusinessCooperateApply record);

    @Update({
        "update `business_cooperate_apply`",
        "set `user_name` = #{user_name,jdbcType=VARCHAR},",
          "`phone_num` = #{phone_num,jdbcType=VARCHAR},",
          "`expect_contact_time` = #{expect_contact_time,jdbcType=VARCHAR},",
          "`project_description` = #{project_description,jdbcType=VARCHAR},",
          "`contacter_status` = #{contacter_status,jdbcType=VARCHAR},",
          "`remark` = #{remark,jdbcType=VARCHAR},",
          "`operator` = #{operator,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=VARCHAR},",
          "`shop_name` = #{shop_name,jdbcType=VARCHAR},",
          "`shop_area_size` = #{shop_area_size,jdbcType=VARCHAR},",
          "`shop_address` = #{shop_address,jdbcType=VARCHAR},",
          "`merchant_type` = #{merchant_type,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(BusinessCooperateApply record);
}