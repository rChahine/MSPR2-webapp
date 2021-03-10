<template>
  <div id="login">
    <img src="../assets/LogoMSPR2.png">
    <div class="body-content">
      <form id="loginForm" v-on:submit.prevent="test"><!-- action = URL où doit être envoyé le formulaire -->
        <div id="emailLogin">
          <label for="identifiant">E-mail</label>
          <br />
          <input id="identifiant" v-model="form.identifiant">
        </div>
        <div>
          <label for="password">Password</label>
          <br />
          <input id="password" type="password" v-model="form.password">
        </div>
        <button id="connectButton">Se connecter</button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'Login',
  data () {
    return {
      form: {
        identifiant: '',
        password: ''
      }
    }
  },

  methods: {
    test () {
      axios.post('https://mspr2.herokuapp.com/authentication', this.form, {
        headers: {
          'Access-Control-Allow-Origin': '*'
        }
      })
        .then(({ data }) => {
        // Perform Success Action
          localStorage.setItem('token', data.token)
          this.$router.push('/file')
        })
        .catch((error) => {
          // error.response.status Check status code
          console.log(error)
        })
        .finally(() => {
          // Perform action in always
          console.log('Finally')
        })
    }
  }
}
</script>

<style>
  @import '../../static/style/loginPage.scss';
</style>
