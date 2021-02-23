<template>
<span></span>
</template>

<script>
import {mapActions} from 'vuex'
export default {
  name: 'LazyLoader',
  methods: mapActions(['loadPageAction']),
  mounted() {
    window.onscroll = () =>{
      const el = document.documentElement
      const isBottom = window.scrollY + window.innerHeight === data.offsetHeight
      if(isBottomOfScreen){
      this.loadPageAction()
      }
    }
  },
  beforeDestroy() {
    window.onscroll=null
  }
}
</script>

<style scoped>

</style>