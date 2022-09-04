<template>
  <div>
    <div class="bead">
      <el-breadcrumb separator-class="el-icon-arrow-right">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item>疫情监控</el-breadcrumb-item>
        <el-breadcrumb-item>全国疫情统计</el-breadcrumb-item>
      </el-breadcrumb>
    </div>
    <div class="avatar">
      <el-dropdown>
        <el-avatar shape="square" :size="medium" :src="squareUrl"></el-avatar>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>
          </el-dropdown-item>
          <el-dropdown-item disabled>个人信息</el-dropdown-item>
          <el-dropdown-item divided>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>


    </div>
  </div>
</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      // squareUrl: "https://img1.baidu.com/it/u=284598427,3453401726&fm=253&fmt=auto&app=138&f=JPG?w=501&h=500",
      squareUrl: "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.duoziwang.com%2F2019%2F06%2F09221645716909.jpg&refer=http%3A%2F%2Fimg.duoziwang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1660014592&t=4817dd17432ccfa79ee37f369a483262",
    }
  }
}
</script>

<style scoped lang="less">
div {
  height: 78px;
  background-color: white;
  margin-left: 0;

  .bead {
    display: inline-block;
    float: left;
    height: 100%;
    margin-left: 20px;
    .el-breadcrumb {
      color: white;
      height: 30px;
      font-size: large;
      margin-top: 30px;
    }
  }

  .avatar {
    display: inline-block;
    float: right;
    height: 100%;
    margin-right: 50px;

    .el-avatar {
      margin: 20px
    }
  }
}

</style>
