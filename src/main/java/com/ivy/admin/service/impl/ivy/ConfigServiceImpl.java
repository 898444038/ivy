package com.ivy.admin.service.impl.ivy;

import com.ivy.admin.service.ivy.ConfigService;
import com.ivy.admin.vo.ivy.ConfigVo;
import com.ivy.admin.mapper.ivy.ConfigMapper;
import com.ivy.admin.entity.ivy.Config;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 配置表
 * @author: Administrator
 * @date: 2020-08-25
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Resource
    private ConfigMapper configMapper;

	@Override
	public Pagination<Config> selectPage(ConfigVo configVo) {
        Pagination<Config> pagination = new Pagination<>();
        int count = configMapper.selectCount(configVo);
        List<Config> list = configMapper.selectPage(configVo);
        pagination.setPageNo(configVo.getPageNo());
        pagination.setPageSize(configVo.getPageSize());
        pagination.setTotalPage(count);
        pagination.setData(list);
        return pagination;
	}

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Override
    public List<Config> selectList(ConfigVo configVo) {
        return configMapper.selectList(configVo);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Override
    public Config selectOne(ConfigVo configVo) {
        return configMapper.selectOne(configVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Override
    public int insert(Config config) {
        return configMapper.insert(config);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Override
    public int update(Config config) {
        return configMapper.update(config);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Override
    public int delete(Long id) {
        return configMapper.delete(id);
    }
}
