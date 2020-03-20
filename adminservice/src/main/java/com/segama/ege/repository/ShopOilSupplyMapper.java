package com.segama.ege.repository;

import com.segama.ege.entity.ShopOilSupply;
import com.segama.ege.entity.ShopOilSupplyExample;
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

public interface ShopOilSupplyMapper {
    @SelectProvider(type=ShopOilSupplySqlProvider.class, method="countByExample")
    int countByExample(ShopOilSupplyExample example);

    @DeleteProvider(type=ShopOilSupplySqlProvider.class, method="deleteByExample")
    int deleteByExample(ShopOilSupplyExample example);

    @Delete({
        "delete from `shop_oil_supply`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `shop_oil_supply` (`shop_id`, `oil_id`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`, ",
        "`version`)",
        "values (#{shop_id,jdbcType=BIGINT}, #{oil_id,jdbcType=BIGINT}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR}, ",
        "#{version,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ShopOilSupply record);

    @InsertProvider(type=ShopOilSupplySqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ShopOilSupply record);

    @SelectProvider(type=ShopOilSupplySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="oil_id", property="oil_id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    List<ShopOilSupply> selectByExample(ShopOilSupplyExample example);

    @Select({
        "select",
        "`id`, `shop_id`, `oil_id`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`version`",
        "from `shop_oil_supply`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="shop_id", property="shop_id", jdbcType=JdbcType.BIGINT),
        @Result(column="oil_id", property="oil_id", jdbcType=JdbcType.BIGINT),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="version", property="version", jdbcType=JdbcType.INTEGER)
    })
    ShopOilSupply selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShopOilSupplySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShopOilSupply record, @Param("example") ShopOilSupplyExample example);

    @UpdateProvider(type=ShopOilSupplySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShopOilSupply record, @Param("example") ShopOilSupplyExample example);

    @UpdateProvider(type=ShopOilSupplySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShopOilSupply record);

    @Update({
        "update `shop_oil_supply`",
        "set `shop_id` = #{shop_id,jdbcType=BIGINT},",
          "`oil_id` = #{oil_id,jdbcType=BIGINT},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`version` = #{version,jdbcType=INTEGER}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShopOilSupply record);
}