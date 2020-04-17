package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.*;
import com.segama.ege.repository.ThOrderForJinrongManageMapper;
import com.segama.ege.repository.ThUrlManageMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author hxj
 * @version 1.0
 * @Description 订单相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/order_jinrong")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderJinRongController extends BaseController {
    @Resource
    private ThOrderForJinrongManageMapper thOrderForJinrongManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(OrderJinRongController.class);

    @RequestMapping("/list")
    public BaseVO list(
            ThOrderForJinrongManage thOrderForJinrongManage
            ,@RequestParam("account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThOrderForJinrongManageExample thOrderForJinrongManageExample = new ThOrderForJinrongManageExample();
            ThOrderForJinrongManageExample.Criteria thOrderForJinrongManageExampleCriteria = thOrderForJinrongManageExample.createCriteria();
            if(StringUtils.isNotEmpty(thOrderForJinrongManage.getProduct_name())) {
                thOrderForJinrongManageExampleCriteria.andProduct_nameLike("%" + thOrderForJinrongManage.getProduct_name() + "%");
            }
            if(StringUtils.isNotEmpty(thOrderForJinrongManage.getPicihao())) {
                thOrderForJinrongManageExampleCriteria.andPicihaoEqualTo( thOrderForJinrongManage.getPicihao() );
            }
            if(StringUtils.isNotEmpty(thOrderForJinrongManage.getOperate_type())) {
                thOrderForJinrongManageExampleCriteria.andOperate_typeEqualTo( thOrderForJinrongManage.getOperate_type() );
            }
            if(!StringUtils.isEmpty(thOrderForJinrongManage.getOrder_time())){
                String[] time = thOrderForJinrongManage.getOrder_time().split(" - ");
                thOrderForJinrongManageExampleCriteria.andOrder_timeBetween(time[0],time[1]);
            }
            Boolean aBoolean = showAllUser(account);
            if(!aBoolean){
                //只能查看自己的operateType=1的数据
                thOrderForJinrongManageExampleCriteria.andOperate_typeEqualTo("上线");
                thOrderForJinrongManageExampleCriteria.andChannel_accountEqualTo(account);
            }
            int count = thOrderForJinrongManageMapper.countByExample(thOrderForJinrongManageExample);
            thOrderForJinrongManageExample.setPageCount(pageSize);
            thOrderForJinrongManageExample.setPageIndex(pageIndex);
            thOrderForJinrongManageExample.setOrderByClause("gmt_create desc");
            List<ThOrderForJinrongManage> thOrderForJinrongManages = Lists.newArrayList();
            if(count>0) {
                thOrderForJinrongManages = thOrderForJinrongManageMapper.selectByExample(thOrderForJinrongManageExample);
                if(!CollectionUtils.isEmpty(thOrderForJinrongManages)){

                    //如果不是管理员展示A的bak数据
                    if(!aBoolean){
                        for (ThOrderForJinrongManage orderManage : thOrderForJinrongManages) {
                            //用于给A展示的数据
                            orderManage.setZhuce(orderManage.getZhuce_bak());
                            orderManage.setXinhu(orderManage.getXinhu_bak());
                            orderManage.setJinjian(orderManage.getJinjian_bak());
                            orderManage.setJihuo(orderManage.getJihuo_bak());
                            orderManage.setShouxin(orderManage.getShouxin_bak());
                            orderManage.setHeka(orderManage.getHeka_bak());
                            orderManage.setXiakuan(orderManage.getXiakuan_bak());
                            orderManage.setXiakuan_amt(orderManage.getXiakuan_amt_bak());
                            orderManage.setShow_btn(0);//不展示按钮
                        }
                    }
                }
            }
            baseVO.setData(thOrderForJinrongManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThOrderForJinrongManageController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/batch_update")
    public BaseVO batch_update(@RequestParam("ids") String ids,
                               @RequestParam("operate_type") String perate_type,
                               @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(ids) ||StringUtils.isEmpty(account) ){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            String[] split = ids.split(",");
            for (String s : split) {
                ThOrderForJinrongManage orderManage = thOrderForJinrongManageMapper.selectByPrimaryKey(Long.valueOf(s));
                orderManage.setOperate_type(perate_type);
                orderManage.setGmt_modify(new Date());
                orderManage.setModifier_account(account);
                thOrderForJinrongManageMapper.updateByPrimaryKey(orderManage);
            }

            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThOrderManageController#edit error",e);
        }
        return baseVO;
    }

    private String ZHUCE="zhuce";
    private String XINHU="xinhu";
    private String JINJIAN="jinjian";
    private String JIHUO="jihuo";
    private String SHOUXIN="shouxin";
    private String HEKA="heka";
    private String XIAKUAN="xiakuan";
    private String XIAKUAN_AMT="xiakuan_amt";

    @RequestMapping("/batch_edit")
    public BaseVO batch_edit(@RequestParam("ids") String ids,
                               @RequestParam("ratio") Double ratio,
                               @RequestParam("column") String column,
                               @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(ids) ||StringUtils.isEmpty(account) ||StringUtils.isEmpty(column) ||ratio==null ){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            String[] split = ids.split(",");
            for (String s : split) {
                ThOrderForJinrongManage orderManage = thOrderForJinrongManageMapper.selectByPrimaryKey(Long.valueOf(s));

                if(ZHUCE.equals(column)){
                    String source = orderManage.getZhuce();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setZhuce_bak(format);
                    }
                }else if(XINHU.equals(column)){
                    String source = orderManage.getXinhu();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setXinhu_bak(format);
                    }

                }else if(JINJIAN.equals(column)){
                    String source = orderManage.getJinjian();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setJinjian_bak(format);
                    }
                }else if(JIHUO.equals(column)){
                    String source = orderManage.getJihuo();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setJihuo_bak(format);
                    }
                }else if(SHOUXIN.equals(column)){
                    String source = orderManage.getShouxin();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setShouxin_bak(format);
                    }
                }else if(HEKA.equals(column)){
                    String source = orderManage.getHeka();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setHeka_bak(format);
                    }
                }else if(XIAKUAN.equals(column)){
                    String source = orderManage.getXiakuan();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setXiakuan_bak(format);
                    }
                }else if(XIAKUAN_AMT.equals(column)){
                    String source = orderManage.getXiakuan_amt();
                    if(!StringUtils.isEmpty(source)){
                        Double target = Double.valueOf(source) * ratio;
                        String format = String.format("%.2f", target);
                        orderManage.setXiakuan_amt_bak(format);
                    }
                }
                orderManage.setGmt_modify(new Date());
                orderManage.setModifier_account(account);
                thOrderForJinrongManageMapper.updateByPrimaryKey(orderManage);
            }

            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThOrderManageController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(ThOrderForJinrongManage thOrderForJinrongManageNew,
                    @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(thOrderForJinrongManageNew.getOrder_code())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThOrderForJinrongManageExample example = new ThOrderForJinrongManageExample();
            example.createCriteria().andOrder_codeEqualTo(thOrderForJinrongManageNew.getOrder_code());
            List<ThOrderForJinrongManage> thOrderForJinrongManages = thOrderForJinrongManageMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(thOrderForJinrongManages)) {
                ThOrderForJinrongManage thOrderForJinrongManage = thOrderForJinrongManages.get(0);
                thOrderForJinrongManage.setGmt_modify(new Date());
                thOrderForJinrongManage.setModifier_account(account);
                BeanUtils.copyProperties(thOrderForJinrongManageNew, thOrderForJinrongManage);
                thOrderForJinrongManageMapper.updateByPrimaryKey(thOrderForJinrongManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThOrderForJinrongManageController#edit error",e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(@RequestParam("menuName") String menuName,
                               @RequestParam("group") String group,
                                @RequestParam("icon") String icon,
                               @RequestParam("url") String url,
                               @RequestParam("account") String account) {

        BaseVO baseVO = new BaseVO();
        try {
            if( StringUtils.isEmpty(menuName) ||
                    StringUtils.isEmpty(url)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThOrderForJinrongManage thOrderForJinrongManage = new ThOrderForJinrongManage();
            thOrderForJinrongManage.setCreator_account(account);
            thOrderForJinrongManage.setModifier_account(account);
            thOrderForJinrongManage.setGmt_create(new Date());
            thOrderForJinrongManage.setGmt_modify(new Date());
            thOrderForJinrongManageMapper.insert(thOrderForJinrongManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThOrderForJinrongManageController#add error",e);
            baseVO.setSuccess(false);
            String msg = "";
            if(StringUtils.isNotEmpty(e.getMessage())&&e.getMessage().contains("Duplicate")){
                msg="请勿重复添加！";
            }
            baseVO.setErrorMsg("添加异常"+msg);
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("order_code") String order_code ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(order_code)){
                baseVO.setErrorMsg("order_code为不能为空！");
                baseVO.setSuccess(false);
            }else {
                ThOrderForJinrongManageExample thOrderForJinrongManageExample = new ThOrderForJinrongManageExample();
                thOrderForJinrongManageExample.createCriteria().andOrder_codeEqualTo(order_code);
                List<ThOrderForJinrongManage> thOrderForJinrongManages = thOrderForJinrongManageMapper.selectByExample(thOrderForJinrongManageExample);
                if(!CollectionUtils.isEmpty(thOrderForJinrongManages)){
                    baseVO.setData(thOrderForJinrongManages.get(0));
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThOrderForJinrongManageController#get Exception input param is order_code="+order_code,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }
    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("order_code") String order_code ) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(order_code)){
                baseVO.setErrorMsg("code为不能为空！");
                baseVO.setSuccess(false);
            }else {
                ThOrderForJinrongManageExample example = new ThOrderForJinrongManageExample();
                example.createCriteria().andOrder_codeEqualTo(order_code);
                thOrderForJinrongManageMapper.deleteByExample(example);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThOrderForJinrongManageController#get Exception input param is order_code:"+order_code,e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("操作异常！");
        }
        return baseVO;
    }
    @Resource
    private ThUrlManageMapper thUrlManageMapper;

    @RequestMapping("/import")
    public BaseVO StringinstallExcel(@RequestParam("account") String account,
                                     @RequestParam(value = "file", required = false) MultipartFile file) {
        BaseVO baseVO = new BaseVO();
        StringBuffer sb = new StringBuffer();
        String picihao=UUIDUtils.UUID();
        try {
            String fname = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            Workbook wb = null;
            if (fname.endsWith("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fname.endsWith("xlsx")) {
                wb = new XSSFWorkbook(is);
            }
            List<ThOrderForJinrongManage> list = new ArrayList<ThOrderForJinrongManage>();
            if (wb != null) {
                for (int sheetNum = 0; sheetNum < wb.getNumberOfSheets(); sheetNum++) {
                    Sheet sheet = wb.getSheetAt(sheetNum);
                    if (sheet == null) {
                        continue;
                    }
                    //获得当前sheet的开始行
                    int firstRowNum = sheet.getFirstRowNum();
                    int lastRowNum = sheet.getLastRowNum();

                    //行
                    for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
                        Row row = sheet.getRow(rowNum);
                        if (row == null) {
                            continue;
                        }

                        //获得当前行的开始列
                        int firstCellNum = row.getFirstCellNum();
                        int lastCellNum = row.getLastCellNum();
                        ThOrderForJinrongManage orderManage = new ThOrderForJinrongManage();
                        //字段数
                        String[] str = new String[11];

                        //列

                        for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                            Cell cell = row.getCell(cellNum);
                            String cellValue = "";
                            if (cell == null) {
                                str[cellNum] = cellValue;
                            } else {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    cell.setCellType(cell.CELL_TYPE_STRING);
                                }
                                switch (cell.getCellType()) {
                                    case Cell.CELL_TYPE_NUMERIC:
                                        cellValue = String.valueOf(cell.getNumericCellValue());
                                        break;
                                    case Cell.CELL_TYPE_STRING:
                                        cellValue = String.valueOf(cell.getStringCellValue());
                                        break;
                                    case Cell.CELL_TYPE_FORMULA:
                                        cellValue = String.valueOf(cell.getCellFormula());
                                        break;
                                    case Cell.CELL_TYPE_BLANK:
                                        cellValue = "";
                                        break;
                                    case Cell.CELL_TYPE_ERROR:
                                        cellValue = "非法字符";
                                        break;
                                    default:
                                        cellValue = "未知字符";
                                        break;

                                }
                                str[cellNum] = cellValue;

                            }
                        }
                        //日期，产品名称，渠道码，注册，新户，进件，激活，授信，核卡，下款，下款金额。
                        orderManage.setOperate_type("下线");
                        orderManage.setOrder_code(UUIDUtils.UUID());
                        orderManage.setOrder_time(str[0]);
                        orderManage.setProduct_name(str[1]);
                        orderManage.setChannel_code(str[2]);
                        orderManage.setZhuce(str[3]);
                        orderManage.setXinhu(str[4]);
                        orderManage.setJinjian(str[5]);
                        orderManage.setJihuo(str[6]);
                        orderManage.setShouxin(str[7]);
                        orderManage.setHeka(str[8]);
                        orderManage.setXiakuan(str[9]);
                        orderManage.setXiakuan_amt(str[10]);

                        //用于给A展示的数据
                        orderManage.setZhuce_bak(str[3]);
                        orderManage.setXinhu_bak(str[4]);
                        orderManage.setJinjian_bak(str[5]);
                        orderManage.setJihuo_bak(str[6]);
                        orderManage.setShouxin_bak(str[7]);
                        orderManage.setHeka_bak(str[8]);
                        orderManage.setXiakuan_bak(str[9]);
                        orderManage.setXiakuan_amt_bak(str[10]);

                        orderManage.setPicihao(picihao);

                        //根据渠道编码查询该数据是属于哪个A推荐出去的
                        //todo 后面需要考虑渠道b怎么区分。owner_1_account 代表管理员将链接分给A，owner_account代表A分给b
                        if(!StringUtils.isEmpty(str[2])){
                            ThUrlManageExample example = new ThUrlManageExample();
                            example.createCriteria()
                                    .andChannel_codeEqualTo(str[2]);
                            List<ThUrlManage> thUrlManages = thUrlManageMapper.selectByExample(example);
                            if(!CollectionUtils.isEmpty(thUrlManages)){
                                ThUrlManage thUrlManage = thUrlManages.get(0);
                                orderManage.setChannel_account(thUrlManage.getOwner_1_account());
                            }
                        }

                        orderManage.setCreator_account(account);
                        orderManage.setModifier_account(account);
                        orderManage.setGmt_create(new Date());
                        orderManage.setGmt_modify(new Date());
                        list.add(orderManage);
                    }

                    if(!CollectionUtils.isEmpty(list)){
                        for (int i=0;i<list.size();i++) {
                            try {
                                thOrderForJinrongManageMapper.insert(list.get(i));
                            }catch (Exception e) {
                                sb.append("第"+(i+1)+"条导入失败；失败原因:"+e.getMessage());
                            }
                        }
                    }
                }

            }
            baseVO = BaseVO.createSuccess();
            String result="";
            if(sb.length()>500){
                result = sb.substring(0,500)+"...";
            }else{
                result = sb.toString();
            }
            baseVO.setErrorMsg(result);
            baseVO.setData(picihao);
            return baseVO;
        } catch (Exception e) {
            LOG.error("CarTypeController#import error", e);
            return BaseVO.createFailure("导入失败，请检查数据格式后再试！");
        }
    }

}
