package com.segama.ege.admin.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.segama.ege.admin.utils.PinYinUtil;
import com.segama.ege.admin.vo.BaseVO;
import com.segama.ege.admin.vo.CarTypeVO;
import com.segama.ege.entity.CarType;
import com.segama.ege.entity.CarTypeExample;
import com.segama.ege.entity.ProvCityArea;
import com.segama.ege.entity.ProvCityAreaExample;
import com.segama.ege.repository.CarTypeMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.*;

/**
 * @author hxj
 * @version 1.0
 * @Description 车型配置相关的接口
 * @date 2019-10-07 14:33
 */
@RestController
@RequestMapping("/ege/api/admin/car_type")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CarTypeController {
    @Resource
    private CarTypeMapper carTypeMapper;

    private static Logger LOG = LoggerFactory.getLogger(CarTypeController.class);

    @RequestMapping("/list")
    public BaseVO list(
            @RequestParam("brand") String brand
            , @RequestParam("limit") Integer pageSize,
            @RequestParam("page") Integer pageIndex) {
        BaseVO baseVO = new BaseVO();
        try {
            CarTypeExample carTypeExample = new CarTypeExample();
            CarTypeExample.Criteria carTypeExampleCriteria = carTypeExample.createCriteria();
            if (!StringUtils.isEmpty(brand)) {
                carTypeExampleCriteria.andBrandLike("%" + brand + "%");
            }
            int count = carTypeMapper.countByExample(carTypeExample);
            carTypeExample.setPageCount(pageSize);
            carTypeExample.setPageIndex(pageIndex);
            carTypeExample.setOrderByClause("gmt_create desc");
            List<CarType> carTypes = carTypeMapper.selectByExample(carTypeExample);
            baseVO.setData(carTypes);
            baseVO.setSuccess(true);
            baseVO.setCount(count);
            baseVO.setCode(0);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            LOG.error("AdminRoleController#list error", e);
        }
        return baseVO;
    }

    @RequestMapping("/delete")
    public BaseVO delete(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        if (id == null) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("id为空不能删除！");
        } else {
            carTypeMapper.deleteByPrimaryKey(id);
            baseVO.setSuccess(true);
        }
        return baseVO;
    }

    @RequestMapping("/edit")
    public BaseVO edit(@RequestParam("id") Long id,
                       @RequestParam("account") String account,
                       @RequestParam("brand") String brand,
                      // @RequestParam("brand_code") String brand_code,
                       @RequestParam("car_style") String car_style,
                     //  @RequestParam("car_style_code") String car_style_code,
                    //   @RequestParam("car_type_code") String car_type_code,
                       @RequestParam("car_type") String car_type
                    //   @RequestParam("brand_first_letter") String brand_first_letter
                    //   @RequestParam("category_code") String category_code,
                    //   @RequestParam("category_name") String category_name,
                    //   @RequestParam("category_level") Long category_level,
                    //   @RequestParam("parent_category_code") String parent_category_code,
                    //   @RequestParam("logo_url") String logo_url
    ) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null ) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }
            CarType carType = carTypeMapper.selectByPrimaryKey(id);

            if (!StringUtils.isEmpty(brand)) {
                carType.setBrand(brand);
                carType.setBrand_code("brand_"+brand.hashCode());
                carType.setBrand_first_letter(PinYinUtil.getPYIndexStr(brand.substring(0,1),true));
            }

            if (!StringUtils.isEmpty(car_type)) {
                carType.setCar_type(car_type);
                carType.setCar_type_code("type_"+car_type.hashCode());
            }
            if (!StringUtils.isEmpty(car_style)) {
                carType.setCar_style(car_style);
                carType.setCar_style_code("style_"+car_style.hashCode());
            }

            /*if (!StringUtils.isEmpty(brand_code)) {
                carType.setBrand_code(brand_code);
            }*/
            /*if (!StringUtils.isEmpty(car_type_code)) {
                carType.setCar_type_code(car_type_code);
            }*/
           /* if (!StringUtils.isEmpty(car_style_code)) {
                carType.setCar_style_code(car_style_code);
            }*/

            /*if (!StringUtils.isEmpty(category_name)) {
                carType.setCategory_name(category_name);
            }
            if (!StringUtils.isEmpty(category_code)) {
                carType.setCategory_code(category_code);
            }
            if (!StringUtils.isEmpty(parent_category_code)) {
                carType.setParent_category_code(parent_category_code);
            }
            if (category_level != null) {
                carType.setCategory_level(category_level);
            }
            if (!StringUtils.isEmpty(logo_url)) {
                carType.setLogo_url(logo_url);
            }*/
            carType.setGmt_modify(new Date());
            carType.setModifier_account(account);
            carTypeMapper.updateByPrimaryKey(carType);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("编辑异常！");
            LOG.error("CarTypeController#edit error", e);
        }
        return baseVO;
    }

    @RequestMapping("/add")
    public BaseVO add(
            @RequestParam("account") String account,
            @RequestParam("brand") String brand,
           // @RequestParam("brand_first_letter") String brand_first_letter,
          //  @RequestParam("category_code") String category_code,
          //  @RequestParam("category_name") String category_name,
          //  @RequestParam("category_level") Long category_level,
          //  @RequestParam("parent_category_code") String parent_category_code,
          //  @RequestParam("logo_url") String logo_url,
          //  @RequestParam("brand_code") String brand_code,
              @RequestParam("car_style") String car_style,
          //  @RequestParam("car_style_code") String car_style_code,
          //  @RequestParam("car_type_code") String car_type_code,
              @RequestParam("car_type") String car_type
    ) {
        BaseVO baseVO = new BaseVO();
        try {
            if (StringUtils.isEmpty(brand)) {
                baseVO.setErrorMsg("请检查必填参数是否填写完整！");
                baseVO.setSuccess(false);
                return baseVO;
            }

            CarType carType = new CarType();
            if (!StringUtils.isEmpty(brand)) {
                carType.setBrand(brand);
                carType.setBrand_code("brand_"+brand.hashCode());
                carType.setBrand_first_letter(PinYinUtil.getPYIndexStr(brand.substring(0,1),true));
            }

            if (!StringUtils.isEmpty(car_type)) {
                carType.setCar_type(car_type);
                carType.setCar_type_code("type_"+car_type.hashCode());
            }
            if (!StringUtils.isEmpty(car_style)) {
                carType.setCar_style(car_style);
                carType.setCar_style_code("style_"+car_style.hashCode());
            }

            /*if (!StringUtils.isEmpty(category_name)) {
                carType.setCategory_name(category_name);
            }
            if (!StringUtils.isEmpty(category_code)) {
                carType.setCategory_code(category_code);
            }
            if (!StringUtils.isEmpty(parent_category_code)) {
                carType.setParent_category_code(parent_category_code);
            }
            if (category_level != null) {
                carType.setCategory_level(category_level);
            }
            if (!StringUtils.isEmpty(logo_url)) {
                carType.setLogo_url(logo_url);
            }*/
            carType.setCreator_account(account);
            carType.setModifier_account(account);
            carType.setGmt_create(new Date());
            carType.setGmt_modify(new Date());
            carTypeMapper.insert(carType);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("CarTypeController#add error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("添加异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get")
    public BaseVO get(@RequestParam("id") Long id) {
        BaseVO baseVO = new BaseVO();
        try {
            if (id == null) {
                baseVO.setErrorMsg("id为不能为空！");
                baseVO.setSuccess(false);
            } else {
                CarType carType = carTypeMapper.selectByPrimaryKey(id);
                baseVO.setData(carType);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("CarTypeController#get Exception input param is id:" + id, e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

    @RequestMapping("/get_all_car_type")
    public BaseVO getAllMenu() {
        BaseVO baseVO = new BaseVO();
        try {
            List<CarType> carTypes = carTypeMapper.selectByExample(new CarTypeExample());
            List<Map<String, Object>> result = Lists.newArrayList();
            if (!CollectionUtils.isEmpty(carTypes)) {
                for (CarType carType : carTypes) {
                    Map<String, Object> map = Maps.newHashMap();
                    map.put("label", carType.getCategory_code());
                    map.put("value", carType.getCategory_name());
                    result.add(map);
                }
            }
            baseVO.setData(result);
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("CarTypeController#getAllMenu error", e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

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
            List<CarType> list = new ArrayList<CarType>();
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
                        CarType carType = new CarType();
                        String[] str = new String[row.getPhysicalNumberOfCells()];

                        //列

                        for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
                            Cell cell = row.getCell(cellNum);
                            String cellValue = "";
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
                        if(StringUtils.isEmpty(str[0])){
                            continue;
                        }
                        carType.setBrand(str[1]);
                        carType.setBrand_code("brand_"+str[1].hashCode());
                        carType.setBrand_first_letter(PinYinUtil.getPYIndexStr(str[1].substring(0,1),true));
                        carType.setCar_type(str[2]);
                        carType.setCar_type_code("type_"+str[2].hashCode());
                        carType.setCar_style(str[3]);
                        carType.setCar_style_code("style_"+str[3].hashCode());

                        carType.setCreator_account(account);
                        carType.setModifier_account(account);
                        carType.setGmt_create(new Date());
                        carType.setGmt_modify(new Date());
                        list.add(carType);
                    }

                    if(!CollectionUtils.isEmpty(list)){
                        for (int i=0;i<list.size();i++) {

                            try {
                                carTypeMapper.insert(list.get(i));
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

    public static List<Map<String,Object>> carTypeLists = Lists.newArrayList();
    @RequestMapping("/get_car_type")
    public BaseVO getCarType() {
        BaseVO baseVO = new BaseVO();
        try {
            if(!CollectionUtils.isEmpty(carTypeLists)){
                baseVO.setData(carTypeLists);
            }else {
                CarTypeExample carTypeExample = new CarTypeExample();
                int count = carTypeMapper.countByExample(carTypeExample);
                int pageCount = (count % 30 == 0) ? (count / 30) : (count / 30 + 1);
                List<CarType> carTypeList = Lists.newArrayList();
                for (int p = 1; p <= pageCount; p++) {
                    carTypeExample.setPageIndex(p);
                    carTypeExample.setPageCount(30);
                    List<CarType> carTypes = carTypeMapper.selectByExample(carTypeExample);
                    if (!CollectionUtils.isEmpty(carTypes)) {
                        carTypeList.addAll(carTypes);
                    }
                }

                List<Map<String, Object>> result = Lists.newArrayList();
                if (!CollectionUtils.isEmpty(carTypeList)) {
                    Set<CarTypeVO> carTypeVOS = Sets.newHashSet();
                    for (CarType carType : carTypeList) {
                        CarTypeVO carTypeVO = new CarTypeVO();
                        BeanUtils.copyProperties(carType, carTypeVO);
                        carTypeVOS.add(carTypeVO);
                    }
                    for (CarTypeVO carTypeVO : carTypeVOS) {
                        Map<String, Object> map = Maps.newHashMap();
                        map.put("label", carTypeVO.getCar_type());
                        map.put("value", carTypeVO.getId());
                        result.add(map);
                    }
                }
                carTypeLists.addAll(result);
                baseVO.setData(result);
            }
            baseVO.setSuccess(true);
        } catch (Exception e) {
            LOG.error("ProvCityAreaController#getAllMenu error",e);
            baseVO.setSuccess(false);
            baseVO.setErrorMsg("查询信息异常！");
        }
        return baseVO;
    }

}
