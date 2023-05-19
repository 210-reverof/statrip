<template>
  <div>
      <b-calendar v-model="value" @context="onContext" block locale="en-US"></b-calendar>
      <p>Value: <b>'{{ value }}'</b></p>
      <pre class="small" >{{ context }}</pre>
  </div>
</template>

<script>
  export default {
    name: 'CalenderGraph',
    data() {
      return {
        value: '',
        context: null
      }
    },
    methods: {
      onContext(ctx) {
        this.context = ctx
      }
    }
  }
</script>