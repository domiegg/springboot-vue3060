package com.dao;

import com.entity.PinkunhuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.PinkunhuView;

/**
 * 贫困户 Dao 接口
 *
 * @author 
 */
public interface PinkunhuDao extends BaseMapper<PinkunhuEntity> {

   List<PinkunhuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
