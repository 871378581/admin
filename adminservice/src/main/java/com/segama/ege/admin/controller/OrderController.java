package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThOrderManage;
import com.segama.ege.entity.ThOrderManageExample;
import com.segama.ege.entity.ThUrlManage;
import com.segama.ege.entity.ThUrlManageExample;
import com.segama.ege.repository.ThOrderManageMapper;
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
@RequestMapping("/ege/api/admin/order")
@CrossOrigin(origins = "*", maxAge = 3600)
public class OrderController extends BaseController {
    @Resource
    private ThOrderManageMapper thOrderManageMapper;

    private static Logger LOG = LoggerFactory.getLogger(OrderController.class);

    @RequestMapping("/list")
    public BaseVO list(
            ThOrderManage thOrderManage
            ,@RequestParam("account") String account
            ,@RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            ThOrderManageExample thOrderManageExample = new ThOrderManageExample();
            ThOrderManageExample.Criteria thOrderManageExampleCriteria = thOrderManageExample.createCriteria();
            if(StringUtils.isNotEmpty(thOrderManage.getGood_name())) {
                thOrderManageExampleCriteria.andGood_nameLike("%" + thOrderManage.getGood_name() + "%");
            }
            if(StringUtils.isNotEmpty(thOrderManage.getPicihao())) {
                thOrderManageExampleCriteria.andPicihaoEqualTo( thOrderManage.getPicihao() );
            }
            if(StringUtils.isNotEmpty(thOrderManage.getOperate_type())) {
                thOrderManageExampleCriteria.andOperate_typeEqualTo( thOrderManage.getOperate_type() );
            }
            if(!StringUtils.isEmpty(thOrderManage.getOrder_time())){
                String[] time = thOrderManage.getOrder_time().split(" - ");
                thOrderManageExampleCriteria.andOrder_timeBetween(time[0],time[1]);
            }
            Boolean aBoolean = showAllUser(account);
            if(!aBoolean){
                //只能查看自己的operateType=1的数据
                thOrderManageExampleCriteria.andOperate_typeEqualTo("上线");
                thOrderManageExampleCriteria.andChannel_accountEqualTo(account);
            }
            int count = thOrderManageMapper.countByExample(thOrderManageExample);
            thOrderManageExample.setPageCount(pageSize);
            thOrderManageExample.setPageIndex(pageIndex);
            thOrderManageExample.setOrderByClause("gmt_create desc");
            List<ThOrderManage> thOrderManages = Lists.newArrayList();
            if(count>0) {
                thOrderManages = thOrderManageMapper.selectByExample(thOrderManageExample);
                if(!CollectionUtils.isEmpty(thOrderManages)){
                    for (ThOrderManage orderManage : thOrderManages) {
                        if(!showAllUser(account)) {
                            orderManage.setShow_btn(0);//不显示按钮
                        }else {
                            orderManage.setShow_btn(1);//显示按钮
                        }
                    }
                }
            }
            baseVO.setData(thOrderManages);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        }catch (Exception e){
            baseVO.setSuccess(false);
            LOG.error("ThOrderManageController#list error",e);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(ThOrderManage thOrderManageNew,
                    @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(thOrderManageNew.getOrder_code())){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            ThOrderManageExample example = new ThOrderManageExample();
            example.createCriteria().andOrder_codeEqualTo(thOrderManageNew.getOrder_code());
            List<ThOrderManage> thOrderManages = thOrderManageMapper.selectByExample(example);
            if(!CollectionUtils.isEmpty(thOrderManages)) {
                ThOrderManage thOrderManage = thOrderManages.get(0);
                thOrderManage.setGmt_modify(new Date());
                thOrderManage.setModifier_account(account);
                BeanUtils.copyProperties(thOrderManageNew, thOrderManage);
                thOrderManageMapper.updateByPrimaryKey(thOrderManage);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThOrderManageController#edit error",e);
        }
        return baseVO;
    }


    @RequestMapping("/batch_update")
    public BaseVO batch_update(@RequestParam("ids") String ids,
                               @RequestParam("operate_type") String perate_type,
                       @RequestParam("account") String account) {
        BaseVO baseVO = new BaseVO();
        try {
            if(StringUtils.isEmpty(ids) ||StringUtils.isEmpty(account)){
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            String[] split = ids.split(",");
            for (String s : split) {
                ThOrderManage orderManage = thOrderManageMapper.selectByPrimaryKey(Long.valueOf(s));
                orderManage.setOperate_type(perate_type);
                orderManage.setGmt_modify(new Date());
                orderManage.setModifier_account(account);
                thOrderManageMapper.updateByPrimaryKey(orderManage);
            }

            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("ThOrderManageController#edit error",e);
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
            ThOrderManage thOrderManage = new ThOrderManage();
            thOrderManage.setCreator_account(account);
            thOrderManage.setModifier_account(account);
            thOrderManage.setGmt_create(new Date());
            thOrderManage.setGmt_modify(new Date());
            thOrderManageMapper.insert(thOrderManage);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThOrderManageController#add error",e);
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
                ThOrderManageExample thOrderManageExample = new ThOrderManageExample();
                thOrderManageExample.createCriteria().andOrder_codeEqualTo(order_code);
                List<ThOrderManage> thOrderManages = thOrderManageMapper.selectByExample(thOrderManageExample);
                if(!CollectionUtils.isEmpty(thOrderManages)){
                    baseVO.setData(thOrderManages.get(0));
                }
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThOrderManageController#get Exception input param is order_code="+order_code,e);
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
                ThOrderManageExample example = new ThOrderManageExample();
                example.createCriteria().andOrder_codeEqualTo(order_code);
                thOrderManageMapper.deleteByExample(example);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ThOrderManageController#get Exception input param is order_code:"+order_code,e);
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
        String picihao=UUIDUtils.UUID();
        StringBuffer sb = new StringBuffer();
        try {
            String fname = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            Workbook wb = null;
            if (fname.endsWith("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fname.endsWith("xlsx")) {
                wb = new XSSFWorkbook(is);
            }
            List<ThOrderManage> list = new ArrayList<ThOrderManage>();
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
                        ThOrderManage orderManage = new ThOrderManage();
                        String[] str = new String[19];

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
                        orderManage.setOperate_type("下线");
                        orderManage.setOrder_code(UUIDUtils.UUID());
                        orderManage.setOrder_time(str[0]);
                        orderManage.setOrder_phone_number(str[1]);
                        orderManage.setProv(str[2]);
                        orderManage.setCity(str[3]);
                        orderManage.setOrder_status(str[4]);
                        orderManage.setCustomer_name(str[5]);
                        orderManage.setCertificate_type(str[6]);
                        orderManage.setCertificate_num(str[7]);
                        orderManage.setCustomer_contact_num(str[8]);
                        orderManage.setGood_name(str[9]);
                        orderManage.setAddress(str[10]);
                        orderManage.setActive_status(str[11]);
                        orderManage.setCudian_code(str[12]);
                        orderManage.setShoucong_amt(str[13]);
                        orderManage.setShoucong_time(str[14]);
                        orderManage.setXiehaozhuanwang_type(str[15]);
                        orderManage.setZhuanhualvtichu_reason(str[16]);
                        orderManage.setChannel_code(str[17]);
                        orderManage.setOrder_id(str[18]);
                        orderManage.setPicihao(picihao);

                        //根据渠道编码查询该数据是属于哪个A推荐出去的
                        //todo 后面需要考虑渠道b怎么区分。owner_1_account 代表管理员将链接分给A，owner_account代表A分给b
                        if(!StringUtils.isEmpty(str[17])){
                            ThUrlManageExample example = new ThUrlManageExample();
                            example.createCriteria()
                                    .andChannel_codeEqualTo(str[17]);
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
                                ThOrderManageExample example = new ThOrderManageExample();
                                example.createCriteria().andOrder_idEqualTo(list.get(i).getOrder_id());
                                List<ThOrderManage> thOrderManages = thOrderManageMapper.selectByExample(example);
                                if(!CollectionUtils.isEmpty(thOrderManages)){
                                    ThOrderManage orderManage = thOrderManages.get(0);
                                    ThOrderManage source = list.get(i);
                                    source.setModifier_account(null);
                                    source.setGmt_modify(null);
                                    source.setGmt_create(null);
                                    source.setCreator_account(null);
                                    BeanUtils.copyProperties(source, orderManage);
                                    orderManage.setGmt_modify(new Date());
                                    orderManage.setModifier_account(account);
                                    thOrderManageMapper.updateByPrimaryKey(orderManage);
                                }else{
                                    if(!StringUtils.isEmpty(list.get(i).getOrder_id())) {
                                        thOrderManageMapper.insert(list.get(i));
                                    }
                                }
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
