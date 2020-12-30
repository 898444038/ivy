package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.service.ppsg.GeneralWeaponService;
import com.ivy.admin.mapper.ppsg.GeneralWeaponMapper;
import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import com.ivy.admin.entity.ppsg.GeneralWeapon;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 战器
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralWeaponServiceImpl implements GeneralWeaponService {

    @Resource
    private GeneralWeaponMapper generalWeaponMapper;

	@Override
	public Pagination<GeneralWeapon> selectPage(GeneralWeaponVo generalWeaponVo) {
        Pagination<GeneralWeapon> pagination = new Pagination<>();
        int count = generalWeaponMapper.selectCount(generalWeaponVo);
        List<GeneralWeapon> list = generalWeaponMapper.selectPage(generalWeaponVo);
        pagination.setPageNo(generalWeaponVo.getPageNo());
        pagination.setPageSize(generalWeaponVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public List<GeneralWeapon> selectList(GeneralWeaponVo generalWeaponVo) {
        return generalWeaponMapper.selectList(generalWeaponVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralWeapon selectOne(GeneralWeaponVo generalWeaponVo) {
        return generalWeaponMapper.selectOne(generalWeaponVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralWeapon generalWeapon) {
        return generalWeaponMapper.insert(generalWeapon);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralWeapon generalWeapon) {
        return generalWeaponMapper.update(generalWeapon);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalWeaponMapper.delete(id);
    }
}
