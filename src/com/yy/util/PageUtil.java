package com.yy.util;

public class PageUtil {
	//������ҳ��Ϣ
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
		return everyPage == 0 ? 10:everyPage;//��ȡÿҳ��¼��
	}
	public static int getCurrentPage(int currentPage){
		return currentPage == 0 ? 1 : currentPage;//��ȡ��ǰҳ
	}
	//��ȡ��ҳ��
	public static int getTotalPage(int everyPage,int totalCount){
		int totalPage = 0;
		if(totalCount != 0 &&totalCount % everyPage == 0){
			totalPage = totalCount/everyPage;
		}else{
			totalPage = totalCount/everyPage+1;
		}
		return totalPage;
	}
	//��ȡ��ʼλ��
	public static int getBeginIndex(int everyPage,int currentPage){
		return(currentPage - 1) * everyPage;
	}
	//�Ƿ�����һҳ
	public static boolean hasPrePage(int currentPage){
		return currentPage == 1 ? false:true;
	}
	//�Ƿ�����һҳ
	public static boolean hasNextPage(int totalPage,int currentPage){
		return currentPage == totalPage || totalPage == 0 ? false:true;
	}
}
