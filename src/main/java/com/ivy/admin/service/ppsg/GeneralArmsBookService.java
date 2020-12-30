package com.ivy.admin.service.ppsg;

import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 兵书
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralArmsBookService {

	Pagination<GeneralArmsBook> selectPage(GeneralArmsBookVo generalArmsBookVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralArmsBook> selectList(GeneralArmsBookVo generalArmsBookVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralArmsBook selectOne(GeneralArmsBookVo generalArmsBookVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralArmsBook generalArmsBook);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralArmsBook generalArmsBook);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

}
