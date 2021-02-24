<template>
  <div id="login">
    <img src="../assets/LogoMSPR2.png">
    <div class="body-content">
      <form id="loginForm" action="/" method="post"><!-- action = URL où doit être envoyé le formulaire -->
        <div id="emailLogin">
          <label for="mail">E-mail</label>
          <br />
          <input type="email" id="mail" name="user_mail">
        </div>
        <div>
          <label for="psw">Password</label>
          <br />
          <input id="psw" type="password" name="user_psw">
        </div>
        <button id="connectButton">Se connecter</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Login',
  data () {
    return {
      msg: 'Welcome to Your Vue.js App'
    }
  }
}
</script>

<style>
  @import '../../static/style/loginPage.scss';
</style>
