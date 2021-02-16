// ZOA_CREATED! DO NOT EDIT IT! -- 
package com.lanyuan.shiro;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.config.Ini;
import org.springframework.beans.factory.FactoryBean;

import com.lanyuan.entity.ResFormMap;
import com.lanyuan.mapper.ResourcesMapper;
import com.lanyuan.util.ConfigUtils;

/**
 * 产生责任链，确定每个url的访问权限
 * 
 */
import com.process.ZoaExp;
import com.process.ZoaThreadLocal;
public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	@Inject
	private ResourcesMapper resourcesMapper;

	// 静态资源访问权限
	private String filterChainDefinitions = null;

	public Ini.Section getObject() throws Exception {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 239 0 8135540"); 
		new ConfigUtils().initTableField(resourcesMapper); 
		Ini ini = new Ini();
		// 加载默认的url
		ini.load(filterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		// 循环Resource的url,逐个添加到section中。section就是filterChainDefinitionMap,
		// 里面的键就是链接URL,值就是存在什么条件才能访问该链接
		List<ResFormMap> lists = resourcesMapper.findByWhere(new ResFormMap());
		for (ResFormMap resources : /* TRUE */lists){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 239 1 8135540");ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 239 2 8135540"); {
			// 构成permission字符串
			int zoa_cond_n3_0 = 2;
int zoa_cond_n3_1 = 2;
//zoa_cond_n3_0#StringUtils.isNotEmpty(resources.get("resUrl") + "")$zoa_cond_n3_1#StringUtils.isNotEmpty(resources.get("resKey") + "")
if ((ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 239 3 8135540")|| true) && ((StringUtils.isNotEmpty(resources.get("resUrl") + "")?(zoa_cond_n3_0 != (zoa_cond_n3_0 = 1)):(zoa_cond_n3_0 == (zoa_cond_n3_0 = 0))) && (StringUtils.isNotEmpty(resources.get("resKey") + "")?(zoa_cond_n3_1 != (zoa_cond_n3_1 = 1)):(zoa_cond_n3_1 == (zoa_cond_n3_1 = 0)))? (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 239 2 0 1 2 ","8135540",true,zoa_cond_n3_0,zoa_cond_n3_1) || true): (ZoaExp.ZoaMCDC(ZoaThreadLocal.G_Ins().G_CInf() + " 239 2 0 0 2 ","8135540",false,zoa_cond_n3_0,zoa_cond_n3_1) && false))){ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 239 4 8135540"); {
				String permission = "perms[" + resources.get("resKey") + "]";
				System.out.println(permission);
				// 不对角色进行权限验证
				// 如需要则 permission = "roles[" + resources.getResKey() + "]";
				section.put(resources.get("resUrl") + "", permission);
			} }

		}}
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1000 239 6 8135540");
		// 所有资源的访问权限，必须放在最后
		/*section.put("/**", "authc");*/
		/** 如果需要一个用户只能登录一处地方,,修改为 section.put("/**", "authc,kickout,sysUser,user"); **/
		section.put("/**", "authc");
		return section;
	}

	/**
	 * 通过filterChainDefinitions对默认的url过滤定义
	 * 
	 * @param filterChainDefinitions
	 *            默认的url过滤定义
	 */
	public void setFilterChainDefinitions(String filterChainDefinitions) {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 239 7 8135540"); 
		this.filterChainDefinitions = filterChainDefinitions;
	}

	public Class<?> getObjectType() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 239 8 8135540"); 
		return this.getClass();
	}

	public boolean isSingleton() {
ZoaExp.N(ZoaThreadLocal.G_Ins().G_CInf() + " 1001 239 9 8135540"); 
		return false;
	}
}
