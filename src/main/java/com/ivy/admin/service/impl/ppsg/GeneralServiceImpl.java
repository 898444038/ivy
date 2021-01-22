package com.ivy.admin.service.impl.ppsg;

import com.ivy.admin.entity.ppsg.GeneralArmsBook;
import com.ivy.admin.entity.ppsg.GeneralAssociation;
import com.ivy.admin.entity.ppsg.GeneralSkin;
import com.ivy.admin.entity.ppsg.GeneralThree;
import com.ivy.admin.entity.ppsg.GeneralWeapon;
import com.ivy.admin.mapper.ppsg.GeneralArmsBookMapper;
import com.ivy.admin.mapper.ppsg.GeneralAssociationMapper;
import com.ivy.admin.mapper.ppsg.GeneralSkinMapper;
import com.ivy.admin.mapper.ppsg.GeneralThreeMapper;
import com.ivy.admin.mapper.ppsg.GeneralWeaponMapper;
import com.ivy.admin.service.ppsg.GeneralService;
import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.vo.ppsg.GeneralAssociationVo;
import com.ivy.admin.vo.ppsg.GeneralSkinVo;
import com.ivy.admin.vo.ppsg.GeneralThreeVo;
import com.ivy.admin.vo.ppsg.GeneralVo;
import com.ivy.admin.mapper.ppsg.GeneralMapper;

import com.ivy.admin.utils.Pagination;
import javax.annotation.Resource;

import com.ivy.admin.vo.ppsg.GeneralWeaponVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
@Service
public class GeneralServiceImpl implements GeneralService {

    @Resource
    private GeneralMapper generalMapper;
    @Resource
    private GeneralArmsBookMapper generalArmsBookMapper;
    @Resource
    private GeneralAssociationMapper generalAssociationMapper;
    @Resource
    private GeneralSkinMapper generalSkinMapper;
    @Resource
    private GeneralThreeMapper generalThreeMapper;
    @Resource
    private GeneralWeaponMapper generalWeaponMapper;

	@Override
	public Pagination<General> selectPage(GeneralVo generalVo) {
        Pagination<General> pagination = new Pagination<>();
        int count = generalMapper.selectCount(generalVo);
        List<General> list = generalMapper.selectPage(generalVo);
        pagination.setPageNo(generalVo.getPageNo());
        pagination.setPageSize(generalVo.getPageSize());
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
    public List<General> selectList(GeneralVo generalVo) {
        return generalMapper.selectList(generalVo);
    }

    @Override
    public List<General> selectDetailList(GeneralVo generalVo) {
        List<General> generalList = generalMapper.selectList(generalVo);
        List<GeneralArmsBook> armsBookList = generalArmsBookMapper.selectList(new GeneralArmsBookVo());
        List<GeneralAssociation> associationList = generalAssociationMapper.selectList(new GeneralAssociationVo());
        List<GeneralSkin> skinList = generalSkinMapper.selectList(new GeneralSkinVo());
        List<GeneralThree> threeList = generalThreeMapper.selectList(new GeneralThreeVo());
        List<GeneralWeapon> weaponList = generalWeaponMapper.selectList(new GeneralWeaponVo());
        for (General general : generalList){
            for (GeneralArmsBook armsBook : armsBookList){
                if(general.getId().equals(armsBook.getGeneralId())){
                    general.setArmsBook(armsBook);
                    break;
                }
            }

            List<GeneralAssociation> generalAssociationList = new ArrayList<>();
            for (GeneralAssociation association : associationList){
                if(general.getId().equals(association.getGeneralId())){
                    generalAssociationList.add(association);
                }
            }
            general.setAssociationList(generalAssociationList);

            for (GeneralSkin skin : skinList){
                if(general.getId().equals(skin.getGeneralId())){
                    general.setGeneralSkin(skin);
                    break;
                }
            }

            List<GeneralThree> generalThreeList = new ArrayList<>();
            for (GeneralThree three : threeList){
                if(general.getId().equals(three.getGeneralId())){
                    generalThreeList.add(three);
                }
            }
            general.setThreeList(generalThreeList);

            List<GeneralWeapon> generalWeaponList = new ArrayList<>();
            for (GeneralWeapon weapon : weaponList){
                if(general.getId().equals(weapon.getGeneralId())){
                    generalWeaponList.add(weapon);
                }
            }
            general.setWeaponList(generalWeaponList);
        }
        return generalList;
    }
	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public General selectOne(GeneralVo generalVo) {
        return generalMapper.selectOne(generalVo);
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int insert(General general) {
        return generalMapper.insert(general);
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int update(General general) {
        return generalMapper.update(general);
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Override
    public int delete(Long id) {
        return generalMapper.delete(id);
    }

    @Override
    public GeneralVo selectByName(String name) {
        return generalMapper.selectByName(name);
    }
}
