<template>
  <div class="dashboard-container">
    <div class="dashboard-text">Welcome {{ name }}</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name',
      'roles'
    ])
  }
}
</script>

<style rel="stylesheet/css" scoped>

.dashboard-container {
  text-align: center;
  margin: 30px;
}

.dashboard-text {
  font-size: 30px;
  line-height: 46px;
}

</style>
