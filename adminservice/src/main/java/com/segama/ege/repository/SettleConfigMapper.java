package com.segama.ege.repository;

import com.segama.ege.entity.SettleConfig;
import com.segama.ege.entity.SettleConfigExample;
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

public interface SettleConfigMapper {
    @SelectProvider(type=SettleConfigSqlProvider.class, method="countByExample")
    int countByExample(SettleConfigExample example);

    @DeleteProvider(type=SettleConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(SettleConfigExample example);

    @Delete({
        "delete from `settle_config`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `settle_config` (`card_level`, `fee`, ",
        "`gmt_modify`, `gmt_create`, ",
        "`creator_account`, `modifier_account`)",
        "values (#{card_level,jdbcType=INTEGER}, #{fee,jdbcType=VARCHAR}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(SettleConfig record);

    @InsertProvider(type=SettleConfigSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(SettleConfig record);

    @SelectProvider(type=SettleConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.INTEGER),
        @Result(column="fee", property="fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<SettleConfig> selectByExample(SettleConfigExample example);

    @Select({
        "select",
        "`id`, `card_level`, `fee`, `gmt_modify`, `gmt_create`, `creator_account`, `modifier_account`",
        "from `settle_config`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="card_level", property="card_level", jdbcType=JdbcType.INTEGER),
        @Result(column="fee", property="fee", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    SettleConfig selectByPrimaryKey(Long id);

    @UpdateProvider(type=SettleConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SettleConfig record, @Param("example") SettleConfigExample example);

    @UpdateProvider(type=SettleConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SettleConfig record, @Param("example") SettleConfigExample example);

    @UpdateProvider(type=SettleConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SettleConfig record);

    @Update({
        "update `settle_config`",
        "set `card_level` = #{card_level,jdbcType=INTEGER},",
          "`fee` = #{fee,jdbcType=VARCHAR},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SettleConfig record);
}