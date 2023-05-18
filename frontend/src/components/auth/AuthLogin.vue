<template>
    <div class="auth-login">
        <h2>Login</h2>
        <h5>로그인</h5>
        <hr class="separator">
        <b-row class="row">
            <b-col class="col-a">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input type="text" class="form-control" id="username" v-model="username">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" id="password" v-model="password">
                </div>
            </b-col>
            <b-col class="col-b">
                <div class="text-right">
                    <button type="submit" class="btn btn-primary">Login</button>
                </div>
            </b-col>
        </b-row>
        <div class="join-link" @click="$router.push('/auth/joina')">아직 회원이 아니신가요?</div>
    </div>
</template>


<script>
export default {
    name: "AuthLogin",
    data() {
        return {
            id: '',
            password: ''
        };
    },
    methods: {
        submitForm() {
            this.id = '';
            this.password = '';
        }
    }
};
</script>

<style>
.auth-login {
    display: flex;
    flex-direction: column;
    align-items: center;
    width: 80%;
    margin: 0 auto;
    padding: 20px;
}

.form-control {
    width: 100%;
}

.row {
    width: 70%;
}

.col-a {
    display: flex;
    flex-direction: column;
    align-items: flex-end;
}

.col-b {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center; 
} 

.join-link {
    text-decoration: underline;
    cursor: pointer;
}

.separator {
    width: 100%;
    margin-top: 20px;
    margin-bottom: 20px;
}
</style>