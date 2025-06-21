
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 贫困户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/pinkunhu")
public class PinkunhuController {
    private static final Logger logger = LoggerFactory.getLogger(PinkunhuController.class);

    private static final String TABLE_NAME = "pinkunhu";

    @Autowired
    private PinkunhuService pinkunhuService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private GonggaoService gonggaoService;//助农政策
    @Autowired
    private GongzuorenyuanService gongzuorenyuanService;//工作人员
    @Autowired
    private NewsService newsService;//农产品经济数据信息
    @Autowired
    private NongchanpinService nongchanpinService;//农产品
    @Autowired
    private NongchanpinXiaoshouService nongchanpinXiaoshouService;//农产品售卖
    @Autowired
    private SingleSeachService singleSeachService;//单页数据
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("贫困户".equals(role))
            params.put("pinkunhuId",request.getSession().getAttribute("userId"));
        else if("工作人员".equals(role))
            params.put("gongzuorenyuanId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = pinkunhuService.queryPage(params);

        //字典表数据转换
        List<PinkunhuView> list =(List<PinkunhuView>)page.getList();
        for(PinkunhuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PinkunhuEntity pinkunhu = pinkunhuService.selectById(id);
        if(pinkunhu !=null){
            //entity转view
            PinkunhuView view = new PinkunhuView();
            BeanUtils.copyProperties( pinkunhu , view );//把实体数据重构到view中
            //级联表 工作人员
            //级联表
            GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(pinkunhu.getGongzuorenyuanId());
            if(gongzuorenyuan != null){
            BeanUtils.copyProperties( gongzuorenyuan , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "gongzuorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setGongzuorenyuanId(gongzuorenyuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody PinkunhuEntity pinkunhu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,pinkunhu:{}",this.getClass().getName(),pinkunhu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("工作人员".equals(role))
            pinkunhu.setGongzuorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<PinkunhuEntity> queryWrapper = new EntityWrapper<PinkunhuEntity>()
            .eq("username", pinkunhu.getUsername())
            .or()
            .eq("pinkunhu_phone", pinkunhu.getPinkunhuPhone())
            .or()
            .eq("pinkunhu_id_number", pinkunhu.getPinkunhuIdNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PinkunhuEntity pinkunhuEntity = pinkunhuService.selectOne(queryWrapper);
        if(pinkunhuEntity==null){
            pinkunhu.setCreateTime(new Date());
            pinkunhu.setPassword("123456");
            pinkunhuService.insert(pinkunhu);
            return R.ok();
        }else {
            return R.error(511,"账户或者手机号或者家庭住址已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody PinkunhuEntity pinkunhu, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,pinkunhu:{}",this.getClass().getName(),pinkunhu.toString());
        PinkunhuEntity oldPinkunhuEntity = pinkunhuService.selectById(pinkunhu.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("工作人员".equals(role))
//            pinkunhu.setGongzuorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(pinkunhu.getPinkunhuPhoto()) || "null".equals(pinkunhu.getPinkunhuPhoto())){
                pinkunhu.setPinkunhuPhoto(null);
        }

            pinkunhuService.updateById(pinkunhu);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<PinkunhuEntity> oldPinkunhuList =pinkunhuService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        pinkunhuService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer pinkunhuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<PinkunhuEntity> pinkunhuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            PinkunhuEntity pinkunhuEntity = new PinkunhuEntity();
//                            pinkunhuEntity.setUsername(data.get(0));                    //账户 要改的
//                            //pinkunhuEntity.setPassword("123456");//密码
//                            pinkunhuEntity.setGongzuorenyuanId(Integer.valueOf(data.get(0)));   //工作人员 要改的
//                            pinkunhuEntity.setPinkunhuName(data.get(0));                    //姓名 要改的
//                            pinkunhuEntity.setPinkunhuPhone(data.get(0));                    //手机号 要改的
//                            pinkunhuEntity.setPinkunhuAddress(data.get(0));                    //身份证号 要改的
//                            pinkunhuEntity.setPinkunhuIdNumber(data.get(0));                    //家庭住址 要改的
//                            pinkunhuEntity.setPinkunhuPhoto("");//详情和图片
//                            pinkunhuEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            pinkunhuEntity.setPinkunhuEmail(data.get(0));                    //电子邮箱 要改的
//                            pinkunhuEntity.setPinkunhuChengyuanText(data.get(0));                    //家庭成员 要改的
//                            pinkunhuEntity.setYonghuNianshouru(data.get(0));                    //年收入 要改的
//                            pinkunhuEntity.setEwaishouruTypes(Integer.valueOf(data.get(0)));   //是否有额外收入 要改的
//                            pinkunhuEntity.setYunshukunnanTypes(Integer.valueOf(data.get(0)));   //是否存在运输困难 要改的
//                            pinkunhuEntity.setCreateTime(date);//时间
                            pinkunhuList.add(pinkunhuEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //手机号
                                if(seachFields.containsKey("pinkunhuPhone")){
                                    List<String> pinkunhuPhone = seachFields.get("pinkunhuPhone");
                                    pinkunhuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> pinkunhuPhone = new ArrayList<>();
                                    pinkunhuPhone.add(data.get(0));//要改的
                                    seachFields.put("pinkunhuPhone",pinkunhuPhone);
                                }
                                //家庭住址
                                if(seachFields.containsKey("pinkunhuIdNumber")){
                                    List<String> pinkunhuIdNumber = seachFields.get("pinkunhuIdNumber");
                                    pinkunhuIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> pinkunhuIdNumber = new ArrayList<>();
                                    pinkunhuIdNumber.add(data.get(0));//要改的
                                    seachFields.put("pinkunhuIdNumber",pinkunhuIdNumber);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<PinkunhuEntity> pinkunhuEntities_username = pinkunhuService.selectList(new EntityWrapper<PinkunhuEntity>().in("username", seachFields.get("username")));
                        if(pinkunhuEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PinkunhuEntity s:pinkunhuEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //手机号
                        List<PinkunhuEntity> pinkunhuEntities_pinkunhuPhone = pinkunhuService.selectList(new EntityWrapper<PinkunhuEntity>().in("pinkunhu_phone", seachFields.get("pinkunhuPhone")));
                        if(pinkunhuEntities_pinkunhuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PinkunhuEntity s:pinkunhuEntities_pinkunhuPhone){
                                repeatFields.add(s.getPinkunhuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [手机号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //家庭住址
                        List<PinkunhuEntity> pinkunhuEntities_pinkunhuIdNumber = pinkunhuService.selectList(new EntityWrapper<PinkunhuEntity>().in("pinkunhu_id_number", seachFields.get("pinkunhuIdNumber")));
                        if(pinkunhuEntities_pinkunhuIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(PinkunhuEntity s:pinkunhuEntities_pinkunhuIdNumber){
                                repeatFields.add(s.getPinkunhuIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [家庭住址] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        pinkunhuService.insertBatch(pinkunhuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        PinkunhuEntity pinkunhu = pinkunhuService.selectOne(new EntityWrapper<PinkunhuEntity>().eq("username", username));
        if(pinkunhu==null || !pinkunhu.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(pinkunhu.getId(),username, "pinkunhu", "贫困户");
        R r = R.ok();
        r.put("token", token);
        r.put("role","贫困户");
        r.put("username",pinkunhu.getPinkunhuName());
        r.put("tableName","pinkunhu");
        r.put("userId",pinkunhu.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody PinkunhuEntity pinkunhu, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<PinkunhuEntity> queryWrapper = new EntityWrapper<PinkunhuEntity>()
            .eq("username", pinkunhu.getUsername())
            .or()
            .eq("pinkunhu_phone", pinkunhu.getPinkunhuPhone())
            .or()
            .eq("pinkunhu_id_number", pinkunhu.getPinkunhuIdNumber())
            ;
        PinkunhuEntity pinkunhuEntity = pinkunhuService.selectOne(queryWrapper);
        if(pinkunhuEntity != null)
            return R.error("账户或者手机号或者家庭住址已经被使用");
        pinkunhu.setCreateTime(new Date());
        pinkunhuService.insert(pinkunhu);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        PinkunhuEntity pinkunhu = pinkunhuService.selectById(id);
        pinkunhu.setPassword("123456");
        pinkunhuService.updateById(pinkunhu);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        PinkunhuEntity pinkunhu = pinkunhuService.selectOne(new EntityWrapper<PinkunhuEntity>().eq("username", username));
        if(pinkunhu!=null){
            pinkunhu.setPassword("123456");
            pinkunhuService.updateById(pinkunhu);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrPinkunhu(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        PinkunhuEntity pinkunhu = pinkunhuService.selectById(id);
        if(pinkunhu !=null){
            //entity转view
            PinkunhuView view = new PinkunhuView();
            BeanUtils.copyProperties( pinkunhu , view );//把实体数据重构到view中

            //级联表
                            GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(pinkunhu.getGongzuorenyuanId());
            if(gongzuorenyuan != null){
                BeanUtils.copyProperties( gongzuorenyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setGongzuorenyuanId(gongzuorenyuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }



    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = pinkunhuService.queryPage(params);

        //字典表数据转换
        List<PinkunhuView> list =(List<PinkunhuView>)page.getList();
        for(PinkunhuView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        PinkunhuEntity pinkunhu = pinkunhuService.selectById(id);
            if(pinkunhu !=null){


                //entity转view
                PinkunhuView view = new PinkunhuView();
                BeanUtils.copyProperties( pinkunhu , view );//把实体数据重构到view中

                //级联表
                    GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(pinkunhu.getGongzuorenyuanId());
                if(gongzuorenyuan != null){
                    BeanUtils.copyProperties( gongzuorenyuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setGongzuorenyuanId(gongzuorenyuan.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody PinkunhuEntity pinkunhu, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,pinkunhu:{}",this.getClass().getName(),pinkunhu.toString());
        Wrapper<PinkunhuEntity> queryWrapper = new EntityWrapper<PinkunhuEntity>()
            .eq("username", pinkunhu.getUsername())
            .or()
            .eq("pinkunhu_phone", pinkunhu.getPinkunhuPhone())
            .or()
            .eq("pinkunhu_id_number", pinkunhu.getPinkunhuIdNumber())
//            .notIn("pinkunhu_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        PinkunhuEntity pinkunhuEntity = pinkunhuService.selectOne(queryWrapper);
        if(pinkunhuEntity==null){
            pinkunhu.setCreateTime(new Date());
        pinkunhu.setPassword("123456");
        pinkunhuService.insert(pinkunhu);

            return R.ok();
        }else {
            return R.error(511,"账户或者手机号或者家庭住址已经被使用");
        }
    }

}

