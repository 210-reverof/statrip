<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h2>Q&A</h2>
        <h5>질문게시판</h5>
        <hr>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-right">
        <b-button squared variant="outline-secondary"
          >글쓰기</b-button
        >
      </b-col>
    </b-row>
    <b-row>
      <b-col>
        <b-table
          striped
          hover
          :items="articles"
          :fields="fields"
        >
        </b-table>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
export default {
    name: 'QuestionList',
    components: {},
    data() {
    return {
      articles: [],
      fields: [
        { key: "articleno", label: "글번호", tdClass: "tdClass" },
        { key: "subject", label: "제목", tdClass: "tdSubject" },
        { key: "userid", label: "작성자", tdClass: "tdClass" },
        { key: "regtime", label: "작성일", tdClass: "tdClass" },
        { key: "hit", label: "조회수", tdClass: "tdClass" },
      ],
    };
  },
    created() {},
    methods: {},
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>