package com.palm.lingcai.dao.futian;

import com.palm.lingcai.entity.futian.FutianDealerInfo;
import com.palm.lingcai.dao.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("futianDealerInfoDao")
public interface FutianDealerInfoDao {

	FutianDealerInfo get(Integer id);

	List<FutianDealerInfo> search(Map<String, Object> parameters);

	Page<FutianDealerInfo> searchPage(@Param("searchFields") Map<String, Object> searchParams, Page page);

	void insert(FutianDealerInfo futianDealerInfo);

	void delete(Integer id);

	void update(FutianDealerInfo futianDealerInfo);

}
