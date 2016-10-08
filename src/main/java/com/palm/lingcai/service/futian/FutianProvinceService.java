package com.palm.lingcai.service.futian;



import com.palm.lingcai.dao.futian.FutianProvinceDao;
import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.entity.futian.FutianProvince;
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
public class FutianProvinceService {

	@Autowired
	private FutianProvinceDao futianProvinceDao;


	/**
	 * 分页查询
	 * 
	 * @param searchParams
	 *            查询条件
	 * @param page
	 *            分页参数
	 * @return
	 */
	public Page<FutianProvince> searchPage(Map<String, Object> searchParams,
			Page page) {
		return futianProvinceDao.searchPage(searchParams, page);
	}

	/**
	 * 不分页查询
	 * 
	 * @param searchParas
	 *            查询条件
	 * @return
	 */
	public List<FutianProvince> search(Map<String, Object> searchParas) {
		return futianProvinceDao.search(searchParas);
	}

	
	public FutianProvince get(Integer id) {
		return futianProvinceDao.get(id);
	}

	public void insert(FutianProvince futianProvince) {
		futianProvinceDao.insert(futianProvince);
	}
	
	public void update(FutianProvince futianProvince) {
		futianProvinceDao.update(futianProvince);
	}

	public void delete(Integer id) {
		futianProvinceDao.delete(id);
	}

}
