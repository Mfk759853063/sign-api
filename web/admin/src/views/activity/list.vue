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
      <el-table-column align="center" label="活动名称">
        <template slot-scope="scope">
          {{ scope.row.activityName }}
        </template>
      </el-table-column>
      <el-table-column label="活动描述" align="center">
        <template slot-scope="scope">
          {{ scope.row.activityDesc }}
        </template>
      </el-table-column>
      <el-table-column label="活动开始时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.activityStartTime).format('YYYY-MM-DD hh:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="活动结束时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.activityEndTime).format('YYYY-MM-DD HH:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建时间" align="center">
        <template slot-scope="scope">
          <span>{{ dayjs(scope.row.createTime).format('YYYY-MM-DD hh:mm:ss') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="管理" align="center">
        <template slot-scope="scope">
          <el-button type = "text" @click="handleGroundList(scope.row)">场地列表</el-button>
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
  </div>
</template>

<script>
import { getList } from '@/api/activity'

import { deleteObj } from '@/api/activity'

export default {
  data() {
    return {
      list: null,
      listLoading: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      getList(this.listQuery).then(response => {
        this.list = response.data
        this.listLoading = false
      })
    },
    update(activity) {
      this.$router.push({ name: 'activityEdit', query: { id: activity.id }})
    },
    handleGroundList(activity) {
      this.$router.push({ name: 'groundList', query: { activityId: activity.id }})
    },
    deleteObj(activity) {
      this.$confirm('确定要删除吗?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        const params = {
          id: activity.id
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
