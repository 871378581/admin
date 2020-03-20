package com.segama.ege.repository;

import com.segama.ege.entity.VerifyCommitRecord;
import com.segama.ege.entity.VerifyCommitRecordExample;
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

public interface VerifyCommitRecordMapper {
    @SelectProvider(type=VerifyCommitRecordSqlProvider.class, method="countByExample")
    int countByExample(VerifyCommitRecordExample example);

    @DeleteProvider(type=VerifyCommitRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(VerifyCommitRecordExample example);

    @Delete({
        "delete from `verify_commit_record`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `verify_commit_record` (`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`verify_account`, `shop_id`, ",
        "`shop_name`, `operate_type`, ",
        "`status`, `remark`, ",
        "`payment_voucher`, `amount`, ",
        "`target_json`, `change_json`)",
        "values (#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{verify_account,jdbcType=VARCHAR}, #{shop_id,jdbcType=BIGINT}, ",
        "#{shop_name,jdbcType=VARCHAR}, #{operate_type,jdbcType=INTEGER}, ",
        "#{status,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{payment_voucher,jdbcType=VARCHAR}, #{amount,jdbcType=VARCHAR}, ",
        "#{target_json,jdbcType=LONGVARCHAR}, #{change_json,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(VerifyCommitRecord record);

    @InsertProvider(type=VerifyCommitRecordSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(VerifyCommitRecord record);

    @SelectProvider(type=VerifyCommitRecordSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_account", property="verify_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_voucher", property="payment_voucher", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_json", property="target_json", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="change_json", property="change_json", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<VerifyCommitRecord> selectByExampleWithBLOBs(VerifyCommitRecordExample example);

    @SelectProvider(type=VerifyCommitRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_account", property="verify_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_voucher", property="payment_voucher", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR)
    })
    List<VerifyCommitRecord> selectByExample(VerifyCommitRecordExample example);

    @Select({
        "select",
        "`id`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `verify_account`, ",
        "`shop_id`, `shop_name`, `operate_type`, `status`, `remark`, `payment_voucher`, ",
        "`amount`, `target_json`, `change_json`",
        "from `verify_commit_record`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="verify_account", property="verify_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="shop_name", property="shop_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="operate_type", property="operate_type", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_voucher", property="payment_voucher", jdbcType=JdbcType.VARCHAR),
        @Result(column="amount", property="amount", jdbcType=JdbcType.VARCHAR),
        @Result(column="target_json", property="target_json", jdbcType=JdbcType.LONGVARCHAR),
        @Result(column="change_json", property="change_json", jdbcType=JdbcType.LONGVARCHAR)
    })
    VerifyCommitRecord selectByPrimaryKey(Long id);

    @UpdateProvider(type=VerifyCommitRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VerifyCommitRecord record, @Param("example") VerifyCommitRecordExample example);

    @UpdateProvider(type=VerifyCommitRecordSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") VerifyCommitRecord record, @Param("example") VerifyCommitRecordExample example);

    @UpdateProvider(type=VerifyCommitRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VerifyCommitRecord record, @Param("example") VerifyCommitRecordExample example);

    @UpdateProvider(type=VerifyCommitRecordSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VerifyCommitRecord record);

    @Update({
        "update `verify_commit_record`",
        "set `gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`verify_account` = #{verify_account,jdbcType=VARCHAR},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`shop_name` = #{shop_name,jdbcType=VARCHAR},",
          "`operate_type` = #{operate_type,jdbcType=INTEGER},",
          "`status` = #{status,jdbcType=INTEGER},",
          "`remark` = #{remark,jdbcType=VARCHAR},",
          "`payment_voucher` = #{payment_voucher,jdbcType=VARCHAR},",
          "`amount` = #{amount,jdbcType=VARCHAR},",
          "`target_json` = #{target_json,jdbcType=LONGVARCHAR},",
          "`change_json` = #{change_json,jdbcType=LONGVARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKeyWithBLOBs(VerifyCommitRecord record);

    @Update({
        "update `verify_commit_record`",
        "set `gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`verify_account` = #{verify_account,jdbcType=VARCHAR},",
          "`shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`shop_name` = #{shop_name,jdbcType=VARCHAR},",
          "`operate_type` = #{operate_type,jdbcType=INTEGER},",
          "`status` = #{status,jdbcType=INTEGER},",
          "`remark` = #{remark,jdbcType=VARCHAR},",
          "`payment_voucher` = #{payment_voucher,jdbcType=VARCHAR},",
          "`amount` = #{amount,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(VerifyCommitRecord record);
}