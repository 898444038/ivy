package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import com.ivy.admin.entity.ppsg.GeneralWeapon;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 战器
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralWeaponMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralWeaponVo generalWeaponVo);

    @TargetDataSource("dataSource1")
	List<GeneralWeapon> selectPage(GeneralWeaponVo generalWeaponVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralWeapon> selectList(GeneralWeaponVo generalWeaponVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralWeapon selectOne(GeneralWeaponVo generalWeaponVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralWeapon generalWeapon);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralWeapon generalWeapon);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
