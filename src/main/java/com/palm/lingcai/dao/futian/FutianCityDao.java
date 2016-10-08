package com.palm.lingcai.dao.futian;

import com.palm.lingcai.entity.futian.FutianCity;
import com.palm.lingcai.dao.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("futianCityDao")
public interface FutianCityDao {

	FutianCity get(Integer id);

	List<FutianCity> search(Map<String, Object> parameters);

	Page<FutianCity> searchPage(@Param("searchFields") Map<String, Object> searchParams, Page page);

	void insert(FutianCity futianCity);

	void delete(Integer id);

	void update(FutianCity futianCity);

}
