package com.yy.util;

public class PageUtil {
	//创建分页信息
	public static Page createPage(int everyPage,int totalCount,int currentPage){
		everyPage = getEveryPage(everyPage);
		currentPage = getCurrentPage(currentPage);
		int beginIndex = getBeginIndex(everyPage, currentPage);
		int totalPage = getTotalPage(everyPage, totalCount);
		boolean hasPrePage = hasNextPage(totalPage, currentPage);
		boolean hasNextPage = hasNextPage(totalPage, currentPage);
		return new Page(everyPage, totalCount, totalPage, currentPage, beginIndex, hasPrePage, hasNextPage);
	}
	public static int getEveryPage(int everyPage){
		return everyPage == 0 ? 10:everyPage;//获取每页记录数
	}
	public static int getCurrentPage(int currentPage){
		return currentPage == 0 ? 1 : currentPage;//获取当前页
	}
	//获取总页数
	public static int getTotalPage(int everyPage,int totalCount){
		int totalPage = 0;
		if(totalCount != 0 &&totalCount % everyPage == 0){
			totalPage = totalCount/everyPage;
		}else{
			totalPage = totalCount/everyPage+1;
		}
		return totalPage;
	}
	//获取起始位置
	public static int getBeginIndex(int everyPage,int currentPage){
		return(currentPage - 1) * everyPage;
	}
	//是否有上一页
	public static boolean hasPrePage(int currentPage){
		return currentPage == 1 ? false:true;
	}
	//是否有下一页
	public static boolean hasNextPage(int totalPage,int currentPage){
		return currentPage == totalPage || totalPage == 0 ? false:true;
	}
}
