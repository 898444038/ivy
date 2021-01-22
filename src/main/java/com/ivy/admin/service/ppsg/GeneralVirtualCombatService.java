package com.ivy.admin.service.ppsg;

import com.ivy.admin.entity.ppsg.General;
import com.ivy.admin.entity.ppsg.GeneralAnalog;
import com.ivy.admin.entity.ppsg.GeneralResult;
import com.ivy.admin.utils.Pagination;
import com.ivy.admin.vo.ppsg.GeneralVo;

import java.util.List;

/**
 * 武将
 * @author: Administrator
 * @date: 2020-12-30
 */
public interface GeneralVirtualCombatService {

    List<GeneralResult> calculate(GeneralAnalog analog);

}
