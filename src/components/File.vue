<template>
  <div id="login">
    <img src="../assets/LogoMSPR2.png"/>
    <div class="body-content">
      <label class="importexport">
        Import
        <input id="inputSelectFile" type="file" accept=".csv" @change="handleFileChange" />
      </label>
      <div class="importexport">Export</div>
    </div>
    <div class="fileName" v-if="value.length > 0">
      File : {{ value[0].name }}
      <img src="../assets/deleteFile.png" v-on:click="deleteFile"/>
    </div>
    <div class="sendButton" v-on:click="sendFile(value[0])">Send file</div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: 'File',
  data () {
    return {
      value: []
    }
  },
  methods: {
    handleFileChange (e) {
      this.$emit('input', e.target.files[0])
      this.value.push(e.target.files[0])
    },
    deleteFile (e) {
      this.value.splice(0, this.value.length)
    },
    sendFile (file) {
      const formData = new FormData()
      formData.append('file', file)
      axios.post('https://mspr2.herokuapp.com/upload', formData, {headers: {'Authorization': localStorage.getItem('token')}})
        .then((res) => {
        // Perform Success Action
          console.log(res)
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
@import '../../static/style/filePage.scss';
  .importexport {
    background-color: white;
    border: 1px solid #ccc;
    display: inline-block;
    padding: 25px 50px;
    cursor: pointer;
    font-style: normal;
  }
input[type=file] {
    display: none;
}
</style>
