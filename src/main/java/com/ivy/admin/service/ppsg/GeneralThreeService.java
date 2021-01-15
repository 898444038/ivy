package com.ivy.admin.service.ppsg;

import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.entity.ppsg.GeneralThree;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 武将三维
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralThreeService {

	Pagination<GeneralThree> selectPage(GeneralThreeVo generalThreeVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralThree> selectList(GeneralThreeVo generalThreeVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralThree selectOne(GeneralThreeVo generalThreeVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralThree generalThree);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralThree generalThree);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

    int deleteByGeneralId(Long id);
}
