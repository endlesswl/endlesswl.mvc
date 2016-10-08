package com.palm.lingcai.dao.futian;

import com.palm.lingcai.entity.futian.FutianUserImg;
import com.palm.lingcai.dao.page.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("futianUserImgDao")
public interface FutianUserImgDao {

	FutianUserImg get(Integer id);

	List<FutianUserImg> search(Map<String, Object> parameters);

	Page<FutianUserImg> searchPage(@Param("searchFields") Map<String, Object> searchParams, Page page);

	void insert(FutianUserImg futianUserImg);

	void delete(Integer id);

	void update(FutianUserImg futianUserImg);

	List<Map<String, Object>> adminImgList();

}
