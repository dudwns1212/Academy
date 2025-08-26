<template>
<!-- 메뉴 검은부분 -->
<div style="padding-top: 74px; text-align: center;">
    <div class="d-flex flex-column justify-content-center align-items-center">
            <h1 class="display-4">이용요금</h1>
            <br>
            <br>
            <h3 class="fw-normal">업무 환경에 맞게 도입할 수 있도록 다양한 상품을 제공합니다.</h3>
    </div>
    <div class="mb-5">
        <p style="margin-top: 10px;margin-left: 40px; color: blue;">*연간 계약 시 최대 20% 할인</p>
        <label style="font-size: medium; margin-right: 20px;">
            <input type="radio" value="year" v-model="sales" /> 연간
        </label>
        <label style="font-size: medium;">
            <input type="radio" value="month" v-model="sales" checked/> 월간
        </label>
    </div>
</div>
<div class="center-container d-flex justify-center align-items-center">
    <div class="card shadow-sm p-6" style="min-height: 700px;">
    <!-- 가격제목 -->
        <h3 class="fs-2 fw-bold mb-1">-Free-</h3>
        <div class="fs-1 fw-bold text-primary mb-2">0원</div>
        <div class="text-gray-700 mb-6">
            최대 10명까지 무료로 사용하는<br />
            팀 커뮤니케이션 플랜
        </div>
        
        <!-- 버튼 -->
        <button class="btn btn-outline-primary w-100 mb-5">무료체험 신청</button>

        <!-- 리스트 -->
        <div class="text-gray-800">
            <div class="mb-2 fw-semibold">📂 공용 용량</div>
            <div class="mb-4">✅ 2GB 기본 제공</div>

            <div class="mb-2 fw-semibold">👥 구성원 수</div>
            <div class="mb-4">✅ 10명까지 추가 가능</div>

            <div class="mb-2 fw-semibold">⚙️ 기본 기능</div>
            <ul class="list-unstyled">
                <li>✅ 메시지</li>
                <li>✅ 최대 4명 음성/영상 통화 (60분)</li>
                <li>✅ 최대 4명 화면 공유 (60분)</li>
                <li>✅ 게시판</li>
                <li>✅ 캘린더</li>
                <li>✅ 주소록 (조직도 기반)</li>
            </ul>
        </div>
    </div>

    <div class="card shadow-sm p-6" style="min-height: 700px;">
    <!-- 가격제목 -->
        <h3 class="fs-2 fw-bold mb-1">-Pro-</h3>
        <div class="fs-1 fw-bold text-primary mb-2">{{ sales == 'month' ? '7900원' : '7000원' }}</div>
        <div class="text-gray-700 mb-6">
            기업용 메일과 협업용 드라이브를<br />
            제공하는 플랜
        </div>

        <!-- 버튼 -->
        <button class="btn btn-outline-primary w-100 mb-5">결제</button>

        <!-- 리스트 -->
        <div class="text-gray-800">
            <div class="mb-2 fw-semibold">📂 공용 용량</div>
            <div class="mb-4">✅ 인당 100GB 기본 제공</div>

            <div class="mb-2 fw-semibold">👥 구성원 수</div>
            <div class="mb-4">✅ 제한 없음</div>

            <div class="mb-2 fw-semibold">⚙️ Free의 모든 기능에 추가로</div>
            <ul class="list-unstyled">
                <li>✅ 메일 기능 제공</li>
                <li>✅ 메일 용량 제공(100GB/인)</li>
                <li>✅ 최대 200명 음성/영상 통화 (300분)</li>
                <li>✅ 최대 200명 화면 공유 (300분)</li>
                <li>✅ 드라이브 기능 제공<br />->동영상 뷰어(mov,mp4 등) </li>
            </ul>
        </div>
    </div>

    <div class="card shadow-sm p-6" style="min-height: 700px;">
    <!-- 가격제목 -->
        <h3 class="fs-2 fw-bold mb-1">Pro Max</h3>
        <div class="fs-1 fw-bold text-primary mb-2">{{ sales == 'month' ? '11900원' : '9500원' }}</div>
        <div class="text-gray-700 mb-6">
            대용량 저장 공간, 문서 공동 편집,<br />
            AI 부가 기능을 제공하는 플랜
        </div>

        <!-- 버튼 -->
        <button class="btn btn-outline-primary w-100 mb-5">결제</button>

        <!-- 리스트 -->
        <div class="text-gray-800">
            <div class="mb-2 fw-semibold">📂 공용 용량</div>
            <div class="mb-4">✅ 1TB 기본 제공</div>

            <div class="mb-2 fw-semibold">👥 구성원 수</div>
            <div class="mb-4">✅ 제한 없음</div>

            <div class="mb-2 fw-semibold">⚙️ Pro의 모든 기능에 추가로</div>
            <ul class="list-unstyled">
                <li>✅ 메일 용량 확장 (3TB/인)</li>
                <li>✅ 최대 200명 음성/영상 통화 (무제한)</li>
                <li>✅ 최대 200명 화면 공유 (무제한)</li>
                <li>✅ 드라이브 고급 기능 추가<br />->문서 공동 편집</li>
                <li>✅ WORKS AI 생산성 기능</li>       
            </ul>
        </div>
    </div>
</div>
</template>

<script setup>
import { ref, onMounted } from 'vue'

//스토어 불러오기
import { storeToRefs } from 'pinia';

import { useAppStore } from '@/stores/app';
const appStore = useAppStore();
const { title } = storeToRefs(appStore);

onMounted(() => {
  console.log(`FeeView : onMounted 호출됨`);

  title.value = '이용요금';

})

const sales = ref('month');


</script>

<style scoped>

.menu-link {
  transition: color 0.2s;
}
.menu-link:hover, .menu-link:focus {
  color: #009ef7 !important; /* 기존 메뉴의 파란색 */
}


</style>
