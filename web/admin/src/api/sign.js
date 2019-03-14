import request from '@/utils/request'

export function getInfo(params) {
  return request({
    url: '/sign/info',
    method: 'get',
    params
  })
}

export function getList(params) {
  return request({
    url: '/sign/list',
    method: 'get',
    params
  })
}

export function deleteObj(params) {
  return request({
    url: '/sign/delete',
    method: 'get',
    params
  })
}

export function addOrUpdate(params) {
  return request({
    url: '/sign/addOrUpdate',
    method: 'post',
    data: params
  })
}
