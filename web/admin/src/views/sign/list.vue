<template>
  <div class="app-container">
    <el-table
      v-loading="listLoading"
      :data="list"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row>
      <el-table-column align="center" label="活动名称">
        <template slot-scope="scope">
          {{ scope.row.activity.activityName }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="活动场地">
        <template slot-scope="scope">
          {{ scope.row.ground.groundName }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="签到人ID">
        <template slot-scope="scope">
          {{ scope.row.userId }}
        </template>
      </el-table-column>
      <el-table-column align="center" label="签到时间">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.signTime).format('YYYY-MM-DD hh:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-button type = "text" @click="deleteObj(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getList } from '@/api/sign'

import { deleteObj } from '@/api/sign'

export default {
  data() {
    return {
      list: [],
      activity: {},
      ground: {},
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
        activityId: this.$route.query.activityId,
        groundId: this.$route.query.groundId
      }
      getList(params).then(response => {
        this.list = response.data
        this.listLoading = false
      })
    },
    deleteObj(sign) {
      this.$confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const params = {
          id: sign.id
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
