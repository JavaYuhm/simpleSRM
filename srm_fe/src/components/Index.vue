<template lang="pug">
.bp-content-container
  nav-bar(
    :stickyMode='stickyMode'
    @onOpenLoginModal='openLoginModal'
    @onOpenJoinModal='openJoinModal'
    @onLogout='logout'
  )
  router-view.router
  login-modal(
    v-if='isLoginModalOpen'
    :isOpen='isLoginModalOpen'
    @onCloseModal='isLoginModalOpen = false'
  )
  Join-modal(
    v-if='isJoinModalOpen'
    :isOpen='isJoinModalOpen'
    @onCloseModal='isJoinModalOpen = false'
  )
</template>

<script>
import NavBar from './NavBar'
import LoginModal from './LoginModal'
import JoinModal from './JoinModal'
import { mapGetters, mapMutations } from 'vuex'

export default {
  components: { NavBar, LoginModal, JoinModal },
  data () {
    return {
      isLoginModalOpen: false,
      isJoinModalOpen: false,
      isScrollTop: true
    }
  },
  created () {
    window.addEventListener('scroll', e => { this.isScrollTop = window.scrollY === 0 })
  },
  methods: {
    ...mapMutations(['setToken', 'setUser']),
    openLoginModal () {
      this.isLoginModalOpen = true
    },
    openJoinModal () {
      this.isJoinModalOpen = true
    },
    logout () {
      this.setToken(null)
      this.setUser(null)
      alert('로그아웃되었습니다.')
      if (this.$route.path !== '/') this.$router.push('/')
    }
  },
  computed: {
    ...mapGetters(['token']),
    stickyMode () {
      return !(this.isScrollTop && this.$route.path === '/')
    }
  }
}
</script>
