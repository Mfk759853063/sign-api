<template>
  <div class="app-container">
    <div v-if="activity.activityStartTime" class="tip">
      有效的签到时间为{{ dayjs(activity.activityStartTime).format('YYYY-MM-DD hh:mm:ss') }}  ~ {{ dayjs(activity.activityEndTime).format('YYYY-MM-DD hh:mm:ss') }}
    </div>
    <el-form ref="form" :model="rule" :rules="rules2" label-width="120px">
      <el-form-item label="签到规则名称" prop="signRuleName">
        <el-input v-model="rule.signRuleName"/>
      </el-form-item>
      <el-form-item label="最多签到次数" prop="userSignTimes">
        <el-input v-model="rule.userSignTimes"/>
      </el-form-item>
      <el-form-item label="签到时间">
        <el-date-picker
          v-model="defaultSignTime"
          type="datetimerange"
          range-separator="至"
          start-placeholder="签到开始日期"
          end-placeholder="签到结束日期"
          align="right"/>
      </el-form-item>
      <el-form-item>
        <el-button class="add" type="primary" @click="onSubmit('form')">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

import { addOrUpdate } from '@/api/rules'

import { getInfo } from '@/api/rules'

import { getInfo as getActivityInfo } from '@/api/activity'

export default {
  data() {
    return {
      rule: {},
      ground: {},
      activity: {},
      defaultSignTime: [],
      rules2: {
        signRuleName: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ],
        userSignTimes: [
          { required: true, message: '不能为空', trigger: 'blur' }
        ]
      }
    }
  },
  mounted() {
    if (this.$route.query.id) {
      this.fetchData()
    }
    this.fetchActivityInfo()
  },
  methods: {
    fetchActivityInfo() {
      const params = {
        id: this.$route.query.activityId
      }
      getActivityInfo(params).then(response => {
        this.activity = response.data
        this.defaultSignTime = [this.activity.activityStartTime, this.activity.activityEndTime]
      })
    },
    fetchData() {
      const params = {
        id: this.$route.query.id
      }
      getInfo(params).then(response => {
        this.activity = response.data.activity
        this.rule = response.data.rule
        this.ground = response.data.ground
      })
    },
    onSubmit(formName) {
      this.$refs[formName].validate((valid) => {
        if (valid) {
          const signStartTime = this.defaultSignTime[0]
          const signEndTime = this.defaultSignTime[1]
          if (signStartTime >= this.activity.activityStartTime && signStartTime <= this.activity.activityEndTime && signEndTime > signStartTime && signEndTime <= this.activity.activityEndTime) {
            const params = this.rule
            params.groundId = this.$route.query.groundId
            params.signStartTime = this.dayjs(signStartTime).valueOf()
            params.signEndTime = this.dayjs(signEndTime).valueOf()
            addOrUpdate(params).then(response => {
              this.$router.go(-1)
            })
          } else {
            this.$message('时间必须在区间范围内')
            return false
          }
        } else {
          return false
        }
      })
    }
  }
}
</script>

<style scoped>
.tip{
  text-align: center;
  margin-bottom: 30px;
  color: orange;
}
.add {
  width: 100%;
}
</style>

