package com.sweet.cakeonline.cake.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sweet.cakeonline.cake.dao.CakeDaoImpl;
import com.sweet.cakeonline.entity.Cake;
import com.sweet.cakeonline.entity.PageBean;

@Service
@Transactional(readOnly=true)
public class CakeServiceImpl {

	@Resource
	private CakeDaoImpl cakeDaoImpl;
	//查找所有蛋糕
	public List<Cake> listAll(){
		return this.cakeDaoImpl.findAll();
	}
	//删除一个蛋糕
	public void deleteOneCake(Cake c) {
		this.cakeDaoImpl.deleteCake(c);
	}
	//更新一个蛋糕
	public void updateOneCake(Cake c) {
		this.cakeDaoImpl.updateCake(c);
	}
	//增加蛋糕
	public void addOneCake(Cake c) {
		this.cakeDaoImpl.saveCake(c);
	}

	//得到总页码数
	public int getPageCount() {
		 return (int) Math.ceil((this.cakeDaoImpl.findRowsCount()/6));		
	}
	/**
     * 分页查询 
     * @param currentPage 当前页号：现在显示的页数
     * @param pageSize 每页显示的记录条数
     * @return 封闭了分页信息(包括记录集list)的Bean
     * */
    @SuppressWarnings("unchecked")
    public PageBean queryForPage(int currentPage,int pageSize) {
        // TODO Auto-generated method stub

        PageBean page = new PageBean();        
        //总记录数
      int allRow = this.cakeDaoImpl.findRowsCount();
        //当前页开始记录
        int offset = page.countOffset(currentPage,pageSize);  
        //分页查询结果集
        List<Cake> list = this.cakeDaoImpl.queryForPage(offset, pageSize); 

        page.setPageNo(currentPage);
        page.setPageSize(pageSize);
        page.setTotalRecords(allRow);
        page.setList(list);
        
        return page;
    }

}
