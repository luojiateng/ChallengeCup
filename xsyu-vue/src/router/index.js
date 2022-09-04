import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
const routes = []

const router = new VueRouter({
    mode: 'history',
    routes
})

router.beforeEach((to, from, next) => {
    next()


})


export default router
