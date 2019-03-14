import request from '@/utils/request'

export function getInfo(params) {
  return request({
    url: '/signRule/info',
    method: 'get',
    params
  })
}

export function getList(params) {
  return request({
    url: '/signRule/list',
    method: 'get',
    params
  })
}

export function deleteObj(params) {
  return request({
    url: '/signRule/delete',
    method: 'get',
    params
  })
}

export function addOrUpdate(params) {
  return request({
    url: '/signRule/addOrUpdate',
    method: 'post',
    data: params
  })
}
