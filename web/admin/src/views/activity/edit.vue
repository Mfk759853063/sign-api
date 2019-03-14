<template>
  <div class="app-container">
    <el-form ref="form" :model="activity" :rules="rules2" label-width="120px">
      <el-form-item label="活动名称" prop="activityName">
        <el-input v-model="activity.activityName"/>
      </el-form-item>
      <el-form-item label="活动描述" prop="activityDesc">
        <el-input v-model="activity.activityDesc"/>
      </el-form-item>
      <el-form-item label="开始时间" prop="activityStartTime">
        <el-date-picker v-model="activity.activityStartTime" type="date" placeholder="开始时间" style="width: 100%;"/>
      </el-form-item>
      <el-form-item label="结束时间" prop="activityEndTime">
        <el-date-picker v-model="activity.activityEndTime" type="date" placeholder="结束时间" style="width: 100%;"/>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit('form')">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import { addOrUpdate } from '@/api/activity'

import { getInfo } from '@/api/activity'

export default {
  data() {
    var timeValidator = (rule, value, callback) => {
      if (value < this.activity.activityStartTime) {
        callback(new Error('结束时间大于开始时间'))
      } else {
        callback()
      }
    }
    return {
      activity: {},
      rules2: {
        activityName: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ],
        activityDesc: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ],
        activityStartTime: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ],
        activityEndTime: [
          { required: true, message: '不能为空', trigger: 'blur' },
          { validator: timeValidator, trigger: 'blur' }
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
        this.activity = response.data
      })
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const params = this.activity
          params.activityStartTime = this.dayjs(this.activity.activityStartTime).valueOf()
          params.activityEndTime = this.dayjs(this.activity.activityEndTime).valueOf()
          addOrUpdate(params).then(response => {
            this.$router.push({ path: '/activity/list' })
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

