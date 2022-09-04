<template>
  <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#304156"
      text-color="#fff"
      active-text-color="#ffd04b"
      router
      :collapse="isCollapse">
    <div></div>
    <el-menu-item index="1">
      <i class="el-icon-s-home"></i>
      <span slot="title">首页</span>
    </el-menu-item>

    <el-submenu index="2">
      <template slot="title">
        <i class="el-icon-s-grid"></i>
        <span>系统管理</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="2-1" class="el-icon-s-platform"> 设备管理</el-menu-item>
        <el-menu-item index="2-2" class="el-icon-user"> 用户管理</el-menu-item>
        <el-menu-item index="2-3" class="el-icon-s-custom"> 角色管理</el-menu-item>
        <el-menu-item index="2-4" class="el-icon-menu"> 菜单管理</el-menu-item>
        <el-menu-item index="2-5" class="el-icon-edit-outline"> 日志管理</el-menu-item>
        <el-menu-item index="2-6" class="el-icon-s-comment"> 通知管理</el-menu-item>
      </el-menu-item-group>
    </el-submenu>


    <el-submenu index="3">
      <template slot="title">
        <i class="el-icon-cpu"></i>
        <span>设备监控</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="3-1" class="el-icon-map-location"> 设备分布</el-menu-item>
        <el-menu-item index="3-2" class="el-icon-data-analysis"> 数据监控</el-menu-item>
        <el-menu-item index="3-3" class="el-icon-printer"> 设备日志</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

    <el-submenu index="4">
      <template slot="title">
        <i class="el-icon-upload"></i>
        <span>疫情监控</span>
      </template>
      <el-menu-item-group>
        <el-menu-item index="4-2" class="el-icon-view"> 虹膜数据</el-menu-item>
        <el-menu-item index="4-3" class="el-icon-discover"> 行程数据</el-menu-item>
        <el-menu-item index="4-4" class="el-icon-date"> 核酸数据</el-menu-item>
        <el-menu-item index="4-5" class="el-icon-s-marketing"> 异常监控</el-menu-item>
        <el-menu-item index="4-6" class="el-icon-data-analysis"> 全国疫情统计</el-menu-item>
      </el-menu-item-group>
    </el-submenu>

  </el-menu>
</template>

<script>
export default {
  name: "Asider",
  data() {
    return {
      isCollapse: false,
    }
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  }
}
</script>

<style lang="less" scoped>

.el-menu /deep/ {
  width: 200px;

  div {
    height: 80px;
    line-height: 80px;
    text-align: center;
    font-weight: 550;
    background-image: url("../assets/logo.png");
    background-size: 90%;
    background-repeat: no-repeat;
    background-position: center center;
  }
}

</style>
