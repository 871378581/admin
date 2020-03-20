package com.segama.ege.repository;

import com.segama.ege.entity.ServiceOrderEvent;
import com.segama.ege.entity.ServiceOrderEventExample;
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

public interface ServiceOrderEventMapper {
    @SelectProvider(type=ServiceOrderEventSqlProvider.class, method="countByExample")
    int countByExample(ServiceOrderEventExample example);

    @DeleteProvider(type=ServiceOrderEventSqlProvider.class, method="deleteByExample")
    int deleteByExample(ServiceOrderEventExample example);

    @Delete({
        "delete from `service_order_event`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into `service_order_event` (`order_id`, `order_string_id`, ",
        "`event_staff_id`, `event_staff_role`, ",
        "`event_staff_name`, `event_desc`, ",
        "`gmt_event`, `gmt_create`, ",
        "`gmt_modify`, `creator_account`, ",
        "`modifier_account`, `result`, ",
        "`is_car_user_operate`)",
        "values (#{order_id,jdbcType=BIGINT}, #{order_string_id,jdbcType=VARCHAR}, ",
        "#{event_staff_id,jdbcType=VARCHAR}, #{event_staff_role,jdbcType=VARCHAR}, ",
        "#{event_staff_name,jdbcType=VARCHAR}, #{event_desc,jdbcType=VARCHAR}, ",
        "#{gmt_event,jdbcType=TIMESTAMP}, #{gmt_create,jdbcType=TIMESTAMP}, ",
        "#{gmt_modify,jdbcType=TIMESTAMP}, #{creator_account,jdbcType=VARCHAR}, ",
        "#{modifier_account,jdbcType=VARCHAR}, #{result,jdbcType=BIT}, ",
        "#{is_car_user_operate,jdbcType=BIT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(ServiceOrderEvent record);

    @InsertProvider(type=ServiceOrderEventSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insertSelective(ServiceOrderEvent record);

    @SelectProvider(type=ServiceOrderEventSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_staff_id", property="event_staff_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_staff_role", property="event_staff_role", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_staff_name", property="event_staff_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_desc", property="event_desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_event", property="gmt_event", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.BIT),
        @Result(column="is_car_user_operate", property="is_car_user_operate", jdbcType=JdbcType.BIT)
    })
    List<ServiceOrderEvent> selectByExample(ServiceOrderEventExample example);

    @Select({
        "select",
        "`id`, `order_id`, `order_string_id`, `event_staff_id`, `event_staff_role`, `event_staff_name`, ",
        "`event_desc`, `gmt_event`, `gmt_create`, `gmt_modify`, `creator_account`, `modifier_account`, ",
        "`result`, `is_car_user_operate`",
        "from `service_order_event`",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_id", property="order_id", jdbcType=JdbcType.BIGINT),
        @Result(column="order_string_id", property="order_string_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_staff_id", property="event_staff_id", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_staff_role", property="event_staff_role", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_staff_name", property="event_staff_name", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_desc", property="event_desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_event", property="gmt_event", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_create", property="gmt_create", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmt_modify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="creator_account", property="creator_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="modifier_account", property="modifier_account", jdbcType=JdbcType.VARCHAR),
        @Result(column="result", property="result", jdbcType=JdbcType.BIT),
        @Result(column="is_car_user_operate", property="is_car_user_operate", jdbcType=JdbcType.BIT)
    })
    ServiceOrderEvent selectByPrimaryKey(Long id);

    @UpdateProvider(type=ServiceOrderEventSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ServiceOrderEvent record, @Param("example") ServiceOrderEventExample example);

    @UpdateProvider(type=ServiceOrderEventSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ServiceOrderEvent record, @Param("example") ServiceOrderEventExample example);

    @UpdateProvider(type=ServiceOrderEventSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ServiceOrderEvent record);

    @Update({
        "update `service_order_event`",
        "set `order_id` = #{order_id,jdbcType=BIGINT},",
          "`order_string_id` = #{order_string_id,jdbcType=VARCHAR},",
          "`event_staff_id` = #{event_staff_id,jdbcType=VARCHAR},",
          "`event_staff_role` = #{event_staff_role,jdbcType=VARCHAR},",
          "`event_staff_name` = #{event_staff_name,jdbcType=VARCHAR},",
          "`event_desc` = #{event_desc,jdbcType=VARCHAR},",
          "`gmt_event` = #{gmt_event,jdbcType=TIMESTAMP},",
          "`gmt_create` = #{gmt_create,jdbcType=TIMESTAMP},",
          "`gmt_modify` = #{gmt_modify,jdbcType=TIMESTAMP},",
          "`creator_account` = #{creator_account,jdbcType=VARCHAR},",
          "`modifier_account` = #{modifier_account,jdbcType=VARCHAR},",
          "`result` = #{result,jdbcType=BIT},",
          "`is_car_user_operate` = #{is_car_user_operate,jdbcType=BIT}",
        "where `id` = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ServiceOrderEvent record);
}