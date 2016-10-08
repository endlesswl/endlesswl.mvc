package com.palm.lingcai.service.futian;

import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.entity.futian.FutianChannelUser;

import com.palm.lingcai.dao.futian.FutianChannelUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class FutianChannelUserService {

	@Autowired
	private FutianChannelUserDao futianChannelUserDao;

	/**
	 * 分页查询
	 * 
	 * @param searchParams
	 *            查询条件
	 * @param page
	 *            分页参数
	 * @return
	 */
	public Page<FutianChannelUser> searchPage(Map<String, Object> searchParams,
			Page page) {
		return futianChannelUserDao.searchPage(searchParams, page);
	}

	/**
	 * 不分页查询
	 * 
	 * @param searchParas
	 *            查询条件
	 * @return
	 */
	public List<FutianChannelUser> search(Map<String, Object> searchParas) {
		return futianChannelUserDao.search(searchParas);
	}

	
	public FutianChannelUser get(Integer id) {
		return futianChannelUserDao.get(id);
	}

	public void insert(FutianChannelUser futianChannelUser) {
		futianChannelUserDao.insert(futianChannelUser);
	}
	
	public void update(FutianChannelUser futianChannelUser) {
		futianChannelUserDao.update(futianChannelUser);
	}

	public void delete(Integer id) {
		futianChannelUserDao.delete(id);
	}

}
