package com.palm.lingcai.service.futian;

import com.palm.lingcai.entity.futian.FutianUserInfo;
import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.dao.futian.FutianUserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
* @Title: 
* @Description: 
* @Author nzh   
* @Date 2016 - 2016
* @Version V1.0
* @Copyright © 2016 零彩宝网络技术有限公司. All rights reserved.
*/
// Spring Service Bean的标识.
@Service
@Transactional
public class FutianUserInfoService {

	@Autowired
	private FutianUserInfoDao futianUserInfoDao;

	/**
	 * 分页查询
	 * 
	 * @param searchParams
	 *            查询条件
	 * @param page
	 *            分页参数
	 * @return
	 */
	public Page<FutianUserInfo> searchPage(Map<String, Object> searchParams,
			Page page) {
		return futianUserInfoDao.searchPage(searchParams, page);
	}

	/**
	 * 不分页查询
	 * 
	 * @param searchParas
	 *            查询条件
	 * @return
	 */
	public List<FutianUserInfo> search(Map<String, Object> searchParas) {
		return futianUserInfoDao.search(searchParas);
	}

	
	public FutianUserInfo get(Integer id) {
		return futianUserInfoDao.get(id);
	}

	public void insert(FutianUserInfo futianUserInfo) {
		futianUserInfo.setCreateTime(new Date());
		futianUserInfoDao.insert(futianUserInfo);
	}
	
	public void update(FutianUserInfo futianUserInfo) {
		futianUserInfoDao.update(futianUserInfo);
	}

	public void delete(Integer id) {
		futianUserInfoDao.delete(id);
	}

	public List<Map<String, Object>> adminList(){
		return futianUserInfoDao.adminList();
	}

}
