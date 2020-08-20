package utils;

import java.util.ArrayList;
import java.util.List;

import bean.Drug;

public class FenYe {
	private int startRow =0; //开始行
	private int endRow =0;   //结束行
	private int  pageTotal =0;//总页数
	private int pageSize = 25; //一页的最多行
	
	
	public int getPageTotal(int rowTotal){
		
		pageTotal = (int) Math.ceil(rowTotal/pageSize);
		return pageTotal;
		
	}
	
	public int getStartRow(int pageNum)
	{
		
		
		startRow = pageSize * (pageNum - 1);
		
		return startRow;
		
	}
	
	public int getEndRow(int pageNum,int rowTotal)
	{
		
		
		startRow = pageSize * (pageNum - 1);
		endRow = startRow + pageSize;
		endRow = (rowTotal > endRow) ? endRow : rowTotal;
		return endRow;
		
	}
	
	
	

}
