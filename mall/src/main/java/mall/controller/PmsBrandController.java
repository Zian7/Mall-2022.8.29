package mall.controller;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.service.PmsBrandService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 品牌Controller
 */
@Controller
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandController demoService;

    //日志工具
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
    //commonresult 统一返回数据格式
    @RequestMapping(value = "listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(demoService.listAllBrand());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBrand(@RequestBody PmsBrand pmsBrand) {
        CommonResult commonResult;
        int count = demoService.createBrand(pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}",pmsBrand);
        }else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed:{}",pmsBrand);
        }
        return commonResult;
    }

    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id,@RequestBody PmsBrand pmsBrandDto,BingdingResult result){
        CommonResult commonResult;
        int count = demoService.updateBrand(id,pmsBrandDto);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.debug("updateBrand success:{}",pmsBrandDto);
        }else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateBrand failed:{}",pmsBrandDto);
        }
        return commonResult;
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable ("id") Long id) {
        int count = demoService.deleteBrand(id);
        if(count == 1){
            LOGGER.debug("deleteBrand success: id ={}",id);
            return CommonResult.success(null);
        }else{
            LOGGER.debug("deleteBrand failed:id = {}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @RequestMapping()
    @ResponseBody
    public CommonResult (){

    }
}
