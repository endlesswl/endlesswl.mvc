package com.palm.lingcai.dao.futian;

import com.palm.lingcai.dao.page.Page;
import com.palm.lingcai.entity.futian.FutianChannelUser;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("futianChannelUserDao")
public interface FutianChannelUserDao {

	FutianChannelUser get(Integer id);

	List<FutianChannelUser> search(Map<String, Object> parameters);

	Page<FutianChannelUser> searchPage(@Param("searchFields") Map<String, Object> searchParams, Page page);

	void insert(FutianChannelUser futianChannelUser);

	void delete(Integer id);

	void update(FutianChannelUser futianChannelUser);

}
