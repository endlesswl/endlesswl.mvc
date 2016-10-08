package com.palm.lingcai.service.futian;

import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.entity.futian.FutianCity;
import com.palm.lingcai.dao.futian.FutianCityDao;
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
public class FutianCityService {

	@Autowired
	private FutianCityDao futianCityDao;

	/**
	 * 分页查询
	 * 
	 * @param searchParams
	 *            查询条件
	 * @param page
	 *            分页参数
	 * @return
	 */
	public Page<FutianCity> searchPage(Map<String, Object> searchParams,
			Page page) {
		return futianCityDao.searchPage(searchParams, page);
	}

	/**
	 * 不分页查询
	 * 
	 * @param searchParas
	 *            查询条件
	 * @return
	 */
	public List<FutianCity> search(Map<String, Object> searchParas) {
		return futianCityDao.search(searchParas);
	}

	
	public FutianCity get(Integer id) {
		return futianCityDao.get(id);
	}

	public void insert(FutianCity futianCity) {
		futianCityDao.insert(futianCity);
	}
	
	public void update(FutianCity futianCity) {
		futianCityDao.update(futianCity);
	}

	public void delete(Integer id) {
		futianCityDao.delete(id);
	}

}
