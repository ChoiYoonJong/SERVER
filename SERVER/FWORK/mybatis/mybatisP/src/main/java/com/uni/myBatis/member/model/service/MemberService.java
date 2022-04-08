package com.uni.myBatis.member.model.service;

import com.uni.myBatis.member.model.dto.Member;

public interface MemberService {
	
	Member loginMember(Member m) throws Exception;

	int insertMember(Member m) throws Exception;
}
