<template>
    <div class="plan-item">
        <div class="place-idx">1</div>
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
    width: 90%;
    height: 200px;
    box-shadow: 0 0px 10px rgba(0, 0, 0, 0.4);
    margin-left: 10px;
    margin-top: 10px;
    margin-bottom: 20px;
    position: relative;
}

.place-idx {
  position: absolute;
  top: 10px; 
  left: 10px; 
  background-color: rgb(52, 114, 50);
  border-radius: 50px;
  box-shadow: 0 0px 4px rgba(0, 0, 0, 0.3);
  color: white;
  padding: 3px 8px; 
  font-size: 14px; 
  font-weight: bold;
}

.place-image {
  width: 100%;
  height: 140px;
  object-fit: cover;
}

.place-name {
    text-align: start;
    margin-top: 4px;
    margin-left: 12px;
    font-size: 16px;
    padding-top: 4px;
}

.place-addr{
    text-align: start;
    margin-left: 12px;
    font-size: 12px;
}
</style>
