<template>
  <el-container class="body">
    <asider>
      <Asider></Asider>
    </asider>
    <el-container>
      <el-header class="header" height="80px">
        <Header></Header>
      </el-header>
      <el-main>组件展示界面</el-main>
    </el-container>
  </el-container>
</template>

<script>
import Asider from "@/components/Asider";
import Header from "@/components/Header";

export default {
  name: "Base",
  components: {
    Asider,
    Header
  }
}
</script>

<style lang="less" scoped>

.body /deep/ {
  height: 100vh;

  .el-container {

    .el-header {
      background-color: palegoldenrod;
      padding: 0;
      border-bottom: black 2px solid;
      margin-bottom: 50px;
    }

  }


}


</style>
