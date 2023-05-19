
<template>
  <div class="plan-block" align="center">
    <h3>New Plans</h3>
    <div class="plan-card-container">
      <plan-card v-for="plan in plans" :key="plan.id" :plan="plan" />
    </div>
  </div>
</template>
<script>
import PlanCard from './PlanCard.vue';

export default {
  name: "PlanBlock",
  components: {
    PlanCard
  },
  data() {
    return {
      // 계획 불러오는데 일부만 뜨도록 페이징이나 select로 골라서 plans에 넣기
      // 3개씩만 표시되도록 수정하기
      plans:[
        {
          id: 1,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},
            {id:5, img: "http://placehold.it/300x200?text=No-image",},
            {id:7, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 2,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 3,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
        {
          id: 4,
          route:[{id:3, img: "http://placehold.it/300x200?text=No-image",},
           {id:1, img: "http://placehold.it/300x200?text=No-image",},
            {id:2, img: "http://placehold.it/300x200?text=No-image",},],
          writer: "Jessica_jj",
          img: "http://placehold.it/300x200?text=No-image",
          likes: "12",
          content: "이 경로 진짜 짱짱 추천입니다",
          regitdate: "2023.03.03",
        },
      ],
    }
  }
};
</script>

<style>
.plan-block {
  background-color: #E8F1E0;
  width: 100%;
  /* margin: 40px; */
}

.plan-block h3 {
  color: #1A4213; 
  font-size: 40px; 
  font-weight: bold;
  padding-top: 100px;
  padding-bottom: 60px;
}

.plan-card-container {
  padding-bottom: 100px;
}

</style>