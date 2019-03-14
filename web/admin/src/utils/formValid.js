/**
 * Created by jiachenpan on 16/11/18.
 */

export var notEmpty = (rule, value, callback) => {
  if (!value || value === '') {
    callback(new Error('不能为空'))
  } else {
    callback()
  }
}
