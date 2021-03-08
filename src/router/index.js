import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/components/Login'
import File from '@/components/File'

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: Login
    },
    {
      path: '/file',
      name: 'File',
      component: File
    }
  ]
})
