package com.ivy.admin.mapper.ppsg;

import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;

import org.apache.ibatis.annotations.Mapper;
import com.ivy.system.config.datasource.TargetDataSource;
import java.util.List;

/**
 * 联协
 * @author: Administrator
 * @date: 2020-12-30
 */
@Mapper
public interface GeneralAssociationMapper {

    @TargetDataSource("dataSource1")
	int selectCount(GeneralAssociationVo generalAssociationVo);

    @TargetDataSource("dataSource1")
	List<GeneralAssociation> selectPage(GeneralAssociationVo generalAssociationVo);

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    List<GeneralAssociation> selectList(GeneralAssociationVo generalAssociationVo);

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    GeneralAssociation selectOne(GeneralAssociationVo generalAssociationVo);

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int insert(GeneralAssociation generalAssociation);

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int update(GeneralAssociation generalAssociation);

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @TargetDataSource("dataSource1")
    int delete(Long id);

}
