<template>
    <v-card class="my-2">
        <v-card-text primary-title>
          <div>
            <v-avatar
                size="36"
                v-if="message.author && message.author.userpic"

            >
              <img
                  :src="message.author.userpic"
                  :alt="message.author.name"
              >
            </v-avatar>
            <v-avatar
                v-else
                size="36"
                color="indigo">
              <v-icon dark>
                mdi-account-circle
              </v-icon>
            </v-avatar>
            <span class="pl-2">{{ authorName }}</span>

          </div>
          <div class="pt-3">
            {{ message.text }}</div>
        </v-card-text>
        <media v-if="message.link" :message="message"></media>
        <v-card-actions>
            <v-btn value="Edit" @click="edit" small rounded>Edit</v-btn>
            <v-btn icon @click="del" small>
                <v-icon>mdi-delete-off</v-icon>
            </v-btn>
        </v-card-actions>
        <comment-list
                :comments="message.comments"
                :message-id="message.id"
        ></comment-list>
    </v-card>
</template>

<script>
    import { mapActions } from 'vuex'
    import Media from 'components/media/Media.vue'
    import CommentList from '../comment/CommentList.vue'
    export default {
        props: ['message', 'editMessage'],
        components: { CommentList, Media },
      computed:{
         authorName() {
           return  this.message.author ?  this.message.author.name : 'unknown'}
      },
      methods: {
            ...mapActions(['removeMessageAction']),
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.removeMessageAction(this.message)
            }
        }
    }
</script>

<style>
</style>
