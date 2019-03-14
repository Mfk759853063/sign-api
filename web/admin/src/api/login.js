import request from '@/utils/request'

export function login(username, password) {
  return request({
    url: '/sys/login',
    method: 'post',
    data: {
      userName: username,
      userPwd: password
    }
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    params: { token }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
