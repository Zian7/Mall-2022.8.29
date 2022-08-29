笔记：
第一章 整合SpringBoot和MyBatis搭建基本骨架
·日志工具logger的使用方法：
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);
·实用工具类库common-util使用：
    ·用处：统一数据返回格式
    ·common-util 这个工具库为我们提供了一个现成的通用返回数据封装类 CommonResult，如：
        @RequestMapping(value = "listAll",method = RequestMethod.GET)
        @ResponseBody
        public CommonResult<List<PmsBrand>> getBrandList(){
              return CommonResult.success(demoService.listAllBrand());
               }
               
        又如：
        @RestController
        public class HelloController {
          @RequestMapping("/test")
           public CommonResult test() {
                  return CommonResult.ok();
                   }
            }
        ·返回数据都应该包含类似如下几个信息：
            success：标识请求成功与否，如：true（成功）、false（失败）
            code：错误码，如果异常的话则为明确错误码，从而更好的对应业务异常。如果请求成功该值可为空或者“0000”
            message：错误消息，与错误码相对应，更具体的描述异常信息。
            data：返回结果，通常是 Bean 对象对应的 JSON 数据，通常为了应对不同返回值类型，将其声明为泛型类型
            timestamp：执行时间戳
            
# Mall-2022.8.29
今天是Mall的项目学习的第一天，资源来自https://www.macrozheng.com/mall/catalog/mall_catalog.html
MyBatis之前没学过，边做尽量多看点书。各种环境配置还没配全，就跳过去了。ppagehelper、druid等等，到后面慢慢整理。
之前学的springboot没学完，边学多复习下。
