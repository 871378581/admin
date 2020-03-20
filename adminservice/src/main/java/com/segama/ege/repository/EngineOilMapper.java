package com.segama.ege.repository;

import com.segama.ege.entity.EngineOil;
import com.segama.ege.entity.EngineOilExample;
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

public interface EngineOilMapper {
    @SelectProvider(type=EngineOilSqlProvider.class, method="countByExample")
    int countByExample(EngineOilExample example);

    @DeleteProvider(type=EngineOilSqlProvider.class, method="deleteByExample")
    int deleteByExample(EngineOilExample example);

    @Delete({
        "delete from `engine_oil`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `engine_oil` (`brand`, `brand_name`, ",
        "`code`, `market_price`, ",
        "`member_price`, `photo_url`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`oil_type`, `market_price_max`)",
        "values (#{brand,jdbcType=VARCHAR}, #{brand_name,jdbcType=VARCHAR}, ",
        "#{code,jdbcType=VARCHAR}, #{market_price,jdbcType=DECIMAL}, ",
        "#{member_price,jdbcType=DECIMAL}, #{photo_url,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{oil_type,jdbcType=VARCHAR}, #{market_price_max,jdbcType=DECIMAL})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(EngineOil record);

    @InsertProvider(type=EngineOilSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(EngineOil record);

    @SelectProvider(type=EngineOilSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name", property="brand_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="market_price", property="market_price", jdbcType=JdbcType.DECIMAL),
        @Result(column="member_price", property="member_price", jdbcType=JdbcType.DECIMAL),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="oil_type", property="oil_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="market_price_max", property="market_price_max", jdbcType=JdbcType.DECIMAL)
    })
    List<EngineOil> selectByExample(EngineOilExample example);

    @Select({
        "select",
        "`id`, `brand`, `brand_name`, `code`, `market_price`, `member_price`, `photo_url`, ",
        "`gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, `oil_type`, ",
        "`market_price_max`",
        "from `engine_oil`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="brand", property="brand", jdbcType=JdbcType.VARCHAR),
        @Result(column="brand_name", property="brand_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="market_price", property="market_price", jdbcType=JdbcType.DECIMAL),
        @Result(column="member_price", property="member_price", jdbcType=JdbcType.DECIMAL),
        @Result(column="photo_url", property="photo_url", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="oil_type", property="oil_type", jdbcType=JdbcType.VARCHAR),
        @Result(column="market_price_max", property="market_price_max", jdbcType=JdbcType.DECIMAL)
    })
    EngineOil selectByPrimaryKey(Long id);

    @UpdateProvider(type=EngineOilSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") EngineOil record, @Param("example") EngineOilExample example);

    @UpdateProvider(type=EngineOilSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") EngineOil record, @Param("example") EngineOilExample example);

    @UpdateProvider(type=EngineOilSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(EngineOil record);

    @Update({
        "update `engine_oil`",
        "set `brand` = #{brand,jdbcType=VARCHAR},",
          "`brand_name` = #{brand_name,jdbcType=VARCHAR},",
          "`code` = #{code,jdbcType=VARCHAR},",
          "`market_price` = #{market_price,jdbcType=DECIMAL},",
          "`member_price` = #{member_price,jdbcType=DECIMAL},",
          "`photo_url` = #{photo_url,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`oil_type` = #{oil_type,jdbcType=VARCHAR},",
          "`market_price_max` = #{market_price_max,jdbcType=DECIMAL}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(EngineOil record);
}