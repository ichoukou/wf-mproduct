package www.wanfin.com.mtest.controller;

import www.wanfin.com.mcore.controller.AbstractController;
import www.wanfin.com.mcore.utils.PageUtils;
import www.wanfin.com.mcore.utils.R;
import www.wanfin.com.mtest.entity.TestGenEntity;
import www.wanfin.com.mtest.service.TestGenService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 测试生成
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-02-08 18:07:35
 */
@Controller
@RequestMapping("/test/testgen")
public class TestGenController extends AbstractController {
	@Autowired
	private TestGenService testGenService;
	
	@RequestMapping("/testgen.html")
	public String list(){
		return "test/testgen.html";
	}
	
	@RequestMapping("/testgen_add.html")
	public String add(){
		return "test/testgen_add.html";
	}
	
	/**
	 * 列表
	 */
	@ResponseBody
	@RequestMapping("/list")
	@RequiresPermissions("testgen:list")
	public R list(Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		map.put("offset", (page - 1) * limit);
		map.put("limit", limit);
		
		//查询列表数据
		List<TestGenEntity> testGenList = testGenService.queryList(map);
		int total = testGenService.queryTotal(map);
		
		PageUtils pageUtil = new PageUtils(testGenList, total, limit, page);
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@ResponseBody
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("testgen:info")
	public R info(@PathVariable("userId") Long userId){
		TestGenEntity testGen = testGenService.queryObject(userId);
		
		return R.ok().put("testGen", testGen);
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@RequestMapping("/save")
	@RequiresPermissions("testgen:save")
	public R save(@RequestBody TestGenEntity testGen){
		testGenService.save(testGen);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("testgen:update")
	public R update(@RequestBody TestGenEntity testGen){
		testGenService.update(testGen);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@ResponseBody
	@RequestMapping("/delete")
	@RequiresPermissions("testgen:delete")
	public R delete(@RequestBody Long[] userIds){
		testGenService.deleteBatch(userIds);
		
		return R.ok();
	}
	
}
