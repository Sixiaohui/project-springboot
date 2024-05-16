package com.codeying.component;

/**
 * 分页信息（用于thymeleaf分页组件）
 */
public class PagerVO {

    private int pageIndex;
    private int pageSize;
    /**
     * 记录总数
     */
    private int itemCount;
    /**
     * 分页链接格式
     */
    private String pagingFormat;

    public PagerVO(int pageIndex, int itemCount){
        this(pageIndex, 20, itemCount);
    }

    public PagerVO(int pageIndex, int pageSize, int itemCount) {
        this(pageIndex,pageSize,itemCount,"javascript:gotoPage(%s)");
    }


    public PagerVO(int pageIndex, int pageSize, int itemCount, String pagingFormat ) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.itemCount = itemCount;
        this.pagingFormat = pagingFormat;
        init();
    }

    public String getPagingFormat() {
        return pagingFormat;
    }

    public void setPagingFormat(String pagingFormat) {
        this.pagingFormat = pagingFormat;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    private int pageCount;

    public int getPageCount() {
        return pageCount;
    }

    private boolean isFirst;

    public boolean getIsFirst() {
        return isFirst;
    }

    private  boolean isLast;

    public boolean getIsLast() {
        return isLast;
    }

    private int pageStart;

    public int getPageStart() {
        return pageStart;
    }

    private int pageEnd;

    public int getPageEnd() {
        return pageEnd;
    }

    private boolean hasLessStart;

    public boolean getHasLessStart() {
        return hasLessStart;
    }

    private boolean hasGreaterEnd;

    public boolean getHasGreaterEnd() {
        return hasGreaterEnd;
    }

    private void  init() {

        double pc = itemCount * 1d / pageSize;
        pageCount = (int) Math.ceil(pc);

        isFirst = pageIndex <= 1;
        isLast = pageIndex >= pageCount;

        pageStart = pageIndex / 10 * 10;
        if (pageIndex % 10 == 0) {
            pageStart -= 10;
        }
        pageStart = pageStart + 1;

        pageEnd = pageStart + 9;
        if (pageEnd > pageCount) {
            pageEnd = pageCount;
        }
        if(pageCount==0){
            pageEnd=1;
        }

        hasLessStart = (pageStart - 1) > 0;
        hasGreaterEnd = (pageEnd + 1) < pageCount;
    }
}
