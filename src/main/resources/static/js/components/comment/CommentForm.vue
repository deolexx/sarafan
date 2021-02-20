<template>
  <v-layout @keyup.13='save' class="px-3 pt-1">
    <v-text-field outlined dense prepend-inner-icon="mdi-comment-processing-outline" label="Add comment" placeholder="Write something" v-model="text"/>
    <span class="pl-2">
      <v-btn @click="save">
        Add
      </v-btn>
    </span>

  </v-layout>
</template>

<script>
import {mapActions} from 'vuex'

export default {
  name: 'CommentForm',
  props:['messageId'] ,
  data() {
    return {text: ''}
  },
  methods:{...mapActions(['addCommentAction']),
    async save() {
await this.addCommentAction({
  text: this.text,
  message: {
    id: this.messageId
  }
})
      this.text= ''
    }

  }
}
</script>

<style scoped>

</style>