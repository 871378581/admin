package com.segama.ege.dto;

public class BasePageDTO {
    private PageDTO page;

    public PageDTO getPage() {
        return page;
    }

    public void setPage(PageDTO page) {
        this.page = page;
    }

    public void addPageInfo(int totalPage, int currentPage) {
        PageDTO pageDTO = new PageDTO();
        pageDTO.totalPage = totalPage;
        pageDTO.currentPage = currentPage;
        this.setPage(pageDTO);
    }

    public static class PageDTO {
        private int totalPage;
        private int currentPage;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }
    }
}

