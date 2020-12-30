package com.ivy.admin.controller.ppsg;

import com.ivy.admin.service.ppsg.GeneralArmsBookService;
import com.ivy.admin.vo.ppsg.GeneralArmsBookVo;
import com.ivy.admin.entity.ppsg.GeneralArmsBook;

import com.ivy.admin.utils.Pagination;
import com.ivy.admin.utils.ResultMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ivy.admin.aspect.log.Log;
import java.util.List;

/**
 * 兵书
 * @author: Administrator
 * @date: 2020-12-30
 */
@RestController
@RequestMapping("/ppsg/general/arms/book")
public class GeneralArmsBookController {

    @Autowired
    private GeneralArmsBookService generalArmsBookService;

    @Log("ppsg.GeneralArmsBook")
	@GetMapping("/selectPage")
    public ResultMsg selectPage(GeneralArmsBookVo generalArmsBookVo){
        Pagination<GeneralArmsBook> pagination = generalArmsBookService.selectPage(generalArmsBookVo);
        return ResultMsg.success(pagination);
    }

	/**
	 * 查询列表
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralArmsBook")
    @GetMapping("/selectList")
    public ResultMsg selectList(GeneralArmsBookVo generalArmsBookVo){
        return ResultMsg.success(generalArmsBookService.selectList(generalArmsBookVo));
    }

	/**
	 * 查询详情
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralArmsBook")
    @GetMapping("/selectOne")
    public ResultMsg selectOne(GeneralArmsBookVo generalArmsBookVo){
        return ResultMsg.success(generalArmsBookService.selectOne(generalArmsBookVo));
    }

	/**
	 * 新增
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralArmsBook")
    @PostMapping("/insert")
    public ResultMsg insert(@RequestBody GeneralArmsBook generalArmsBook){
        if(generalArmsBook == null){
            return ResultMsg.failed();
        }
        int i = generalArmsBookService.insert(generalArmsBook);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id更新
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralArmsBook")
    @PostMapping("/update")
    public ResultMsg update(@RequestBody GeneralArmsBook generalArmsBook){
        if(generalArmsBook == null || generalArmsBook.getId() == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalArmsBookService.update(generalArmsBook);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }

	/**
	 * 根据id删除
	 * @author: Administrator
	 * @date: 2020-12-30
	 */
    @Log("ppsg.GeneralArmsBook")
    @PostMapping("/delete/{id}")
    public ResultMsg delete(@RequestBody @PathVariable("id") Long id){
        if(id == null){
            return ResultMsg.failed("ID不能为空！");
        }
        int i = generalArmsBookService.delete(id);
        if(i>0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
}
