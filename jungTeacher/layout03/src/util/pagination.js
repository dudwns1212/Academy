///
/// 페이지네이션을 위한 Composable 모듈
///

import { ref } from 'vue';

export const usePagination = () => {

    ///
    /// 페이지네이션 객체를 만들기 위한 함수
    ///
    const makePagination = (header) => {
        console.log(`makePagination 호출됨 : ${JSON.stringify(header)}`);

        const pagination = {};

        let curPage = Number(header.page);
        let perPage = Number(header.perPage);
        let totalRecords = header.total;
        console.log(`헤더 : ${curPage}, ${perPage}, ${totalRecords}`);

        let pageCount = Math.ceil(totalRecords / perPage);
        console.log(`페이지 개수 : ${pageCount}`);

        // 한 번에 보여줄 페이지 개수
        let unitPage = 10;

        // 시작 페이지의 인덱스
        let startPageIndex = Math.floor((curPage-1)/unitPage) * unitPage;

        let endPage = pageCount - startPageIndex;
        if (endPage > unitPage) {
            endPage = startPageIndex + unitPage;
        } else {
            endPage = startPageIndex + endPage;
        }
        console.log(`시작 페이지 인덱스와 끝 페이지 : ${startPageIndex}, ${endPage}`);

        const pages = [];
        for (let i = startPageIndex; i < endPage; i++) {
            if ((i+1) == curPage) {
                pages.push({
                    pageNo: i+1,
                    pageActive: true
                })
            } else {
                pages.push({
                    pageNo: i+1,
                    pageActive: false
                })
            }
        }

        pagination.page = curPage;
        pagination.perPage = perPage;
        pagination.total = totalRecords;

        pagination.pages = pages;
        pagination.pageCount = pageCount;
 
        return pagination;
    }

    return { makePagination }
}