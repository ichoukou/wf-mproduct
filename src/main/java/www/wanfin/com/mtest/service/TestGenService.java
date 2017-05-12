package www.wanfin.com.mtest.service;

import www.wanfin.com.mtest.entity.TestGenEntity;

import java.util.List;
import java.util.Map;

/**
 * 测试生成
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-02-08 18:07:35
 */
public interface TestGenService {
	
	TestGenEntity queryObject(Long userId);
	
	List<TestGenEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(TestGenEntity testGen);
	
	void update(TestGenEntity testGen);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);
}
