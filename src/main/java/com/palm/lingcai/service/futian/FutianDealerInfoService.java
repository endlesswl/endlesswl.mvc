package com.palm.lingcai.service.futian;

import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.entity.futian.FutianDealerInfo;
import com.palm.lingcai.dao.futian.FutianDealerInfoDao;
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
public class FutianDealerInfoService {

	@Autowired
	private FutianDealerInfoDao futianDealerInfoDao;

	/**
	 * 分页查询
	 * 
	 * @param searchParams
	 *            查询条件
	 * @param page
	 *            分页参数
	 * @return
	 */
	public Page<FutianDealerInfo> searchPage(Map<String, Object> searchParams,
			Page page) {
		return futianDealerInfoDao.searchPage(searchParams, page);
	}

	/**
	 * 不分页查询
	 * 
	 * @param searchParas
	 *            查询条件
	 * @return
	 */
	public List<FutianDealerInfo> search(Map<String, Object> searchParas) {
		return futianDealerInfoDao.search(searchParas);
	}

	
	public FutianDealerInfo get(Integer id) {
		return futianDealerInfoDao.get(id);
	}

	public void insert(FutianDealerInfo futianDealerInfo) {
		futianDealerInfo.setCreateTime(new Date());
		futianDealerInfoDao.insert(futianDealerInfo);
	}
	
	public void update(FutianDealerInfo futianDealerInfo) {
		futianDealerInfoDao.update(futianDealerInfo);
	}

	public void delete(Integer id) {
		futianDealerInfoDao.delete(id);
	}

}
