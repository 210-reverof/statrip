<template>
  <div class="plan-card">
    <div class="card-background">
      <b-row>
      </b-row>
    </div>
  </div>
</template>

<script>
export default {
  components: {
  },
};
</script>

<style scoped>
.plan-card {
  margin: 60px;
}

.card-background {
  background-color: #1A4213;
  border-radius: 10px;
  height: 300px;
  width: 1500px;
  box-shadow: 0px 0px 15px rgba(0, 0, 0, 0.3);
}

.image-row {
  display: flex;
  justify-content: center;
  align-items: center;
}

.thumbnail {
  padding: 60px;
}

.content-row {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.left-align {
  text-align: left;
  margin-left: 60px;
  margin-bottom: 20px;
}

.right-align {
  text-align: right;
  margin-right: 60px;
  margin-bottom: 20px;
}
</style>
