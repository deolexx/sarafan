<template>



        <v-app>
            <v-app-bar app>
                <v-app-bar-nav-icon></v-app-bar-nav-icon>

                <v-toolbar-title>Title</v-toolbar-title>

                <v-spacer></v-spacer>

                <v-btn icon>
                    <v-icon>mdi-magnify</v-icon>
                </v-btn>

                <v-btn icon>
                    <v-icon>mdi-heart</v-icon>
                </v-btn>

                <v-btn icon>
                    <v-icon>mdi-dots-vertical</v-icon>
                </v-btn>
            </v-app-bar>
            <div v-if="!profile">Необходимо авторизоваться через
                <a href="/login">Google</a>
            </div>
            <div v-else>
                <div>{{profile.name}}&nbsp<a href="/logout">Выйти</a></div>
                <messages-list :messages="messages"/>
            </div>
        </v-app>


</template>

<script>
    import MessagesList from 'components/messages/MessageList.vue'
    import {addHandler} from "util/ws"
    import {getIndex} from "util/collections"

    export default {
        components: {
            MessagesList
        },
        data() {
            return {
                messages: frontendData.messages,
                profile: frontendData.profile
            }
        },
        created() {
            addHandler(data => {
                let index = getIndex(this.messages, data.id)
                if (index > -1) {
                    this.messages.splice(index, 1, data)
                } else {
                    this.messages.push(data)
                }
            })
        }
    }
</script>

<style>

</style>
