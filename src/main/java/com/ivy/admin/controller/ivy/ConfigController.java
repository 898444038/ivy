package com.ivy.admin.controller.ivy;

import com.ivy.admin.service.ivy.ConfigService;
import com.ivy.admin.vo.ivy.ConfigVo;
import com.ivy.admin.entity.ivy.Config;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import com.ivy.system.jwt.anno.ValidateToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 配置表
 * @author: Administrator
 * @date: 2020-08-25
 */
@RestController
@RequestMapping("/config")
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @Log("Config")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(ConfigVo configVo){
        Pagination<Config> pagination = configService.selectPage(configVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
	@ValidateToken
    @Log("Config")
    @GetMapping("/selectList")
    public ResultMsg selectList(ConfigVo configVo){
        return ResultMsg.success(configService.selectList(configVo));
    }

    @Log("Config")
    @GetMapping("/selectMap")
    public ResultMsg selectMap(ConfigVo bnsConfigVo){
        List<Config> list = configService.selectList(bnsConfigVo);
        Map<String,String> map = list.stream().collect(Collectors.toMap(Config::getCode,Config::getVal));
        return ResultMsg.success(map);
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Log("Config")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(ConfigVo configVo){
        return ResultMsg.success(configService.selectOne(configVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Log("Config")
    @PostMapping("/insert")
    public ResultMsg insert(Config config){
        if(config == null){
            return ResultMsg.failed();
        }
        int i = configService.insert(config);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Log("Config")
    @PostMapping("/update")
    public ResultMsg update(Config config){
        if(config == null || config.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = configService.update(config);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-08-25
	 */
    @Log("Config")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = configService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
