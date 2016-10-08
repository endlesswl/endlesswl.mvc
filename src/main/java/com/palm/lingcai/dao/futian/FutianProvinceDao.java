package com.palm.lingcai.dao.futian;

import com.palm.lingcai.entity.futian.FutianProvince;
import com.palm.lingcai.dao.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("futianProvinceDao")
public interface FutianProvinceDao {

	FutianProvince get(Integer id);

	List<FutianProvince> search(Map<String, Object> parameters);

	Page<FutianProvince> searchPage(@Param("searchFields") Map<String, Object> searchParams, Page page);

	void insert(FutianProvince futianProvince);

	void delete(Integer id);

	void update(FutianProvince futianProvince);

}
