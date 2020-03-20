package com.segama.ege.repository;

import com.segama.ege.entity.CapitalAccount;
import com.segama.ege.entity.CapitalAccountExample;
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

public interface CapitalAccountMapper {
    @SelectProvider(type=CapitalAccountSqlProvider.class, method="countByExample")
    int countByExample(CapitalAccountExample example);

    @DeleteProvider(type=CapitalAccountSqlProvider.class, method="deleteByExample")
    int deleteByExample(CapitalAccountExample example);

    @Delete({
        "delete from `capital_account`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `capital_account` (`account_no`, `account_type`, ",
        "`total_amount`, `freezing_amount`, ",
        "`available_amount`, `mac`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`opening_bank`, `bank_card_num`, ",
        "`payee`)",
        "values (#{account_no,jdbcType=VARCHAR}, #{account_type,jdbcType=VARCHAR}, ",
        "#{total_amount,jdbcType=VARCHAR}, #{freezing_amount,jdbcType=VARCHAR}, ",
        "#{available_amount,jdbcType=VARCHAR}, #{mac,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{opening_bank,jdbcType=VARCHAR}, #{bank_card_num,jdbcType=VARCHAR}, ",
        "#{payee,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(CapitalAccount record);

    @InsertProvider(type=CapitalAccountSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(CapitalAccount record);

    @SelectProvider(type=CapitalAccountSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_no", property="account_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_type", property="account_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="total_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="freezing_amount", property="freezing_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="available_amount", property="available_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="mac", property="mac", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="opening_bank", property="opening_bank", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card_num", property="bank_card_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="payee", property="payee", jdbcType=JdbcType.VARCHAR)
    })
    List<CapitalAccount> selectByExample(CapitalAccountExample example);

    @Select({
        "select",
        "`id`, `account_no`, `account_type`, `total_amount`, `freezing_amount`, `available_amount`, ",
        "`mac`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `opening_bank`, ",
        "`bank_card_num`, `payee`",
        "from `capital_account`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="account_no", property="account_no", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_type", property="account_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="total_amount", property="total_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="freezing_amount", property="freezing_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="available_amount", property="available_amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="mac", property="mac", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="opening_bank", property="opening_bank", jdbcType=JdbcType.VARCHAR),
        @Result(column="bank_card_num", property="bank_card_num", jdbcType=JdbcType.VARCHAR),
        @Result(column="payee", property="payee", jdbcType=JdbcType.VARCHAR)
    })
    CapitalAccount selectByPrimaryKey(Long id);

    @UpdateProvider(type=CapitalAccountSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") CapitalAccount record, @Param("example") CapitalAccountExample example);

    @UpdateProvider(type=CapitalAccountSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") CapitalAccount record, @Param("example") CapitalAccountExample example);

    @UpdateProvider(type=CapitalAccountSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(CapitalAccount record);

    @Update({
        "update `capital_account`",
        "set `account_no` = #{account_no,jdbcType=VARCHAR},",
          "`account_type` = #{account_type,jdbcType=VARCHAR},",
          "`total_amount` = #{total_amount,jdbcType=VARCHAR},",
          "`freezing_amount` = #{freezing_amount,jdbcType=VARCHAR},",
          "`available_amount` = #{available_amount,jdbcType=VARCHAR},",
          "`mac` = #{mac,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`opening_bank` = #{opening_bank,jdbcType=VARCHAR},",
          "`bank_card_num` = #{bank_card_num,jdbcType=VARCHAR},",
          "`payee` = #{payee,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(CapitalAccount record);
}