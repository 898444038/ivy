package com.ivy.admin.service.ppsg;

import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 联协
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralAssociationService {

	Pagination<GeneralAssociation> selectPage(GeneralAssociationVo generalAssociationVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralAssociation> selectList(GeneralAssociationVo generalAssociationVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralAssociation selectOne(GeneralAssociationVo generalAssociationVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralAssociation generalAssociation);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralAssociation generalAssociation);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

    int deleteByGeneralId(Long id);
}
