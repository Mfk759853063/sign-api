import request from '@/utils/request'

export function getInfo(params) {
  return request({
    url: '/ground/info',
    method: 'get',
    params
  })
}

export function getList(params) {
  return request({
    url: '/ground/list',
    method: 'get',
    params
  })
}

export function deleteObj(params) {
  return request({
    url: '/ground/delete',
    method: 'get',
    params
  })
}

export function addOrUpdate(params) {
  return request({
    url: '/ground/addOrUpdate',
    method: 'post',
    data: params
  })
}
