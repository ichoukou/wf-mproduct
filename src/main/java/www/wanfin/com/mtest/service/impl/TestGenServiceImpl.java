package www.wanfin.com.mtest.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import www.wanfin.com.mtest.dao.TestGenDao;
import www.wanfin.com.mtest.entity.TestGenEntity;
import www.wanfin.com.mtest.service.TestGenService;



@Service("testGenService")
public class TestGenServiceImpl implements TestGenService {
	@Autowired
	private TestGenDao testGenDao;
	
	@Override
	public TestGenEntity queryObject(Long userId){
		return testGenDao.queryObject(userId);
	}
	
	@Override
	public List<TestGenEntity> queryList(Map<String, Object> map){
		return testGenDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return testGenDao.queryTotal(map);
	}
	
	@Override
	public void save(TestGenEntity testGen){
		testGenDao.save(testGen);
	}
	
	@Override
	public void update(TestGenEntity testGen){
		testGenDao.update(testGen);
	}
	
	@Override
	public void delete(Long userId){
		testGenDao.delete(userId);
	}
	
	@Override
	public void deleteBatch(Long[] userIds){
		testGenDao.deleteBatch(userIds);
	}
	
}
