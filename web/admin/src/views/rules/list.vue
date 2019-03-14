<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="data.rules"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="签到时间段名称">
        <template slot-scope="scope">
          {{ scope.row.signRuleName }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="可签到次数">
        <template slot-scope="scope">
          {{ scope.row.userSignTimes }}
        </template>
      </el-table-column>
      <el-table-column label="签到开始时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.signStartTime).format('YYYY-MM-DD hh:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="签到结束时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.signEndTime).format('YYYY-MM-DD HH:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.createTime).format('YYYY-MM-DD hh:mm:ss') }}</span>
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
    <el-button :disabled="canAdd === false" class="add" type="primary" @click="handleAdd()">新增签到时间段</el-button>
  </div>
</template>

<script>
import { getList } from '@/api/rules'

import { deleteObj } from '@/api/rules'

export default {
  data() {
    return {
      canAdd: false,
      listLoading: true,
      data: {}
    }
  },
  created() {
    if (this.$route.query.groundId) {
      this.fetchData()
    }
  },
  methods: {
    fetchData() {
      this.listLoading = true
      const params = {
        groundId: this.$route.query.groundId
      }
      getList(params).then(response => {
        this.data = response.data
        console.log(this.data)
        this.listLoading = false
        this.canAdd = true
      })
    },
    update(signRule) {
      this.$router.push({ name: 'ruleEdit', query: { id: signRule.id, activityId: this.$route.query.activityId }})
    },
    handleAdd() {
      this.$router.push({ name: 'ruleEdit', query: { groundId: this.$route.query.groundId, activityId: this.$route.query.activityId }})
    },
    deleteObj(signRule) {
      this.$confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const params = {
          id: signRule.id
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
