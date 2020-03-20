package com.segama.ege.repository;

import com.segama.ege.entity.MembershipCard;
import com.segama.ege.entity.MembershipCardExample;
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

public interface MembershipCardMapper {
    @SelectProvider(type=MembershipCardSqlProvider.class, method="countByExample")
    int countByExample(MembershipCardExample example);

    @DeleteProvider(type=MembershipCardSqlProvider.class, method="deleteByExample")
    int deleteByExample(MembershipCardExample example);

    @Delete({
        "delete from `membership_card`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `membership_card` (`card_id`, `password`, ",
        "`batch_num`, `status`, ",
        "`effective_days`, `effective_date`, ",
        "`expire_date`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `take_effect_type`, ",
        "`card_level`)",
        "values (#{card_id,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{batch_num,jdbcType=VARCHAR}, #{status,jdbcType=VARCHAR}, ",
        "#{effective_days,jdbcType=INTEGER}, #{effective_date,jdbcType=TIMESTAMP}, ",
        "#{expire_date,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{take_effect_type,jdbcType=VARCHAR}, ",
        "#{card_level,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(MembershipCard record);

    @InsertProvider(type=MembershipCardSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(MembershipCard record);

    @SelectProvider(type=MembershipCardSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="card_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="batch_num", property="batch_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_days", property="effective_days", jdbcType=JdbcType.INTEGER),
        @Result(column="effective_date", property="effective_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expire_date", property="expire_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="take_effect_type", property="take_effect_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR)
    })
    List<MembershipCard> selectByExample(MembershipCardExample example);

    @Select({
        "select",
        "`id`, `card_id`, `password`, `batch_num`, `status`, `effective_days`, `effective_date`, ",
        "`expire_date`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`take_effect_type`, `card_level`",
        "from `membership_card`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_id", property="card_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="batch_num", property="batch_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="effective_days", property="effective_days", jdbcType=JdbcType.INTEGER),
        @Result(column="effective_date", property="effective_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="expire_date", property="expire_date", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="take_effect_type", property="take_effect_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.VARCHAR)
    })
    MembershipCard selectByPrimaryKey(Long id);

    @UpdateProvider(type=MembershipCardSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") MembershipCard record, @Param("example") MembershipCardExample example);

    @UpdateProvider(type=MembershipCardSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") MembershipCard record, @Param("example") MembershipCardExample example);

    @UpdateProvider(type=MembershipCardSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MembershipCard record);

    @Update({
        "update `membership_card`",
        "set `card_id` = #{card_id,jdbcType=VARCHAR},",
          "`password` = #{password,jdbcType=VARCHAR},",
          "`batch_num` = #{batch_num,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=VARCHAR},",
          "`effective_days` = #{effective_days,jdbcType=INTEGER},",
          "`effective_date` = #{effective_date,jdbcType=TIMESTAMP},",
          "`expire_date` = #{expire_date,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`take_effect_type` = #{take_effect_type,jdbcType=VARCHAR},",
          "`card_level` = #{card_level,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(MembershipCard record);
}