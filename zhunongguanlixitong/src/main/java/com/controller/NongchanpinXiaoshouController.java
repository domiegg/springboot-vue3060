
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
 * 农产品售卖
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/nongchanpinXiaoshou")
public class NongchanpinXiaoshouController {
    private static final Logger logger = LoggerFactory.getLogger(NongchanpinXiaoshouController.class);

    private static final String TABLE_NAME = "nongchanpinXiaoshou";

    @Autowired
    private NongchanpinXiaoshouService nongchanpinXiaoshouService;


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
    private PinkunhuService pinkunhuService;//贫困户
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
        PageUtils page = nongchanpinXiaoshouService.queryPage(params);

        //字典表数据转换
        List<NongchanpinXiaoshouView> list =(List<NongchanpinXiaoshouView>)page.getList();
        for(NongchanpinXiaoshouView c:list){
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
        NongchanpinXiaoshouEntity nongchanpinXiaoshou = nongchanpinXiaoshouService.selectById(id);
        if(nongchanpinXiaoshou !=null){
            //entity转view
            NongchanpinXiaoshouView view = new NongchanpinXiaoshouView();
            BeanUtils.copyProperties( nongchanpinXiaoshou , view );//把实体数据重构到view中
            //级联表 农产品
            //级联表
            NongchanpinEntity nongchanpin = nongchanpinService.selectById(nongchanpinXiaoshou.getNongchanpinId());
            if(nongchanpin != null){
            BeanUtils.copyProperties( nongchanpin , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "gongzuorenyuanId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setNongchanpinId(nongchanpin.getId());
            }
            //级联表 工作人员
            //级联表
            GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(nongchanpinXiaoshou.getGongzuorenyuanId());
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
    public R save(@RequestBody NongchanpinXiaoshouEntity nongchanpinXiaoshou, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,nongchanpinXiaoshou:{}",this.getClass().getName(),nongchanpinXiaoshou.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("工作人员".equals(role))
            nongchanpinXiaoshou.setGongzuorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        NongchanpinEntity nongchanpinEntity = nongchanpinService.selectById(nongchanpinXiaoshou.getNongchanpinId());
        if(nongchanpinEntity==null)
            return R.error("查不到农产品");

        int balance = nongchanpinEntity.getNongchanpinKucunNumber() - nongchanpinXiaoshou.getBuyNumber();
        if(balance<0)
            return R.error("销售数量不能大于库存数量,请核实后再操作");

        nongchanpinEntity.setNongchanpinKucunNumber(balance);
        nongchanpinService.updateById(nongchanpinEntity);


        nongchanpinXiaoshou.setNongchanpinXiaoshouXiaoshouzonge(nongchanpinXiaoshou.getBuyNumber()*nongchanpinEntity.getNongchanpinNewJine());
        nongchanpinXiaoshou.setNongchanpinXiaoshouLirun(nongchanpinXiaoshou.getBuyNumber()*(nongchanpinEntity.getNongchanpinNewJine()-nongchanpinEntity.getNongchanpinCaigouJine()));

            nongchanpinXiaoshou.setInsertTime(new Date());
            nongchanpinXiaoshou.setCreateTime(new Date());
            nongchanpinXiaoshouService.insert(nongchanpinXiaoshou);
            return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody NongchanpinXiaoshouEntity nongchanpinXiaoshou, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,nongchanpinXiaoshou:{}",this.getClass().getName(),nongchanpinXiaoshou.toString());
        NongchanpinXiaoshouEntity oldNongchanpinXiaoshouEntity = nongchanpinXiaoshouService.selectById(nongchanpinXiaoshou.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("工作人员".equals(role))
//            nongchanpinXiaoshou.setGongzuorenyuanId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            nongchanpinXiaoshouService.updateById(nongchanpinXiaoshou);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<NongchanpinXiaoshouEntity> oldNongchanpinXiaoshouList =nongchanpinXiaoshouService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        nongchanpinXiaoshouService.deleteBatchIds(Arrays.asList(ids));

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
            List<NongchanpinXiaoshouEntity> nongchanpinXiaoshouList = new ArrayList<>();//上传的东西
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
                            NongchanpinXiaoshouEntity nongchanpinXiaoshouEntity = new NongchanpinXiaoshouEntity();
//                            nongchanpinXiaoshouEntity.setNongchanpinXiaoshouUuidNumber(data.get(0));                    //销售编号 要改的
//                            nongchanpinXiaoshouEntity.setGongzuorenyuanId(Integer.valueOf(data.get(0)));   //工作人员 要改的
//                            nongchanpinXiaoshouEntity.setNongchanpinId(Integer.valueOf(data.get(0)));   //农产品 要改的
//                            nongchanpinXiaoshouEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //销售数量 要改的
//                            nongchanpinXiaoshouEntity.setNongchanpinXiaoshouXiaoshouzonge(data.get(0));                    //销售总额 要改的
//                            nongchanpinXiaoshouEntity.setNongchanpinXiaoshouLirun(data.get(0));                    //本次利润 要改的
//                            nongchanpinXiaoshouEntity.setNongchanpinXiaoshouTypes(Integer.valueOf(data.get(0)));   //销售类型 要改的
//                            nongchanpinXiaoshouEntity.setXiaoshouTime(sdf.parse(data.get(0)));          //销售时间 要改的
//                            nongchanpinXiaoshouEntity.setNongchanpinXiaoshouContent("");//详情和图片
//                            nongchanpinXiaoshouEntity.setInsertTime(date);//时间
//                            nongchanpinXiaoshouEntity.setCreateTime(date);//时间
                            nongchanpinXiaoshouList.add(nongchanpinXiaoshouEntity);


                            //把要查询是否重复的字段放入map中
                                //销售编号
                                if(seachFields.containsKey("nongchanpinXiaoshouUuidNumber")){
                                    List<String> nongchanpinXiaoshouUuidNumber = seachFields.get("nongchanpinXiaoshouUuidNumber");
                                    nongchanpinXiaoshouUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> nongchanpinXiaoshouUuidNumber = new ArrayList<>();
                                    nongchanpinXiaoshouUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("nongchanpinXiaoshouUuidNumber",nongchanpinXiaoshouUuidNumber);
                                }
                        }

                        //查询是否重复
                         //销售编号
                        List<NongchanpinXiaoshouEntity> nongchanpinXiaoshouEntities_nongchanpinXiaoshouUuidNumber = nongchanpinXiaoshouService.selectList(new EntityWrapper<NongchanpinXiaoshouEntity>().in("nongchanpin_xiaoshou_uuid_number", seachFields.get("nongchanpinXiaoshouUuidNumber")));
                        if(nongchanpinXiaoshouEntities_nongchanpinXiaoshouUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(NongchanpinXiaoshouEntity s:nongchanpinXiaoshouEntities_nongchanpinXiaoshouUuidNumber){
                                repeatFields.add(s.getNongchanpinXiaoshouUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [销售编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        nongchanpinXiaoshouService.insertBatch(nongchanpinXiaoshouList);
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
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = nongchanpinXiaoshouService.queryPage(params);

        //字典表数据转换
        List<NongchanpinXiaoshouView> list =(List<NongchanpinXiaoshouView>)page.getList();
        for(NongchanpinXiaoshouView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        NongchanpinXiaoshouEntity nongchanpinXiaoshou = nongchanpinXiaoshouService.selectById(id);
            if(nongchanpinXiaoshou !=null){


                //entity转view
                NongchanpinXiaoshouView view = new NongchanpinXiaoshouView();
                BeanUtils.copyProperties( nongchanpinXiaoshou , view );//把实体数据重构到view中

                //级联表
                    NongchanpinEntity nongchanpin = nongchanpinService.selectById(nongchanpinXiaoshou.getNongchanpinId());
                if(nongchanpin != null){
                    BeanUtils.copyProperties( nongchanpin , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setNongchanpinId(nongchanpin.getId());
                }
                //级联表
                    GongzuorenyuanEntity gongzuorenyuan = gongzuorenyuanService.selectById(nongchanpinXiaoshou.getGongzuorenyuanId());
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
    public R add(@RequestBody NongchanpinXiaoshouEntity nongchanpinXiaoshou, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,nongchanpinXiaoshou:{}",this.getClass().getName(),nongchanpinXiaoshou.toString());
        Wrapper<NongchanpinXiaoshouEntity> queryWrapper = new EntityWrapper<NongchanpinXiaoshouEntity>()
            .eq("nongchanpin_xiaoshou_uuid_number", nongchanpinXiaoshou.getNongchanpinXiaoshouUuidNumber())
            .eq("gongzuorenyuan_id", nongchanpinXiaoshou.getGongzuorenyuanId())
            .eq("nongchanpin_id", nongchanpinXiaoshou.getNongchanpinId())
            .eq("buy_number", nongchanpinXiaoshou.getBuyNumber())
            .eq("nongchanpin_xiaoshou_types", nongchanpinXiaoshou.getNongchanpinXiaoshouTypes())
//            .notIn("nongchanpin_xiaoshou_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        NongchanpinXiaoshouEntity nongchanpinXiaoshouEntity = nongchanpinXiaoshouService.selectOne(queryWrapper);
        if(nongchanpinXiaoshouEntity==null){
            nongchanpinXiaoshou.setInsertTime(new Date());
            nongchanpinXiaoshou.setCreateTime(new Date());
        nongchanpinXiaoshouService.insert(nongchanpinXiaoshou);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

