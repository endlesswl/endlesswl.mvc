package com.palm.lingcai.dao.futian;

import com.palm.lingcai.entity.futian.FutianUserInfo;
import com.palm.lingcai.dao.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("futianUserInfoDao")
public interface FutianUserInfoDao {

	FutianUserInfo get(Integer id);

	List<FutianUserInfo> search(Map<String, Object> parameters);

	Page<FutianUserInfo> searchPage(@Param("searchFields") Map<String, Object> searchParams, Page page);

	void insert(FutianUserInfo futianUserInfo);

	void delete(Integer id);

	void update(FutianUserInfo futianUserInfo);

	List<Map<String, Object>> adminList();

}
