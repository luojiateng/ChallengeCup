<template>
  <div style="width: 250px;position: absolute;left: 40%;top: 30%;">
    <el-card class="box-card">
      <el-tabs style="border: red" :stretch="true" v-model="activeTab">
        <el-tab-pane label="登录" name="first">
          <div>
            <el-form :model="loginform" style="width: 200px;margin-left: 0">
              <el-form-item label="账 号:" :label-width="formWid">
                <el-input v-model.trim="loginform.username" autocomplete="off" placeholder="请输入账号"></el-input>
              </el-form-item>
              <el-form-item label="密 码:" :label-width="formWid">
                <el-input type="password" v-model.trim="loginform.password" autocomplete="off" placeholder="请输入密码"
                          show-password></el-input>
              </el-form-item>
            </el-form>
            <el-button type="primary" style="position: center;width: 100%" @click="login">登录</el-button>
          </div>
        </el-tab-pane>

        <el-tab-pane label="注册" name="second">
          <div>
            <el-form :model="registerForm" style="width: auto;margin-left: 0">
              <el-form-item label="账号:" :label-width="formWid">
                <el-input v-model.trim="registerForm.username" autocomplete="off" placeholder="请输入账号"></el-input>
              </el-form-item>
              <el-form-item label="密码:" :label-width="formWid">
                <el-input type="password" v-model.trim="registerForm.password" autocomplete="off" placeholder="请输入密码"
                          show-password></el-input>
              </el-form-item>
              <el-form-item label="重复:" :label-width="formWid">
                <el-input type="password" v-model.trim="registerForm.repectPass" autocomplete="off" placeholder="请确认密码"
                          show-password></el-input>
              </el-form-item>
            </el-form>
            <el-button type="primary" style="position: center;width: 100%" @click="regist">注册</el-button>
          </div>
        </el-tab-pane>

      </el-tabs>
    </el-card>
  </div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "Login",
  data() {
    return {
      input: "",
      formWid: '50px',
      activeTab: "first",
      loginform: {
        username: "",
        password: ""
      },
      registerForm: {
        username: "",
        password: "",
        repectPass: ""
      }
    }
  },
  methods: {
    login() {
      if (this.loginform.username == "" || this.loginform.password == "") {
        this.$message.error("请输入用户名和密码")
        return false
      }
      request.post("/user/login", this.loginform).then(res => {

        if (res.code === '200') {
          localStorage.setItem("user", JSON.stringify(res.data))
          this.$message.success("登录成功")
          this.$router.push('/home')
        } else {
          this.$message.error(res.msg)
        }
      })
    },
    regist() {
      if (this.registerForm.password !== this.registerForm.repectPass) {
        this.$message.error("密码两次输入不一致")
        return false
      }
      request.post("/user/regist", this.registerForm).then(res => {
            if (res.code === '200') {
              this.$message.success('注册成功,为您自动登录,已跳转至个人信息界面')
              request.post("/user/login", this.registerForm).then(res => {

                if (res.code === '200') {
                  localStorage.setItem("user", JSON.stringify(res.data))
                  this.$router.push('/person')
                } else {
                  this.$message.error(res.msg)
                }
              })
            } else {
              this.$message.error(res.msg)
            }
          }
      )
    }
  }
}
</script>

<style scoped>

</style>
