import request from '@/utils/request'

export function getInfo(params) {
  return request({
    url: '/activity/info',
    method: 'get',
    params
  })
}

export function getList(params) {
  return request({
    url: '/activity/list',
    method: 'get',
    params
  })
}

export function deleteObj(params) {
  return request({
    url: '/activity/delete',
    method: 'get',
    params
  })
}

export function addOrUpdate(params) {
  return request({
    url: '/activity/addOrUpdate',
    method: 'post',
    data: params
  })
}
