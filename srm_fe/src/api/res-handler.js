export default {
  handle (callback) {
    return (res) => {
      console.log(res)
      if (res.data.header && res.data.header.code === 500) {
        const error = new Error(res.data.header.message)
        callback(error, null) // 오류 콜백 호출
      } else {
        callback(null, res.data.body) // 성공 콜백 호출
      }
    }
  }
}
