package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.segama.ege.admin.utils.BeanUtils;
import com.segama.ege.admin.utils.UUIDUtils;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.entity.ThOrderForJinrongManage;
import com.segama.ege.entity.ThOrderForJinrongManageExample;
import com.segama.ege.entity.ThUrlManage;
import com.segama.ege.entity.ThUrlManageExample;
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
                thOrderForJinrongManageExampleCriteria.andOperate_typeEqualTo("1");
                thOrderForJinrongManageExampleCriteria.andChannel_accountEqualTo(account);
            }
            int count = thOrderForJinrongManageMapper.countByExample(thOrderForJinrongManageExample);
            thOrderForJinrongManageExample.setPageCount(pageSize);
            thOrderForJinrongManageExample.setPageIndex(pageIndex);
            thOrderForJinrongManageExample.setOrderByClause("gmt_create desc");
            List<ThOrderForJinrongManage> thOrderForJinrongManages = Lists.newArrayList();
            if(count>0) {
                thOrderForJinrongManages = thOrderForJinrongManageMapper.selectByExample(thOrderForJinrongManageExample);
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
                            } catch (NumberFormatException e) {
                                sb.append("第"+(i+1)+"条导入失败；失败原因:类目等级必须为数字;\n");
                            }catch (Exception e) {
                                if(e.getMessage().contains("category_code_UNIQUE")){
                                    sb.append("第"+(i+1)+"条导入失败；失败原因:类目编码重复\n");
                                }else{
                                    sb.append("第"+(i+1)+"条导入失败；失败原因:系统忙请稍后再试！\n");
                                }
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
            return baseVO;
        } catch (Exception e) {
            LOG.error("CarTypeController#import error", e);
            return BaseVO.createFailure("导入失败，请检查数据格式后再试！");
        }
    }

}
