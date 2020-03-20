package com.segama.ege.repository;

import com.segama.ege.entity.RepeatServiceWxUsers;
import com.segama.ege.entity.RepeatServiceWxUsersExample;
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

public interface RepeatServiceWxUsersMapper {
    @SelectProvider(type=RepeatServiceWxUsersSqlProvider.class, method="countByExample")
    int countByExample(RepeatServiceWxUsersExample example);

    @DeleteProvider(type=RepeatServiceWxUsersSqlProvider.class, method="deleteByExample")
    int deleteByExample(RepeatServiceWxUsersExample example);

    @Delete({
        "delete from `repeat_service_wx_users`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `repeat_service_wx_users` (`order_id`, `order_string_id`, ",
        "`user_id`, `user_name`, ",
        "`car_id`, `car_plate`, ",
        "`car_type_name`, `gmt_actual_service`, ",
        "`gmt_create`, `gmt_modify`, ",
        "`creator_account`, `modifier_account`)",
        "values (#{order_id,jdbcType=VARCHAR}, #{order_string_id,jdbcType=VARCHAR}, ",
        "#{user_id,jdbcType=VARCHAR}, #{user_name,jdbcType=VARCHAR}, ",
        "#{car_id,jdbcType=BIGINT}, #{car_plate,jdbcType=VARCHAR}, ",
        "#{car_type_name,jdbcType=VARCHAR}, #{gmt_actual_service,jdbcType=VARCHAR}, ",
        "#{gmt_create,jdbcType=TIMESTAMP}, #{gmt_modify,jdbcType=TIMESTAMP}, ",
        "#{creator_account,jdbcType=VARCHAR}, #{modifier_account,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(RepeatServiceWxUsers record);

    @InsertProvider(type=RepeatServiceWxUsersSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(RepeatServiceWxUsers record);

    @SelectProvider(type=RepeatServiceWxUsersSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_id", property="car_id", jdbcType=JdbcType.BIGINT),
        @Result(column="car_plate", property="car_plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_name", property="car_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_actual_service", property="gmt_actual_service", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    List<RepeatServiceWxUsers> selectByExample(RepeatServiceWxUsersExample example);

    @Select({
        "select",
        "`id`, `order_id`, `order_string_id`, `user_id`, `user_name`, `car_id`, `car_plate`, ",
        "`car_type_name`, `gmt_actual_service`, `gmt_create`, `gmt_modify`, `creator_account`, ",
        "`modifier_account`",
        "from `repeat_service_wx_users`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="user_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="user_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_id", property="car_id", jdbcType=JdbcType.BIGINT),
        @Result(column="car_plate", property="car_plate", jdbcType=JdbcType.VARCHAR),
        @Result(column="car_type_name", property="car_type_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_actual_service", property="gmt_actual_service", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR)
    })
    RepeatServiceWxUsers selectByPrimaryKey(Long id);

    @UpdateProvider(type=RepeatServiceWxUsersSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RepeatServiceWxUsers record, @Param("example") RepeatServiceWxUsersExample example);

    @UpdateProvider(type=RepeatServiceWxUsersSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RepeatServiceWxUsers record, @Param("example") RepeatServiceWxUsersExample example);

    @UpdateProvider(type=RepeatServiceWxUsersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(RepeatServiceWxUsers record);

    @Update({
        "update `repeat_service_wx_users`",
        "set `order_id` = #{order_id,jdbcType=VARCHAR},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`user_id` = #{user_id,jdbcType=VARCHAR},",
          "`user_name` = #{user_name,jdbcType=VARCHAR},",
          "`car_id` = #{car_id,jdbcType=BIGINT},",
          "`car_plate` = #{car_plate,jdbcType=VARCHAR},",
          "`car_type_name` = #{car_type_name,jdbcType=VARCHAR},",
          "`gmt_actual_service` = #{gmt_actual_service,jdbcType=VARCHAR},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(RepeatServiceWxUsers record);
}