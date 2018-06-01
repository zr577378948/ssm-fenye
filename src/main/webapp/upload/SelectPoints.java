package com.lida.share.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.lida.share.pojo.Knowledge;
import com.siqiansoft.framework.bo.DatabaseBo;
import com.siqiansoft.framework.db.Database;
import com.siqiansoft.framework.model.LoginModel;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 查询知识点分享模块列表数据
 * @author caijingna
 * 
 */
public class SelectPoints {
    
	DatabaseBo dbo = new DatabaseBo();
	
	/**
	 * 首次数据加载
	 * @param start 每一页的起始数据
	 * @param end 每一页的终止数据
	 * @return lists 查询的结果列表
	 */
	public List queryAllPoints(int start,int end){
		ArrayList lists = new ArrayList();
		//1:1--10  2:11--20  3:21--30
		/*String sql = "select * from (select t.*,rownum num from (select * from lida_knowledge order by pageview desc,downloads desc,time desc)t"
				+ " where rownum <= "+end+" ) nn where nn.num >="+start;*/
		String sql = "select * from(select a.*,rownum rn from (select * from lida_knowledge order by pageview desc,downloads desc,time desc) a)"
				+ " where rn between "+start+" and "+end+" " ;
		try {
			ArrayList<HashMap<String, String>> list = dbo.prepareQuery(sql, null);
			for(int i = 0 ; i < list.size() ; i++){
				Knowledge knowledge = new Knowledge() ;
				if(null != list.get(i).get("ID") && !"".equals(list.get(i).get("ID"))){
					String ID = list.get(i).get("ID");
					knowledge.setID(ID);
				}else{
					knowledge.setID("");
				}
				
				if(null != list.get(i).get("USERCODE") && !"".equals(list.get(i).get("USERCODE"))){
					String USERCODE = list.get(i).get("USERCODE");
					knowledge.setUSERCODE(USERCODE);
				}else{
					knowledge.setUSERCODE("");
				}
				
				if(null != list.get(i).get("USERNAME") && !"".equals(list.get(i).get("USERNAME"))){
					String USERNAME = list.get(i).get("USERNAME");
					knowledge.setUSERNAME(USERNAME);
				}else{
					knowledge.setUSERNAME("");
				}
				
				if(null != list.get(i).get("TITLE") && !"".equals(list.get(i).get("TITLE"))){
					String TITLE = list.get(i).get("TITLE");
					knowledge.setTITLE(TITLE);
				}else{
					knowledge.setTITLE("");
				}
				
				if(null != list.get(i).get("PAGEVIEW") && !"".equals(list.get(i).get("PAGEVIEW"))){
					String PAGEVIEW = list.get(i).get("PAGEVIEW");
					knowledge.setPAGEVIEW(PAGEVIEW);
				}else{
					knowledge.setPAGEVIEW("");
				}
				
				if(null != list.get(i).get("DOWNLOADS") && !"".equals(list.get(i).get("DOWNLOADS"))){
					String DOWNLOADS = list.get(i).get("DOWNLOADS");
					knowledge.setDOWNLOADS(DOWNLOADS);
				}else{
					knowledge.setDOWNLOADS("");
				}
				
				if(null != list.get(i).get("TYPE") && !"".equals(list.get(i).get("TYPE"))){
					String TYPE = list.get(i).get("TYPE");
					knowledge.setTYPE(TYPE);
				}else{
					knowledge.setTYPE("");
				}
				
				lists.add(knowledge);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	
	/**
	 * 模糊查询
	 * @param title 查询条件
	 * @param start 每一页的起始数据
	 * @param end 每一页的终止数据
	 * @return lists 查询的结果列表
	 */
	public List queryPointsByTitle(String title,int start,int end){
		ArrayList lists = new ArrayList();
		//查询时，每次只查询出固定的数据量
		String sql = "select * from(select a.*,rownum rn from (select * from lida_knowledge where title like '%"+ title +"%' order by pageview desc,downloads desc,time desc) a)"
				+ " where rn between "+ start +" and "+ end;
		try {
			ArrayList<HashMap<String, String>> list = dbo.prepareQuery(sql, null);
			for(int i = 0 ; i < list.size() ; i++){
				Knowledge knowledge = new Knowledge();
				
				String ID = list.get(i).get("ID");
				if(null != ID && !"".equals(ID)){
					knowledge.setID(ID);
				}else{
					knowledge.setID("");
				}
				
				String TITLE = list.get(i).get("TITLE");
				if(null != TITLE && !"".equals(ID)){
					knowledge.setTITLE(TITLE);
				}else{
					knowledge.setTITLE("");
				}
				
				String PAGEVIEW = list.get(i).get("PAGEVIEW");
				if(null != PAGEVIEW && !"".equals(PAGEVIEW)){
					knowledge.setPAGEVIEW(PAGEVIEW);
				}else{
					knowledge.setPAGEVIEW("");
				}
				
				String DOWNLOADS = list.get(i).get("DOWNLOADS");
				if(null != DOWNLOADS && !"".equals(DOWNLOADS)){
					knowledge.setDOWNLOADS(DOWNLOADS);
				}else{
					knowledge.setDOWNLOADS("");
				}
				
				String TYPE = list.get(i).get("TYPE");
				if(null != TYPE && !"".equals(TYPE)){
					knowledge.setTYPE(TYPE);
				}else{
					knowledge.setTYPE("");
				}
				
				lists.add(knowledge);
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	
	/**
	 * 下拉框查询
	 * @param option 查询条件
	 * @param start 每一页的起始数据
	 * @param end 每一页的终止数据
	 * @return lists 查询的结果列表
	 */
	public List queryPointsByType(String option,int start,int end){
		
		ArrayList lists = new ArrayList();
		//当条件为空时展示所有数据
		String sql = "select * from(select a.*,rownum rn from (select * from lida_knowledge order by pageview desc,downloads desc,time desc) a) "
				+ "where rn between "+ start +" and "+ end;
		if(!"".equals(option)&& option!=null){
			sql="select * from(select a.*,rownum rn from (select * from lida_knowledge where type='"+option+"' order by pageview desc,downloads desc,time desc) a)"
					+ " where rn between "+ start +" and "+ end;
		}
		
		try {
			ArrayList<HashMap<String, String>> list = dbo.prepareQuery(sql, null);
			for(int i = 0 ; i < list.size() ; i++){
				Knowledge knowledge = new Knowledge();
				
				String ID = list.get(i).get("ID");
				if(!"".equals(ID) && null != ID){
					knowledge.setID(ID);
				}else{
					knowledge.setID("");
				}
				
				String TITLE = list.get(i).get("TITLE");
				if(!"".equals(TITLE) && null != TITLE){
					knowledge.setTITLE(TITLE);
				}else{
					knowledge.setTITLE("");
				}
				
				String PAGEVIEW = list.get(i).get("PAGEVIEW");
				if(!"".equals(PAGEVIEW) && null != PAGEVIEW){
					knowledge.setPAGEVIEW(PAGEVIEW);
				}else{
					knowledge.setPAGEVIEW("");
				}
				
				String DOWNLOADS = list.get(i).get("DOWNLOADS");
				if(!"".equals(DOWNLOADS) && null != DOWNLOADS){
					knowledge.setDOWNLOADS(DOWNLOADS);
				}else{
					knowledge.setDOWNLOADS("");
				}
				
				String TYPE = list.get(i).get("TYPE");
				if(!"".equals(TYPE) && null != TYPE){
					knowledge.setTYPE(TYPE);
				}else{
					knowledge.setTYPE("");
				}
				
				lists.add(knowledge);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	
	/**
	 * 我的上传
	 * @param login 查询条件
	 * @param start 每一页的起始数据
	 * @param end 每一页的终止数据
	 * @return lists 查询的结果列表
	 */
	public List queryMyPoints(String login,int start,int end){
		ArrayList lists = new ArrayList() ;
		//String sql = "select * from LIDA_KNOWLEDGE where USERCODE ='"+login+"'";
		String sql = "select * from(select a.*,rownum rn from (select * from lida_knowledge order by pageview desc,downloads desc,time desc) a) "
				+ "where rn between "+ start +" and "+ end;
		if(!"".equals(login)&& login!=null){
			
			sql= "select * from(select a.*,rownum rn from (select * from lida_knowledge where usercode ='"+login+"' order by pageview desc,downloads desc,time desc) a) "
					+ "where rn between "+ start +" and "+ end;

		}
		try {
			ArrayList<HashMap<String, String>> list = dbo.prepareQuery(sql, null);
			for(int i = 0 ;i <list.size(); i++){
				
				System.out.println("进入for循环"+list.size());
				Knowledge knowledge = new Knowledge();
				
				String ID = list.get(i).get("ID");
				if(!"".equals(ID) && null != ID){
					knowledge.setID(ID);
				}else{
					knowledge.setID("");
				}
				
				String TITLE = list.get(i).get("TITLE");
				if(!"".equals(TITLE) && null != TITLE){
					knowledge.setTITLE(TITLE);
				}else{
					knowledge.setTITLE("");
				}
				
				String PAGEVIEW = list.get(i).get("PAGEVIEW");
				if(!"".equals(PAGEVIEW) && null != PAGEVIEW){
					knowledge.setPAGEVIEW(PAGEVIEW);
				}else{
					knowledge.setPAGEVIEW("");
				}
				
				String DOWNLOADS = list.get(i).get("DOWNLOADS");
				if(!"".equals(DOWNLOADS) && null != DOWNLOADS){
					knowledge.setDOWNLOADS(DOWNLOADS);
				}else{
					knowledge.setDOWNLOADS("");
				}
				
				String TYPE = list.get(i).get("TYPE");
				if(!"".equals(TYPE) && null != TYPE){
					knowledge.setTYPE(TYPE);
				}else{
					knowledge.setTYPE("");
				}
				
				lists.add(knowledge);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lists;
	}
	
	/**
	 * 计算每一页的起止数据
	 * @param num 当前页码
	 * @param pageNum 每一页展示的数据量
	 * @return list 查询的结果列表
	 */
	public ArrayList<Integer> startAndend(String num,int pageNum){
		  ArrayList<Integer> list = new ArrayList<Integer>() ;
		  int currentpage = Integer.parseInt(num) ; //当前页码
		  int start = ((currentpage - 1) * pageNum) + 1  ; //从0开始
		  int end = (currentpage - 1) * pageNum + pageNum ;
		  list.add(start) ;
		  list.add(end) ;
		  return list ;
	  }
}
