package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.mapper.ppsg.GeneralArmsBookMapper;
import com.ivy.admin.service.ppsg.GeneralArmsBookService;
import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 兵书
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralArmsBookServiceImpl implements GeneralArmsBookService {

    @Resource
    private GeneralArmsBookMapper generalArmsBookMapper;

	@Override
	public Pagination<GeneralArmsBook> selectPage(GeneralArmsBookVo generalArmsBookVo) {
        Pagination<GeneralArmsBook> pagination = new Pagination<>();
        int count = generalArmsBookMapper.selectCount(generalArmsBookVo);
        List<GeneralArmsBook> list = generalArmsBookMapper.selectPage(generalArmsBookVo);
        pagination.setPageNo(generalArmsBookVo.getPageNo());
        pagination.setPageSize(generalArmsBookVo.getPageSize());
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
    public List<GeneralArmsBook> selectList(GeneralArmsBookVo generalArmsBookVo) {
        return generalArmsBookMapper.selectList(generalArmsBookVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public GeneralArmsBook selectOne(GeneralArmsBookVo generalArmsBookVo) {
        return generalArmsBookMapper.selectOne(generalArmsBookVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(GeneralArmsBook generalArmsBook) {
        return generalArmsBookMapper.insert(generalArmsBook);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(GeneralArmsBook generalArmsBook) {
        return generalArmsBookMapper.update(generalArmsBook);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalArmsBookMapper.delete(id);
    }
}
