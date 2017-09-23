<#include "main.ftl"/>

<#macro m_body>

<div class="page-header text-center">
    <h2>Log in</h2>
</div>
    <#if error ??>
    <div class="alert alert-danger">
        Wrong email or password. Try again.
    </div>

    </#if>

<div class="col-md-5 col-lg-offset-5 text-center">
    <form action="/login/process" method="post" class="form-horizontal text-center">
        <div class="form-group text-center">
            <div class="col-md-5">
                <input type="text" name="login" class="form-control" placeholder="логин">
            </div>
        </div>
        <div class="form-group text-center">
            <div class="col-md-5">
                <input type="password" name="password" class="form-control" placeholder="пароль">
            </div>
        </div>
        <div class="form-group text-center">
            <div class="col-md-5">
                Remember me <input type="checkbox" id="remember" name="_spring_security_remember_me" value="true">
            </div>
        </div>
        <div class="form-group text-center">
            <div class="col-md-5">
                <button type="submit" class="btn btn-success">Войти</button>
            </div>
        </div>

        <br/>
        <div class="col-md-5">
            <p>Don't have an account yet? Then <a href="/registration">register</a></p>
        </div>
    </form>
</div>


</#macro>

<@main title="Login"/>