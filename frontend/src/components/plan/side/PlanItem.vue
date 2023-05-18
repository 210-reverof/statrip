<template>
    <div class="plan-item">
        <img class="place-image" src="https://via.placeholder.com/300x200">
        <div class="place-name">장소이름</div>
        <div class="place-addr">주소</div>
    </div>
</template>

<script>
export default {
    name: "PlanItem",

}
</script>

<style scoped>
.plan-item {
    width: 80%;
    height: 25%;
    box-shadow: 0 0px 10px rgba(0, 0, 0, 0.4);
}

.place-image {
  width: 100%;
  height: 75%;
  object-fit: cover;
}

.place-name {
    font-size: 16px;
    padding-top: 4px;
}

.place-addr{
    font-size: 12px;
}
</style>
