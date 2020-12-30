package com.ivy.admin.service.ppsg;

import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import com.ivy.admin.entity.ppsg.GeneralWeapon;

import com.ivy.admin.utils.Pagination;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 战器
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralWeaponService {

	Pagination<GeneralWeapon> selectPage(GeneralWeaponVo generalWeaponVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    List<GeneralWeapon> selectList(GeneralWeaponVo generalWeaponVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    GeneralWeapon selectOne(GeneralWeaponVo generalWeaponVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int insert(GeneralWeapon generalWeapon);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int update(GeneralWeapon generalWeapon);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    int delete(Long id);

}
