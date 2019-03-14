<template>
  <div class="app-container">
    <el-form ref="form" :model="ground" :rules="rules2" label-width="120px">
      <el-form-item label="场地名称" prop="groundName">
        <el-input v-model="ground.groundName"/>
      </el-form-item>
      <el-form-item label="场地地点" prop="groundAddr">
        <el-input v-model="ground.groundAddr"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import { addOrUpdate } from '@/api/ground'

import { getInfo } from '@/api/ground'

export default {
  data() {
    return {
      ground: {},
      rules2: {
        groundName: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ],
        groundAddr: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  mounted() {
    if (this.$route.query.id) {
      this.fetchData()
    }
  },
  methods: {
    fetchData() {
      const params = {
        id: this.$route.query.id
      }
      getInfo(params).then(response => {
        this.ground = response.data
      })
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const params = this.ground
          params.activityId = this.$route.query.activityId
          addOrUpdate(params).then(response => {
            this.$router.push({ name: 'groundList', query: { activityId: this.$route.query.activityId }})
          })
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style scoped>
.line{
  text-align: center;
}
</style>

