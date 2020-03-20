package com.segama.ege.admin.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.DateUtil;
import com.segama.ege.admin.utils.ExcelUtil;
import com.segama.ege.admin.utils.Password;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.AdminSystemConfig;
import com.segama.ege.entity.AdminSystemConfigExample;
import com.segama.ege.entity.MembershipCardExample;
import com.segama.ege.entity.MembershipCard;
import com.segama.ege.repository.AdminSystemConfigMapper;
import com.segama.ege.repository.MembershipCardMapper;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author hxj
 * @version 1.0
 * @Description 会员卡相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/membership_card")
@CrossOrigin(origins = "*", maxAge = 3600)
public class MemberShipCardController {
    @Resource
    private MembershipCardMapper membershipCardMapper;

    @Resource
    private HttpServletResponse httpServletResponse;

    @Resource
    private AdminSystemConfigMapper adminSystemConfigMapper;

    private static Logger LOG = LoggerFactory.getLogger(MemberShipCardController.class);

    public static ExecutorService executorService = Executors.newFixedThreadPool(6);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("batch_num") String batch_num,
            @RequestParam("card_id") String cardId,
            @RequestParam("status") String status
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            MembershipCardExample membershipCardExample = new MembershipCardExample();
            MembershipCardExample.Criteria criteria = membershipCardExample.createCriteria();
            if(!StringUtils.isEmpty(cardId)) {
                criteria.andCard_idLike("%" + cardId + "%");
            }
            if(!StringUtils.isEmpty(batch_num)){
                criteria.andBatch_numEqualTo(batch_num);
            }
            if(!StringUtils.isEmpty(status)) {
                criteria.andStatusEqualTo(status);
            }
            int count = membershipCardMapper.countByExample(membershipCardExample);
            membershipCardExample.setPageCount(pageSize);
            membershipCardExample.setPageIndex(pageIndex);
            membershipCardExample.setOrderByClause("id desc");
            List<MembershipCard> membershipCards = membershipCardMapper.selectByExample(membershipCardExample);
            baseVO.setData(membershipCards);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("MemberShipCardController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        if(id == null){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        }else {
            membershipCardMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/batch_delete")
    public BaseVO batch_delete(@RequestParam("idList") String ids ) {
        BaseVO baseVO = new BaseVO();
        Type type = new TypeReference<List<Long>>(){}.getType();
        List<Long> idList = (List<Long>)JSON.parseObject(ids, type);
        if(CollectionUtils.isEmpty(idList)){
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("请选择数据之后再删除！");
        }else {
            for (Long id : idList) {
                membershipCardMapper.deleteByPrimaryKey(id);
            }
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("status") String status,
                       @RequestParam("effective_days") Integer effective_days,
                    @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id==null){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            MembershipCard membershipCard = membershipCardMapper.selectByPrimaryKey(id);

            membershipCard.setGmt_modify(new Date());
            membershipCard.setModifier_account(account);
            membershipCard.setStatus(status);
            if(Objects.nonNull(effective_days)){
                membershipCard.setEffective_days(effective_days);
            }
            membershipCardMapper.updateByPrimaryKey(membershipCard);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminMenuController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/get_batch_num")
    public BaseVO batchNum() {
        BaseVO baseVO = new BaseVO();
        baseVO.setSuccess(true);
        try {
            //从最新的卡号开始生成，如果数据库从来没有生成卡号就从1开始
            MembershipCardExample example1 = new MembershipCardExample();
            example1.setOrderByClause("card_id desc");
            example1.setPageIndex(1);
            example1.setPageCount(1);
            List<MembershipCard> membershipCards1 = membershipCardMapper.selectByExample(example1);
            if(!CollectionUtils.isEmpty(membershipCards1)){
                MembershipCard membershipCard = membershipCards1.get(0);
                baseVO.setData(buildBatchNum(membershipCard.getBatch_num()));
            }else{
                baseVO.setData("BN0000000001");
            }
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("批次号生成异常！");
            LOG.error("AdminMenuController#get_batch_num error",e);
        }
        return baseVO;
    }
    @RequestMapping("/edit_status")
    public BaseVO editStatus(
            @RequestParam("batch_num") String batch_num,
            @RequestParam("status") String status,
                       @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(batch_num)  || StringUtils.isEmpty(status) || StringUtils.isEmpty(account)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            MembershipCardExample example = new MembershipCardExample();
            MembershipCardExample.Criteria criteria = example.createCriteria();
            criteria.andBatch_numEqualTo(batch_num);
            List<MembershipCard> membershipCards = membershipCardMapper.selectByExample(example);
            if(CollectionUtils.isEmpty(membershipCards)){
                baseVO.setErrorMsg("批次号不存在！");
                baseVO.setSuccess(false);
                return baseVO;
            }else{
                for (MembershipCard membershipCard : membershipCards) {
                    membershipCard.setBatch_num(batch_num);
                    membershipCard.setStatus(status);
                    membershipCard.setGmt_modify(new Date());
                    membershipCard.setModifier_account(account);
                    membershipCardMapper.updateByPrimaryKey(membershipCard);
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("AdminMenuController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
                      @RequestParam("batch_num") String batch_num,
                      @RequestParam("count") Integer count,
                      @RequestParam("card_level") String card_level,
                     /* @RequestParam("effective_days") Long effective_days,
                      @RequestParam("effective_date") String effective_date,
                      @RequestParam("expire_date") String expire_date,*/
                      @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        baseVO.setErrorMsg("系统繁忙请稍后再试！");
        baseVO.setSuccess(false);
        synchronized (this) {
            try {
                if (StringUtils.isEmpty(account) || count == null || StringUtils.isEmpty(batch_num)) {
                    baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                    baseVO.setSuccess(false);
                    return baseVO;
                }

                //批次号判重复
                MembershipCardExample example = new MembershipCardExample();
                MembershipCardExample.Criteria criteria = example.createCriteria();
                criteria.andBatch_numEqualTo(batch_num);
                List<MembershipCard> membershipCards = membershipCardMapper.selectByExample(example);
                if (!CollectionUtils.isEmpty(membershipCards)) {
                    baseVO.setErrorMsg("批次号已存在！");
                    baseVO.setSuccess(false);
                    return baseVO;
                }

                //从最新的卡号开始生成，如果数据库从来没有生成卡号就从1开始
                MembershipCardExample example1 = new MembershipCardExample();
                example1.setOrderByClause("card_id desc");
                example1.setPageIndex(1);
                example1.setPageCount(1);
                List<MembershipCard> membershipCards1 = membershipCardMapper.selectByExample(example1);
                String card_id = "";
                if (!CollectionUtils.isEmpty(membershipCards1)) {
                    MembershipCard membershipCard = membershipCards1.get(0);
                    card_id = membershipCard.getCard_id();
                }
                if (StringUtils.isEmpty(card_id)) {
                    card_id="08080000000000";
                }

                List<MembershipCard> membershipCards2 = buildCard(card_level,batch_num, card_id, count, account);
                //数量大雨60
                if(!CollectionUtils.isEmpty(membershipCards2) &&membershipCards2.size()>100000){
                    List<List<MembershipCard>> lists = averageAssign(membershipCards2, 6);
                    for (List<MembershipCard> list : lists) {
                        executorService.submit(new Callable<Object>() {
                            @Override
                            public Object call() throws Exception {
                                for (MembershipCard membershipCard : list) {
                                    membershipCardMapper.insertSelective(membershipCard);
                                }
                                return true;
                            }
                        });
                    }
                }else{
                    for (MembershipCard membershipCard : membershipCards2) {
                        membershipCardMapper.insertSelective(membershipCard);
                    }
                }

                baseVO.setSuccess(true);
            } catch (Exception e) {
                LOG.error("AdminMenuController#add error", e);
                baseVO.setSuccess(false);
                baseVO.setErrorMsg("添加异常！");
            }
        }
        return baseVO;
    }

    private String buildBatchNum(String old_batch_num){
        String substring = old_batch_num.substring(2, old_batch_num.length());
        List<MembershipCard> membershipCards = Lists.newArrayList();
        Integer numId = Integer.valueOf(substring);
        int num=numId + 1;
        String nums = String.valueOf(num);
        int count0 = 10 - (String.valueOf(num).length());
        for(int a=0;a<count0;a++){
            nums = "0"+nums;
        }
        return "BN"+nums;
    }

    private  List<MembershipCard> buildCard(String card_level,String batch_num,String card_id,Integer count,String account){
        String substring = card_id.substring(4, card_id.length());
        List<MembershipCard> membershipCards = Lists.newArrayList();
        Integer cardId = Integer.valueOf(substring);
        AdminSystemConfigExample example = new AdminSystemConfigExample();
        AdminSystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andKeyEqualTo("period_of_validity");
        List<AdminSystemConfig> adminSystemConfigs = adminSystemConfigMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(adminSystemConfigs)){
            throw new RuntimeException("会员卡默认有效期(period_of_validity)未配置配置！");
        }
        AdminSystemConfig adminSystemConfig = adminSystemConfigs.get(0);
        for(int i=1;i<=count;i++){
            MembershipCard membershipCard = new MembershipCard();
            int card=cardId + i;
            String cards = String.valueOf(card);
            int count0 = 10 - (String.valueOf(card).length());
            for(int a=0;a<count0;a++){
                cards = "0"+cards;
            }
            membershipCard.setCard_id("0808"+cards);
            membershipCard.setBatch_num(batch_num);
            membershipCard.setCard_level(card_level);
            membershipCard.setCreator_account(account);
            membershipCard.setModifier_account(account);
            membershipCard.setPassword(Password.getRandomS());
            membershipCard.setStatus("0");
            membershipCard.setEffective_days(Integer.valueOf(adminSystemConfig.getValue()));
            membershipCard.setGmt_create(new Date());
            membershipCard.setGmt_modify(new Date());
            membershipCards.add(membershipCard);
        }
        return membershipCards;
    }

    /*public static void main(String[] args) {
        buildCard("cehsi","08080000000001",100,"123123");
    }*/

    public static <T> List<List<T>> averageAssign(List<T> source,int n){
        List<List<T>> result=new ArrayList<List<T>>();
        int remaider=source.size()%n; //(先计算出余数)
        int number=source.size()/n; //然后是商
        int offset=0;//偏移量
        for(int i=0;i<n;i++){
            List<T> value=null;
            if(remaider>0){
                value=source.subList(i*number+offset, (i+1)*number+offset+1);
                remaider--;
                offset++;
            }else{
                value=source.subList(i*number+offset, (i+1)*number+offset);
            }
            result.add(value);
        }
        return result;
    }



    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(id == null){
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            }else {
                MembershipCard membershipCard = membershipCardMapper.selectByPrimaryKey(id);
                baseVO.setData(membershipCard);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("AdminMenuController#get Exception input param is id:"+id,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询会员卡信息信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/export")
    public void export(
            @RequestParam("card_id") String cardId,
            @RequestParam("status") String status,
             @RequestParam("batch_num") String batch_num
            /*,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex*/) {
        try {
            MembershipCardExample membershipCardExample = new MembershipCardExample();
            MembershipCardExample.Criteria criteria = membershipCardExample.createCriteria();
            if(!StringUtils.isEmpty(cardId)) {
                criteria.andCard_idLike("%" + cardId + "%");
            }
            if(!StringUtils.isEmpty(status)) {
                criteria.andStatusEqualTo(status);
            }
            if(!StringUtils.isEmpty(batch_num)){
                criteria.andBatch_numEqualTo(batch_num);
            }
            List<MembershipCard> membershipCards = membershipCardMapper.selectByExample(membershipCardExample);
            ExcelUtil.exportExcel(
                    "会员卡数据表格",
                    new String[]{"ID","批次号","卡号","密码"},
                    new ArrayList<Object[]>() {{
                        for (MembershipCard membershipCard : membershipCards) {
                            add(new Object[]{
                                    membershipCard.getId(),
                                    membershipCard.getBatch_num(),
                                    membershipCard.getCard_id(),
                                    membershipCard.getPassword()
                            });
                        }
                    }},
                    new String("会员卡数据表格.xls".getBytes("UTF-8"),"iso-8859-1"),
                    httpServletResponse);
        }catch (Exception e){
            LOG.error("MemberShipCardController#export error",e);
        }
    }
}
