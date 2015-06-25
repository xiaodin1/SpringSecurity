/**
 * 软件著作权：学科网
 * 系统名称：xy360
 * 创建日期： 2015-01-09
 */
package com.example.service.security;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.entity.Authority;
import com.example.service.AuthorityService;


/**
 * SecurityMetadataSourceMapBuilder接口的具体实现
 * @version 1.0
 * @author LiaoGang
 */

@Component
public class ItemSecurityMetadataSourceMapBuilder implements SecurityMetadataSourceMapBuilder{
	
	@Autowired
	private AuthorityService authorityService; 
	
	/**
	 * 构造资源与权限对应的Map集合
	 * 哪些权限可以访问哪些资源
	 * @return
	 */
	public LinkedHashMap<String, List<String>> buildSrcMap() {
		LinkedHashMap<String, List<String>> srcMap = new LinkedHashMap<>();
		List<Authority>  authoritys = authorityService.getAll();
		for(Authority authority : authoritys) {
			String url = authority.getUrl();
			List<String> roleNames = new ArrayList<>();
			roleNames.add(authority.getName());
			srcMap.put(url, roleNames);
		}
		return srcMap;
	}
}
