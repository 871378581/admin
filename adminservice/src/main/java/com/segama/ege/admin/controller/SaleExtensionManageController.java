package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.response.ShishouOrder;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.utils.ExcelUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.AdminUserMapper;
import com.segama.ege.repository.ThProductManageMapper;
import com.segama.ege.repository.ThSaleExtensionManageMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 销售数据管理
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/sale_extension")
@CrossOrigin(origins = "*", maxAge = 3600)
public class SaleExtensionManageController extends BaseController {
    @Resource
    private ThSaleExtensionManageMapper thSaleExtensionManageMapper;

    @Resource
    private AdminUserMapper adminUserMapper;

    @Resource
    private ThProductManageMapper thProductManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(SaleExtensionManageController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam(value = "channel_A",required = false) String channel_A,
            @RequestParam(value = "channel_b",required = false) String channel_b,
            @RequestParam(value = "user_name",required = false) String user_name,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "qq",required = false) String qq,
            @RequestParam(value = "type",required = false) String type
            ,@RequestParam(value = "account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThSaleExtensionManageExample example = new ThSaleExtensionManageExample();
            ThSaleExtensionManageExample.Criteria criteria = example.createCriteria();
            if(!showAllUser(account)){
                if(!StringUtils.isEmpty(type)){
                    if("1".equals(type)){
                        criteria.andCreate_accountEqualTo(account);
                    }else{
                        criteria.andOwner_accountEqualTo(account);
                    }
                }
            }
            if(StringUtils.isNotEmpty(channel_A)) {
                criteria.andCreate_accountEqualTo(channel_A);
            }
            if(StringUtils.isNotEmpty(channel_b)) {
                criteria.andOwner_accountEqualTo(channel_b);
            }
            if(StringUtils.isNotEmpty(user_name)) {
                criteria.andUser_nameLike("%" + user_name + "%");
            }
            if(StringUtils.isNotEmpty(phone)) {
                criteria.andPhoneLike("%" + phone + "%");
            }
            if(StringUtils.isNotEmpty(qq)) {
                criteria.andQqLike("%" + qq + "%");
            }
            if(!showAllUser(account)){
                AdminUserExample example1 = new AdminUserExample();
                example1.createCriteria().andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(example1);
                if(!CollectionUtils.isEmpty(adminUsers)){
                    AdminUser adminUser = adminUsers.get(0);
                    if(adminUser.getChannel_type().equals(1)){
                        criteria.andCreate_accountEqualTo(account);
                    }else if(adminUser.getChannel_type().equals(2)){
                        criteria.andOwner_accountEqualTo(account);
                    }
                }

            }
            int count = thSaleExtensionManageMapper.countByExample(example);
            example.setPageCount(pageSize);
            example.setPageIndex(pageIndex);
            example.setOrderByClause("gmt_create desc");
            List<ThSaleExtensionManage> adminMenus = thSaleExtensionManageMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(adminMenus)){
                for (ThSaleExtensionManage manage : adminMenus) {
                    if(StringUtils.isEmpty(manage.getProduct_name())&&!StringUtils.isEmpty(manage.getQq())&&manage.getQq().split("@l@").length==2){
                        manage.setProduct_name(manage.getQq().split("@l@")[1]);
                    }
                    if(!StringUtils.isEmpty(manage.getProduct_code())) {
                        ThProductManageExample example2 = new ThProductManageExample();
                        example2.createCriteria()
                                .andProduct_codeEqualTo(manage.getProduct_code())
                                .andProduct_statusEqualTo(1);
                        List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example2);
                        if (!CollectionUtils.isEmpty(thProductManages)) {
                            ThProductManage thProductManage = thProductManages.get(0);
                            manage.setProduct_name(thProductManage.getProduct_name());
                        }
                    }
                }
            }
            baseVO.setData(adminMenus);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThSaleExtensionManageController#list error",e);
        }
        return baseVO;
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/shishou_list")
    public BaseVO shishou_list(
            @RequestParam(value = "channel_A",required = false) String channel_A,
            @RequestParam(value = "channel_b",required = false) String channel_b,
            @RequestParam(value = "user_name",required = false) String user_name,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "order_time",required = false) String order_time,
            @RequestParam(value = "type",required = false) String type
            ,@RequestParam(value = "account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            List<Object> params = Lists.newArrayList();
            StringBuffer sql = new StringBuffer();
            StringBuffer sqlCount = new StringBuffer();
            sqlCount.append("select count(0) " +
                    "            from th_order_manage a,th_sale_extension_manage b\n" +
                    "            where left(a.customer_name,1) = left(b.user_name,1)\n" +
                    "            and left(a.customer_contact_num,3) =  left(b.phone,3)\n" +
                    "            and right(a.customer_contact_num,3) =  right(b.phone,3) ");

            sql.append("select\n" +
                        "                    a.order_code,\n" +
                        "                    a.order_time,\n" +
                        "                    a.order_phone_number,\n" +
                        "                    a.prov,\n" +
                        "                    a.city,\n" +
                        "                    a.order_status,\n" +
                        "                    a.customer_name,\n" +
                        "                    a.customer_contact_num,\n" +
                        "                    a.good_name,\n" +
                        "                    a.address,\n" +
                        "                    a.active_status,\n" +
                        "                    a.cudian_code,\n" +
                        "                    a.shoucong_amt,\n" +
                        "                    a.shoucong_time,\n" +
                        "                    a.xiehaozhuanwang_type,\n" +
                        "                    a.zhuanhualvtichu_reason,\n" +
                        "                    a.channel_account,\n" +
                        "                    a.channel_code,\n" +
                        "                    a.picihao,\n" +
                        "                    b.owner_account,\n" +
                        "                    b.create_account\n" +
                        "            from th_order_manage a,th_sale_extension_manage b\n" +
                        "            where left(a.customer_name,1) = left(b.user_name,1)\n" +
                        "            and left(a.customer_contact_num,3) =  left(b.phone,3)\n" +
                        "            and right(a.customer_contact_num,3) =  right(b.phone,3) ");
            if(!StringUtils.isEmpty(order_time)){
                String[] time = order_time.split(" - ");
                params.add(time[0]);
                params.add(time[1]);
                sql.append(" and  a.order_time between ? and ?");
                sqlCount.append(" and  a.order_time between ? and ?");
            }

            if(!StringUtils.isEmpty(phone)){
                params.add(phone);
                sql.append(" and  b.phone = ?");
                sqlCount.append(" and  b.phone = ?");
            }
            if(!StringUtils.isEmpty(user_name)){
                params.add(user_name);
                sql.append(" and  b.user_name = ?");
                sqlCount.append(" and  b.user_name = ?");
            }

            if(!StringUtils.isEmpty(order_time)){
                String[] time = order_time.split(" - ");
                params.add(time[0]);
                params.add(time[1]);
                sql.append(" and  a.order_time between ? and ?");
                sqlCount.append(" and  a.order_time between ? and ?");
            }
            if(!showAllUser(account)){
                AdminUserExample example1 = new AdminUserExample();
                example1.createCriteria().andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(example1);
                if(!CollectionUtils.isEmpty(adminUsers)){
                    AdminUser adminUser = adminUsers.get(0);
                    if(adminUser.getChannel_type().equals(2)){
                        sql.append(" and b.owner_account = ? ");
                        sqlCount.append(" and b.owner_account = ? ");
                        params.add(account);
                    }else if(adminUser.getChannel_type().equals(1)){
                        sql.append(" and b.create_account = ?");
                        sqlCount.append(" and b.create_account = ?");
                        params.add(account);
                    }
                }
            }
            if(!StringUtils.isEmpty(channel_b)){
                sql.append(" and b.owner_account = ? ");
                sqlCount.append(" and b.owner_account = ? ");
                params.add(channel_b);
            }
            if(!StringUtils.isEmpty(channel_A)){
                sql.append(" and b.create_account = ?");
                sqlCount.append(" and b.create_account = ?");
                params.add(channel_A);
            }
            Integer count = 0;

            Integer count2 = jdbcTemplate.queryForObject(sqlCount.toString(), params.toArray(),
                    Integer.class);
            if(count2!=null){
                count= count2;
            }

            params.add(pageIndex-1);
            params.add(pageSize);
            sql.append(" limit ?,? ");
            List<ShishouOrder> query = Lists.newArrayList();
            List<ShishouOrder> result = jdbcTemplate.query(sql.toString(), params.toArray(),
                    new BeanPropertyRowMapper<>(ShishouOrder.class));
            if(!CollectionUtils.isEmpty(result)){
                query=result;
            }

            baseVO.setData(query);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThSaleExtensionManageController#list error",e);
        }
        return baseVO;
    }


    @RequestMapping("/export")
    private void export(
                @RequestParam(value = "channel_A",required = false) String channel_A,
                @RequestParam(value = "channel_b",required = false) String channel_b,
                @RequestParam(value = "user_name",required = false) String user_name,
                @RequestParam(value = "phone",required = false) String phone,
                @RequestParam(value = "qq",required = false) String qq,
                @RequestParam(value = "type",required = false) String type
                ,@RequestParam(value = "account") String account) {
        try {
            ThSaleExtensionManageExample example = new ThSaleExtensionManageExample();
            ThSaleExtensionManageExample.Criteria criteria = example.createCriteria();
            if (!showAllUser(account)) {
                if (!StringUtils.isEmpty(type)) {
                    if ("1".equals(type)) {
                        criteria.andCreate_accountEqualTo(account);
                    } else {
                        criteria.andOwner_accountEqualTo(account);
                    }
                }
            }
            if (StringUtils.isNotEmpty(channel_A)) {
                criteria.andCreate_accountEqualTo(channel_A);
            }
            if (StringUtils.isNotEmpty(channel_b)) {
                criteria.andOwner_accountEqualTo(channel_b);
            }
            if (StringUtils.isNotEmpty(user_name)) {
                criteria.andUser_nameLike("%" + user_name + "%");
            }
            if (StringUtils.isNotEmpty(phone)) {
                criteria.andPhoneLike("%" + phone + "%");
            }
            if (StringUtils.isNotEmpty(qq)) {
                criteria.andQqLike("%" + qq + "%");
            }
            if (!showAllUser(account)) {
                AdminUserExample example1 = new AdminUserExample();
                example1.createCriteria().andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(example1);
                if (!CollectionUtils.isEmpty(adminUsers)) {
                    AdminUser adminUser = adminUsers.get(0);
                    if (adminUser.getChannel_type().equals(1)) {
                        criteria.andCreate_accountEqualTo(account);
                    } else if (adminUser.getChannel_type().equals(2)) {
                        criteria.andOwner_accountEqualTo(account);
                    }
                }

            }
            List<ThSaleExtensionManage> thSaleExtensionManages = thSaleExtensionManageMapper.selectByExample(example);
            String[] rowName=null;
            List<Object[]> dataList = Lists.newArrayList();
            if(!CollectionUtils.isEmpty(thSaleExtensionManages)) {
                rowName = new String[]{"ID",
                        "产品名称",
                        "产品编码",
                        "渠道A",
                        "渠道b",
                        "电话",
                        "用户名",
                        "请求链接",
                        "创建时间"};

                for (ThSaleExtensionManage thSaleExtensionManage : thSaleExtensionManages) {
                    if(thSaleExtensionManage.getProduct_code()!=null) {
                        ThProductManageExample example2 = new ThProductManageExample();
                        example2.createCriteria()
                                .andProduct_codeEqualTo(thSaleExtensionManage.getProduct_code());
                        List<ThProductManage> thProductManages = thProductManageMapper.selectByExample(example2);
                        if (!CollectionUtils.isEmpty(thProductManages)) {
                            ThProductManage thProductManage = thProductManages.get(0);
                            thSaleExtensionManage.setProduct_name(thProductManage.getProduct_name());
                        }
                    }
                    dataList.add(new Object[]{
                            thSaleExtensionManage.getId(),
                            thSaleExtensionManage.getProduct_name(),
                            thSaleExtensionManage.getProduct_code(),
                            thSaleExtensionManage.getCreate_account(),
                            thSaleExtensionManage.getOwner_account(),
                            thSaleExtensionManage.getPhone(),
                            thSaleExtensionManage.getUser_name(),
                            thSaleExtensionManage.getRequest_url(),
                            DateUtil.parse(thSaleExtensionManage.getGmt_create())
                    });
                }
            }else{
                rowName = new String[]{"结果"};
                dataList.add(new Object[]{"没有数据"});
            }
            ExcelUtil.exportExcel("销售记录", rowName, dataList, new String("销售记录.xls".getBytes("UTF-8"), "iso-8859-1"), response);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/export2")
    public void export2(
            HttpServletResponse response,
            @RequestParam(value = "channel_A",required = false) String channel_A,
            @RequestParam(value = "channel_b",required = false) String channel_b,
            @RequestParam(value = "user_name",required = false) String user_name,
            @RequestParam(value = "phone",required = false) String phone,
            @RequestParam(value = "order_time",required = false) String order_time,
            @RequestParam(value = "type",required = false) String type
            ,@RequestParam(value = "account") String account) {
        try {
            List<Object> params = Lists.newArrayList();
            StringBuffer sql = new StringBuffer();
            StringBuffer sqlCount = new StringBuffer();
            sqlCount.append("select count(0) " +
                    "            from th_order_manage a,th_sale_extension_manage b\n" +
                    "            where left(a.customer_name,1) = left(b.user_name,1)\n" +
                    "            and left(a.customer_contact_num,3) =  left(b.phone,3)\n" +
                    "            and right(a.customer_contact_num,3) =  right(b.phone,3) ");

            sql.append("select\n" +
                    "                    a.order_code,\n" +
                    "                    a.order_time,\n" +
                    "                    a.order_phone_number,\n" +
                    "                    a.prov,\n" +
                    "                    a.city,\n" +
                    "                    a.order_status,\n" +
                    "                    a.customer_name,\n" +
                    "                    a.customer_contact_num,\n" +
                    "                    a.good_name,\n" +
                    "                    a.address,\n" +
                    "                    a.active_status,\n" +
                    "                    a.cudian_code,\n" +
                    "                    a.shoucong_amt,\n" +
                    "                    a.shoucong_time,\n" +
                    "                    a.xiehaozhuanwang_type,\n" +
                    "                    a.zhuanhualvtichu_reason,\n" +
                    "                    a.channel_account,\n" +
                    "                    a.channel_code,\n" +
                    "                    a.picihao,\n" +
                    "                    b.owner_account,\n" +
                    "                    b.create_account\n" +
                    "            from th_order_manage a,th_sale_extension_manage b\n" +
                    "            where left(a.customer_name,1) = left(b.user_name,1)\n" +
                    "            and left(a.customer_contact_num,3) =  left(b.phone,3)\n" +
                    "            and right(a.customer_contact_num,3) =  right(b.phone,3) ");
            if (!StringUtils.isEmpty(order_time)) {
                String[] time = order_time.split(" - ");
                params.add(time[0]);
                params.add(time[1]);
                sql.append(" and  a.order_time between ? and ?");
                sqlCount.append(" and  a.order_time between ? and ?");
            }

            if (!StringUtils.isEmpty(phone)) {
                params.add(phone);
                sql.append(" and  b.phone = ?");
                sqlCount.append(" and  b.phone = ?");
            }
            if (!StringUtils.isEmpty(user_name)) {
                params.add(user_name);
                sql.append(" and  b.user_name = ?");
                sqlCount.append(" and  b.user_name = ?");
            }

            if (!StringUtils.isEmpty(order_time)) {
                String[] time = order_time.split(" - ");
                params.add(time[0]);
                params.add(time[1]);
                sql.append(" and  a.order_time between ? and ?");
                sqlCount.append(" and  a.order_time between ? and ?");
            }
            if (!showAllUser(account)) {
                AdminUserExample example1 = new AdminUserExample();
                example1.createCriteria().andAccountEqualTo(account);
                List<AdminUser> adminUsers = adminUserMapper.selectByExample(example1);
                if (!CollectionUtils.isEmpty(adminUsers)) {
                    AdminUser adminUser = adminUsers.get(0);
                    if (adminUser.getChannel_type().equals(2)) {
                        sql.append(" and b.owner_account = ? ");
                        sqlCount.append(" and b.owner_account = ? ");
                        params.add(account);
                    } else if (adminUser.getChannel_type().equals(1)) {
                        sql.append(" and b.create_account = ?");
                        sqlCount.append(" and b.create_account = ?");
                        params.add(account);
                    }
                }
            }
            if (!StringUtils.isEmpty(channel_b)) {
                sql.append(" and b.owner_account = ? ");
                sqlCount.append(" and b.owner_account = ? ");
                params.add(channel_b);
            }
            if (!StringUtils.isEmpty(channel_A)) {
                sql.append(" and b.create_account = ?");
                sqlCount.append(" and b.create_account = ?");
                params.add(channel_A);
            }
            Integer count = 0;

            Integer count2 = jdbcTemplate.queryForObject(sqlCount.toString(), params.toArray(),
                    Integer.class);
            if (count2 != null) {
                count = count2;
            }

            sql.append(" limit ?,? ");

            List<ShishouOrder> query = Lists.newArrayList();
            if (count > 0) {
                int pageSize = 20;
                int page = (count + pageSize - 1) / pageSize;
                int flag=0;
                for (int i = 1; i <= page; i++) {
                    if(flag!=0) {
                        int size = params.size();
                        params.remove(size-1);
                        params.remove(size - 2);
                    }
                    params.add(i);
                    params.add(20);
                    List<ShishouOrder> result = jdbcTemplate.query(sql.toString(), params.toArray(),
                            new BeanPropertyRowMapper<>(ShishouOrder.class));
                    if (!CollectionUtils.isEmpty(result)) {
                        query.addAll(result);
                    }
                    flag++;
                }
                String[] rowName = null;
                List<Object[]> dataList = Lists.newArrayList();
                if (!CollectionUtils.isEmpty(query)) {
                    rowName = new String[]{
                            "渠道A",
                            "渠道b",
                            "订单编码",
                            "订单时间",
                            "订购号码",
                            "号码省份",
                            "号码地市",
                            "订单状态",
                            "客户姓名",
                            "证件类型",
                            "证件号码",
                            "客户联系号码",
                            "商品名称",
                            "配送地址",
                            "激活状态",
                            "触点编码",
                            "首充金额",
                            "首充时间",
                            "携号转网类型",
                            "转化率剔除原"
                    };

                    for (ShishouOrder syncData : query) {
                        dataList.add(new Object[]{
                                syncData.getCreate_account(),
                                syncData.getOwner_account(),
                                syncData.getOrder_code(),
                                syncData.getOrder_time(),
                                syncData.getOrder_phone_number(),
                                syncData.getProv(),
                                syncData.getCity(),
                                syncData.getOrder_status(),
                                syncData.getCustomer_name(),
                                syncData.getCertificate_type(),
                                syncData.getCertificate_num(),
                                syncData.getCustomer_contact_num(),
                                syncData.getGood_name(),
                                syncData.getAddress(),
                                syncData.getActive_status(),
                                syncData.getCudian_code(),
                                syncData.getShoucong_amt(),
                                syncData.getShoucong_time(),
                                syncData.getXiehaozhuanwang_type(),
                                syncData.getZhuanhualvtichu_reason(),

                        });
                    }
                } else {
                    rowName = new String[]{"结果"};
                    dataList.add(new Object[]{"没有数据"});
                }
                ExcelUtil.exportExcel("销售实收报表", rowName, dataList, new String("销售实收报表.xls".getBytes("UTF-8"), "iso-8859-1"), response);
            }
        } catch (Exception e) {
            LOG.error("SaleExtensionManageController#list error", e);
        }
    }
}
