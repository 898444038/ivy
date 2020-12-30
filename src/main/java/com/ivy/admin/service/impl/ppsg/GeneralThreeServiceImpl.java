package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.mapper.ppsg.GeneralThreeMapper;
import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.service.ppsg.GeneralThreeService;
import com.ivy.admin.entity.ppsg.GeneralThree;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 武将三维
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralThreeServiceImpl implements GeneralThreeService {

    @Resource
    private GeneralThreeMapper generalThreeMapper;

	@Override
	public Pagination<GeneralThree> selectPage(GeneralThreeVo generalThreeVo) {
        Pagination<GeneralThree> pagination = new Pagination<>();
        int count = generalThreeMapper.selectCount(generalThreeVo);
        List<GeneralThree> list = generalThreeMapper.selectPage(generalThreeVo);
        pagination.setPageNo(generalThreeVo.getPageNo());
        pagination.setPageSize(generalThreeVo.getPageSize());
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
    public List<GeneralThree> selectList(GeneralThreeVo generalThreeVo) {
        return generalThreeMapper.selectList(generalThreeVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralThree selectOne(GeneralThreeVo generalThreeVo) {
        return generalThreeMapper.selectOne(generalThreeVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralThree generalThree) {
        return generalThreeMapper.insert(generalThree);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralThree generalThree) {
        return generalThreeMapper.update(generalThree);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalThreeMapper.delete(id);
    }
}
