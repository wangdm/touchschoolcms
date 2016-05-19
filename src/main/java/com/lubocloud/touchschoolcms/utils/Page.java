package com.lubocloud.touchschoolcms.utils;

public class Page {
	
	private int currentPage;//当前页
	
	private int pageSize;//每页行数
	
	private int totalCount;//总行数
	
	private int totalPage;//总页数

	public Page() {
		this.currentPage = 0;
		this.pageSize = 10;
		this.totalCount = 0;
		this.totalPage = 0;
	}

	public Page(int currentPage, int pageSize, int totalCount) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		int tmp = totalCount % pageSize;
		if(tmp==0){
			this.totalPage = totalCount / pageSize;
		}else{
			this.totalPage = totalCount / pageSize + 1;
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		int tmp = this.totalCount % pageSize;
		if(tmp==0){
			this.totalPage = this.totalCount / pageSize;
		}else{
			this.totalPage = this.totalCount / pageSize + 1;
		}
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		int tmp = totalCount % this.pageSize;
		if(tmp==0){
			this.totalPage = totalCount / this.pageSize;
		}else{
			this.totalPage = totalCount / this.pageSize + 1;
		}
	}

	public int getTotalPage() {
		return totalPage;
	}

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//	}
	
}

	
	
