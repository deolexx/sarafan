<template>


  <v-app>
    <v-app-bar app>
      <v-app-bar-nav-icon></v-app-bar-nav-icon>

      <v-toolbar-title>Sarafan</v-toolbar-title>

      <v-spacer></v-spacer>


      <span v-if="profile"> {{ profile.name }}</span>
      <v-btn v-if="profile" icon href="/logout">
        <v-icon>mdi-exit-to-app</v-icon>
      </v-btn>

    </v-app-bar>
    <v-main>
      <v-container v-if="!profile">Необходимо авторизоваться через
        <a href="/login">Google</a>
      </v-container>

      <v-container v-if="profile">
        <messages-list />
      </v-container>
    </v-main>

  </v-app>


</template>

<script>
import {mapState, mapMutations} from 'vuex'
import MessagesList from 'components/messages/MessageList.vue'
import {addHandler} from "util/ws"



export default {
  components: {
    MessagesList
  },
  computed: mapState(['profile']),
  methods: mapMutations(['addMessageMutation',
    'updateMessageMutation',
    'removeMessageMutation',
      'addCommentMutation'
  ]),
  created() {
    addHandler(data => {
      if (data.objectType === 'MESSAGE') {
        switch (data.eventType) {
          case 'CREATE' :
              this.addMessageMutation(data.body)
            break
          case 'UPDATE' :
              this.updateMessageMutation(data.body)
              break
          case 'REMOVE' :
            this.removeMessageMutation(data.body)

            break
          default :
            console.error('Looks like the event type is unknown "${data.eventType}"')
        }
      } else if (data.objectType === 'COMMENT') {
        switch (data.eventType) {
          case 'CREATE' :
              this.addCommentMutation(data.body)
            break
          default :
            console.error('Looks like the event type is unknown "${data.eventType}"')
        }
      } else {
        console.error('Looks like the object type is unknown "${data.objectType"}')
      }
    })
  }
}
</script>

<style>

</style>
