package com.palm.lingcai.service.futian;

import com.palm.lingcai.dao.futian.FutianUserImgDao;
import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.entity.futian.FutianUserImg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class FutianUserImgService {

	private static Logger logger = LoggerFactory.getLogger(FutianUserImgService.class);

	@Autowired
	private FutianUserImgDao futianUserImgDao;

	/**
	 * 分页查询
	 * 
	 * @param searchParams
	 *            查询条件
	 * @param page
	 *            分页参数
	 * @return
	 */
	public Page<FutianUserImg> searchPage(Map<String, Object> searchParams,
			Page page) {
		return futianUserImgDao.searchPage(searchParams, page);
	}

	/**
	 * 不分页查询
	 * 
	 * @param searchParas
	 *            查询条件
	 * @return
	 */
	public List<FutianUserImg> search(Map<String, Object> searchParas) {
		return futianUserImgDao.search(searchParas);
	}

	
	public FutianUserImg get(Integer id) {
		return futianUserImgDao.get(id);
	}

	public void insert(FutianUserImg futianUserImg) {
		futianUserImg.setCreateTime(new Date());
		futianUserImgDao.insert(futianUserImg);
	}
	
	public void update(FutianUserImg futianUserImg) {
		futianUserImgDao.update(futianUserImg);
	}

	public void delete(Integer id) {
		futianUserImgDao.delete(id);
	}

	public List<Map<String, Object>> adminImgList(){
		return futianUserImgDao.adminImgList();
	}
}
