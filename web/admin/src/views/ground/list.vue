<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="场地名称">
        <template slot-scope="scope">
          {{ scope.row.groundName }}
        </template>
      </el-table-column>
      <el-table-column label="场地地点" align="center">
        <template slot-scope="scope">
          {{ scope.row.groundAddr }}
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.createTime).format('YYYY-MM-DD hh:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="管理" align="center">
        <template slot-scope="scope">
          <el-button type = "text" @click="handleTimeRulesList(scope.row)">签到时间管理</el-button>
          <el-button type = "text" >|</el-button>
          <el-button type = "text" @click="handleSignList(scope.row)">签到人数</el-button>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type = "text" @click="update(scope.row)">修改</el-button>
          <span>|</span>
          <el-button type = "text" @click="deleteObj(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-button :disabled="canAdd === false" class="add" type="primary" @click="handleAdd()">新增活动场地</el-button>
  </div>
</template>

<script>
import { getList } from '@/api/ground'

import { deleteObj } from '@/api/ground'

export default {
  data() {
    return {
      canAdd: false,
      list: null,
      listLoading: true
    }
  },
  created() {
    if (this.$route.query.activityId) {
      this.fetchData()
    }
  },
  methods: {
    fetchData() {
      this.listLoading = true
      const params = {
        activityId: this.$route.query.activityId
      }
      getList(params).then(response => {
        this.list = response.data
        this.listLoading = false
        this.canAdd = true
      })
    },
    update(ground) {
      this.$router.push({ name: 'groundEdit', query: { id: ground.id, activityId: this.$route.query.activityId }})
    },
    handleTimeRulesList(ground) {
      this.$router.push({ name: 'ruleList', query: { groundId: ground.id, activityId: this.$route.query.activityId }})
    },
    handleSignList(ground) {
      this.$router.push({ name: 'signList', query: { groundId: ground.id, activityId: this.$route.query.activityId }})
    },
    handleAdd() {
      this.$router.push({ name: 'groundEdit', query: { activityId: this.$route.query.activityId }})
    },
    deleteObj(ground) {
      this.$confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const params = {
          id: ground.id
        }
        deleteObj(params).then(response => {
          this.$message({
            type: 'success',
            message: '删除成功!'
          })
          this.fetchData()
        })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
      })
    }
  }
}
</script>

<style scoped>
.add {
  width: 100%;
  margin-top: 30px;
}
</style>
